package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCommon$StCommonExt
  extends MessageMicro<StCommonExt>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "mapInfo", "attachInfo", "mapBytesInfo" }, new Object[] { null, "", null }, StCommonExt.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> mapBytesInfo = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> mapInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudCommon.StCommonExt
 * JD-Core Version:    0.7.0.1
 */