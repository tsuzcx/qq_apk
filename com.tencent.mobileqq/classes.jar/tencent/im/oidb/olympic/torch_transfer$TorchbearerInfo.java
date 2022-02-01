package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class torch_transfer$TorchbearerInfo
  extends MessageMicro<TorchbearerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public torch_transfer.BusinessEntryInfo msg_business_entry_info = new torch_transfer.BusinessEntryInfo();
  public torch_transfer.LightCityInfo msg_light_city_info = new torch_transfer.LightCityInfo();
  public torch_transfer.TorchLimitInfo msg_limit_info = new torch_transfer.TorchLimitInfo();
  public torch_transfer.TorchPicInfo msg_pic_info = new torch_transfer.TorchPicInfo();
  public torch_transfer.TorcherRankInfo msg_torcher_rank_info = new torch_transfer.TorcherRankInfo();
  public final PBUInt32Field uint32_transfer_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bearer_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "uint64_uin", "uint64_bearer_id", "uint32_transfer_num", "msg_pic_info", "msg_light_city_info", "msg_limit_info", "msg_business_entry_info", "msg_torcher_rank_info" }, new Object[] { localLong, localLong, Integer.valueOf(0), null, null, null, null, null }, TorchbearerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo
 * JD-Core Version:    0.7.0.1
 */