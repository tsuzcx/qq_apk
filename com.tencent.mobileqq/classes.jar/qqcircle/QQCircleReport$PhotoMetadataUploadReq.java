package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleReport$PhotoMetadataUploadReq
  extends MessageMicro<PhotoMetadataUploadReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "AddPhotoMetadatas", "DelPhotoMetadatas", "uploadComplete" }, new Object[] { null, null, Boolean.valueOf(false) }, PhotoMetadataUploadReq.class);
  public final PBRepeatMessageField<QQCirclePhotocatemetadata.PhotoMetadata> AddPhotoMetadatas = PBField.initRepeatMessage(QQCirclePhotocatemetadata.PhotoMetadata.class);
  public final PBRepeatMessageField<QQCirclePhotocatemetadata.PhotoMetadata> DelPhotoMetadatas = PBField.initRepeatMessage(QQCirclePhotocatemetadata.PhotoMetadata.class);
  public final PBBoolField uploadComplete = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleReport.PhotoMetadataUploadReq
 * JD-Core Version:    0.7.0.1
 */