package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StWearingMedalInfo
  extends MessageMicro<StWearingMedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "medalName", "medalID" }, new Object[] { Integer.valueOf(0), "", "" }, StWearingMedalInfo.class);
  public final PBStringField medalID = PBField.initString("");
  public final PBStringField medalName = PBField.initString("");
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StWearingMedalInfo
 * JD-Core Version:    0.7.0.1
 */