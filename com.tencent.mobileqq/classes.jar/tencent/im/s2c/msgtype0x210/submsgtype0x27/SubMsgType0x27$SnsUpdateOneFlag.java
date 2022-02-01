package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$SnsUpdateOneFlag
  extends MessageMicro<SnsUpdateOneFlag>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64__uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64__uin", "uint64_id", "uint32_flag" }, new Object[] { localLong, localLong, Integer.valueOf(0) }, SnsUpdateOneFlag.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag
 * JD-Core Version:    0.7.0.1
 */