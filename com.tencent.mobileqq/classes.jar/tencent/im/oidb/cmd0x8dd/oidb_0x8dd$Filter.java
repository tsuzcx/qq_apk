package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8dd$Filter
  extends MessageMicro<Filter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x8dd.Hometown msg_hometown = new oidb_0x8dd.Hometown();
  public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
  public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interest = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sub_interest = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "uint32_gender", "uint32_time_interval", "uint32_age_up", "uint32_age_low", "uint32_interest", "uint64_sub_interest", "uint32_profession", "msg_hometown", "uint32_constellation" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), localInteger, null, localInteger }, Filter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.Filter
 * JD-Core Version:    0.7.0.1
 */