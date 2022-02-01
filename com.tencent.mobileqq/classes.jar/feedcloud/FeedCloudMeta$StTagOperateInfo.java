package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StTagOperateInfo
  extends MessageMicro<StTagOperateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field activityEndTime = PBField.initInt64(0L);
  public final PBInt64Field activityStartTime = PBField.initInt64(0L);
  public final PBStringField backgroundURL = PBField.initString("");
  public final PBStringField bannerSkipLink = PBField.initString("");
  public final PBStringField bannerURL = PBField.initString("");
  public final PBInt64Field beWhiteEndTime = PBField.initInt64(0L);
  public final PBInt64Field beWhiteStartTime = PBField.initInt64(0L);
  public final PBStringField coverURL = PBField.initString("");
  public final PBStringField createUser = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBInt32Field isWhite = PBField.initInt32(0);
  public final PBStringField publishSchema = PBField.initString("");
  public final PBStringField recommendReason = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 96, 106 }, new String[] { "createUser", "coverURL", "desc", "backgroundURL", "bannerURL", "bannerSkipLink", "activityStartTime", "activityEndTime", "recommendReason", "isWhite", "beWhiteStartTime", "beWhiteEndTime", "publishSchema" }, new Object[] { "", "", "", "", "", "", localLong, localLong, "", Integer.valueOf(0), localLong, localLong, "" }, StTagOperateInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StTagOperateInfo
 * JD-Core Version:    0.7.0.1
 */