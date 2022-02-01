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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
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
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  implements FileTransferManager.Callback
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgItemPAAudio.1(this);
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new StructMsgItemPAAudio.2(this);
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  public String ac;
  String ad;
  String ae;
  String af;
  String ag;
  ImageView b;
  int o;
  int p;
  int q;
  
  public StructMsgItemPAAudio()
  {
    this.jdField_a_of_type_JavaLangString = "paaudio";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool2 = paramBundle.getBoolean("isSubscript", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)paramContext).app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
    Resources localResources = paramContext.getResources();
    Object localObject;
    if ((paramView != null) && ((paramView.getTag() instanceof StructMsgItemPAAudio.ViewHolder)))
    {
      localObject = (StructMsgItemPAAudio.ViewHolder)paramView.getTag();
      ((StructMsgItemPAAudio.ViewHolder)localObject).c.clearAnimation();
      ((TextView)((StructMsgItemPAAudio.ViewHolder)localObject).d).setText(String.valueOf(this.p) + "''");
    }
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        paramBundle = localResources.getDrawable(2130841925);
        if (TextUtils.isEmpty(this.ac))
        {
          ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject).jdField_a_of_type_AndroidViewView).setBackgroundDrawable(paramBundle);
          if (TextUtils.isEmpty(this.ac)) {
            continue;
          }
          if (paramView.findViewById(97) == null)
          {
            paramContext = new View(paramContext);
            paramContext.setId(97);
            if (!bool2) {
              continue;
            }
            paramBundle = new RelativeLayout.LayoutParams(-1, (int)(BaseChatItemLayout.b / 2.4D * 0.69D));
            paramBundle.addRule(12, -1);
            paramContext.setBackgroundResource(2130841945);
            ((RelativeLayout)paramView).addView(paramContext, paramBundle);
          }
          paramContext = (Context)localObject;
          paramBundle = paramView;
          paramView = paramContext;
          paramBundle.post(new StructMsgItemPAAudio.3(this, paramBundle, paramView));
          paramView.jdField_a_of_type_JavaLangString = PAAudioPttDownloadProcessor.getPttPath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.af);
          paramBundle.setTag(paramView);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.b);
          this.b = ((ImageView)paramView.c);
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            paramBundle.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramBundle.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          }
          paramBundle.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramBundle;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        paramBundle = null;
        continue;
        i = localResources.getDisplayMetrics().widthPixels;
        paramBundle = URLDrawable.getDrawable(this.ac, i, i, paramBundle, paramBundle);
        if ((AbsDownloader.hasFile(this.ac)) || (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)))
        {
          bool1 = true;
          paramBundle.setAutoDownload(bool1);
          if ((paramBundle != null) && (paramBundle.getStatus() == 1))
          {
            ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject).jdField_a_of_type_AndroidViewView).setBackgroundDrawable(null);
            ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject).jdField_a_of_type_AndroidViewView).setBackgroundDrawable(paramBundle);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        ((AnyScaleTypeImageView)((StructMsgItemPAAudio.ViewHolder)localObject).jdField_a_of_type_AndroidViewView).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        ((StructMsgItemPAAudio.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setBackgroundColor(15790320);
        continue;
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramContext.setBackgroundColor(Color.parseColor("#1A000000"));
        ((RelativeLayout)paramView).addView(paramContext, paramBundle);
        continue;
        paramContext = paramView.findViewById(97);
        if (paramContext == null) {
          continue;
        }
        ((RelativeLayout)paramView).removeView(paramContext);
        continue;
      }
      paramBundle = new StructMsgItemPAAudio.ViewHolder();
      localObject = new RelativeLayout(paramContext);
      paramBundle.jdField_a_of_type_AndroidViewView = new AnyScaleTypeImageView(paramContext);
      paramBundle.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131694583));
      ((AnyScaleTypeImageView)paramBundle.jdField_a_of_type_AndroidViewView).setDisplayRuleDef(CustomScaleType.a);
      ((AnyScaleTypeImageView)paramBundle.jdField_a_of_type_AndroidViewView).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      try
      {
        paramView = localResources.getDrawable(2130841925);
        if (TextUtils.isEmpty(this.ac))
        {
          ((AnyScaleTypeImageView)paramBundle.jdField_a_of_type_AndroidViewView).setBackgroundDrawable(paramView);
          paramBundle.b = new ImageView(paramContext);
          paramBundle.b.setId(99);
          paramBundle.b.setBackgroundResource(2130841936);
          paramBundle.c = new ImageView(paramContext);
          paramBundle.c.setId(98);
          paramBundle.c.setBackgroundResource(2130841981);
          paramBundle.d = new TextView(paramContext);
          ((TextView)paramBundle.d).setText(String.valueOf(this.p) + "'");
          ((TextView)paramBundle.d).setTextSize(20.0F);
          ((TextView)paramBundle.d).setTextColor(-1);
          paramView = new RelativeLayout.LayoutParams(-1, -1);
          ((RelativeLayout)localObject).addView(paramBundle.jdField_a_of_type_AndroidViewView, paramView);
          if (!TextUtils.isEmpty(this.ac))
          {
            paramContext = new View(paramContext);
            paramContext.setId(97);
            if (!bool2) {
              break label1180;
            }
            paramView = new RelativeLayout.LayoutParams(-1, (int)(BaseChatItemLayout.b / 2.4D * 0.69D));
            paramView.addRule(12, -1);
            paramContext.setBackgroundResource(2130841945);
            ((RelativeLayout)localObject).addView(paramContext, paramView);
          }
          paramContext = new RelativeLayout.LayoutParams(AIOUtils.a(12.0F, localResources), AIOUtils.a(20.0F, localResources));
          paramContext.addRule(9, -1);
          paramContext.setMargins(AIOUtils.a(20.0F, localResources), 0, 0, 0);
          paramContext.addRule(15, -1);
          ((RelativeLayout)localObject).addView(paramBundle.b, paramContext);
          paramContext = new RelativeLayout.LayoutParams(AIOUtils.a(14.0F, localResources), AIOUtils.a(20.0F, localResources));
          paramContext.setMargins(AIOUtils.a(5.0F, localResources), 0, 0, 0);
          paramContext.addRule(15, -1);
          paramContext.addRule(1, paramBundle.b.getId());
          ((RelativeLayout)localObject).addView(paramBundle.c, paramContext);
          paramContext = new RelativeLayout.LayoutParams(-2, -2);
          paramContext.setMargins(AIOUtils.a(15.0F, localResources), 0, 0, 0);
          paramContext.addRule(15, -1);
          paramContext.addRule(1, paramBundle.c.getId());
          ((RelativeLayout)localObject).addView(paramBundle.d, paramContext);
          paramContext = (Context)localObject;
          paramView = paramBundle;
          paramBundle = paramContext;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        for (;;)
        {
          paramView = null;
          continue;
          i = localResources.getDisplayMetrics().widthPixels;
          paramView = URLDrawable.getDrawable(this.ac, i, i, paramView, paramView);
          if ((AbsDownloader.hasFile(this.ac)) || (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)))
          {
            bool1 = true;
            label1104:
            paramView.setAutoDownload(bool1);
            if ((paramView == null) || (paramView.getStatus() != 1)) {
              break label1153;
            }
            ((AnyScaleTypeImageView)paramBundle.jdField_a_of_type_AndroidViewView).setBackgroundDrawable(null);
          }
          for (;;)
          {
            ((AnyScaleTypeImageView)paramBundle.jdField_a_of_type_AndroidViewView).setBackgroundDrawable(paramView);
            break;
            bool1 = false;
            break label1104;
            label1153:
            ((AnyScaleTypeImageView)paramBundle.jdField_a_of_type_AndroidViewView).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
            paramBundle.jdField_a_of_type_AndroidViewView.setBackgroundColor(15790320);
          }
          label1180:
          paramView = new RelativeLayout.LayoutParams(-1, -1);
          paramContext.setBackgroundColor(Color.parseColor("#1A000000"));
          ((RelativeLayout)localObject).addView(paramContext, paramView);
        }
      }
    }
  }
  
  public String a()
  {
    return "paaudio";
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130772145);
    ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getBackground()).start();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.fileType != 33) || (paramInt1 == 2002) || (paramInt1 == 2001)) {}
    while ((paramInt1 != 2003) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    b();
    c();
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
    this.o = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
    this.ad = paramObjectInput.readUTF();
    this.ae = paramObjectInput.readUTF();
    this.q = paramObjectInput.readInt();
    this.af = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeUTF(this.ac);
    paramObjectOutput.writeInt(this.o);
    paramObjectOutput.writeInt(this.p);
    if (this.ad == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ae != null) {
        break label108;
      }
      str = "";
      label64:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.q);
      if (this.af != null) {
        break label116;
      }
    }
    label108:
    label116:
    for (String str = "";; str = this.af)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.ad;
      break;
      str = this.ae;
      break label64;
    }
  }
  
  void a(String paramString, View paramView)
  {
    if (LoadingStateManager.a().d())
    {
      paramString = paramView.getContext();
      DialogUtil.a(paramString, 232, null, paramString.getString(2131692257), new StructMsgItemPAAudio.4(this), null).show();
      b();
      return;
    }
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView, this);
    Object localObject = new RichMsg.PttRec();
    ((RichMsg.PttRec)localObject).localPath.set(this.af);
    ((RichMsg.PttRec)localObject).size.set(this.q);
    ((RichMsg.PttRec)localObject).type.set(2);
    ((RichMsg.PttRec)localObject).uuid.set(this.af);
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
    ((RichMsg.PttRec)localObject).busiType.set(this.o);
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
        ((TransferRequest)localObject).mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
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
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
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
    paramXmlSerializer.attribute(null, "cover", this.ac);
    paramXmlSerializer.attribute(null, "busitype", String.valueOf(this.o));
    paramXmlSerializer.attribute(null, "duration", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "md5", this.ad);
    paramXmlSerializer.attribute(null, "filename", this.ae);
    paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "uuid", this.af);
    paramXmlSerializer.endTag(null, "paaudio");
  }
  
  boolean a(long paramLong)
  {
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a();
    if (localChatMessage == null) {}
    while (localChatMessage.uniseq != paramLong) {
      return false;
    }
    return true;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.ac = paramStructMsgNode.a("cover");
    this.o = Integer.parseInt(paramStructMsgNode.a("busitype"));
    this.p = Integer.parseInt(paramStructMsgNode.a("duration"));
    this.ad = paramStructMsgNode.a("md5");
    this.ae = paramStructMsgNode.a("filename");
    this.q = Integer.parseInt(paramStructMsgNode.a("filesize"));
    this.af = paramStructMsgNode.a("uuid");
    return true;
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841936);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setBackgroundResource(2130772146);
      ((AnimationDrawable)this.b.getBackground()).start();
      return;
    }
    this.b.clearAnimation();
    this.b.setBackgroundResource(2130841981);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(((ChatItemBuilder.BaseHolder)AIOUtils.a(this.jdField_a_of_type_AndroidViewViewGroup)).a);
    this.b.clearAnimation();
    this.b.setBackgroundResource(2130772146);
    ((AnimationDrawable)this.b.getBackground()).start();
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    MediaPlayerManager localMediaPlayerManager = (MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
    if (((ChatItemBuilder.BaseHolder)AIOUtils.a(this.jdField_a_of_type_AndroidViewViewGroup)).a.equals(localMediaPlayerManager.a())) {
      localMediaPlayerManager.a(false);
    }
    this.b.clearAnimation();
    this.b.setBackgroundResource(2130841981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio
 * JD-Core Version:    0.7.0.1
 */