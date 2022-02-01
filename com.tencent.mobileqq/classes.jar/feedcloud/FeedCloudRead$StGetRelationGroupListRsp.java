package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StGetRelationGroupListRsp
  extends MessageMicro<StGetRelationGroupListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "groupList", "timeInterval" }, new Object[] { null, null, Long.valueOf(0L) }, StGetRelationGroupListRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudRead.RelationGroup> groupList = PBField.initRepeatMessage(FeedCloudRead.RelationGroup.class);
  public final PBInt64Field timeInterval = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetRelationGroupListRsp
 * JD-Core Version:    0.7.0.1
 */