package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StGetRelationGroupListReq
  extends MessageMicro<StGetRelationGroupListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "reqItems", "count", "scene" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0) }, StGetRelationGroupListReq.class);
  public final PBInt64Field count = PBField.initInt64(0L);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudRead.GroupReqItem> reqItems = PBField.initRepeatMessage(FeedCloudRead.GroupReqItem.class);
  public final PBInt32Field scene = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetRelationGroupListReq
 * JD-Core Version:    0.7.0.1
 */