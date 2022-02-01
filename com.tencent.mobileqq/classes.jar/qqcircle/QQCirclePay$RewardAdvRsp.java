package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCirclePay$RewardAdvRsp
  extends MessageMicro<RewardAdvRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "toastContent", "errCode", "rewardType", "balance" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, RewardAdvRsp.class);
  public final PBInt64Field balance = PBField.initInt64(0L);
  public final PBInt64Field errCode = PBField.initInt64(0L);
  public final PBEnumField rewardType = PBField.initEnum(0);
  public final PBStringField toastContent = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCirclePay.RewardAdvRsp
 * JD-Core Version:    0.7.0.1
 */