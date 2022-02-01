package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;

public final class oidb_cmd0xf30$ReqRecommendPara
  extends MessageMicro<ReqRecommendPara>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField action_type = PBField.initEnum(0);
  public final PBBytesField bytes_device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x68b.ReqAdvertisePara req_advertise_para = new oidb_cmd0x68b.ReqAdvertisePara();
  public final PBEnumField request_type = PBField.initEnum(0);
  public final PBRepeatField<Integer> rpt_ads_pos = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_card_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recommend_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 32, 40, 50, 58, 64, 72, 80, 88, 98, 104, 112 }, new String[] { "bytes_req_rowkey", "bytes_subscribe_id", "uint32_update_times", "uint32_req_recommend_flag", "bytes_manufacturer", "bytes_device_brand_and_model", "uint32_network_type", "uint32_os_type", "action_type", "request_type", "req_advertise_para", "uint32_card_pos", "rpt_ads_pos" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger, localInteger, localInteger, null, localInteger, localInteger }, ReqRecommendPara.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.ReqRecommendPara
 * JD-Core Version:    0.7.0.1
 */