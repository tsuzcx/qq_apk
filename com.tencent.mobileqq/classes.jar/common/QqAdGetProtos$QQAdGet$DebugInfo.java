package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGet$DebugInfo
  extends MessageMicro<DebugInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "debug_adindexid", "nomatch", "debug" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false) }, DebugInfo.class);
  public final PBBoolField debug = PBField.initBool(false);
  public final PBUInt32Field debug_adindexid = PBField.initUInt32(0);
  public final PBBoolField nomatch = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet.DebugInfo
 * JD-Core Version:    0.7.0.1
 */