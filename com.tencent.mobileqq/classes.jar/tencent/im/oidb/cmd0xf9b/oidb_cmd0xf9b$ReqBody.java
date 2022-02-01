package tencent.im.oidb.cmd0xf9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf9b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBDoubleField lon = PBField.initDouble(0.0D);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 24, 32, 40 }, new String[] { "lat", "lon", "num", "start", "coordinate" }, new Object[] { localDouble, localDouble, localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf9b.oidb_cmd0xf9b.ReqBody
 * JD-Core Version:    0.7.0.1
 */