package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xece$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "busi_id", "active_app_tips" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public oidb_0xece.ActiveAppTips active_app_tips = new oidb_0xece.ActiveAppTips();
  public final PBUInt32Field busi_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xece.oidb_0xece.RspBody
 * JD-Core Version:    0.7.0.1
 */