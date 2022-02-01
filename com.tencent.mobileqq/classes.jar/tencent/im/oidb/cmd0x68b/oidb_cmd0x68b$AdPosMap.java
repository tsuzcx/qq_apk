package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$AdPosMap
  extends MessageMicro<AdPosMap>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ads_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int_req_type = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_cmd0x68b.AdPosInfo> rpt_ad_pos_info_list = PBField.initRepeatMessage(oidb_cmd0x68b.AdPosInfo.class);
  public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "rpt_ad_pos_info_list", "bytes_ads_context", "bytes_ad_user_info", "uint64_ad_channel_id", "int_req_type" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0) }, AdPosMap.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdPosMap
 * JD-Core Version:    0.7.0.1
 */