package tencent.im.oidb.cmd0xbed;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbed$ReqChannelPara
  extends MessageMicro<ReqChannelPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_begin_recommend_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_end_recommend_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xbed.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_cmd0xbed.InnerMsg.class);
  public final PBRepeatField<Long> rpt_subscription_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sim_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
  public final PBUInt64Field uint64_begin_collection_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_begin_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_collection_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 66, 72, 82, 88, 96, 104, 112, 80010 }, new String[] { "uint32_channel_id", "uint32_channel_type", "uint64_begin_recommend_seq", "uint64_end_recommend_seq", "bytes_begin_recommend_rowkey", "bytes_end_recommend_rowkey", "rpt_subscription_article_list", "bytes_device_id", "uint32_update_times", "rpt_inner_msg_list", "uint32_sim_type", "uint64_begin_collection_id", "uint64_end_collection_id", "uint32_network_type", "bytes_business_info" }, new Object[] { localInteger, localInteger, localLong, localLong, localByteStringMicro1, localByteStringMicro2, localLong, localByteStringMicro3, localInteger, null, localInteger, localLong, localLong, localInteger, localByteStringMicro4 }, ReqChannelPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ReqChannelPara
 * JD-Core Version:    0.7.0.1
 */