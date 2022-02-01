package tencent.im.oidb.cmd0xe27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe27$InOutQQ
  extends MessageMicro<InOutQQ>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_biz_id", "uint32_timestamp" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, InOutQQ.class);
  public final PBEnumField enum_biz_id = PBField.initEnum(1);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.InOutQQ
 * JD-Core Version:    0.7.0.1
 */