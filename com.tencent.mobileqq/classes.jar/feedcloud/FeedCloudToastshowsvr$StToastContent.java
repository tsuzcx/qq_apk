package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudToastshowsvr$StToastContent
  extends MessageMicro<StToastContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 74, 82 }, new String[] { "title", "content", "user", "jumpInfo", "createTime", "cover", "closeButtonImg", "coverLayerAnimation", "rightIconAnimation", "toastBackgroundImg" }, new Object[] { "", "", null, null, Long.valueOf(0L), null, null, null, null, null }, StToastContent.class);
  public FeedCloudMeta.StImage closeButtonImg = new FeedCloudMeta.StImage();
  public final PBStringField content = PBField.initString("");
  public FeedCloudMeta.StImage cover = new FeedCloudMeta.StImage();
  public FeedCloudMeta.StAnimation coverLayerAnimation = new FeedCloudMeta.StAnimation();
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public FeedCloudToastshowsvr.StJumpInfo jumpInfo = new FeedCloudToastshowsvr.StJumpInfo();
  public FeedCloudMeta.StAnimation rightIconAnimation = new FeedCloudMeta.StAnimation();
  public final PBStringField title = PBField.initString("");
  public FeedCloudToastshowsvr.StToastBackgroundImg toastBackgroundImg = new FeedCloudToastshowsvr.StToastBackgroundImg();
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StToastContent
 * JD-Core Version:    0.7.0.1
 */