package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class RoomOperate$ReqAssemblyPointOperation
  extends MessageMicro<ReqAssemblyPointOperation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBDoubleField lon = PBField.initDouble(0.0D);
  public final PBBytesField poi_address = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField poi_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField point_operation = PBField.initEnum(1);
  public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 25, 33, 42, 50 }, new String[] { "room_key", "point_operation", "lon", "lat", "poi_name", "poi_address" }, new Object[] { null, Integer.valueOf(1), Double.valueOf(0.0D), Double.valueOf(0.0D), localByteStringMicro1, localByteStringMicro2 }, ReqAssemblyPointOperation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.ReqAssemblyPointOperation
 * JD-Core Version:    0.7.0.1
 */