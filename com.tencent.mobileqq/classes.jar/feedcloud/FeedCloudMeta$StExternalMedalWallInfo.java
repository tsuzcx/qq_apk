package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StExternalMedalWallInfo
  extends MessageMicro<StExternalMedalWallInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<FeedCloudMeta.StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta.StMedalInfo.class);
  public final PBStringField medalWallJumpUrl = PBField.initString("");
  public final PBBoolField needRedPoint = PBField.initBool(false);
  public final PBBoolField needShowEntrance = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "needRedPoint", "medalInfos", "medalWallJumpUrl", "needShowEntrance" }, new Object[] { localBoolean, null, "", localBoolean }, StExternalMedalWallInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StExternalMedalWallInfo
 * JD-Core Version:    0.7.0.1
 */