package tencent.im.oidb.cmd0x954;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x954$FeedInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x954.Comment msg_hot_comment = new cmd0x954.Comment();
  public cmd0x954.UserInfo msg_publisher_info = new cmd0x954.UserInfo();
  public cmd0x954.Topic msg_topic_info = new cmd0x954.Topic();
  public final PBRepeatField rpt_pic_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_anonymity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_publish_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_publisher_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 48, 58, 66, 72, 82, 88, 96, 104 }, new String[] { "bytes_feed_id", "uint32_type", "msg_topic_info", "uint64_publisher_uin", "msg_publisher_info", "uint64_publish_time", "bytes_content", "rpt_pic_url", "uint32_anonymity", "msg_hot_comment", "uint32_like_count", "uint32_comment_count", "uint32_read_count" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), null, Long.valueOf(0L), null, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FeedInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x954.cmd0x954.FeedInfo
 * JD-Core Version:    0.7.0.1
 */