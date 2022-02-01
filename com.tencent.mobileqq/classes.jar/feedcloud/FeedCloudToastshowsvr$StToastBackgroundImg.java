package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class FeedCloudToastshowsvr$StToastBackgroundImg
  extends MessageMicro<StToastBackgroundImg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21 }, new String[] { "backgroundImg", "cornerRadius" }, new Object[] { null, Float.valueOf(0.0F) }, StToastBackgroundImg.class);
  public FeedCloudMeta.StImage backgroundImg = new FeedCloudMeta.StImage();
  public final PBFloatField cornerRadius = PBField.initFloat(0.0F);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StToastBackgroundImg
 * JD-Core Version:    0.7.0.1
 */