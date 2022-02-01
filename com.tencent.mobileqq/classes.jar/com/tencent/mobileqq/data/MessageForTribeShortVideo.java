package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MessageForTribeShortVideo
  extends MessageForStructing
{
  public static final String KEY_BRIEF_BG_COLOR = "briefBgColor";
  public static final String KEY_THEME_NAME = "tribe_video_theme";
  public static final String KEY_TRIBE_NAME = "tribe_name";
  public static final String KEY_TYPE = "type";
  public static final String KEY_VID = "tribe_video_vid";
  public static final String KEY_VIDEO_HEIGHT = "tribe_video_height";
  public static final String KEY_VIDEO_URL = "tribe_video_url";
  public static final String KEY_VIDEO_WIDTH = "tribe_video_width";
  public static final String TAG = "MessageForTribeShortVideo";
  public String bid;
  public String brief;
  public int briefBgColor;
  public String coverImgUrl;
  public String jumpUrl;
  public String mVid;
  public String msgAction;
  public String pid;
  public String sourceActionType;
  public String sourceJumpUrl;
  public String srcAction;
  public String srcName;
  public String themeName;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public static String buildCompatibleText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131706607));
    localStringBuilder.append("QQ");
    localStringBuilder.append(HardCodeUtil.a(2131706635));
    return localStringBuilder.toString();
  }
  
  public void doParse()
  {
    super.doParse();
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
    if (localStructMsgForGeneralShare.mMsgBrief.length() > 68) {
      this.brief = localStructMsgForGeneralShare.mMsgBrief.substring(0, 68);
    } else {
      this.brief = localStructMsgForGeneralShare.mMsgBrief;
    }
    this.srcAction = localStructMsgForGeneralShare.mSourceAction;
    this.msgAction = localStructMsgForGeneralShare.mMsgAction;
    this.jumpUrl = localStructMsgForGeneralShare.mMsgUrl;
    this.sourceJumpUrl = localStructMsgForGeneralShare.mSourceUrl;
    this.coverImgUrl = localStructMsgForGeneralShare.mContentCover;
    try
    {
      JSONObject localJSONObject = new JSONObject(localStructMsgForGeneralShare.mTribeShortVideoExtra);
      this.srcName = localJSONObject.optString("tribe_name");
      this.videoUrl = localJSONObject.optString("tribe_video_url");
      this.briefBgColor = localJSONObject.optInt("briefBgColor");
      this.videoWidth = localJSONObject.optInt("tribe_video_width");
      this.videoHeight = localJSONObject.optInt("tribe_video_height");
      this.mVid = localJSONObject.optString("tribe_video_vid");
      this.themeName = localJSONObject.optString("tribe_video_theme");
      this.bid = localJSONObject.optString("tribe_bid");
      this.pid = localJSONObject.optString("tribe_pid");
      if (this.themeName.length() > 68) {
        this.themeName = this.themeName.substring(0, 68);
      }
      if (this.briefBgColor == 0) {
        this.briefBgColor = Color.parseColor("#000000");
      }
      this.briefBgColor &= 0xFFFFFF;
      this.briefBgColor |= 0xD8000000;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doParse exp:");
        localStringBuilder.append(localStructMsgForGeneralShare.mTribeShortVideoExtra);
        localStringBuilder.append(", ");
        localStringBuilder.append(localException.toString());
        QLog.w(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public String getSummaryMsg()
  {
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(this.themeName))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131706626));
      localStringBuilder.append(this.themeName);
      return localStringBuilder.toString();
    }
    if (!TextUtils.isEmpty(this.brief))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131706602));
      localStringBuilder.append(this.brief);
      return localStringBuilder.toString();
    }
    return HardCodeUtil.a(2131706643);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForTribeShortVideo{");
    localStringBuilder.append("mVid='");
    localStringBuilder.append(this.mVid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.videoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverImgUrl=");
    localStringBuilder.append(this.coverImgUrl);
    localStringBuilder.append(", srcName='");
    localStringBuilder.append(this.srcName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", srcAction='");
    localStringBuilder.append(this.sourceActionType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sourceJumpUrl='");
    localStringBuilder.append(this.sourceJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTribeShortVideo
 * JD-Core Version:    0.7.0.1
 */