package tencent.im.s2c.msgtype0x210.submsgtype0xe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xe4$GeoInfo
  extends MessageMicro<GeoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_latitude = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_longitude = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_latitude", "uint64_longitude" }, new Object[] { localLong, localLong }, GeoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4.GeoInfo
 * JD-Core Version:    0.7.0.1
 */