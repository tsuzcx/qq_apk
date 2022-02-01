package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x8d$NotifyBody
  extends MessageMicro<NotifyBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public SubMsgType0x8d.CommentFeeds msg_comment_feeds = new SubMsgType0x8d.CommentFeeds();
  public SubMsgType0x8d.DeleteComment msg_delete_comment = new SubMsgType0x8d.DeleteComment();
  public SubMsgType0x8d.DeleteFeeds msg_delete_feeds = new SubMsgType0x8d.DeleteFeeds();
  public SubMsgType0x8d.LikeFeeds msg_like_feeds = new SubMsgType0x8d.LikeFeeds();
  public SubMsgType0x8d.PublishFeeds msg_publish_feeds = new SubMsgType0x8d.PublishFeeds();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 82, 90, 98, 106, 114 }, new String[] { "uint32_notify_type", "uint32_seq", "uint32_push_time", "msg_publish_feeds", "msg_comment_feeds", "msg_like_feeds", "msg_delete_feeds", "msg_delete_comment" }, new Object[] { localInteger, localInteger, localInteger, null, null, null, null, null }, NotifyBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.SubMsgType0x8d.NotifyBody
 * JD-Core Version:    0.7.0.1
 */