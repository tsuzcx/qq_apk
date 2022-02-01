package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import org.json.JSONObject;

public class MessageForQQStory
  extends MessageForStructing
{
  public static final String KEY_AUTHOR_NAME = "authorName";
  public static final String KEY_BRIEF_BG_COLOR = "briefBgColor";
  public static final String KEY_COVER_IMG_URL = "coverImgUrl";
  public static final String KEY_HEAD_TIP = "headtip";
  public static final String KEY_LOGO_IMG_URL = "logoImgUrl";
  public static final String KEY_STORY_BRIEF = "storyBrief";
  public static final String KEY_STORY_TITLE = "storyTitle";
  public static final String KEY_TYPE = "type";
  public static final String KEY_VID = "vid";
  public static final String TAG = "MessageForQQStory";
  public static final int TYPE_GUEST_FEED_LIST = 9;
  public static final int TYPE_GUEST_SINGLE = 6;
  public static final int TYPE_INFO_CARD = 7;
  public static final int TYPE_MY_MEMORY_ONE_DAY_VIDEO = 5;
  public static final int TYPE_MY_MEMORY_SINGLE_VIDEO = 4;
  public static final int TYPE_PGC_STORY = 0;
  public static final int TYPE_SELF_FEED_LIST = 8;
  public static final int TYPE_SHARE_BANNER = 13;
  public static final int TYPE_SHARE_GROUP_CARD_SHARE = 10;
  public static final int TYPE_SHARE_GROUP_MULTI_VIDEO = 11;
  public static final int TYPE_SHARE_GROUP_SINGLE_VIDEO = 12;
  public static final int TYPE_UGC_HOT_STORY = 2;
  public static final int TYPE_UGC_MY_DAY = 3;
  public static final int TYPE_UGC_MY_STORY = 1;
  public String authorName;
  public String brief;
  public int briefBgColor;
  public String coverImgUrl;
  public String logoImgUrl;
  public Map<String, String> mAttrMap;
  public String mHeadTip;
  public int mShareType;
  public String mVid;
  public String msgAction;
  public String srcAction;
  public String srcName;
  public String storyBrief;
  public String storyTitle;
  public int type = 1;
  
  public static String buildCompatibleText(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(HardCodeUtil.a(2131904503));
      paramString1.append(paramString3);
      paramString1.append(HardCodeUtil.a(2131904499));
      paramString1.append("QQ");
      paramString1.append(HardCodeUtil.a(2131904471));
      return paramString1.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(HardCodeUtil.a(2131904482));
    localStringBuilder.append(paramString3);
    localStringBuilder.append(HardCodeUtil.a(2131904497));
    localStringBuilder.append("QQ");
    localStringBuilder.append(HardCodeUtil.a(2131904466));
    return localStringBuilder.toString();
  }
  
  public void doParse()
  {
    super.doParse();
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
    this.brief = localStructMsgForGeneralShare.mMsgBrief;
    this.srcName = localStructMsgForGeneralShare.mSourceName;
    this.srcAction = localStructMsgForGeneralShare.mSourceAction;
    this.msgAction = localStructMsgForGeneralShare.mMsgAction;
    try
    {
      JSONObject localJSONObject = new JSONObject(localStructMsgForGeneralShare.mQQStoryExtra);
      this.coverImgUrl = localJSONObject.optString("coverImgUrl");
      this.logoImgUrl = localJSONObject.optString("logoImgUrl");
      this.briefBgColor = localJSONObject.optInt("briefBgColor");
      this.mHeadTip = localJSONObject.optString("headtip");
      this.mVid = localJSONObject.optString("vid");
      this.mAttrMap = URLUtil.a(this.msgAction);
      if (TextUtils.isEmpty(this.mVid))
      {
        this.mVid = ((String)this.mAttrMap.get("videoId"));
        if (TextUtils.isEmpty(this.mVid)) {
          this.mVid = ((String)this.mAttrMap.get("videoid"));
        }
      }
      if (this.briefBgColor == 0) {
        this.briefBgColor = Color.parseColor("#000000");
      }
      this.briefBgColor &= 0xFFFFFF;
      this.briefBgColor |= 0xD8000000;
      this.authorName = localJSONObject.optString("authorName");
      this.storyTitle = localJSONObject.optString("storyTitle");
      this.storyBrief = localJSONObject.optString("storyBrief");
      this.type = localJSONObject.optInt("type");
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doParse exp:");
        localStringBuilder.append(localStructMsgForGeneralShare.mQQStoryExtra);
        localStringBuilder.append(", ");
        localStringBuilder.append(localException.toString());
        QLog.w("Q.qqstory.share", 2, localStringBuilder.toString());
      }
    }
    this.msg = getSummaryMsg();
  }
  
  public String getSummaryMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.srcName);
    localStringBuilder.append("]");
    localStringBuilder.append(this.brief);
    return localStringBuilder.toString();
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    String str2;
    try
    {
      String str1 = String.format("#%x", new Object[] { Integer.valueOf(this.briefBgColor) });
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.share", 2, "toString exp:", localException);
      }
      str2 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder("MessageForQQStory{");
    localStringBuilder.append("coverImgUrl='");
    localStringBuilder.append(this.coverImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", logoImgUrl='");
    localStringBuilder.append(this.logoImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", brief='");
    localStringBuilder.append(this.brief);
    localStringBuilder.append('\'');
    localStringBuilder.append(", briefBgColor=");
    localStringBuilder.append(str2);
    localStringBuilder.append(", srcName='");
    localStringBuilder.append(this.srcName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", srcAction='");
    localStringBuilder.append(this.srcAction);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgAction='");
    localStringBuilder.append(this.msgAction);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authorName='");
    localStringBuilder.append(this.authorName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyTitle='");
    localStringBuilder.append(this.storyTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyBrief='");
    localStringBuilder.append(this.storyBrief);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQStory
 * JD-Core Version:    0.7.0.1
 */