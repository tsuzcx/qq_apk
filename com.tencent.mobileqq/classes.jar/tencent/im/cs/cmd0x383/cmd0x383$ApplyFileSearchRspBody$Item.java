package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyFileSearchRspBody$Item
  extends MessageMicro<Item>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> bytes_match_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_uploader_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x383.ApplyGetFileListRspBody.FileInfo file_info = new cmd0x383.ApplyGetFileListRspBody.FileInfo();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_upload_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 58 }, new String[] { "uint64_group_code", "bytes_group_name", "uint64_upload_uin", "bytes_uploader_nick_name", "bytes_match_word", "uint64_match_uin", "file_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), null }, Item.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody.Item
 * JD-Core Version:    0.7.0.1
 */