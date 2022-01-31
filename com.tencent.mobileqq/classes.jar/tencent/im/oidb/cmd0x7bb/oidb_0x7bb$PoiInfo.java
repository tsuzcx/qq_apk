package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7bb$PoiInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public final PBBytesField addr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBBytesField banner = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lng = PBField.initInt32(0);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField photo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field poi_id = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 66, 74, 82, 88 }, new String[] { "poi_id", "lat", "lng", "name", "addr", "adcode", "type", "icon", "banner", "photo", "appid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, PoiInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PoiInfo
 * JD-Core Version:    0.7.0.1
 */