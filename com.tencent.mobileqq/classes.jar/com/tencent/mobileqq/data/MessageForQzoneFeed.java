package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForQzoneFeed
  extends ChatMessage
{
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  public static final String MSG_QZONE_FEED_KEY_ACTION_URL = "actionUrl";
  public static final String MSG_QZONE_FEED_KEY_APPID = "appid";
  public static final String MSG_QZONE_FEED_KEY_COMMENT_NUMS = "commentNums";
  public static final String MSG_QZONE_FEED_KEY_CONTENT = "content";
  public static final String MSG_QZONE_FEED_KEY_COVER_URL = "coverImageUrl";
  public static final String MSG_QZONE_FEED_KEY_FROM_UIN = "fromuin";
  public static final String MSG_QZONE_FEED_KEY_GENDER = "iGender";
  public static final String MSG_QZONE_FEED_KEY_IMAGE_COUNT = "imageCount";
  public static final String MSG_QZONE_FEED_KEY_IS_FIRST_MSG_WITH_NEWFRIEND = "isFirstMsgWithNewFriend";
  public static final String MSG_QZONE_FEED_KEY_LBS_INFO = "lbsinfo";
  public static final String MSG_QZONE_FEED_KEY_LIKE_NUMS = "likeNums";
  public static final String MSG_QZONE_FEED_KEY_MEDIA_DATAS = "mediaDatas";
  public static final String MSG_QZONE_FEED_KEY_SUMMERY = "summery";
  public static final String MSG_QZONE_FEED_KEY_TIME = "time";
  public static final String MSG_QZONE_FEED_KEY_TITLE = "title";
  public static final String MSG_QZONE_FEED_LEY_EXTEND_INFO = "mapExt";
  public static final String MSG_QZONE_STRUCT_VERSION = "version";
  public static final int MSG_QZONE_VERSION = 2;
  public String actionUrl;
  public int appId;
  public String content;
  public String coverImageUrl;
  public JSONObject feedMsg;
  public long feedTime;
  public long fromUin;
  public int gender = 0;
  public boolean hasExposed;
  public int imageCount;
  public boolean isFirstMsgWithNewFriend;
  public boolean isOldStructMsg;
  public String lbsInfo;
  public HashMap<String, String> mapExt;
  public ArrayList<MessageForQzoneFeed.MediaData> mediaDatas;
  public String summery;
  public String title;
  public int uCommentNum;
  public int ulikeNum;
  public int version;
  
  public MessageForQzoneFeed()
  {
    this.msgtype = -2015;
    this.mNeedTimeStamp = false;
  }
  
  public MessageForQzoneFeed(MessageRecord paramMessageRecord)
  {
    this.extInt = paramMessageRecord.extInt;
    this.extLong = paramMessageRecord.extLong;
    this.extraflag = paramMessageRecord.extraflag;
    this.extStr = paramMessageRecord.extStr;
    this.frienduin = paramMessageRecord.frienduin;
    this.isread = paramMessageRecord.isread;
    this.issend = paramMessageRecord.issend;
    this.istroop = paramMessageRecord.istroop;
    this.isValid = paramMessageRecord.isValid;
    this.longMsgCount = paramMessageRecord.longMsgCount;
    this.longMsgId = paramMessageRecord.longMsgId;
    this.longMsgIndex = paramMessageRecord.longMsgIndex;
    this.msg = paramMessageRecord.msg;
    this.msgData = paramMessageRecord.msgData;
    this.msgseq = paramMessageRecord.msgseq;
    this.msgtype = -2015;
    this.msgUid = paramMessageRecord.msgUid;
    this.selfuin = paramMessageRecord.selfuin;
    this.senderuin = paramMessageRecord.senderuin;
    this.sendFailCode = paramMessageRecord.sendFailCode;
    this.shmsgseq = paramMessageRecord.shmsgseq;
    this.time = paramMessageRecord.time;
    this.uniseq = paramMessageRecord.uniseq;
    this.versionCode = paramMessageRecord.versionCode;
    this.vipBubbleID = paramMessageRecord.vipBubbleID;
  }
  
  protected void doParse()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOQzoneFeed.QZoneFeeds", 2, "MessageForQzoneFeed doParse feedMsg:" + this.msg);
      }
      this.feedMsg = new JSONObject(this.msg);
      this.appId = this.feedMsg.optInt("appid");
      this.fromUin = this.feedMsg.optLong("fromuin");
      this.feedTime = this.feedMsg.optLong("time");
      this.lbsInfo = this.feedMsg.optString("lbsinfo");
      this.summery = this.feedMsg.optString("summery");
      this.title = this.feedMsg.optString("title");
      this.content = this.feedMsg.optString("content");
      this.coverImageUrl = this.feedMsg.optString("coverImageUrl");
      this.imageCount = this.feedMsg.optInt("imageCount");
      this.actionUrl = this.feedMsg.optString("actionUrl");
      this.ulikeNum = this.feedMsg.optInt("likeNums");
      this.uCommentNum = this.feedMsg.optInt("commentNums");
      this.isFirstMsgWithNewFriend = this.feedMsg.optBoolean("isFirstMsgWithNewFriend");
      this.gender = this.feedMsg.optInt("iGender");
      this.version = this.feedMsg.optInt("version");
      if (this.version < 2) {
        this.isOldStructMsg = true;
      }
      Object localObject1 = this.feedMsg.optString("mediaDatas");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new JSONArray((String)localObject1);
        if (((JSONArray)localObject1).length() > 0)
        {
          this.mediaDatas = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getString(i);
            this.mediaDatas.add(MessageForQzoneFeed.MediaData.createFromJson((String)localObject2));
            i += 1;
          }
        }
      }
      localObject1 = this.feedMsg.optString("mapExt");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).keys();
        this.mapExt = new HashMap();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          this.mapExt.put(str, ((JSONObject)localObject1).optString(str));
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOQzoneFeed", 2, "convert msg to json failed,error msg is:" + localJSONException.getMessage(), localJSONException);
      }
      this.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQzoneFeed
 * JD-Core Version:    0.7.0.1
 */