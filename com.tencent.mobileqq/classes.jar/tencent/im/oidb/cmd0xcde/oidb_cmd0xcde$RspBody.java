package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xcde$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_encrypt_key_rsp", "get_decrypt_key_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_cmd0xcde.GetDecryptKeyRsp get_decrypt_key_rsp = new oidb_cmd0xcde.GetDecryptKeyRsp();
  public oidb_cmd0xcde.GetEncryptKeyRsp get_encrypt_key_rsp = new oidb_cmd0xcde.GetEncryptKeyRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.RspBody
 * JD-Core Version:    0.7.0.1
 */