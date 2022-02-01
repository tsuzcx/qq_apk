package com.tencent.protofile.terminal_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class terminal_info$TerminalInfo
  extends MessageMicro<TerminalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField android_cid = PBField.initString("");
  public final PBStringField android_id = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField browser_info = PBField.initString("");
  public final PBStringField idfa = PBField.initString("");
  public final PBStringField idfv = PBField.initString("");
  public final PBStringField imsi = PBField.initString("");
  public final PBBoolField is_root = PBField.initBool(false);
  public final PBStringField mac_addr = PBField.initString("");
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField os_version = PBField.initString("");
  public final PBStringField phone_name = PBField.initString("");
  public final PBStringField phone_type = PBField.initString("");
  public final PBStringField qimei = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
  public final PBBoolField simulation = PBField.initBool(false);
  public final PBStringField wifi_mac = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 112, 120, 130, 138 }, new String[] { "qimei", "mac_addr", "phone_type", "manufacturer", "phone_name", "idfa", "idfv", "android_id", "android_cid", "wifi_mac", "imsi", "os_version", "qua", "simulation", "is_root", "appid", "browser_info" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", localBoolean, localBoolean, "", "" }, TerminalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.terminal_info.terminal_info.TerminalInfo
 * JD-Core Version:    0.7.0.1
 */