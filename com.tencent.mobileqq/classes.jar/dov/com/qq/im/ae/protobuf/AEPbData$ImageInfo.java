package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class AEPbData$ImageInfo
  extends MessageMicro<ImageInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<AEPbData.FaceInfo> faceInfos = PBField.initRepeatMessage(AEPbData.FaceInfo.class);
  public final PBInt32Field faceNum = PBField.initInt32(0);
  public final PBBoolField hasFace = PBField.initBool(false);
  public final PBBytesField imageRawData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field imgHeight = PBField.initInt32(0);
  public final PBInt32Field imgWidth = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48 }, new String[] { "imageRawData", "hasFace", "faceNum", "faceInfos", "imgWidth", "imgHeight" }, new Object[] { localByteStringMicro, Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ImageInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.ImageInfo
 * JD-Core Version:    0.7.0.1
 */