package tencent.im.cs.cmd0xe59;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0xe59$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField singer_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField song_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField song_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField zip_compress_flag = PBField.initBool(false);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "song_id", "zip_compress_flag", "singer_name", "song_name" }, new Object[] { localByteStringMicro1, Boolean.valueOf(false), localByteStringMicro2, localByteStringMicro3 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0xe59.cmd0xe59.ReqBody
 * JD-Core Version:    0.7.0.1
 */