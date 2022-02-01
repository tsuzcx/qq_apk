package tencent.im.oidb.cmd0xe9c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe9c$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xe9c.RelatedFaceReq relatedFaceReqBody = new oidb_0xe9c.RelatedFaceReq();
  public final PBStringField str_client_ver = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 82 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_aio_type", "uint32_age", "str_client_ver", "relatedFaceReqBody" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9c.oidb_0xe9c.ReqBody
 * JD-Core Version:    0.7.0.1
 */