package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class topic_info$PaymentInfo
  extends MessageMicro<PaymentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29, 37, 40, 48, 56 }, new String[] { "update_status", "plan_content_count", "current_price", "original_price", "discount_start_time", "discount_end_time", "sale_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, PaymentInfo.class);
  public final PBFloatField current_price = PBField.initFloat(0.0F);
  public final PBUInt64Field discount_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field discount_start_time = PBField.initUInt64(0L);
  public final PBFloatField original_price = PBField.initFloat(0.0F);
  public final PBUInt32Field plan_content_count = PBField.initUInt32(0);
  public final PBBoolField sale_flag = PBField.initBool(false);
  public final PBUInt32Field update_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.PaymentInfo
 * JD-Core Version:    0.7.0.1
 */