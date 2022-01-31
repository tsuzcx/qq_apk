package com.tencent.mobileqq.structmsg;

import aihk;
import aihm;
import aihn;
import aiho;
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
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.Date;

public class StructMsgForAudioShare
  extends AbsShareMsg
  implements QQPlayerService.QQPlayerCallback
{
  private static View.OnClickListener a = new aihk();
  private WeakReference mCoverImage;
  private boolean mIsShowCommentLayout;
  private View.OnClickListener musicShareCoverClikListener = new aihm(this);
  
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
    localStructMsgForAudioShare.mContentCover = "http://url.cn/R3i1JD";
    localStructMsgForAudioShare.mContentLayout = 2;
    localStructMsgForAudioShare.mContentSrc = "http://url.cn/JpkdzT";
    localStructMsgForAudioShare.mContentSummary = "张惠妹";
    localStructMsgForAudioShare.mContentTitle = ("记得" + new Date());
    localStructMsgForAudioShare.mMsgUrl = "http://y.qq.com/i/song.html?songid=625023&source=qq";
    localStructMsgForAudioShare.mSourceName = "QQ音乐";
    localStructMsgForAudioShare.mMsgBrief = "QQ音乐 的分享";
    localStructMsgForAudioShare.mMsgAction = "web";
    localStructMsgForAudioShare.mMsgActionData = "y.qq.com";
    localStructMsgForAudioShare.mMsg_A_ActionData = "com.tencent.qqmusic";
    localStructMsgForAudioShare.mSource_I_ActionData = "tencent100497308://";
    localStructMsgForAudioShare.mSourceAction = "app";
    localStructMsgForAudioShare.mMsgTemplateID = 1;
    localStructMsgForAudioShare.mSourceAppid = 100497308L;
    localStructMsgForAudioShare.mSourceUrl = "http://web.p.qq.com/qqmpmobile/aio/app.html?id=100497308";
    localStructMsgForAudioShare.mSourceIcon = "http://p.qpic.cn/qqconnect_app_logo/1LlgQzJVOyA9xucianwgfHru8JA97ERytRa0lHcRRGGw/0";
    return localStructMsgForAudioShare;
  }
  
  public static void onClickEvent(Context paramContext, StructMsgForAudioShare paramStructMsgForAudioShare)
  {
    int j = 1;
    if ("web".equals(paramStructMsgForAudioShare.mMsgAction))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", paramStructMsgForAudioShare.mMsgUrl);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", AppShareIDUtil.a(paramStructMsgForAudioShare.mSourceAppid));
      paramContext.sendBroadcast(new Intent("qqplayer_exit_action"));
      PublicAccountUtil.a(paramStructMsgForAudioShare.message, localIntent, paramStructMsgForAudioShare.mMsgUrl);
      paramContext.startActivity(localIntent);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramStructMsgForAudioShare.mMsgUrl, "", "", "");
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      for (i = j;; i = 0)
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForAudioShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForAudioShare.msgId, paramStructMsgForAudioShare.templateIDForPortal, "", paramStructMsgForAudioShare.mMsgUrl);
        paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForAudioShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForAudioShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(paramStructMsgForAudioShare.mMsgUrl));
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForAudioShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
        return;
      }
    }
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    ImageView localImageView;
    Object localObject;
    TextView localTextView;
    String str1;
    if (paramView != null)
    {
      localImageView = (ImageView)paramView.findViewById(2131361925);
      localObject = (TextView)paramView.findViewById(2131361926);
      localTextView = (TextView)paramView.findViewById(2131361927);
      str1 = this.mContentCover;
      String str2 = this.mContentTitle;
      String str3 = this.mContentSummary;
      ((TextView)localObject).setText(str2);
      localTextView.setText(str3);
      if (TextUtils.isEmpty(str2)) {
        break label158;
      }
      localTextView.setMaxLines(2);
      ((TextView)localObject).setVisibility(0);
      label92:
      if (!TextUtils.isEmpty(str3)) {
        break label174;
      }
    }
    label158:
    label174:
    for (int i = 3;; i = 2)
    {
      ((TextView)localObject).setMaxLines(i);
      localObject = paramContext.getResources().getDrawable(2130846102);
      localImageView.setBackgroundDrawable(null);
      if (!TextUtils.isEmpty(str1)) {
        break label179;
      }
      localImageView.setImageDrawable((Drawable)localObject);
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2130971595, null);
      break;
      ((TextView)localObject).setVisibility(8);
      localTextView.setMaxLines(4);
      break label92;
    }
    label179:
    if ((!str1.startsWith("http://")) && (!str1.startsWith("https://"))) {}
    for (paramContext = Uri.fromFile(new File(str1)).toString();; paramContext = str1)
    {
      localImageView.setImageDrawable(URLDrawable.getDrawable(paramContext, (Drawable)localObject, (Drawable)localObject));
      return paramView;
    }
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
      paramContext.setId(2131361855);
      paramContext.setTag(2131361855, this);
      return paramContext;
    }
    this.mIsShowCommentLayout = paramBundle.getBoolean("isShowCommentLayout", false);
    paramBundle = paramContext.getResources();
    paramView = LayoutInflater.from(paramContext).inflate(2130971592, null);
    paramOnLongClickAndTouchListener = (URLImageView)paramView.findViewById(2131361925);
    Object localObject1 = paramView.findViewById(2131368330);
    int i;
    Object localObject2;
    if (this.mIsShowCommentLayout)
    {
      ((View)localObject1).setVisibility(0);
      i = AIOUtils.a(2.0F, paramBundle);
      paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), i);
      this.mCoverImage = new WeakReference(paramOnLongClickAndTouchListener);
      localObject1 = (TextView)paramView.findViewById(2131361926);
      localObject2 = (TextView)paramView.findViewById(2131361927);
      ((TextView)localObject1).setText(this.mContentTitle);
      ((TextView)localObject2).setText(this.mContentSummary);
      if (TextUtils.isEmpty(this.mContentTitle)) {
        break label399;
      }
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setVisibility(0);
      label199:
      if (!TextUtils.isEmpty(this.mContentSummary)) {
        break label415;
      }
      i = 3;
      label212:
      ((TextView)localObject1).setMaxLines(i);
      paramOnLongClickAndTouchListener.setVisibility(0);
      if (!QQPlayerService.a(this)) {
        break label421;
      }
      paramOnLongClickAndTouchListener.setImageResource(2130842745);
      paramOnLongClickAndTouchListener.setContentDescription(paramBundle.getString(2131437019));
      label250:
      if (TextUtils.isEmpty(this.mContentCover)) {
        break label489;
      }
      localObject1 = this.mContentCover;
      localObject2 = paramBundle.getDrawable(2130846102);
    }
    for (;;)
    {
      try
      {
        i = AIOUtils.a(140.0F, paramBundle);
        paramBundle = URLDrawable.getDrawable((String)localObject1, i, i, (Drawable)localObject2, (Drawable)localObject2);
        if (AbsDownloader.a((String)localObject1)) {
          break label515;
        }
        if (URLDrawableHelper.a(paramContext)) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        label399:
        label415:
        label421:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AudioShareMsg", 2, "getView " + paramContext.getMessage());
        continue;
      }
      paramBundle.setAutoDownload(bool);
      paramOnLongClickAndTouchListener.setBackgroundDrawable(paramBundle);
      paramContext = paramView.getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
        paramView.setLayoutParams(paramContext);
        paramOnLongClickAndTouchListener.setTag(this);
        paramOnLongClickAndTouchListener.setOnClickListener(this.musicShareCoverClikListener);
        paramView.setId(2131361855);
        paramView.setTag(2131361855, this);
        return paramView;
        ((View)localObject1).setVisibility(8);
        break;
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject2).setMaxLines(4);
        break label199;
        i = 2;
        break label212;
        paramOnLongClickAndTouchListener.setImageResource(2130842744);
        paramOnLongClickAndTouchListener.setContentDescription(paramBundle.getString(2131437018));
        break label250;
        bool = false;
        continue;
        label489:
        paramOnLongClickAndTouchListener.setBackgroundResource(2130846102);
        continue;
      }
      paramContext.width = BaseChatItemLayout.e;
      paramContext.height = -2;
      continue;
      label515:
      boolean bool = true;
    }
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.mCoverImage == null) || (this.mCoverImage.get() == null)) {}
    URLImageView localURLImageView;
    do
    {
      return;
      localURLImageView = (URLImageView)this.mCoverImage.get();
    } while (localURLImageView == null);
    Resources localResources = localURLImageView.getContext().getResources();
    if ((paramInt == 2) || (paramInt == 1))
    {
      localURLImageView.post(new aihn(this, localURLImageView));
      localURLImageView.setContentDescription(localResources.getString(2131437019));
      return;
    }
    localURLImageView.post(new aiho(this, localURLImageView));
    localURLImageView.setContentDescription(localResources.getString(2131437018));
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    do
    {
      do
      {
        return true;
        this.mContentLayout = StructMsgUtils.a(paramStructMsgNode.a("layout"));
      } while ((paramStructMsgNode == null) || (paramStructMsgNode.a() < 3));
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
    } while (paramStructMsgNode == null);
    this.mContentSummary = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
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
      else if (i >= 2)
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
        if (i >= 3)
        {
          this.mCompatibleText = paramObjectInput.readUTF();
          this.msgId = paramObjectInput.readLong();
          this.mPromotionType = paramObjectInput.readInt();
          this.mPromotionMsg = paramObjectInput.readUTF();
          this.mPromotionMenus = paramObjectInput.readUTF();
          this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
          if (i >= 5)
          {
            this.source_puin = paramObjectInput.readUTF();
            if (i >= 7)
            {
              this.adverSign = paramObjectInput.readInt();
              this.adverKey = paramObjectInput.readUTF();
              this.index = paramObjectInput.readUTF();
              this.index_name = paramObjectInput.readUTF();
              this.index_type = paramObjectInput.readUTF();
              if (i >= 15)
              {
                this.forwardType = paramObjectInput.readInt();
                this.shareData.readExternal(paramObjectInput);
                if (i >= 16) {}
              }
            }
          }
        }
      }
      else
      {
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
  
  protected void toContentXml(AbsStructMsg.XmlSerializerWithFilter paramXmlSerializerWithFilter)
  {
    paramXmlSerializerWithFilter.startTag(null, "item");
    paramXmlSerializerWithFilter.attribute(null, "layout", String.valueOf(this.mContentLayout));
    paramXmlSerializerWithFilter.startTag(null, "audio");
    if (this.mContentCover == null)
    {
      str = "";
      paramXmlSerializerWithFilter.attribute(null, "cover", str);
      if (this.mContentSrc != null) {
        break label169;
      }
      str = "";
      label64:
      paramXmlSerializerWithFilter.attribute(null, "src", str);
      paramXmlSerializerWithFilter.endTag(null, "audio");
      paramXmlSerializerWithFilter.startTag(null, "title");
      if (this.mContentTitle != null) {
        break label177;
      }
      str = "";
      label102:
      paramXmlSerializerWithFilter.text(str);
      paramXmlSerializerWithFilter.endTag(null, "title");
      paramXmlSerializerWithFilter.startTag(null, "summary");
      if (this.mContentSummary != null) {
        break label185;
      }
    }
    label169:
    label177:
    label185:
    for (String str = "";; str = this.mContentSummary)
    {
      paramXmlSerializerWithFilter.text(str);
      paramXmlSerializerWithFilter.endTag(null, "summary");
      paramXmlSerializerWithFilter.endTag(null, "item");
      return;
      str = this.mContentCover;
      break;
      str = this.mContentSrc;
      break label64;
      str = this.mContentTitle;
      break label102;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgActionData != null) {
        break label606;
      }
      str = "";
      label57:
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_A_ActionData != null) {
        break label614;
      }
      str = "";
      label74:
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_I_ActionData != null) {
        break label622;
      }
      str = "";
      label91:
      paramObjectOutput.writeUTF(str);
      if (this.mMsgUrl != null) {
        break label630;
      }
      str = "";
      label108:
      paramObjectOutput.writeUTF(str);
      if (this.mMsgBrief != null) {
        break label638;
      }
      str = "";
      label125:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mContentLayout);
      if (this.mContentCover != null) {
        break label646;
      }
      str = "";
      label152:
      paramObjectOutput.writeUTF(str);
      if (this.mContentSrc != null) {
        break label654;
      }
      str = "";
      label169:
      paramObjectOutput.writeUTF(str);
      if (this.mContentTitle != null) {
        break label662;
      }
      str = "";
      label186:
      paramObjectOutput.writeUTF(str);
      if (this.mContentSummary != null) {
        break label674;
      }
      str = "";
      label203:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.mSourceAppid);
      if (this.mSourceIcon != null) {
        break label686;
      }
      str = "";
      label230:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceName != null) {
        break label694;
      }
      str = "";
      label247:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceUrl != null) {
        break label702;
      }
      str = "";
      label264:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceAction != null) {
        break label710;
      }
      str = "";
      label281:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceActionData != null) {
        break label718;
      }
      str = "";
      label298:
      paramObjectOutput.writeUTF(str);
      if (this.mSource_A_ActionData != null) {
        break label726;
      }
      str = "";
      label315:
      paramObjectOutput.writeUTF(str);
      if (this.mSource_I_ActionData != null) {
        break label734;
      }
      str = "";
      label332:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label742;
      }
      str = "";
      label379:
      paramObjectOutput.writeUTF(str);
      if (this.mCompatibleText != null) {
        break label750;
      }
      str = "";
      label396:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label758;
      }
      str = "";
      label433:
      paramObjectOutput.writeUTF(str);
      if (this.mPromotionMenus != null) {
        break label766;
      }
      str = "";
      label450:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.source_puin != null) {
        break label774;
      }
      str = "";
      label477:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label782;
      }
      str = "";
      label504:
      paramObjectOutput.writeUTF(str);
      if (this.index != null) {
        break label790;
      }
      str = "";
      label521:
      paramObjectOutput.writeUTF(str);
      if (this.index_name != null) {
        break label798;
      }
      str = "";
      label538:
      paramObjectOutput.writeUTF(str);
      if (this.index_type != null) {
        break label806;
      }
      str = "";
      label555:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.forwardType);
      this.shareData.writeExternal(paramObjectOutput);
      if (this.mCommonData != null) {
        break label814;
      }
    }
    label646:
    label654:
    label662:
    label674:
    label806:
    label814:
    for (String str = "";; str = this.mCommonData)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.mMsgAction;
      break;
      label606:
      str = this.mMsgActionData;
      break label57;
      label614:
      str = this.mMsg_A_ActionData;
      break label74;
      label622:
      str = this.mMsg_I_ActionData;
      break label91;
      label630:
      str = this.mMsgUrl;
      break label108;
      label638:
      str = this.mMsgBrief;
      break label125;
      str = this.mContentCover;
      break label152;
      str = this.mContentSrc;
      break label169;
      str = MessageUtils.a(this.mContentTitle, false);
      break label186;
      str = MessageUtils.a(this.mContentSummary, false);
      break label203;
      label686:
      str = this.mSourceIcon;
      break label230;
      label694:
      str = this.mSourceName;
      break label247;
      label702:
      str = this.mSourceUrl;
      break label264;
      label710:
      str = this.mSourceAction;
      break label281;
      label718:
      str = this.mSourceActionData;
      break label298;
      label726:
      str = this.mSource_A_ActionData;
      break label315;
      label734:
      str = this.mSource_I_ActionData;
      break label332;
      label742:
      str = this.mCommentText;
      break label379;
      label750:
      str = this.mCompatibleText;
      break label396;
      label758:
      str = this.mPromotionMsg;
      break label433;
      label766:
      str = this.mPromotionMenus;
      break label450;
      str = this.source_puin;
      break label477;
      str = this.adverKey;
      break label504;
      str = this.index;
      break label521;
      str = this.index_name;
      break label538;
      str = this.index_type;
      break label555;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForAudioShare
 * JD-Core Version:    0.7.0.1
 */