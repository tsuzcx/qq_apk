package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyCheckAuditFlagRspBody
  extends MessageMicro<ApplyCheckAuditFlagRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_audit_flag" }, new Object[] { Integer.valueOf(0) }, ApplyCheckAuditFlagRspBody.class);
  public final PBUInt32Field uint32_audit_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyCheckAuditFlagRspBody
 * JD-Core Version:    0.7.0.1
 */