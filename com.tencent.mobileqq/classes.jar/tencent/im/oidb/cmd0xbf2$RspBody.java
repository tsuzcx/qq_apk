package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xbf2$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "phoneAddrBook", "uint32_end", "uint32_next_index" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField<cmd0xbf2.PhoneAddrBook> phoneAddrBook = PBField.initRepeatMessage(cmd0xbf2.PhoneAddrBook.class);
  public final PBUInt32Field uint32_end = PBField.initUInt32(0);
  public final PBUInt64Field uint32_next_index = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbf2.RspBody
 * JD-Core Version:    0.7.0.1
 */