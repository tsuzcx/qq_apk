package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeac$BatchRspBody
  extends MessageMicro<BatchRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "wording", "error_code", "succ_cnt", "msg_proc_infos", "digest_time" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, BatchRspBody.class);
  public final PBUInt32Field digest_time = PBField.initUInt32(0);
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xeac.MsgProcessInfo> msg_proc_infos = PBField.initRepeatMessage(oidb_0xeac.MsgProcessInfo.class);
  public final PBInt32Field succ_cnt = PBField.initInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.BatchRspBody
 * JD-Core Version:    0.7.0.1
 */