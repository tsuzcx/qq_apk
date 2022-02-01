package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb60$CheckUrlReq
  extends MessageMicro<CheckUrlReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "appid", "app_type", "url" }, new Object[] { localInteger, localInteger, "" }, CheckUrlReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.CheckUrlReq
 * JD-Core Version:    0.7.0.1
 */