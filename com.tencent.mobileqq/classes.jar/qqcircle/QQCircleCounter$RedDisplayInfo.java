package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleCounter$RedDisplayInfo
  extends MessageMicro<RedDisplayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "num", "headImg", "ext", "avatarURL" }, new Object[] { Integer.valueOf(0), "", "", "" }, RedDisplayInfo.class);
  public final PBStringField avatarURL = PBField.initString("");
  public final PBStringField ext = PBField.initString("");
  public final PBStringField headImg = PBField.initString("");
  public final PBUInt32Field num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */