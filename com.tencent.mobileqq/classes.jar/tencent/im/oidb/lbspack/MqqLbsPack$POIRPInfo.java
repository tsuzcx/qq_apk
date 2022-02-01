package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MqqLbsPack$POIRPInfo
  extends MessageMicro<POIRPInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public final PBRepeatMessageField<MqqLbsPack.LbsPackInfo> lbs_pack_info = PBField.initRepeatMessage(MqqLbsPack.LbsPackInfo.class);
  public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(900000000);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_poi_id", "int32_lat", "int32_lon", "uint32_total_num", "lbs_pack_info" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, Integer.valueOf(0), null }, POIRPInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.POIRPInfo
 * JD-Core Version:    0.7.0.1
 */