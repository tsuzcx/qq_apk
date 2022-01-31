package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyUploadHitReqV2
  extends MessageMicro<ApplyUploadHitReqV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_3sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_local_filepath = PBField.initString("");
  public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 562, 642, 720, 800 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "bytes_3sha", "bytes_sha", "str_local_filepath", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyUploadHitReqV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2
 * JD-Core Version:    0.7.0.1
 */