package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xfa4$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "req_red", "rpt_req_list" }, new Object[] { null, null }, ReqBody.class);
  public oidb_cmd0xfa4.ReqMsgBoardInfo req_red = new oidb_cmd0xfa4.ReqMsgBoardInfo();
  public final PBRepeatMessageField<oidb_cmd0xfa4.ReqMsgBoardInfo> rpt_req_list = PBField.initRepeatMessage(oidb_cmd0xfa4.ReqMsgBoardInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.ReqBody
 * JD-Core Version:    0.7.0.1
 */