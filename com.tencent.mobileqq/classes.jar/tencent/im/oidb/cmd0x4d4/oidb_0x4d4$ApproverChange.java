package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.trunk.Qworkflow.Qworkflow.Approver;

public final class oidb_0x4d4$ApproverChange
  extends MessageMicro<ApproverChange>
{
  public static final int ADD = 1;
  public static final int DELETE = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_change_type", "msg_approver" }, new Object[] { Integer.valueOf(1), null }, ApproverChange.class);
  public final PBEnumField enum_change_type = PBField.initEnum(1);
  public Qworkflow.Approver msg_approver = new Qworkflow.Approver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.ApproverChange
 * JD-Core Version:    0.7.0.1
 */