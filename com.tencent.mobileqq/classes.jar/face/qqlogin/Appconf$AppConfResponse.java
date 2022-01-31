package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Appconf$AppConfResponse
  extends MessageMicro<AppConfResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField ActionSeq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField AppName = PBField.initString("");
  public final PBBytesField ColorSeq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField Debug = PBField.initString("");
  public final PBStringField ErrMsg = PBField.initString("");
  public final PBEnumField Mode = PBField.initEnum(0);
  public final PBUInt32Field Ret = PBField.initUInt32(0);
  public final PBStringField Session = PBField.initString("");
  public final PBRepeatMessageField<Appconf.Wording> Wordings = PBField.initRepeatMessage(Appconf.Wording.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 122 }, new String[] { "AppName", "Wordings", "Mode", "ColorSeq", "Session", "Ret", "ErrMsg", "Debug", "ActionSeq" }, new Object[] { "", null, Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), "", "", localByteStringMicro2 }, AppConfResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     face.qqlogin.Appconf.AppConfResponse
 * JD-Core Version:    0.7.0.1
 */