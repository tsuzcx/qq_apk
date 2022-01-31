package tencent.im.oidb.cmd0x626;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x626$Tiny2Open_ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_tinyid_req_info" }, new Object[] { null }, Tiny2Open_ReqBody.class);
  public final PBRepeatMessageField msg_tinyid_req_info = PBField.initRepeatMessage(Oidb_0x626.TinyIDInfoReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_ReqBody
 * JD-Core Version:    0.7.0.1
 */