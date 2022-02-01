package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagcategorysvr$PicRecomEntry
  extends MessageMicro<PicRecomEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "picId", "recomTags", "materialId", "filterId", "exifInfo" }, new Object[] { "", "", "", "", null }, PicRecomEntry.class);
  public FeedCloudMeta.StExifInfo exifInfo = new FeedCloudMeta.StExifInfo();
  public final PBStringField filterId = PBField.initString("");
  public final PBStringField materialId = PBField.initString("");
  public final PBStringField picId = PBField.initString("");
  public final PBRepeatField<String> recomTags = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.PicRecomEntry
 * JD-Core Version:    0.7.0.1
 */