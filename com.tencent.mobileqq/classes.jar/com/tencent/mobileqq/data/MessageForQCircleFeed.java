package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForQCircleFeed
  extends ChatMessage
{
  public static final String MSG_QCIRCLE_FEED_KEY_ACTION_URL = "actionUrl";
  public static final String MSG_QCIRCLE_FEED_KEY_APPID = "appid";
  public static final String MSG_QCIRCLE_FEED_KEY_COMMENT_NUMS = "commentNums";
  public static final String MSG_QCIRCLE_FEED_KEY_CONTENT = "content";
  public static final String MSG_QCIRCLE_FEED_KEY_CONTENT_JUMP_URL = "contentJumpUrl";
  public static final String MSG_QCIRCLE_FEED_KEY_COVER_URL = "coverImageUrl";
  public static final String MSG_QCIRCLE_FEED_KEY_FEEDID = "feedid";
  public static final String MSG_QCIRCLE_FEED_KEY_FROM_UIN = "fromuin";
  public static final String MSG_QCIRCLE_FEED_KEY_IMAGE_COUNT = "imageCount";
  public static final String MSG_QCIRCLE_FEED_KEY_IS_FIRST_MSG_WITH_NEWFRIEND = "isFirstMsgWithNewFriend";
  public static final String MSG_QCIRCLE_FEED_KEY_LBS_INFO = "lbsinfo";
  public static final String MSG_QCIRCLE_FEED_KEY_LIKE_COUNT = "likeCount";
  public static final String MSG_QCIRCLE_FEED_KEY_LIKE_NUMS = "likeNums";
  public static final String MSG_QCIRCLE_FEED_KEY_MEDIA_DATAS = "mediaDatas";
  public static final String MSG_QCIRCLE_FEED_KEY_PUSH_COUNT = "pushCount";
  public static final String MSG_QCIRCLE_FEED_KEY_SUMMERY = "summery";
  public static final String MSG_QCIRCLE_FEED_KEY_TIME = "time";
  public static final String MSG_QCIRCLE_FEED_KEY_TITLE = "title";
  public static final String MSG_QCIRCLE_FEED_KEY_TYPE = "type";
  public static final String MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT = "videoCount";
  public static final String MSG_QCIRCLE_FEED_LEY_BUSI_DATA = "busiData";
  public static final String MSG_QCIRCLE_FEED_LEY_EXTEND_INFO = "mapExt";
  public static final String MSG_QCIRCLE_STRUCT_VERSION = "version";
  public static final int MSG_QCIRCLE_VERSION = 2;
  public String actionUrl;
  public int appId;
  public String content;
  public String contentJumpUrl;
  public String coverImageUrl;
  public String feedId;
  public JSONObject feedMsg;
  public long feedTime;
  public long fromUin;
  public boolean hasExposed;
  public int imageCount;
  public boolean isFirstMsgWithNewFriend = false;
  public boolean isOldStructMsg = false;
  public String lbsInfo;
  public int likeCount;
  public HashMap<String, String> mapExt;
  public ArrayList<MessageForQCircleFeed.MediaData> mediaDatas;
  public int pushCount;
  public String summery;
  public String title;
  public int type;
  public int uCommentNum;
  public int ulikeNum;
  public int version;
  
  public MessageForQCircleFeed()
  {
    this.msgtype = -2077;
    this.mNeedTimeStamp = false;
  }
  
  public MessageForQCircleFeed(MessageRecord paramMessageRecord)
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
    this.msgtype = -2077;
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
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("MessageForQCircleFeed doParse feedMsg:");
        ((StringBuilder)localObject1).append(this.msg);
        QLog.i("AIOQCircleFeed.QCircleFeeds", 2, ((StringBuilder)localObject1).toString());
      }
      this.feedMsg = new JSONObject(this.msg);
      this.appId = this.feedMsg.optInt("appid");
      this.feedId = this.feedMsg.optString("feedid");
      this.fromUin = this.feedMsg.optLong("fromuin");
      this.feedTime = this.feedMsg.optLong("time");
      this.lbsInfo = this.feedMsg.optString("lbsinfo");
      this.summery = this.feedMsg.optString("summery");
      this.title = this.feedMsg.optString("title");
      this.content = this.feedMsg.optString("content");
      this.coverImageUrl = this.feedMsg.optString("coverImageUrl");
      this.imageCount = this.feedMsg.optInt("imageCount");
      this.pushCount = this.feedMsg.optInt("pushCount");
      this.likeCount = this.feedMsg.optInt("likeCount");
      this.actionUrl = this.feedMsg.optString("actionUrl");
      this.ulikeNum = this.feedMsg.optInt("likeNums");
      this.uCommentNum = this.feedMsg.optInt("commentNums");
      this.isFirstMsgWithNewFriend = this.feedMsg.optBoolean("isFirstMsgWithNewFriend");
      this.type = this.feedMsg.optInt("type");
      this.version = this.feedMsg.optInt("version");
      this.contentJumpUrl = this.feedMsg.optString("contentJumpUrl");
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
            this.mediaDatas.add(MessageForQCircleFeed.MediaData.createFromJson((String)localObject2));
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
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("convert msg to json failed,error msg is:");
        ((StringBuilder)localObject2).append(localJSONException.getMessage());
        QLog.d("AIOQCircleFeed", 2, ((StringBuilder)localObject2).toString(), localJSONException);
      }
      this.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQCircleFeed
 * JD-Core Version:    0.7.0.1
 */