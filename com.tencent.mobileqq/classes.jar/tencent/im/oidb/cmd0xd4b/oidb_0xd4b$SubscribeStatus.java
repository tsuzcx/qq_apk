package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$SubscribeStatus
  extends MessageMicro<SubscribeStatus>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_column_id", "uint32_sub_status" }, new Object[] { localInteger, localInteger }, SubscribeStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeStatus
 * JD-Core Version:    0.7.0.1
 */