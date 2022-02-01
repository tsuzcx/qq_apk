package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StCircleRankItem
  extends MessageMicro<StCircleRankItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField circleID = PBField.initString("");
  public final PBStringField circleName = PBField.initString("");
  public final PBInt64Field feedNum = PBField.initInt64(0L);
  public final PBInt64Field fuelValue = PBField.initInt64(0L);
  public final PBInt32Field rankNo = PBField.initInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "rankNo", "circleName", "fuelValue", "feedNum", "circleID" }, new Object[] { Integer.valueOf(0), "", localLong, localLong, "" }, StCircleRankItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StCircleRankItem
 * JD-Core Version:    0.7.0.1
 */