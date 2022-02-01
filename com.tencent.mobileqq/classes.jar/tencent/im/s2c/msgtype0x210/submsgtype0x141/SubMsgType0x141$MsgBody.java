package tencent.im.s2c.msgtype0x210.submsgtype0x141;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x141$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_aio_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_from", "uint64_to", "uint64_aio_uin", "uint64_busi_id", "uint64_tips_seq_id" }, new Object[] { localLong, localLong, localLong, localLong, localLong }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x141.SubMsgType0x141.MsgBody
 * JD-Core Version:    0.7.0.1
 */