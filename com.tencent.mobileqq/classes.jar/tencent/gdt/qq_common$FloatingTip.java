package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_common$FloatingTip
  extends MessageMicro<FloatingTip>
{
  public static final int FLOATING_TIPS_APP = 1;
  public static final int FLOATING_TIPS_INDUSTRY = 2;
  public static final int FLOATING_TIPS_UNKNOWN = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "text", "icon_url" }, new Object[] { Integer.valueOf(0), "", "" }, FloatingTip.class);
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField text = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_common.FloatingTip
 * JD-Core Version:    0.7.0.1
 */