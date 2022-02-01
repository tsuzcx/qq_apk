package tencent.im.oidb.cmd0xebb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xebb$ReqRecommendPara
  extends MessageMicro<ReqRecommendPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_req_recommend_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
  public final PBUInt64Field uint64_begin_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 32, 42, 50, 56, 112 }, new String[] { "uint64_channel_id", "uint64_begin_recommend_seq", "uint64_end_recommend_seq", "bytes_req_rowkey", "bytes_subscribe_id", "uint32_update_times", "uint32_req_recommend_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqRecommendPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqRecommendPara
 * JD-Core Version:    0.7.0.1
 */