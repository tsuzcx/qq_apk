package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupLabel$Color
  extends MessageMicro<Color>
{
  public static final int UINT32_B_FIELD_NUMBER = 3;
  public static final int UINT32_G_FIELD_NUMBER = 2;
  public static final int UINT32_R_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
  public final PBUInt32Field uint32_b = PBField.initUInt32(0);
  public final PBUInt32Field uint32_g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_r = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.group.group_label.GroupLabel.Color
 * JD-Core Version:    0.7.0.1
 */