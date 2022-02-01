package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad$QQAdGet
  extends MessageMicro<QQAdGet>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 72 }, new String[] { "pos_id", "ad_count", "pos_layout", "net_info", "last_adid", "last_req_time", "get_back", "debug_id", "trigger_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), Integer.valueOf(0) }, QQAdGet.class);
  public final PBRepeatField<Integer> ad_count = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field debug_id = PBField.initUInt64(0L);
  public final PBBoolField get_back = PBField.initBool(false);
  public final PBRepeatField<Long> last_adid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field last_req_time = PBField.initUInt64(0L);
  public qq_ad.QQAdGet.Phone net_info = new qq_ad.QQAdGet.Phone();
  public final PBRepeatField<Long> pos_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBInt32Field pos_layout = PBField.initInt32(0);
  public final PBUInt32Field trigger_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGet
 * JD-Core Version:    0.7.0.1
 */