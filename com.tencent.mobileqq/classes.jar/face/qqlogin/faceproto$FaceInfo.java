package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class faceproto$FaceInfo
  extends MessageMicro<FaceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "Medias", "RecMode" }, new Object[] { null, Integer.valueOf(0) }, FaceInfo.class);
  public final PBRepeatMessageField<faceproto.Media> Medias = PBField.initRepeatMessage(faceproto.Media.class);
  public final PBEnumField RecMode = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     face.qqlogin.faceproto.FaceInfo
 * JD-Core Version:    0.7.0.1
 */