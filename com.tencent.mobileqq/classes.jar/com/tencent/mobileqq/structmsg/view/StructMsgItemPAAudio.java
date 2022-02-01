package com.tencent.mobileqq.structmsg.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.CustomScaleType;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import localpb.richMsg.RichMsg.PttRec;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemPAAudio
  extends AbsStructMsgElement
  implements Callback
{
  String aA;
  QQAppInterface aB;
  ImageView aC;
  ImageView aD;
  boolean aE = false;
  ViewGroup aF;
  MediaPlayerManager aG;
  String aM;
  View.OnClickListener aN = new StructMsgItemPAAudio.1(this);
  URLDrawableDownListener.Adapter aO = new StructMsgItemPAAudio.2(this);
  public String au;
  int av;
  int aw;
  String ax;
  String ay;
  int az;
  
  public StructMsgItemPAAudio()
  {
    this.b = "paaudio";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramView;
    boolean bool2 = paramBundle.getBoolean("isSubscript", false);
    this.aB = ((BaseActivity)paramContext).app;
    this.aG = ((MediaPlayerManager)this.aB.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
    Resources localResources = paramContext.getResources();
    if ((localObject1 != null) && ((paramView.getTag() instanceof StructMsgItemPAAudio.ViewHolder)))
    {
      localObject2 = (StructMsgItemPAAudio.ViewHolder)paramView.getTag();
      ((StructMsgItemPAAudio.ViewHolder)localObject2).d.clearAnimation();
      paramView = (TextView)((StructMsgItemPAAudio.ViewHolder)localObject2).e;
      paramBundle = new StringBuilder();
      paramBundle.append(String.valueOf(this.aw));
      paramBundle.append("''");
      paramView.setText(paramBundle.toString());
    }
    try
    {
      paramView = localResources.getDrawable(2130842733);
    }
    catch (OutOfMemoryError paramView)
    {
      label133:
      int i;
      boolean bool1;
      double d;
      label553:
      break label133;
    }
    paramView = null;
    if (TextUtils.isEmpty(this.au))
    {
      ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject2).b).setBackgroundDrawable(paramView);
    }
    else
    {
      i = localResources.getDisplayMetrics().widthPixels;
      paramView = URLDrawable.getDrawable(this.au, i, i, paramView, paramView);
      if ((!AbsDownloader.hasFile(this.au)) && (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext))) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      paramView.setAutoDownload(bool1);
      if ((paramView != null) && (paramView.getStatus() == 1))
      {
        ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject2).b).setBackgroundDrawable(null);
      }
      else
      {
        ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject2).b).setURLDrawableDownListener(this.aO);
        ((StructMsgItemPAAudio.ViewHolder)localObject2).b.setBackgroundColor(15790320);
      }
      ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject2).b).setBackgroundDrawable(paramView);
    }
    if (!TextUtils.isEmpty(this.au))
    {
      paramBundle = (Bundle)localObject1;
      paramView = (View)localObject2;
      if (((View)localObject1).findViewById(97) == null)
      {
        paramContext = new View(paramContext);
        paramContext.setId(97);
        if (bool2)
        {
          d = BaseChatItemLayout.b;
          Double.isNaN(d);
          paramView = new RelativeLayout.LayoutParams(-1, (int)(d / 2.4D * 0.69D));
          paramView.addRule(12, -1);
          paramContext.setBackgroundResource(2130842753);
          ((RelativeLayout)localObject1).addView(paramContext, paramView);
          paramBundle = (Bundle)localObject1;
          paramView = (View)localObject2;
        }
        else
        {
          paramView = new RelativeLayout.LayoutParams(-1, -1);
          paramContext.setBackgroundColor(Color.parseColor("#1A000000"));
          ((RelativeLayout)localObject1).addView(paramContext, paramView);
          paramBundle = (Bundle)localObject1;
          paramView = (View)localObject2;
        }
      }
    }
    else
    {
      paramContext = ((View)localObject1).findViewById(97);
      paramBundle = (Bundle)localObject1;
      paramView = (View)localObject2;
      if (paramContext != null)
      {
        ((RelativeLayout)localObject1).removeView(paramContext);
        paramBundle = (Bundle)localObject1;
        paramView = (View)localObject2;
        break label1192;
        localObject1 = new StructMsgItemPAAudio.ViewHolder();
        paramBundle = new RelativeLayout(paramContext);
        ((StructMsgItemPAAudio.ViewHolder)localObject1).b = new AnyScaleTypeImageView(paramContext);
        ((StructMsgItemPAAudio.ViewHolder)localObject1).b.setContentDescription(localResources.getString(2131892235));
        ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject1).b).setDisplayRuleDef(CustomScaleType.a);
        ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject1).b).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
    try
    {
      paramView = localResources.getDrawable(2130842733);
    }
    catch (OutOfMemoryError paramView)
    {
      break label553;
    }
    paramView = null;
    if (TextUtils.isEmpty(this.au))
    {
      ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject1).b).setBackgroundDrawable(paramView);
    }
    else
    {
      i = localResources.getDisplayMetrics().widthPixels;
      paramView = URLDrawable.getDrawable(this.au, i, i, paramView, paramView);
      if ((!AbsDownloader.hasFile(this.au)) && (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext))) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      paramView.setAutoDownload(bool1);
      if ((paramView != null) && (paramView.getStatus() == 1))
      {
        ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject1).b).setBackgroundDrawable(null);
      }
      else
      {
        ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject1).b).setURLDrawableDownListener(this.aO);
        ((StructMsgItemPAAudio.ViewHolder)localObject1).b.setBackgroundColor(15790320);
      }
      ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject1).b).setBackgroundDrawable(paramView);
    }
    ((StructMsgItemPAAudio.ViewHolder)localObject1).c = new ImageView(paramContext);
    ((StructMsgItemPAAudio.ViewHolder)localObject1).c.setId(99);
    ((StructMsgItemPAAudio.ViewHolder)localObject1).c.setBackgroundResource(2130842744);
    ((StructMsgItemPAAudio.ViewHolder)localObject1).d = new ImageView(paramContext);
    ((StructMsgItemPAAudio.ViewHolder)localObject1).d.setId(98);
    ((StructMsgItemPAAudio.ViewHolder)localObject1).d.setBackgroundResource(2130842789);
    ((StructMsgItemPAAudio.ViewHolder)localObject1).e = new TextView(paramContext);
    paramView = (TextView)((StructMsgItemPAAudio.ViewHolder)localObject1).e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(this.aw));
    ((StringBuilder)localObject2).append("'");
    paramView.setText(((StringBuilder)localObject2).toString());
    ((TextView)((StructMsgItemPAAudio.ViewHolder)localObject1).e).setTextSize(20.0F);
    ((TextView)((StructMsgItemPAAudio.ViewHolder)localObject1).e).setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    paramView = (RelativeLayout)paramBundle;
    paramView.addView(((StructMsgItemPAAudio.ViewHolder)localObject1).b, (ViewGroup.LayoutParams)localObject2);
    if (!TextUtils.isEmpty(this.au))
    {
      paramContext = new View(paramContext);
      paramContext.setId(97);
      if (bool2)
      {
        d = BaseChatItemLayout.b;
        Double.isNaN(d);
        localObject2 = new RelativeLayout.LayoutParams(-1, (int)(d / 2.4D * 0.69D));
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        paramContext.setBackgroundResource(2130842753);
        paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        paramContext.setBackgroundColor(Color.parseColor("#1A000000"));
        paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject2);
      }
    }
    paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(12.0F, localResources), AIOUtils.b(20.0F, localResources));
    paramContext.addRule(9, -1);
    paramContext.setMargins(AIOUtils.b(20.0F, localResources), 0, 0, 0);
    paramContext.addRule(15, -1);
    paramView.addView(((StructMsgItemPAAudio.ViewHolder)localObject1).c, paramContext);
    paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(14.0F, localResources), AIOUtils.b(20.0F, localResources));
    paramContext.setMargins(AIOUtils.b(5.0F, localResources), 0, 0, 0);
    paramContext.addRule(15, -1);
    paramContext.addRule(1, ((StructMsgItemPAAudio.ViewHolder)localObject1).c.getId());
    paramView.addView(((StructMsgItemPAAudio.ViewHolder)localObject1).d, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.setMargins(AIOUtils.b(15.0F, localResources), 0, 0, 0);
    paramContext.addRule(15, -1);
    paramContext.addRule(1, ((StructMsgItemPAAudio.ViewHolder)localObject1).d.getId());
    paramView.addView(((StructMsgItemPAAudio.ViewHolder)localObject1).e, paramContext);
    paramView = (View)localObject1;
    label1192:
    paramBundle.post(new StructMsgItemPAAudio.3(this, paramBundle, paramView));
    paramView.a = ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getPAAudioPttPath(this.aB, this.aA);
    paramBundle.setTag(paramView);
    this.aC = ((ImageView)paramView.c);
    this.aD = ((ImageView)paramView.d);
    if (this.ar != null)
    {
      paramBundle.setOnLongClickListener((View.OnLongClickListener)this.ar.get());
      paramBundle.setOnTouchListener((View.OnTouchListener)this.ar.get());
    }
    paramBundle.setOnClickListener(this.aN);
    return paramBundle;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = paramObjectInput.readUTF();
    this.av = paramObjectInput.readInt();
    this.aw = paramObjectInput.readInt();
    this.ax = paramObjectInput.readUTF();
    this.ay = paramObjectInput.readUTF();
    this.az = paramObjectInput.readInt();
    this.aA = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeUTF(this.au);
    paramObjectOutput.writeInt(this.av);
    paramObjectOutput.writeInt(this.aw);
    String str2 = this.ax;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.ay;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeInt(this.az);
    str2 = this.aA;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
  }
  
  void a(String paramString, View paramView)
  {
    if (LoadingStateManager.b().e())
    {
      paramString = paramView.getContext();
      DialogUtil.a(paramString, 232, null, paramString.getString(2131889169), new StructMsgItemPAAudio.4(this), null).show();
      d();
      return;
    }
    FileTransferManager.a(this.aB).a(paramView, this);
    Object localObject = new RichMsg.PttRec();
    ((RichMsg.PttRec)localObject).localPath.set(this.aA);
    ((RichMsg.PttRec)localObject).size.set(this.az);
    ((RichMsg.PttRec)localObject).type.set(2);
    ((RichMsg.PttRec)localObject).uuid.set(this.aA);
    ((RichMsg.PttRec)localObject).isRead.set(false);
    ((RichMsg.PttRec)localObject).serverStorageSource.set("pttcenter");
    ((RichMsg.PttRec)localObject).isReport.set(0);
    ((RichMsg.PttRec)localObject).version.set(5);
    ((RichMsg.PttRec)localObject).pttFlag.set(0);
    ((RichMsg.PttRec)localObject).longPttVipFlag.set(0);
    long l = System.currentTimeMillis() / 1000L;
    ((RichMsg.PttRec)localObject).msgRecTime.set(l);
    ((RichMsg.PttRec)localObject).msgTime.set(0L);
    ((RichMsg.PttRec)localObject).voiceChangeFlag.set(0);
    ((RichMsg.PttRec)localObject).busiType.set(this.av);
    paramView = MessageRecordFactory.a(-2002);
    paramView.frienduin = paramString;
    paramView.istroop = 1008;
    paramView.msgData = ((RichMsg.PttRec)localObject).toByteArray();
    ((MessageForPtt)paramView).doParse();
    for (;;)
    {
      try
      {
        localObject = new TransferRequest();
        ((TransferRequest)localObject).mSelfUin = this.aB.getAccount();
        ((TransferRequest)localObject).mPeerUin = paramString;
        ((TransferRequest)localObject).mUinType = 1008;
        ((TransferRequest)localObject).mFileType = 33;
        ((TransferRequest)localObject).mUniseq = paramView.uniseq;
        ((TransferRequest)localObject).mIsUp = false;
        ((TransferRequest)localObject).mServerPath = ((MessageForPtt)paramView).urlAtServer;
        ((TransferRequest)localObject).mOutFilePath = ((MessageForPtt)paramView).getLocalFilePath();
        if (paramView.isSendFromOtherTerminal()) {
          break label465;
        }
        if (!paramView.isSend()) {
          break label459;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("structmsg.StructMsgItemPAAudio", 2, paramString.getMessage());
        return;
      }
      ((TransferRequest)localObject).mIsSelfSend = bool;
      ((TransferRequest)localObject).mMd5 = ((MessageForPtt)paramView).md5;
      ((TransferRequest)localObject).mGroupFileID = ((MessageForPtt)paramView).groupFileID;
      ((TransferRequest)localObject).mGroupFileKeyStr = ((MessageForPtt)paramView).groupFileKeyStr;
      ((TransferRequest)localObject).mDbRecVersion = ((MessageForPtt)paramView).subVersion;
      ((TransferRequest)localObject).mRec = paramView;
      ((TransferRequest)localObject).mExtraObj = new TransferRequest.PttDownExtraInfo(1, 0);
      ((ITransFileController)this.aB.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
      return;
      label459:
      boolean bool = false;
      continue;
      label465:
      bool = true;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "paaudio");
    paramXmlSerializer.attribute(null, "cover", this.au);
    paramXmlSerializer.attribute(null, "busitype", String.valueOf(this.av));
    paramXmlSerializer.attribute(null, "duration", String.valueOf(this.aw));
    paramXmlSerializer.attribute(null, "md5", this.ax);
    paramXmlSerializer.attribute(null, "filename", this.ay);
    paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.az));
    paramXmlSerializer.attribute(null, "uuid", this.aA);
    paramXmlSerializer.endTag(null, "paaudio");
  }
  
  boolean a(long paramLong)
  {
    ChatMessage localChatMessage = this.aG.f();
    boolean bool = false;
    if (localChatMessage == null) {
      return false;
    }
    if (localChatMessage.uniseq == paramLong) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.au = paramStructMsgNode.a("cover");
    this.av = Integer.parseInt(paramStructMsgNode.a("busitype"));
    this.aw = Integer.parseInt(paramStructMsgNode.a("duration"));
    this.ax = paramStructMsgNode.a("md5");
    this.ay = paramStructMsgNode.a("filename");
    this.az = Integer.parseInt(paramStructMsgNode.a("filesize"));
    this.aA = paramStructMsgNode.a("uuid");
    return true;
  }
  
  public String b()
  {
    return "paaudio";
  }
  
  void c()
  {
    this.aC.setBackgroundResource(2130772239);
    ((AnimationDrawable)this.aC.getBackground()).start();
  }
  
  void d()
  {
    this.aC.clearAnimation();
    this.aC.setBackgroundResource(2130842744);
    if (this.aE)
    {
      this.aD.setBackgroundResource(2130772240);
      ((AnimationDrawable)this.aD.getBackground()).start();
      return;
    }
    this.aD.clearAnimation();
    this.aD.setBackgroundResource(2130842789);
  }
  
  public void e()
  {
    if (this.aE) {
      return;
    }
    ViewGroup localViewGroup = this.aF;
    if (localViewGroup == null) {
      return;
    }
    this.aE = true;
    this.aG.a(((ChatItemBuilder.BaseHolder)AIOUtils.b(localViewGroup)).q);
    this.aD.clearAnimation();
    this.aD.setBackgroundResource(2130772240);
    ((AnimationDrawable)this.aD.getBackground()).start();
  }
  
  public void f()
  {
    if (!this.aE) {
      return;
    }
    if (this.aF == null) {
      return;
    }
    this.aE = false;
    MediaPlayerManager localMediaPlayerManager = (MediaPlayerManager)this.aB.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
    if (((ChatItemBuilder.BaseHolder)AIOUtils.b(this.aF)).q.equals(localMediaPlayerManager.f())) {
      localMediaPlayerManager.a(false);
    }
    this.aD.clearAnimation();
    this.aD.setBackgroundResource(2130842789);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.fileType == 33) && (paramInt1 != 2002))
    {
      if (paramInt1 == 2001) {
        return;
      }
      if ((paramInt1 == 2003) && (this.aB != null))
      {
        d();
        e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio
 * JD-Core Version:    0.7.0.1
 */