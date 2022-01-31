package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xcde$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_encrypt_key_req", "get_decrypt_key_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_cmd0xcde.GetDecryptKeyReq get_decrypt_key_req = new oidb_cmd0xcde.GetDecryptKeyReq();
  public oidb_cmd0xcde.GetEncrptkeyReq get_encrypt_key_req = new oidb_cmd0xcde.GetEncrptkeyReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.ReqBody
 * JD-Core Version:    0.7.0.1
 */