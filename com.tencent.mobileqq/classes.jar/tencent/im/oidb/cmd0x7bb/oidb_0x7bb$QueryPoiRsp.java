package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x7bb$QueryPoiRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "poi", "items", "status", "style" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, QueryPoiRsp.class);
  public final PBRepeatMessageField items = PBField.initRepeatMessage(oidb_0x7bb.ItemInfo.class);
  public oidb_0x7bb.PoiInfo poi = new oidb_0x7bb.PoiInfo();
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt32Field style = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.QueryPoiRsp
 * JD-Core Version:    0.7.0.1
 */