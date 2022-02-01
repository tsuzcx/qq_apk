package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Smartptt$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_sub_cmd", "msg_semantic_reco_rsp", "msg_ptttrans_rsp", "msg_tts_rsp", "str_trace_id" }, new Object[] { Integer.valueOf(0), null, null, null, "" }, RspBody.class);
  public Smartptt.PttTransRsp msg_ptttrans_rsp = new Smartptt.PttTransRsp();
  public Smartptt.SemanticRecoRsp msg_semantic_reco_rsp = new Smartptt.SemanticRecoRsp();
  public Smartptt.TTSRsp msg_tts_rsp = new Smartptt.TTSRsp();
  public final PBStringField str_trace_id = PBField.initString("");
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.smartptt.Smartptt.RspBody
 * JD-Core Version:    0.7.0.1
 */