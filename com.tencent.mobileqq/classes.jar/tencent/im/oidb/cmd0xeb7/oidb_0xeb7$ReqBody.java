package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xeb7$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "signInStatusReq", "signInWriteReq" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0xeb7.StSignInStatusReq signInStatusReq = new oidb_0xeb7.StSignInStatusReq();
  public oidb_0xeb7.StSignInWriteReq signInWriteReq = new oidb_0xeb7.StSignInWriteReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.ReqBody
 * JD-Core Version:    0.7.0.1
 */