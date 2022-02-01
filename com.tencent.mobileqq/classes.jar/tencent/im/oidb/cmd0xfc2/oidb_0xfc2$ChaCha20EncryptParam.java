package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xfc2$ChaCha20EncryptParam
  extends MessageMicro<ChaCha20EncryptParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str32_hexkey", "str8_hexnonce" }, new Object[] { "", "" }, ChaCha20EncryptParam.class);
  public final PBStringField str32_hexkey = PBField.initString("");
  public final PBStringField str8_hexnonce = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ChaCha20EncryptParam
 * JD-Core Version:    0.7.0.1
 */