package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf30$ReqRecommendPara
  extends MessageMicro<ReqRecommendPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField action_type = PBField.initEnum(0);
  public final PBBytesField bytes_device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField request_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recommend_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 32, 40, 50, 58, 64, 72, 80, 88 }, new String[] { "bytes_req_rowkey", "bytes_subscribe_id", "uint32_update_times", "uint32_req_recommend_flag", "bytes_manufacturer", "bytes_device_brand_and_model", "uint32_network_type", "uint32_os_type", "action_type", "request_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqRecommendPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.ReqRecommendPara
 * JD-Core Version:    0.7.0.1
 */