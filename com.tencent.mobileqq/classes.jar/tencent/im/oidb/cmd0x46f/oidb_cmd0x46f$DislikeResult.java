package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x46f$DislikeResult
  extends MessageMicro<DislikeResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_articleid", "uint32_result", "str_message" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, DislikeResult.class);
  public final PBStringField str_message = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_articleid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeResult
 * JD-Core Version:    0.7.0.1
 */