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
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field balance = PBField.initInt64(0L);
  public final PBInt64Field errCode = PBField.initInt64(0L);
  public final PBEnumField rewardType = PBField.initEnum(0);
  public final PBStringField toastContent = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "toastContent", "errCode", "rewardType", "balance" }, new Object[] { "", localLong, Integer.valueOf(0), localLong }, RewardAdvRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePay.RewardAdvRsp
 * JD-Core Version:    0.7.0.1
 */