package tencent.im.oidb.ranklist_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ranklist_comm$ExtraParam
  extends MessageMicro<ExtraParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "param_key", "param_value", "param_type" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, ExtraParam.class);
  public final PBStringField param_key = PBField.initString("");
  public final PBInt32Field param_type = PBField.initInt32(0);
  public final PBInt32Field param_value = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.ranklist_comm.ranklist_comm.ExtraParam
 * JD-Core Version:    0.7.0.1
 */