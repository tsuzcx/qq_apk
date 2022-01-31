package localpb.dataline;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DatalineMsgData$MsgData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tokenkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url_notify = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
  public final PBStringField str_fileUuid = PBField.initString("");
  public final PBStringField str_moloiconurl = PBField.initString("");
  public final PBStringField str_molokey = PBField.initString("");
  public final PBStringField str_molosource = PBField.initString("");
  public final PBStringField str_molosrcurl = PBField.initString("");
  public final PBStringField str_msg = PBField.initString("");
  public final PBStringField str_reserve1 = PBField.initString("");
  public final PBUInt32Field uint32_busId = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fileFrom = PBField.initUInt32(0);
  public final PBUInt32Field uint32_forwardTroopFileEntranc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_isapkfile = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ismoloimage = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nOpType = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_OwnerUin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_entityID = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_filemsgstatus = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_weiyunsessionid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66, 72, 85, 88, 98, 106, 112, 120, 130, 136, 144, 152, 160, 168 }, new String[] { "str_msg", "uint64_filemsgstatus", "uint64_weiyunsessionid", "str_molokey", "str_moloiconurl", "str_molosource", "str_molosrcurl", "str_reserve1", "uint32_isapkfile", "fixed32_ip", "uint32_port", "bytes_url_notify", "bytes_tokenkey", "uint32_ismoloimage", "uint32_fileFrom", "str_fileUuid", "uint32_nOpType", "uint64_entityID", "uint64_OwnerUin", "uint32_busId", "uint32_forwardTroopFileEntranc" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, MsgData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     localpb.dataline.DatalineMsgData.MsgData
 * JD-Core Version:    0.7.0.1
 */