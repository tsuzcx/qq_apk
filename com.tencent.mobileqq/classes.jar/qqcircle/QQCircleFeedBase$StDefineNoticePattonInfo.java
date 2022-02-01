package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StDefineNoticePattonInfo
  extends MessageMicro<StDefineNoticePattonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "pattonType", "contentJumpUrl", "picJumpUrl", "buttonName", "buttonJumpUrl", "contentShowCutOff" }, new Object[] { Integer.valueOf(0), "", "", "", "", Boolean.valueOf(false) }, StDefineNoticePattonInfo.class);
  public final PBStringField buttonJumpUrl = PBField.initString("");
  public final PBStringField buttonName = PBField.initString("");
  public final PBStringField contentJumpUrl = PBField.initString("");
  public final PBBoolField contentShowCutOff = PBField.initBool(false);
  public final PBUInt32Field pattonType = PBField.initUInt32(0);
  public final PBStringField picJumpUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StDefineNoticePattonInfo
 * JD-Core Version:    0.7.0.1
 */