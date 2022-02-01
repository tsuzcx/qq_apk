package tencent.im.cs.cmd0xe59;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe59$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBBoolField safe_hit_flag = PBField.initBool(false);
  public final PBBytesField song_lyric = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sub_ret = PBField.initUInt32(0);
  public final PBBoolField zip_compress_flag = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "ret", "sub_ret", "msg", "song_lyric", "zip_compress_flag", "safe_hit_flag" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localBoolean, localBoolean }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0xe59.cmd0xe59.RspBody
 * JD-Core Version:    0.7.0.1
 */