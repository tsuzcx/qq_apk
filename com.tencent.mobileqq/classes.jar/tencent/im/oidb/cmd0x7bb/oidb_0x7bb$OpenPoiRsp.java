package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x7bb$OpenPoiRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "item", "status", "holder" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false) }, OpenPoiRsp.class);
  public final PBBoolField holder = PBField.initBool(false);
  public oidb_0x7bb.ItemInfo item = new oidb_0x7bb.ItemInfo();
  public final PBUInt32Field status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.OpenPoiRsp
 * JD-Core Version:    0.7.0.1
 */