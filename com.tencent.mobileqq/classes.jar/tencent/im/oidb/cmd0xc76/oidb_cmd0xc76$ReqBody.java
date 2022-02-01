package tencent.im.oidb.cmd0xc76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc76$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "cmd", "apps" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0xc76.Item> apps = PBField.initRepeatMessage(oidb_cmd0xc76.Item.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.ReqBody
 * JD-Core Version:    0.7.0.1
 */