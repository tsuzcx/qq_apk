package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$ReqGetFollowTabPara
  extends MessageMicro<ReqGetFollowTabPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_last_feed_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_red_dot_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_refresh_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_curr_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<oidb_cmd0x68b.ExposeTopic> rpt_expose_topic_list = PBField.initRepeatMessage(oidb_cmd0x68b.ExposeTopic.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_cmd0x68b.InnerMsg.class);
  public final PBUInt32Field uint32_enter_topic_reddot_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
  public final PBUInt64Field uint64_begin_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104, 114, 122, 128, 138, 146, 152, 162, 170, 178 }, new String[] { "uint64_channel_id", "uint64_begin_recommend_seq", "uint64_end_recommend_seq", "rpt_curr_article_list", "bytes_set_top_cookie", "bytes_device_id", "uint32_update_times", "rpt_inner_msg_list", "rpt_expose_topic_list", "uint32_enter_topic_reddot_time", "bytes_refresh_cookie", "bytes_last_feed_cookie", "bytes_red_dot_cookie" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ReqGetFollowTabPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqGetFollowTabPara
 * JD-Core Version:    0.7.0.1
 */