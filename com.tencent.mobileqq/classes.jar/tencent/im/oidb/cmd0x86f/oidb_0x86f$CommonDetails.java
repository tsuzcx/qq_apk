package tencent.im.oidb.cmd0x86f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x86f$CommonDetails
  extends MessageMicro<CommonDetails>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content_txt2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_content_txt3 = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_content_txt2", "bytes_content_txt3" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, CommonDetails.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x86f.oidb_0x86f.CommonDetails
 * JD-Core Version:    0.7.0.1
 */