package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetTroopAioTopAD$AdInfo
  extends MessageMicro<AdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField ad_show_type = PBField.initEnum(0);
  public GetTroopAioTopAD.ExtAdInfo msg_ext_adinfo = new GetTroopAioTopAD.ExtAdInfo();
  public final PBStringField str_background_url = PBField.initString("");
  public final PBStringField str_more_url = PBField.initString("");
  public final PBStringField str_pic_url = PBField.initString("");
  public final PBUInt32Field uint32_ad_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_valid_interval = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "uint32_ad_id", "str_background_url", "str_more_url", "str_pic_url", "uint32_valid_interval", "ad_show_type", "msg_ext_adinfo" }, new Object[] { localInteger, "", "", "", localInteger, localInteger, null }, AdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.AdInfo
 * JD-Core Version:    0.7.0.1
 */