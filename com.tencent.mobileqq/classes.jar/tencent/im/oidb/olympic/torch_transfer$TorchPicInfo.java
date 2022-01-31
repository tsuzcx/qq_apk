package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class torch_transfer$TorchPicInfo
  extends MessageMicro<TorchPicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_business_type", "str_torch_pic_url", "str_torch_pic_md5", "rpt_city_pic_list" }, new Object[] { Integer.valueOf(0), "", "", null }, TorchPicInfo.class);
  public final PBRepeatMessageField<torch_transfer.CityBackPicInfo> rpt_city_pic_list = PBField.initRepeatMessage(torch_transfer.CityBackPicInfo.class);
  public final PBStringField str_torch_pic_md5 = PBField.initString("");
  public final PBStringField str_torch_pic_url = PBField.initString("");
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.olympic.torch_transfer.TorchPicInfo
 * JD-Core Version:    0.7.0.1
 */