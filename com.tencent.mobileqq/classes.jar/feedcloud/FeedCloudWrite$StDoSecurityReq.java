package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudWrite$StDoSecurityReq
  extends MessageMicro<StDoSecurityReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "extInfo", "feed", "comment", "reply", "from", "poster" }, new Object[] { null, null, null, null, Integer.valueOf(0), null }, StDoSecurityReq.class);
  public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public final PBInt32Field from = PBField.initInt32(0);
  public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
  public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoSecurityReq
 * JD-Core Version:    0.7.0.1
 */