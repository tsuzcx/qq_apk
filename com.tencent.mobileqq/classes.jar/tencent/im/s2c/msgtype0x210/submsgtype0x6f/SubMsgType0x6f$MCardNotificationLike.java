package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$MCardNotificationLike
  extends MessageMicro<MCardNotificationLike>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_counter_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_counter_total = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_from_uin", "uint32_counter_total", "uint32_counter_new", "str_wording" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, "" }, MCardNotificationLike.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike
 * JD-Core Version:    0.7.0.1
 */