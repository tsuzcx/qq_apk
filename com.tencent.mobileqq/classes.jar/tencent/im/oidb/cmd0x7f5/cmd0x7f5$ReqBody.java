package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7f5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_route_mac = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x7f5.GPS msg_gps = new cmd0x7f5.GPS();
  public final PBRepeatMessageField<cmd0x7f5.Wifi> rpt_msg_wifi_mac = PBField.initRepeatMessage(cmd0x7f5.Wifi.class);
  public final PBUInt32Field uint32_area_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_id = PBField.initUInt32(0);
  public final PBFixed32Field uint32_ipv4 = PBField.initFixed32(0);
  public final PBUInt32Field uint32_loc_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_distance = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sort_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 53, 58, 66, 72, 80, 88, 96 }, new String[] { "uint32_max_count", "uint32_max_distance", "uint32_loc_type", "msg_gps", "bytes_route_mac", "uint32_ipv4", "rpt_msg_wifi_mac", "bytes_req_context", "uint32_area_count", "uint32_sort_type", "uint32_filter_id", "uint32_strategy" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.ReqBody
 * JD-Core Version:    0.7.0.1
 */