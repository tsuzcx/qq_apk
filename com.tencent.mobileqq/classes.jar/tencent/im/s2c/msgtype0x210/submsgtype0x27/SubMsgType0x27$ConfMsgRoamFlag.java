package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$ConfMsgRoamFlag
  extends MessageMicro<ConfMsgRoamFlag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_confid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_confid", "uint32_flag", "uint64_timestamp" }, new Object[] { localLong, Integer.valueOf(0), localLong }, ConfMsgRoamFlag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ConfMsgRoamFlag
 * JD-Core Version:    0.7.0.1
 */