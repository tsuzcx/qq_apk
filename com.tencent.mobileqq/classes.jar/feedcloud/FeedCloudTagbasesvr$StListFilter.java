package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StListFilter
  extends MessageMicro<StListFilter>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 800 }, new String[] { "tagStatuss", "tagCategorys", "tagTypes", "startDay", "endDay", "search", "appid" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, StListFilter.class);
  public final PBInt32Field appid = PBField.initInt32(0);
  public final PBStringField endDay = PBField.initString("");
  public final PBStringField search = PBField.initString("");
  public final PBStringField startDay = PBField.initString("");
  public final PBRepeatField<String> tagCategorys = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<Integer> tagStatuss = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public final PBRepeatField<Integer> tagTypes = PBField.initRepeat(PBEnumField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StListFilter
 * JD-Core Version:    0.7.0.1
 */