package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StGetUserGroupListRsp
  extends MessageMicro<StGetUserGroupListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "groupList", "friendGroupList" }, new Object[] { null, null, null }, StGetUserGroupListRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StUserGroupInfo> friendGroupList = PBField.initRepeatMessage(FeedCloudMeta.StUserGroupInfo.class);
  public final PBRepeatMessageField<FeedCloudMeta.StUserGroupInfo> groupList = PBField.initRepeatMessage(FeedCloudMeta.StUserGroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetUserGroupListRsp
 * JD-Core Version:    0.7.0.1
 */