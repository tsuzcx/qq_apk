package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class FeedCloudMeta$StGPSV2
  extends MessageMicro<StGPSV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lat", "lon", "eType", "alt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, StGPSV2.class);
  public final PBInt64Field alt = PBField.initInt64(0L);
  public final PBInt64Field eType = PBField.initInt64(0L);
  public final PBInt64Field lat = PBField.initInt64(0L);
  public final PBInt64Field lon = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StGPSV2
 * JD-Core Version:    0.7.0.1
 */