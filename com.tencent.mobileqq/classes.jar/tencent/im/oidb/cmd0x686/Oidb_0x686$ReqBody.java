package tencent.im.oidb.cmd0x686;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "msg_lbs_info", "uint32_last_config_seq", "uint32_last_config_time", "uint32_push_redpoint_id" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public final PBUInt32Field uint32_last_config_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_config_time = PBField.initUInt32(0);
  public final PBRepeatField<Integer> uint32_push_redpoint_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody
 * JD-Core Version:    0.7.0.1
 */