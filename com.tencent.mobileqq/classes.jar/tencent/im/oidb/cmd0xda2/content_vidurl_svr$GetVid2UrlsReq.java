package tencent.im.oidb.cmd0xda2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class content_vidurl_svr$GetVid2UrlsReq
  extends MessageMicro<GetVid2UrlsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_name = PBField.initString("");
  public final PBStringField app_version = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField client_ip = PBField.initString("");
  public final PBStringField idfa = PBField.initString("");
  public final PBStringField imei = PBField.initString("");
  public final PBUInt32Field net_type = PBField.initUInt32(0);
  public final PBStringField sign = PBField.initString("");
  public final PBUInt32Field system = PBField.initUInt32(0);
  public final PBStringField timestamp = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
  public final PBRepeatField<String> vids = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 72, 82, 90, 98 }, new String[] { "uid", "appid", "client_ip", "net_type", "app_name", "app_version", "imei", "idfa", "system", "vids", "timestamp", "sign" }, new Object[] { "", "", "", localInteger, "", "", "", "", localInteger, "", "", "" }, GetVid2UrlsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xda2.content_vidurl_svr.GetVid2UrlsReq
 * JD-Core Version:    0.7.0.1
 */