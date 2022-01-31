package com.tencent.mobileqq.data;

import aio.qq_story.feed.AIOQQStoryFeedPB.AIOQQStoryFeed;
import aio.qq_story.feed.AIOQQStoryFeedPB.CoverItem;
import aio.qq_story.feed.AIOQQStoryFeedPB.MsgBody;
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
  public String str_cover;
  public String str_feed_id;
  public String str_jump_url;
  public int uint32_keep_time;
  public int uint32_latest_qzone_time;
  public int uint32_video_num;
  public long uint64_time;
  
  public MessageForQQStoryFeed()
  {
    this.msgtype = -2061;
    this.msg = "";
  }
  
  public MessageForQQStoryFeed(MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    this();
    this.str_cover = paramMessageForQQStoryFeed.str_cover;
    this.str_jump_url = paramMessageForQQStoryFeed.str_jump_url;
    this.str_feed_id = paramMessageForQQStoryFeed.str_feed_id;
    this.uint64_time = paramMessageForQQStoryFeed.uint64_time;
    this.uint32_video_num = paramMessageForQQStoryFeed.uint32_video_num;
    this.uint32_keep_time = paramMessageForQQStoryFeed.uint32_keep_time;
    this.uint32_latest_qzone_time = paramMessageForQQStoryFeed.uint32_latest_qzone_time;
    this.frienduin = paramMessageForQQStoryFeed.frienduin;
    this.time = paramMessageForQQStoryFeed.time;
  }
  
  @Deprecated
  public static AIOQQStoryFeedPB.MsgBody mockMsgPB()
  {
    AIOQQStoryFeedPB.CoverItem localCoverItem = new AIOQQStoryFeedPB.CoverItem();
    localCoverItem.str_cover.set("http://a3.qpic.cn/psb?/V133lZWc2qh6QM/Xo69bsP*acyJTMY26yEy.LwJjP5jPVGtm2G2UAFwIlM!/m/dPIAAAAAAAAA&ek=1&kp=1&pt=0&tm=1506412800&sce=0-12-12&rf=4-24");
    localCoverItem.str_jump_url.set("http://story.now.qq.com/mobile/transfer.html?token=AACBEBPz&src_type=app&version=1&fromId=17&videoOwnerUin=1332793427&videoId=6BD6D54BC2BC6245326B8221D3948D99&unionid=2_9000000112&ptype=11&actionnamekey=1&storysharefrom=wechat&sharefromtype=71&one_page=0&type=onedaylist&feedid=FEED-0-1332793427-20170928&identify=1&from=singlemessage");
    AIOQQStoryFeedPB.MsgBody localMsgBody = new AIOQQStoryFeedPB.MsgBody();
    AIOQQStoryFeedPB.AIOQQStoryFeed localAIOQQStoryFeed = new AIOQQStoryFeedPB.AIOQQStoryFeed();
    localAIOQQStoryFeed.msg_covers_info.set(localCoverItem);
    localMsgBody.msg_aio_feed.set(localAIOQQStoryFeed);
    localMsgBody.uint32_keep_time.set(604800);
    localMsgBody.uint32_latest_qzone_time.set(10000);
    return localMsgBody;
  }
  
  protected Object clone()
  {
    return super.clone();
  }
  
  protected void doParse()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageForQQStoryFeed", 2, "doParse invoked. info: TAG: MessageForQQStoryFeed");
    }
    parseMsgFromMsgData(this.msgData);
  }
  
  public boolean isEmpty()
  {
    if ((this.uint64_time <= 0L) || (this.uint32_video_num <= 0)) {}
    while ((TextUtils.isEmpty(this.str_cover)) || (TextUtils.isEmpty(this.str_jump_url))) {
      return true;
    }
    return false;
  }
  
  public void parseMsgFromMsgData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    AIOQQStoryFeedPB.MsgBody localMsgBody = new AIOQQStoryFeedPB.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      this.msgData = paramArrayOfByte;
      this.msg = "";
      this.str_cover = localMsgBody.msg_aio_feed.msg_covers_info.str_cover.get();
      this.str_jump_url = localMsgBody.msg_aio_feed.msg_covers_info.str_jump_url.get();
      this.str_feed_id = localMsgBody.msg_aio_feed.str_feed_id.get();
      this.uint64_time = localMsgBody.msg_aio_feed.uint64_time.get();
      this.uint32_video_num = localMsgBody.msg_aio_feed.uint32_video_num.get();
      this.uint32_keep_time = localMsgBody.uint32_keep_time.get();
      this.uint32_latest_qzone_time = localMsgBody.uint32_latest_qzone_time.get();
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageForQQStoryFeed", 2, "parseMsgFromMsgData Failed. info: exception: ", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
  
  protected void postRead()
  {
    doParse();
  }
  
  protected void prewrite()
  {
    this.msg = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = System.getProperty("line.separator");
    localStringBuilder.append("msgtype: ").append(this.msgtype).append(str).append("msgseq: ").append(this.msgseq).append(str).append("msg: ").append(this.msg).append(str).append("msgData.length: ").append(this.msgData.length).append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQStoryFeed
 * JD-Core Version:    0.7.0.1
 */