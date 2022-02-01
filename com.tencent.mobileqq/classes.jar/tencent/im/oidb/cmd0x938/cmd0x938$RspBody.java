package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x938$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "msg_comm_param", "msg_client_config", "msg_datacard_config", "msg_operation_config", "msg_scorelist_config", "msg_floatbutton_config" }, new Object[] { null, null, null, null, null, null }, RspBody.class);
  public cmd0x938.ClientConfig msg_client_config = new cmd0x938.ClientConfig();
  public cmd0x938.CommParamRsp msg_comm_param = new cmd0x938.CommParamRsp();
  public cmd0x938.DataCardConfig msg_datacard_config = new cmd0x938.DataCardConfig();
  public cmd0x938.FloatButtonConfig msg_floatbutton_config = new cmd0x938.FloatButtonConfig();
  public cmd0x938.OperationConfig msg_operation_config = new cmd0x938.OperationConfig();
  public cmd0x938.ScoreListConfig msg_scorelist_config = new cmd0x938.ScoreListConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x938.cmd0x938.RspBody
 * JD-Core Version:    0.7.0.1
 */