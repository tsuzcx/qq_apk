package tencent.im.oidb.cmd0xf90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf90$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field random = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "group_code", "seq", "random", "appid" }, new Object[] { localLong, localLong, localLong, localLong }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf90.oidb_0xf90.ReqBody
 * JD-Core Version:    0.7.0.1
 */