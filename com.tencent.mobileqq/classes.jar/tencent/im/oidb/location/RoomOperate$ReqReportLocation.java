package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

public final class RoomOperate$ReqReportLocation
  extends MessageMicro<ReqReportLocation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField direction = PBField.initDouble(0.0D);
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBDoubleField lon = PBField.initDouble(0.0D);
  public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17, 25, 33 }, new String[] { "room_key", "lon", "lat", "direction" }, new Object[] { null, localDouble, localDouble, localDouble }, ReqReportLocation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.ReqReportLocation
 * JD-Core Version:    0.7.0.1
 */