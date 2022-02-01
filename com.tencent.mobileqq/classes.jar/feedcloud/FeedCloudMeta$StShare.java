package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StShare
  extends MessageMicro<StShare>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudMeta.StUser author = new FeedCloudMeta.StUser();
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StImage cover = new FeedCloudMeta.StImage();
  public final PBStringField desc = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StImage> images = PBField.initRepeatMessage(FeedCloudMeta.StImage.class);
  public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
  public final PBUInt32Field publishTotalUser = PBField.initUInt32(0);
  public final PBStringField shareCardInfo = PBField.initString("");
  public FeedCloudMeta.StShareQzoneInfo shareQzoneInfo = new FeedCloudMeta.StShareQzoneInfo();
  public final PBStringField shorturl = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public FeedCloudMeta.StVideo video = new FeedCloudMeta.StVideo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 112 }, new String[] { "title", "desc", "type", "url", "author", "poster", "cover", "video", "shorturl", "shareCardInfo", "shareQzoneInfo", "busiData", "images", "publishTotalUser" }, new Object[] { "", "", localInteger, "", null, null, null, null, "", "", null, localByteStringMicro, null, localInteger }, StShare.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StShare
 * JD-Core Version:    0.7.0.1
 */