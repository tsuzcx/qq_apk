package tencent.im.s2c.msgtype0x210.submsgtype0x103;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x103$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_cur_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96 }, new String[] { "uint64_from", "uint64_to", "uint32_topic_id", "uint32_cur_count", "uint32_total_count" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x103.submsgtype0x103.MsgBody
 * JD-Core Version:    0.7.0.1
 */