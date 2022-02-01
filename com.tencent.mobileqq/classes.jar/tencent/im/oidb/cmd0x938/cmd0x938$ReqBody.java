package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x938$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "msg_comm_param", "msg_client_param", "msg_datacard_param", "msg_operation_param", "msg_scorelist_param", "msg_floatbutton_param" }, new Object[] { null, null, null, null, null, null }, ReqBody.class);
  public cmd0x938.ClientParam msg_client_param = new cmd0x938.ClientParam();
  public cmd0x938.CommParamReq msg_comm_param = new cmd0x938.CommParamReq();
  public cmd0x938.DataCardParam msg_datacard_param = new cmd0x938.DataCardParam();
  public cmd0x938.FloatButtonParam msg_floatbutton_param = new cmd0x938.FloatButtonParam();
  public cmd0x938.OperationParam msg_operation_param = new cmd0x938.OperationParam();
  public cmd0x938.ScoreListParam msg_scorelist_param = new cmd0x938.ScoreListParam();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x938.cmd0x938.ReqBody
 * JD-Core Version:    0.7.0.1
 */