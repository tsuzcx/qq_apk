package com.tencent.mobileqq.data;

import aio.qq_story.feed.AIOQQStoryFeedPB.AIOQQStoryFeed;
import aio.qq_story.feed.AIOQQStoryFeedPB.CoverItem;
import aio.qq_story.feed.AIOQQStoryFeedPB.MsgBody;
import ajjy;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class MessageForQQStoryFeed
  extends ChatMessage
{
  public static final String TAG = "MessageForQQStoryFeed";
  public long friendActionMills;
  public String mCoverUrl;
  public String mFeedAddress;
  public String mFeedId;
  public long mFeedTime;
  public int mKeepTime;
  public String mMainText;
  public int mQZoneRemainTime;
  public String mUnionId;
  
  public MessageForQQStoryFeed()
  {
    this.msgtype = -2061;
  }
  
  public MessageForQQStoryFeed(MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    this();
    this.mCoverUrl = paramMessageForQQStoryFeed.mCoverUrl;
    this.mFeedId = paramMessageForQQStoryFeed.mFeedId;
    this.mFeedTime = paramMessageForQQStoryFeed.mFeedTime;
    this.mKeepTime = paramMessageForQQStoryFeed.mKeepTime;
    this.mQZoneRemainTime = paramMessageForQQStoryFeed.mQZoneRemainTime;
    this.frienduin = paramMessageForQQStoryFeed.frienduin;
    this.time = paramMessageForQQStoryFeed.time;
    this.mFeedAddress = paramMessageForQQStoryFeed.mFeedAddress;
    this.mMainText = paramMessageForQQStoryFeed.mMainText;
    this.mUnionId = paramMessageForQQStoryFeed.mUnionId;
    this.friendActionMills = paramMessageForQQStoryFeed.friendActionMills;
  }
  
  @Deprecated
  public static AIOQQStoryFeedPB.MsgBody mockMsgPB()
  {
    AIOQQStoryFeedPB.CoverItem localCoverItem = new AIOQQStoryFeedPB.CoverItem();
    localCoverItem.str_cover.set("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D500/sign=e65f24392c2dd42a5b0901ab333a5b2f/00e93901213fb80e4a9910873fd12f2eb9389411.jpg");
    localCoverItem.str_content.set("我发表了2个小视频");
    AIOQQStoryFeedPB.MsgBody localMsgBody = new AIOQQStoryFeedPB.MsgBody();
    AIOQQStoryFeedPB.AIOQQStoryFeed localAIOQQStoryFeed = new AIOQQStoryFeedPB.AIOQQStoryFeed();
    localAIOQQStoryFeed.msg_covers_info.set(localCoverItem);
    localAIOQQStoryFeed.uint64_time.set(System.currentTimeMillis() / 1000L);
    localAIOQQStoryFeed.str_location.set(ajjy.a(2131640813));
    localAIOQQStoryFeed.str_feed_id.set("FEED-1000-2f583f987a1ffd3644b2672111f0d64b31d30c72d9598be3-20180412");
    localAIOQQStoryFeed.str_union_id.set("0_2463624242");
    localMsgBody.msg_aio_feed.set(localAIOQQStoryFeed);
    localMsgBody.uint32_keep_time.set(604800);
    localMsgBody.uint32_latest_qzone_time.set(10000);
    return localMsgBody;
  }
  
  protected void doParse()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageForQQStoryFeed", 2, "doParse invoked. ");
    }
    mergeFrom(this.msgData);
  }
  
  public boolean isEmpty()
  {
    return (this.mFeedTime <= 0L) || (TextUtils.isEmpty(this.mCoverUrl)) || (TextUtils.isEmpty(this.mUnionId)) || (TextUtils.isEmpty(this.mFeedId));
  }
  
  public void mergeFrom(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    AIOQQStoryFeedPB.MsgBody localMsgBody = new AIOQQStoryFeedPB.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      this.msgData = paramArrayOfByte;
      this.mCoverUrl = localMsgBody.msg_aio_feed.msg_covers_info.str_cover.get();
      this.mMainText = localMsgBody.msg_aio_feed.msg_covers_info.str_content.get();
      this.mFeedAddress = localMsgBody.msg_aio_feed.str_location.get();
      this.mUnionId = localMsgBody.msg_aio_feed.str_union_id.get();
      this.mFeedId = localMsgBody.msg_aio_feed.str_feed_id.get();
      this.mFeedTime = localMsgBody.msg_aio_feed.uint64_time.get();
      this.mKeepTime = localMsgBody.uint32_keep_time.get();
      this.mQZoneRemainTime = localMsgBody.uint32_latest_qzone_time.get();
      this.friendActionMills = localMsgBody.uint64_msg_time.get();
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageForQQStoryFeed", 2, "mergeFrom Failed. info: exception: ", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
  
  public void postRead()
  {
    doParse();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForQQStoryFeed{");
    localStringBuilder.append(", mFeedId='").append(this.mFeedId).append('\n');
    localStringBuilder.append(", mFeedTime=").append(this.mFeedTime);
    localStringBuilder.append(", mKeepTime=").append(this.mKeepTime);
    localStringBuilder.append(", mQZoneRemainTime=").append(this.mQZoneRemainTime);
    localStringBuilder.append(", mMainText='").append(this.mMainText).append('\n');
    localStringBuilder.append(", mFeedAddress='").append(this.mFeedAddress).append('\n');
    localStringBuilder.append(", friendActionMills=").append(this.friendActionMills);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQStoryFeed
 * JD-Core Version:    0.7.0.1
 */