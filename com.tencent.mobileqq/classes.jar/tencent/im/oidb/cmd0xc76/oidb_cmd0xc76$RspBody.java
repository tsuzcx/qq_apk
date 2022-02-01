package tencent.im.oidb.cmd0xc76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc76$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "cmd", "main", "apps" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public oidb_cmd0xc76.Setting apps = new oidb_cmd0xc76.Setting();
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public oidb_cmd0xc76.Setting main = new oidb_cmd0xc76.Setting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.RspBody
 * JD-Core Version:    0.7.0.1
 */