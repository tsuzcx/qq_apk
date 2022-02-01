package tencent.im.oidb.cmd0x983;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x983$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_lbs_info", "uint32_network" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public final PBUInt32Field uint32_network = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x983.oidb_cmd0x983.ReqBody
 * JD-Core Version:    0.7.0.1
 */