package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCirclePhotocatemetadata$PhotoMetadata
  extends MessageMicro<PhotoMetadata>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QQCirclePhotocatemetadata.PhotoExifInfo exif = new QQCirclePhotocatemetadata.PhotoExifInfo();
  public final PBInt32Field favourite = PBField.initInt32(0);
  public final PBInt32Field height = PBField.initInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField mimeType = PBField.initString("");
  public final PBInt64Field modifyTime = PBField.initInt64(0L);
  public final PBStringField path = PBField.initString("");
  public final PBFloatField qualityScore = PBField.initFloat(0.0F);
  public final PBRepeatMessageField<QQCirclePhotocatemetadata.PhotoTagInfo> tags = PBField.initRepeatMessage(QQCirclePhotocatemetadata.PhotoTagInfo.class);
  public final PBInt64Field time = PBField.initInt64(0L);
  public final PBInt32Field width = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 74, 80, 93 }, new String[] { "id", "path", "mimeType", "time", "modifyTime", "width", "height", "exif", "tags", "favourite", "qualityScore" }, new Object[] { "", "", "", localLong, localLong, localInteger, localInteger, null, null, localInteger, Float.valueOf(0.0F) }, PhotoMetadata.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePhotocatemetadata.PhotoMetadata
 * JD-Core Version:    0.7.0.1
 */