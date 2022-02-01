package tencent.im.oidb.cmd0x66b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x66b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reqbody_5eb = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_req_configinfo = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_giftinfo = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_likeinfo = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pansocialinfo = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_visitor = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 480802, 481600, 482400, 483200, 484000, 484800 }, new String[] { "bytes_reqbody_5eb", "uint32_req_likeinfo", "uint32_req_pansocialinfo", "uint32_req_giftinfo", "uint32_req_configinfo", "uint32_req_visitor" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody
 * JD-Core Version:    0.7.0.1
 */