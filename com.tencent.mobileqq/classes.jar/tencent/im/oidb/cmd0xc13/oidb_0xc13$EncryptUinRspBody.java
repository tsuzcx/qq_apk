package tencent.im.oidb.cmd0xc13;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xc13$EncryptUinRspBody
  extends MessageMicro<EncryptUinRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_encrypt_result" }, new Object[] { null }, EncryptUinRspBody.class);
  public final PBRepeatMessageField<oidb_0xc13.EncryptUinResult> rpt_msg_encrypt_result = PBField.initRepeatMessage(oidb_0xc13.EncryptUinResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc13.oidb_0xc13.EncryptUinRspBody
 * JD-Core Version:    0.7.0.1
 */