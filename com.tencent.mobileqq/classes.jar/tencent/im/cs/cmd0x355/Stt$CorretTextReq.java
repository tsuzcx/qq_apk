package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Stt$CorretTextReq
  extends MessageMicro<CorretTextReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_Filemd5 = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
  public final PBUInt32Field uint32_fileid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_len = PBField.initUInt32(0);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 80, 88, 98, 104 }, new String[] { "uint64_sessionid", "uint32_ptt_type", "uint64_sender_uin", "uint64_receiver_uin", "uint32_fileid", "str_Filemd5", "str_file_path", "uint32_total_len", "uint32_seq", "uint32_pos", "uint32_len", "bytes_text", "uint32_ptt_format" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, CorretTextReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x355.Stt.CorretTextReq
 * JD-Core Version:    0.7.0.1
 */