package tencent.im.oidb.cmd0x962;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x962$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x962.ClientInfo msg_client_info = new oidb_0x962.ClientInfo();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_times = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "uint64_group_code", "bytes_id", "uint32_times", "msg_client_info", "uint32_product_id", "uint32_cmd" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x962.oidb_0x962.ReqBody
 * JD-Core Version:    0.7.0.1
 */