package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class LBS$GPS
  extends MessageMicro<GPS>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field altitude = PBField.initInt32(0);
  public final PBEnumField coordinate = PBField.initEnum(0);
  public final PBInt32Field latitude = PBField.initInt32(0);
  public final PBInt32Field longitude = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "latitude", "longitude", "altitude", "coordinate" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, GPS.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.hotchat.LBS.GPS
 * JD-Core Version:    0.7.0.1
 */