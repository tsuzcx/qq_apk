package tencent.im.oidb.cmd0x909;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x909$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_count = PBField.initInt32(0);
  public final PBUInt32Field uint32_photo_slot = PBField.initUInt32(0);
  public final PBUInt64Field uint64_labelid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_photoid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_to", "uint64_labelid", "uint64_photoid", "uint32_photo_slot", "int32_count" }, new Object[] { localLong, localLong, localLong, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x909.oidb_0x909.ReqBody
 * JD-Core Version:    0.7.0.1
 */