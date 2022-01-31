package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceproto$Media
  extends MessageMicro<Media>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField Action = PBField.initString("");
  public final PBBytesField ColorSeq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Float> FivePoint = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBUInt32Field Size = PBField.initUInt32(0);
  public final PBEnumField Tag = PBField.initEnum(0);
  public final PBEnumField Type = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 45, 50 }, new String[] { "Tag", "Type", "Size", "Action", "FivePoint", "ColorSeq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Float.valueOf(0.0F), localByteStringMicro }, Media.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     face.qqlogin.faceproto.Media
 * JD-Core Version:    0.7.0.1
 */