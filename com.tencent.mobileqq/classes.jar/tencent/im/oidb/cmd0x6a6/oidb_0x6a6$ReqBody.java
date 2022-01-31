package tencent.im.oidb.cmd0x6a6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6a6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_init_read_count = PBField.initInt32(0);
  public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_article_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50 }, new String[] { "bytes_article_id", "uint32_req_type", "uint32_article_type", "uint32_platform_type", "int32_init_read_count", "rowkey" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6a6.oidb_0x6a6.ReqBody
 * JD-Core Version:    0.7.0.1
 */