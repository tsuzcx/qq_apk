package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class TroopTips0x857$MessageBoxInfo
  extends MessageMicro<MessageBoxInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_button = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "opt_bytes_content", "opt_bytes_title", "opt_bytes_button" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, MessageBoxInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.MessageBoxInfo
 * JD-Core Version:    0.7.0.1
 */