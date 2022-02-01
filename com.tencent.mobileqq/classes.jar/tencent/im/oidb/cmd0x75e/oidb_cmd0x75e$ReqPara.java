package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0x75e$ReqPara
  extends MessageMicro<ReqPara>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "enum_op_type" }, new Object[] { Integer.valueOf(1) }, ReqPara.class);
  public final PBEnumField enum_op_type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqPara
 * JD-Core Version:    0.7.0.1
 */