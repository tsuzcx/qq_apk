package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x791$SetAppidOpt
  extends MessageMicro<SetAppidOpt>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appid", "set_reddot_opt" }, new Object[] { Integer.valueOf(0), null }, SetAppidOpt.class);
  public oidb_0x791.SetRedDotOpt set_reddot_opt = new oidb_0x791.SetRedDotOpt();
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.SetAppidOpt
 * JD-Core Version:    0.7.0.1
 */