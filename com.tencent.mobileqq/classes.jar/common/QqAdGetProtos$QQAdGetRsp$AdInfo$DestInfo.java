package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$DestInfo
  extends MessageMicro<DestInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField canvas_json = PBField.initString("");
  public final PBUInt32Field dest_type = PBField.initUInt32(0);
  public final PBUInt32Field dest_url_display_type = PBField.initUInt32(0);
  public final PBStringField landing_page = PBField.initString("");
  public final PBStringField pop_sheet = PBField.initString("");
  public final PBStringField universal_link = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "dest_url_display_type", "landing_page", "canvas_json", "dest_type", "pop_sheet", "universal_link" }, new Object[] { localInteger, "", "", localInteger, "", "" }, DestInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.DestInfo
 * JD-Core Version:    0.7.0.1
 */