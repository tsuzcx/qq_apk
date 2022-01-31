package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x2ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pb_bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_batch_id = PBField.initString("");
  public final PBStringField str_batch_item_id = PBField.initString("");
  public final PBStringField str_client_key = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_file_key = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_busid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mark = PBField.initUInt32(0);
  public final PBUInt32Field uint32_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sequence = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66, 74, 80, 88, 96, 104, 112, 122 }, new String[] { "uint32_disscus_uin", "uint32_sender_uin", "str_file_name", "uint64_file_size", "str_file_id", "str_batch_id", "str_batch_item_id", "str_client_key", "str_file_key", "uint32_mark", "uint64_time", "uint64_sequence", "uint32_busid", "uint32_random", "bytes_pb_bytes_reserve" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, SubCmd0x2ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x2ReqBody
 * JD-Core Version:    0.7.0.1
 */