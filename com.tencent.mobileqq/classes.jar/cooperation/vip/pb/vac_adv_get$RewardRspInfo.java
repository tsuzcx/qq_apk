package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class vac_adv_get$RewardRspInfo
  extends MessageMicro<RewardRspInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "time", "nonce", "signature" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, RewardRspInfo.class);
  public final PBInt32Field nonce = PBField.initInt32(0);
  public final PBStringField signature = PBField.initString("");
  public final PBUInt64Field time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.RewardRspInfo
 * JD-Core Version:    0.7.0.1
 */