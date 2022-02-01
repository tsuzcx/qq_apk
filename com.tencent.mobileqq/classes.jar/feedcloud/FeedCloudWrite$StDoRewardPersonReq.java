package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import qqcircle.QQCircleFeedBase.StPolyLike;

public final class FeedCloudWrite$StDoRewardPersonReq
  extends MessageMicro<StDoRewardPersonReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "toUser", "rewardInfo", "from" }, new Object[] { null, null, null, Integer.valueOf(0) }, StDoRewardPersonReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field from = PBField.initInt32(0);
  public QQCircleFeedBase.StPolyLike rewardInfo = new QQCircleFeedBase.StPolyLike();
  public FeedCloudMeta.StUser toUser = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoRewardPersonReq
 * JD-Core Version:    0.7.0.1
 */