package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$BackflowPymkDescEntry
  extends MessageMicro<BackflowPymkDescEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "key", "count", "describe", "needDisplay" }, new Object[] { "", Integer.valueOf(0), "", Boolean.valueOf(false) }, BackflowPymkDescEntry.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField describe = PBField.initString("");
  public final PBStringField key = PBField.initString("");
  public final PBBoolField needDisplay = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.BackflowPymkDescEntry
 * JD-Core Version:    0.7.0.1
 */