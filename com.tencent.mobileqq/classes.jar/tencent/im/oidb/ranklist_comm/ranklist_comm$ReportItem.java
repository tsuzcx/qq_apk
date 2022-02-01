package tencent.im.oidb.ranklist_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ranklist_comm$ReportItem
  extends MessageMicro<ReportItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "openid", "score", "rpt_extra_param" }, new Object[] { "", Integer.valueOf(0), null }, ReportItem.class);
  public final PBStringField openid = PBField.initString("");
  public final PBRepeatMessageField<ranklist_comm.ExtraParam> rpt_extra_param = PBField.initRepeatMessage(ranklist_comm.ExtraParam.class);
  public final PBInt32Field score = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.ranklist_comm.ranklist_comm.ReportItem
 * JD-Core Version:    0.7.0.1
 */