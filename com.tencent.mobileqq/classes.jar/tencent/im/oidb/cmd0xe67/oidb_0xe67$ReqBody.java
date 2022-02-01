package tencent.im.oidb.cmd0xe67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe67$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_lbs_info", "uint32_action" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
  public oidb_0xe67.LBSInfo msg_lbs_info = new oidb_0xe67.LBSInfo();
  public final PBUInt32Field uint32_action = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe67.oidb_0xe67.ReqBody
 * JD-Core Version:    0.7.0.1
 */