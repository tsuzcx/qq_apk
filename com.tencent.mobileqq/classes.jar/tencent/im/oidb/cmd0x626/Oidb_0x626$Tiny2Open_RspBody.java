package tencent.im.oidb.cmd0x626;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x626$Tiny2Open_RspBody
  extends MessageMicro<Tiny2Open_RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_openid_rsp_info" }, new Object[] { null }, Tiny2Open_RspBody.class);
  public final PBRepeatMessageField<Oidb_0x626.OpenIDInfoRsp> msg_openid_rsp_info = PBField.initRepeatMessage(Oidb_0x626.OpenIDInfoRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_RspBody
 * JD-Core Version:    0.7.0.1
 */