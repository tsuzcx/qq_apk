package tencent.im.oidb.cmd0x8f1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8f1$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_label_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_label_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_req_num", "bytes_label_cookie", "uint64_req_uin", "uint64_label_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro, localLong, localLong }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f1.oidb_0x8f1.ReqBody
 * JD-Core Version:    0.7.0.1
 */