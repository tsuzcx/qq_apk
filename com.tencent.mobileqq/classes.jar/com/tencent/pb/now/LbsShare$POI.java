package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LbsShare$POI
  extends MessageMicro<POI>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 66, 74, 80, 90, 98, 106, 114 }, new String[] { "name", "addr", "shop_url", "lat", "lng", "coordinate", "id", "shop_url_quan", "dpid", "shop_count", "shangquan_url", "shangquan_wording", "POI_preview_url", "city" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", "", "", "" }, POI.class);
  public final PBStringField POI_preview_url = PBField.initString("");
  public final PBStringField addr = PBField.initString("");
  public final PBStringField city = PBField.initString("");
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBStringField dpid = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lng = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField shangquan_url = PBField.initString("");
  public final PBStringField shangquan_wording = PBField.initString("");
  public final PBUInt32Field shop_count = PBField.initUInt32(0);
  public final PBStringField shop_url = PBField.initString("");
  public final PBStringField shop_url_quan = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.LbsShare.POI
 * JD-Core Version:    0.7.0.1
 */