package tencent.im.oidb.cmd0x59a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x59a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cgi_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_web_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x59a.ExpertFields msg_expert_fields = new oidb_cmd0x59a.ExpertFields();
  public final PBUInt32Field uint32_category_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_expert_tinyid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "uint32_category_id", "bytes_client_version", "bytes_web_version", "bytes_cgi_version", "uint64_expert_tinyid", "msg_expert_fields" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59a.oidb_cmd0x59a.ReqBody
 * JD-Core Version:    0.7.0.1
 */