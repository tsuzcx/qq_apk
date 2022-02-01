package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupLabel$Label
  extends MessageMicro<Label>
{
  public static final int BYTES_NAME_FIELD_NUMBER = 1;
  public static final int EDGING_COLOR_FIELD_NUMBER = 4;
  public static final int ENUM_TYPE_FIELD_NUMBER = 2;
  public static final int TEXT_COLOR_FIELD_NUMBER = 3;
  public static final int UINT32_LABEL_ATTR_FIELD_NUMBER = 5;
  public static final int UINT32_LABEL_TYPE_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public GroupLabel.Color edging_color = new GroupLabel.Color();
  public final PBEnumField enum_type = PBField.initEnum(1);
  public GroupLabel.Color text_color = new GroupLabel.Color();
  public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.group.group_label.GroupLabel.Label
 * JD-Core Version:    0.7.0.1
 */