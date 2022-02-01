package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StFeedAbstract
  extends MessageMicro<StFeedAbstract>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 64 }, new String[] { "id", "title", "poster", "pic", "type", "createTime", "video", "fuelNum" }, new Object[] { "", "", null, null, Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, StFeedAbstract.class);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBUInt32Field fuelNum = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public FeedCloudMeta.StImage pic = new FeedCloudMeta.StImage();
  public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public FeedCloudMeta.StVideo video = new FeedCloudMeta.StVideo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StFeedAbstract
 * JD-Core Version:    0.7.0.1
 */