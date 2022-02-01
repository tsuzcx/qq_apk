package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StBlackInfo
  extends MessageMicro<StBlackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "isBlocked", "blockedText" }, new Object[] { Integer.valueOf(0), "" }, StBlackInfo.class);
  public final PBStringField blockedText = PBField.initString("");
  public final PBUInt32Field isBlocked = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBlackInfo
 * JD-Core Version:    0.7.0.1
 */