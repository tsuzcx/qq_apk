package com.tencent.mobileqq.data;

import ajya;
import android.graphics.Color;
import android.text.TextUtils;
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
  public static final String TAG = MessageForTribeShortVideo.class.getSimpleName();
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
    return ajya.a(2131706582) + "QQ" + ajya.a(2131706610);
  }
  
  public void doParse()
  {
    super.doParse();
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
    if (localStructMsgForGeneralShare.mMsgBrief.length() > 68) {}
    for (this.brief = localStructMsgForGeneralShare.mMsgBrief.substring(0, 68);; this.brief = localStructMsgForGeneralShare.mMsgBrief)
    {
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
        while (!QLog.isColorLevel()) {}
        QLog.w(TAG, 2, "doParse exp:" + localStructMsgForGeneralShare.mTribeShortVideoExtra + ", " + localException.toString());
      }
    }
  }
  
  public String getSummaryMsg()
  {
    if (!TextUtils.isEmpty(this.themeName)) {
      return ajya.a(2131706601) + this.themeName;
    }
    if (!TextUtils.isEmpty(this.brief)) {
      return ajya.a(2131706576) + this.brief;
    }
    return ajya.a(2131706618);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForTribeShortVideo{");
    localStringBuilder.append("mVid='").append(this.mVid).append('\'');
    localStringBuilder.append(", videoUrl='").append(this.videoUrl).append('\'');
    localStringBuilder.append(", coverImgUrl=").append(this.coverImgUrl);
    localStringBuilder.append(", srcName='").append(this.srcName).append('\'');
    localStringBuilder.append(", srcAction='").append(this.sourceActionType).append('\'');
    localStringBuilder.append(", sourceJumpUrl='").append(this.sourceJumpUrl).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTribeShortVideo
 * JD-Core Version:    0.7.0.1
 */