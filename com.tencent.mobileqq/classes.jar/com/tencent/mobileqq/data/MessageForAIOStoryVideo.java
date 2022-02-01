package com.tencent.mobileqq.data;

import NS_QQ_STORY_META.META.StImage;
import NS_QQ_STORY_META.META.StStoryFeed;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class MessageForAIOStoryVideo
  extends ChatMessage
{
  public static final String MSG_STORY_FEED_CREATE_TIME = "createtime";
  public static final String MSG_STORY_FEED_KEY_COVER = "cover";
  public static final String MSG_STORY_FEED_KEY_DESC = "desc";
  public static final String TAG = "MessageForAIOStoryVideo";
  public String cover = "";
  public long createtime = 0L;
  public META.StStoryFeed mStStoryFeed = new META.StStoryFeed();
  public String text = "";
  
  public MessageForAIOStoryVideo()
  {
    this.msgtype = -2074;
    this.mNeedTimeStamp = false;
  }
  
  protected void doParse()
  {
    try
    {
      if (TextUtils.isEmpty(this.msg)) {
        break label117;
      }
      localObject = Base64.decode(this.msg, 0);
      if (this.mStStoryFeed == null) {
        break label117;
      }
      this.mStStoryFeed.mergeFrom((byte[])localObject);
      if (this.mStStoryFeed.coverImage != null) {
        this.cover = this.mStStoryFeed.coverImage.url.get();
      }
      this.createtime = this.mStStoryFeed.createTime.get();
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      label77:
      label117:
      break label77;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doParseForMessageForAIOStoryVideo:");
      ((StringBuilder)localObject).append(this.msg);
      QLog.i("MessageForAIOStoryVideo", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForAIOStoryVideo
 * JD-Core Version:    0.7.0.1
 */