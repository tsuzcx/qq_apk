package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Smartptt$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_sub_cmd", "msg_ptt_up_req", "msg_tts_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
  public Smartptt.PttUpReq msg_ptt_up_req = new Smartptt.PttUpReq();
  public Smartptt.TTSReq msg_tts_req = new Smartptt.TTSReq();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.smartptt.Smartptt.ReqBody
 * JD-Core Version:    0.7.0.1
 */