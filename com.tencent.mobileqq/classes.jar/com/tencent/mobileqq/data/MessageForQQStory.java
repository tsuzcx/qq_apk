package com.tencent.mobileqq.data;

import alud;
import android.graphics.Color;
import android.text.TextUtils;
import bhsz;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
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
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2 + alud.a(2131707011) + paramString3 + alud.a(2131707007) + "QQ" + alud.a(2131706979);
    }
    return paramString1 + "-" + paramString2 + alud.a(2131706990) + paramString3 + alud.a(2131707005) + "QQ" + alud.a(2131706974);
  }
  
  public void doParse()
  {
    super.doParse();
    localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
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
      this.mAttrMap = bhsz.a(this.msgAction);
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
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "doParse exp:" + localStructMsgForGeneralShare.mQQStoryExtra + ", " + localException.toString());
        }
      }
    }
    this.msg = getSummaryMsg();
  }
  
  public String getSummaryMsg()
  {
    return "[" + this.srcName + "]" + this.brief;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    Object localObject2 = "";
    try
    {
      localObject1 = String.format("#%x", new Object[] { Integer.valueOf(this.briefBgColor) });
      localObject2 = new StringBuilder("MessageForQQStory{");
      ((StringBuilder)localObject2).append("coverImgUrl='").append(this.coverImgUrl).append('\'');
      ((StringBuilder)localObject2).append(", logoImgUrl='").append(this.logoImgUrl).append('\'');
      ((StringBuilder)localObject2).append(", brief='").append(this.brief).append('\'');
      ((StringBuilder)localObject2).append(", briefBgColor=").append((String)localObject1);
      ((StringBuilder)localObject2).append(", srcName='").append(this.srcName).append('\'');
      ((StringBuilder)localObject2).append(", srcAction='").append(this.srcAction).append('\'');
      ((StringBuilder)localObject2).append(", msgAction='").append(this.msgAction).append('\'');
      ((StringBuilder)localObject2).append(", authorName='").append(this.authorName).append('\'');
      ((StringBuilder)localObject2).append(", type='").append(this.type).append('\'');
      ((StringBuilder)localObject2).append(", storyTitle='").append(this.storyTitle).append('\'');
      ((StringBuilder)localObject2).append(", storyBrief='").append(this.storyBrief).append('\'');
      ((StringBuilder)localObject2).append('}');
      return ((StringBuilder)localObject2).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.qqstory.share", 2, "toString exp:", localException);
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQStory
 * JD-Core Version:    0.7.0.1
 */