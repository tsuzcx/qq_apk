package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudMeta$StWearingMedal
  extends MessageMicro<StWearingMedal>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "medalInfos" }, new Object[] { null }, StWearingMedal.class);
  public final PBRepeatMessageField<FeedCloudMeta.StWearingMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta.StWearingMedalInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StWearingMedal
 * JD-Core Version:    0.7.0.1
 */