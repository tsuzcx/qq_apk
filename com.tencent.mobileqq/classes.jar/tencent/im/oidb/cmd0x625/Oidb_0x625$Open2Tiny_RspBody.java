package tencent.im.oidb.cmd0x625;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x625$Open2Tiny_RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_tinyid_rsp_info" }, new Object[] { null }, Open2Tiny_RspBody.class);
  public final PBRepeatMessageField msg_tinyid_rsp_info = PBField.initRepeatMessage(Oidb_0x625.TinyIDInfoRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_RspBody
 * JD-Core Version:    0.7.0.1
 */