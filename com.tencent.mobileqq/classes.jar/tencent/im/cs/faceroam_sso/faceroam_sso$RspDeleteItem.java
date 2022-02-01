package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class faceroam_sso$RspDeleteItem
  extends MessageMicro<RspDeleteItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "filename", "ret" }, new Object[] { "", Long.valueOf(0L) }, RspDeleteItem.class);
  public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<Long> ret = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.faceroam_sso.faceroam_sso.RspDeleteItem
 * JD-Core Version:    0.7.0.1
 */