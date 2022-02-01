package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbe4$MsgFolderInfo
  extends MessageMicro<MsgFolderInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_orange_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field folder_red_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_folder = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_show_folder", "folder_red_type", "bytes_orange_word", "bytes_summary" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2 }, MsgFolderInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgFolderInfo
 * JD-Core Version:    0.7.0.1
 */