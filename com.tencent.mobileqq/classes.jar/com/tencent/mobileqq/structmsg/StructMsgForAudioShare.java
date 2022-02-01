package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.Date;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StructMsgForAudioShare
  extends AbsShareMsg
  implements QQPlayerCallback
{
  private static View.OnClickListener a = new StructMsgForAudioShare.1();
  private WeakReference<URLImageView> mCoverImage;
  private boolean mIsShowCommentLayout;
  private View.OnClickListener musicShareCoverClikListener = new StructMsgForAudioShare.2(this);
  
  StructMsgForAudioShare()
  {
    this.mMsgServiceID = 2;
  }
  
  StructMsgForAudioShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentSrc = paramBundle.getString("audio_url");
    this.mContentLayout = 2;
    this.mMsgServiceID = 2;
    this.mMsgAction = "web";
  }
  
  StructMsgForAudioShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mMsgServiceID = 2;
  }
  
  public static StructMsgForAudioShare getTestObj()
  {
    StructMsgForAudioShare localStructMsgForAudioShare = new StructMsgForAudioShare();
    localStructMsgForAudioShare.mMsgServiceID = 2;
    localStructMsgForAudioShare.fwFlag = 0;
    localStructMsgForAudioShare.mContentCover = "https://url.cn/R3i1JD";
    localStructMsgForAudioShare.mContentLayout = 2;
    localStructMsgForAudioShare.mContentSrc = "https://url.cn/JpkdzT";
    localStructMsgForAudioShare.mContentSummary = HardCodeUtil.a(2131911911);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131911914));
    localStringBuilder.append(new Date());
    localStructMsgForAudioShare.mContentTitle = localStringBuilder.toString();
    localStructMsgForAudioShare.mMsgUrl = "https://y.qq.com/i/song.html?songid=625023&source=qq";
    localStructMsgForAudioShare.mSourceName = "QQ音乐";
    localStructMsgForAudioShare.mMsgBrief = HardCodeUtil.a(2131911923);
    localStructMsgForAudioShare.mMsgAction = "web";
    localStructMsgForAudioShare.mMsgActionData = "y.qq.com";
    localStructMsgForAudioShare.mMsg_A_ActionData = "com.tencent.qqmusic";
    localStructMsgForAudioShare.mSource_I_ActionData = "tencent100497308://";
    localStructMsgForAudioShare.mSourceAction = "app";
    localStructMsgForAudioShare.mMsgTemplateID = 1;
    localStructMsgForAudioShare.mSourceAppid = 100497308L;
    localStructMsgForAudioShare.mSourceUrl = "https://web.p.qq.com/qqmpmobile/aio/app.html?id=100497308";
    localStructMsgForAudioShare.mSourceIcon = "https://p.qpic.cn/qqconnect_app_logo/1LlgQzJVOyA9xucianwgfHru8JA97ERytRa0lHcRRGGw/0";
    return localStructMsgForAudioShare;
  }
  
  public static void onClickEvent(Context paramContext, StructMsgForAudioShare paramStructMsgForAudioShare)
  {
    boolean bool = "web".equals(paramStructMsgForAudioShare.mMsgAction);
    int i = 1;
    if (bool)
    {
      ((IOnlineMusicStatusManager)((IOnlineStatusManagerService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class)).a(1);
      localObject = new Intent(paramContext, QQBrowserDelegationActivity.class);
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_aio");
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("url", paramStructMsgForAudioShare.mMsgUrl);
      ((Intent)localObject).putExtra("param_force_internal_browser", true);
      ((Intent)localObject).putExtra("isAppShare", true);
      ((Intent)localObject).putExtra("appShareID", AppShareIDUtil.c(paramStructMsgForAudioShare.mSourceAppid));
      paramContext.sendBroadcast(new Intent("qqplayer_exit_action"));
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramStructMsgForAudioShare.message, (Intent)localObject, paramStructMsgForAudioShare.mMsgUrl);
      paramContext.startActivity((Intent)localObject);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramStructMsgForAudioShare.mMsgUrl, "", "", "");
    }
    else
    {
      i = 0;
    }
    paramContext = paramStructMsgForAudioShare.uin;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramStructMsgForAudioShare.msgId);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramContext, "0X80055C7", "0X80055C7", 0, i, ((StringBuilder)localObject).toString(), paramStructMsgForAudioShare.templateIDForPortal, "", paramStructMsgForAudioShare.mMsgUrl);
    paramContext = new StringBuilder();
    paramContext.append("MSGID=");
    paramContext.append(Long.toString(paramStructMsgForAudioShare.msgId));
    paramContext.append(";TEPLATEID=");
    paramContext.append(paramStructMsgForAudioShare.templateIDForPortal);
    paramContext.append(";ARTICALID=");
    paramContext.append("");
    paramContext.append(";REFERRER=");
    paramContext.append(AbsStructMsgElement.a(paramStructMsgForAudioShare.mMsgUrl));
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForAudioShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(paramContext).inflate(2131629318, null);
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131435545);
    Object localObject = (TextView)paramView.findViewById(2131448814);
    TextView localTextView = (TextView)paramView.findViewById(2131448780);
    String str1 = this.mContentCover;
    String str2 = this.mContentTitle;
    String str3 = this.mContentSummary;
    ((TextView)localObject).setText(str2);
    localTextView.setText(str3);
    boolean bool = TextUtils.isEmpty(str2);
    int i = 2;
    if (!bool)
    {
      localTextView.setMaxLines(2);
      ((TextView)localObject).setVisibility(0);
    }
    else
    {
      ((TextView)localObject).setVisibility(8);
      localTextView.setMaxLines(4);
    }
    if (TextUtils.isEmpty(str3)) {
      i = 3;
    }
    ((TextView)localObject).setMaxLines(i);
    localObject = paramContext.getResources().getDrawable(2130852676);
    localImageView.setBackgroundDrawable(null);
    if (TextUtils.isEmpty(str1))
    {
      localImageView.setImageDrawable((Drawable)localObject);
      return paramView;
    }
    paramContext = str1;
    if (!str1.startsWith("http://"))
    {
      paramContext = str1;
      if (!str1.startsWith("https://")) {
        paramContext = Uri.fromFile(new File(str1)).toString();
      }
    }
    localImageView.setImageDrawable(URLDrawable.getDrawable(paramContext, (Drawable)localObject, (Drawable)localObject));
    return paramView;
  }
  
  public String getToken()
  {
    return QQPlayerService.a(1, String.valueOf(this.uniseq));
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    if (this.mMsgException)
    {
      paramContext = getVersionExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
      paramContext.setId(2131446476);
      paramContext.setTag(2131446476, this);
      return paramContext;
    }
    paramBundle = paramContext.getResources();
    paramView = LayoutInflater.from(paramContext).inflate(2131629315, null);
    paramOnLongClickAndTouchListener = (URLImageView)paramView.findViewById(2131435545);
    this.mCoverImage = new WeakReference(paramOnLongClickAndTouchListener);
    Object localObject1 = (TextView)paramView.findViewById(2131448814);
    Object localObject2 = (TextView)paramView.findViewById(2131448780);
    ((TextView)localObject1).setText(this.mContentTitle);
    ((TextView)localObject2).setText(this.mContentSummary);
    boolean bool2 = TextUtils.isEmpty(this.mContentTitle);
    boolean bool1 = false;
    if (!bool2)
    {
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setVisibility(0);
    }
    else
    {
      ((TextView)localObject1).setVisibility(8);
      ((TextView)localObject2).setMaxLines(4);
    }
    int i;
    if (TextUtils.isEmpty(this.mContentSummary)) {
      i = 3;
    } else {
      i = 2;
    }
    ((TextView)localObject1).setMaxLines(i);
    paramOnLongClickAndTouchListener.setVisibility(0);
    if (QQPlayerService.d(this))
    {
      paramOnLongClickAndTouchListener.setImageResource(2130847050);
      paramOnLongClickAndTouchListener.setContentDescription(paramBundle.getString(2131887113));
    }
    else
    {
      paramOnLongClickAndTouchListener.setImageResource(2130847049);
      paramOnLongClickAndTouchListener.setContentDescription(paramBundle.getString(2131887111));
    }
    if (!TextUtils.isEmpty(this.mContentCover))
    {
      localObject1 = this.mContentCover;
      localObject2 = paramBundle.getDrawable(2130852676);
    }
    for (;;)
    {
      try
      {
        i = AIOUtils.b(70.0F, paramBundle);
        paramBundle = URLDrawable.getDrawable((String)localObject1, i, i, (Drawable)localObject2, (Drawable)localObject2);
        if ((AbsDownloader.hasFile((String)localObject1)) || (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext))) {
          break label455;
        }
        paramBundle.setAutoDownload(bool1);
        paramOnLongClickAndTouchListener.setBackgroundDrawable(paramBundle);
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label382;
        }
      }
      paramBundle = new StringBuilder();
      paramBundle.append("getView ");
      paramBundle.append(paramContext.getMessage());
      QLog.d("AudioShareMsg", 2, paramBundle.toString());
      break label382;
      paramOnLongClickAndTouchListener.setBackgroundResource(2130852676);
      label382:
      paramContext = paramView.getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new RelativeLayout.LayoutParams(BaseChatItemLayout.B, -2);
      }
      else
      {
        paramContext.width = BaseChatItemLayout.B;
        paramContext.height = -2;
      }
      paramView.setLayoutParams(paramContext);
      paramOnLongClickAndTouchListener.setTag(this);
      paramOnLongClickAndTouchListener.setOnClickListener(this.musicShareCoverClikListener);
      paramView.setId(2131446476);
      paramView.setTag(2131446476, this);
      return paramView;
      label455:
      bool1 = true;
    }
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = this.mCoverImage;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (URLImageView)this.mCoverImage.get();
      Resources localResources = ((URLImageView)localObject).getContext().getResources();
      if ((paramInt != 2) && (paramInt != 1))
      {
        ((URLImageView)localObject).post(new StructMsgForAudioShare.4(this, (URLImageView)localObject));
        ((URLImageView)localObject).setContentDescription(localResources.getString(2131887111));
        return;
      }
      ((URLImageView)localObject).post(new StructMsgForAudioShare.3(this, (URLImageView)localObject));
      ((URLImageView)localObject).setContentDescription(localResources.getString(2131887113));
    }
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.mContentLayout = StructMsgUtils.a(paramStructMsgNode.a("layout"));
    if ((paramStructMsgNode != null) && (paramStructMsgNode.a() >= 3))
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(0);
      if (localStructMsgNode != null)
      {
        this.mContentCover = localStructMsgNode.a("cover");
        this.mContentSrc = localStructMsgNode.a("src");
      }
      localStructMsgNode = paramStructMsgNode.a(1);
      if (localStructMsgNode != null) {
        this.mContentTitle = MessageUtils.a(StructMsgFactory.a(localStructMsgNode), false);
      }
      paramStructMsgNode = paramStructMsgNode.a(2);
      if (paramStructMsgNode != null) {
        this.mContentSummary = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
      }
    }
    return true;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    try
    {
      int i = paramObjectInput.readInt();
      this.mVersion = i;
      if (i == 1)
      {
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        this.mContentLayout = paramObjectInput.readInt();
        this.mContentCover = paramObjectInput.readUTF();
        this.mContentSrc = paramObjectInput.readUTF();
        this.mContentTitle = paramObjectInput.readUTF();
        this.mContentSummary = paramObjectInput.readUTF();
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        if ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon))) {
          this.mHasSource = true;
        }
      }
      else
      {
        if (i >= 2)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          this.mContentLayout = paramObjectInput.readInt();
          this.mContentCover = paramObjectInput.readUTF();
          this.mContentSrc = paramObjectInput.readUTF();
          this.mContentTitle = paramObjectInput.readUTF();
          this.mContentSummary = paramObjectInput.readUTF();
          this.mSourceAppid = paramObjectInput.readLong();
          this.mSourceIcon = paramObjectInput.readUTF();
          this.mSourceName = paramObjectInput.readUTF();
          this.mSourceUrl = paramObjectInput.readUTF();
          this.mSourceAction = paramObjectInput.readUTF();
          this.mSourceActionData = paramObjectInput.readUTF();
          this.mSource_A_ActionData = paramObjectInput.readUTF();
          this.mSource_I_ActionData = paramObjectInput.readUTF();
          this.fwFlag = paramObjectInput.readInt();
          this.mFlag = paramObjectInput.readInt();
          this.mHasSource = paramObjectInput.readBoolean();
          this.mCommentText = paramObjectInput.readUTF();
          if (i < 3) {
            return;
          }
          this.mCompatibleText = paramObjectInput.readUTF();
          this.msgId = paramObjectInput.readLong();
          this.mPromotionType = paramObjectInput.readInt();
          this.mPromotionMsg = paramObjectInput.readUTF();
          this.mPromotionMenus = paramObjectInput.readUTF();
          this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
          if (i < 5) {
            return;
          }
          this.source_puin = paramObjectInput.readUTF();
          if (i < 7) {
            return;
          }
          this.adverSign = paramObjectInput.readInt();
          this.adverKey = paramObjectInput.readUTF();
          this.index = paramObjectInput.readUTF();
          this.index_name = paramObjectInput.readUTF();
          this.index_type = paramObjectInput.readUTF();
          if (i < 15) {
            return;
          }
          this.forwardType = paramObjectInput.readInt();
          this.shareData.readExternal(paramObjectInput);
          return;
        }
        this.mMsgException = true;
        return;
      }
    }
    catch (IOException paramObjectInput)
    {
      if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error"))) {
        this.mMsgException = true;
      }
    }
  }
  
  public void report(Object paramObject)
  {
    SdkShareReporter.a("2", this.uinType, this.mContentTitle, this.mSourceAppid);
  }
  
  protected void toContentXml(AbsStructMsg.XmlSerializerWithFilter paramXmlSerializerWithFilter)
  {
    paramXmlSerializerWithFilter.startTag(null, "item");
    paramXmlSerializerWithFilter.attribute(null, "layout", String.valueOf(this.mContentLayout));
    paramXmlSerializerWithFilter.startTag(null, "audio");
    Object localObject = this.mContentCover;
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.mContentCover;
    }
    paramXmlSerializerWithFilter.attribute(null, "cover", (String)localObject);
    if (this.mContentSrc == null) {
      localObject = "";
    } else {
      localObject = this.mContentSrc;
    }
    paramXmlSerializerWithFilter.attribute(null, "src", (String)localObject);
    paramXmlSerializerWithFilter.endTag(null, "audio");
    paramXmlSerializerWithFilter.startTag(null, "title");
    if (this.mContentTitle == null) {
      localObject = "";
    } else {
      localObject = this.mContentTitle;
    }
    paramXmlSerializerWithFilter.text((String)localObject);
    paramXmlSerializerWithFilter.endTag(null, "title");
    paramXmlSerializerWithFilter.startTag(null, "summary");
    if (this.mContentSummary == null) {
      localObject = str;
    } else {
      localObject = this.mContentSummary;
    }
    paramXmlSerializerWithFilter.text((String)localObject);
    paramXmlSerializerWithFilter.endTag(null, "summary");
    paramXmlSerializerWithFilter.endTag(null, "item");
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    Object localObject = this.mMsgAction;
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.mMsgAction;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsgActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsg_A_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsg_A_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsg_I_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsg_I_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgUrl == null) {
      localObject = "";
    } else {
      localObject = this.mMsgUrl;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgBrief == null) {
      localObject = "";
    } else {
      localObject = this.mMsgBrief;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.mContentLayout);
    if (this.mContentCover == null) {
      localObject = "";
    } else {
      localObject = this.mContentCover;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mContentSrc == null) {
      localObject = "";
    } else {
      localObject = this.mContentSrc;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mContentTitle == null) {
      localObject = "";
    } else {
      localObject = MessageUtils.a(this.mContentTitle, false);
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mContentSummary == null) {
      localObject = "";
    } else {
      localObject = MessageUtils.a(this.mContentSummary, false);
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null) {
      localObject = "";
    } else {
      localObject = this.mSourceIcon;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceName == null) {
      localObject = "";
    } else {
      localObject = this.mSourceName;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceUrl == null) {
      localObject = "";
    } else {
      localObject = this.mSourceUrl;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceAction == null) {
      localObject = "";
    } else {
      localObject = this.mSourceAction;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSourceActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSource_A_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSource_A_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSource_I_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSource_I_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.fwFlag);
    paramObjectOutput.writeInt(this.mFlag);
    paramObjectOutput.writeBoolean(this.mHasSource);
    if (this.mCommentText == null) {
      localObject = "";
    } else {
      localObject = this.mCommentText;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mCompatibleText == null) {
      localObject = "";
    } else {
      localObject = this.mCompatibleText;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeLong(this.msgId);
    paramObjectOutput.writeInt(this.mPromotionType);
    if (this.mPromotionMsg == null) {
      localObject = "";
    } else {
      localObject = this.mPromotionMsg;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mPromotionMenus == null) {
      localObject = "";
    } else {
      localObject = this.mPromotionMenus;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
    if (this.source_puin == null) {
      localObject = "";
    } else {
      localObject = this.source_puin;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.adverSign);
    if (this.adverKey == null) {
      localObject = "";
    } else {
      localObject = this.adverKey;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index == null) {
      localObject = "";
    } else {
      localObject = this.index;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index_name == null) {
      localObject = "";
    } else {
      localObject = this.index_name;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index_type == null) {
      localObject = "";
    } else {
      localObject = this.index_type;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.forwardType);
    this.shareData.writeExternal(paramObjectOutput);
    if (this.mCommonData == null) {
      localObject = str;
    } else {
      localObject = this.mCommonData;
    }
    paramObjectOutput.writeUTF((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForAudioShare
 * JD-Core Version:    0.7.0.1
 */