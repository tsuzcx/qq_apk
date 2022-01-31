package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7bb$ItemInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field belong = PBField.initUInt32(0);
  public final PBBytesField billno = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field cooldown = PBField.initUInt32(0);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt64Field ctime = PBField.initUInt64(0L);
  public final PBUInt64Field expire = PBField.initUInt64(0L);
  public final PBBytesField extra = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon_3d = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x7bb.PoiInfo info = new oidb_0x7bb.PoiInfo();
  public final PBUInt32Field item_id = PBField.initUInt32(0);
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field unlock = PBField.initUInt32(0);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 64, 72, 80, 90, 98, 104, 112, 122, 170, 178 }, new String[] { "item_id", "type", "name", "icon", "url", "unlock", "level", "count", "ctime", "expire", "info", "icon_3d", "belong", "cooldown", "extra", "sig", "billno" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, ItemInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ItemInfo
 * JD-Core Version:    0.7.0.1
 */