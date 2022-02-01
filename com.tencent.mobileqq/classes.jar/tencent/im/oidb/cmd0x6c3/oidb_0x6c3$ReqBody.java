package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6c3$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6c3.ExtParam msg_ext_param = new oidb_0x6c3.ExtParam();
  public oidb_0x6c3.GetExtraDataReq msg_extra_data = new oidb_0x6c3.GetExtraDataReq();
  public oidb_0x6c3.GetStockReq msg_get_stock = new oidb_0x6c3.GetStockReq();
  public final PBUInt32Field uint32_activity_detail = PBField.initUInt32(0);
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_use_stock_cache = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 74, 80, 88, 96, 104 }, new String[] { "uint64_group", "bytes_user_ip", "bytes_version", "uint32_portal", "uint32_client", "uint32_instance_id", "msg_ext_param", "msg_get_stock", "msg_extra_data", "uint32_business_id", "uint32_req_from", "uint32_activity_detail", "uint32_use_stock_cache" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger, null, null, null, localInteger, localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ReqBody
 * JD-Core Version:    0.7.0.1
 */