package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Stt$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public Stt.TransC2CPttReq msg_c2c_ptt_req = new Stt.TransC2CPttReq();
  public Stt.CorretTextReq msg_corret_text_req = new Stt.CorretTextReq();
  public Stt.TransGroupPttReq msg_group_ptt_req = new Stt.TransGroupPttReq();
  public final PBUInt32Field ptt_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 80 }, new String[] { "uint32_sub_cmd", "msg_group_ptt_req", "msg_c2c_ptt_req", "msg_corret_text_req", "ptt_version" }, new Object[] { localInteger, null, null, null, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x355.Stt.ReqBody
 * JD-Core Version:    0.7.0.1
 */