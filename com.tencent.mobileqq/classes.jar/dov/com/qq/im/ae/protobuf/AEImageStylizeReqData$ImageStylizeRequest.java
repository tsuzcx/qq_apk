package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class AEImageStylizeReqData$ImageStylizeRequest
  extends MessageMicro<ImageStylizeRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "imgInfo", "stylizeType" }, new Object[] { null, Integer.valueOf(0) }, ImageStylizeRequest.class);
  public AEImageStylizeReqData.ImageInfo imgInfo = new AEImageStylizeReqData.ImageInfo();
  public final PBEnumField stylizeType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageStylizeRequest
 * JD-Core Version:    0.7.0.1
 */