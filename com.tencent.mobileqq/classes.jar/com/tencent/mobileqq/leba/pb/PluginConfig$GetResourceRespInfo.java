package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$GetResourceRespInfo
  extends MessageMicro<GetResourceRespInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field can_change_state = PBField.initUInt32(0);
  public final PBStringField grid_icon_url = PBField.initString("");
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField pkg_name = PBField.initString("");
  public final PBStringField res_conf = PBField.initString("");
  public final PBUInt32Field res_id = PBField.initUInt32(0);
  public final PBStringField res_name = PBField.initString("");
  public final PBUInt32Field res_seq = PBField.initUInt32(0);
  public final PBUInt32Field simple_mode = PBField.initUInt32(0);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 80, 90, 96, 106 }, new String[] { "res_id", "state", "res_seq", "sub_type", "res_name", "icon_url", "jump_url", "res_conf", "can_change_state", "pkg_name", "simple_mode", "grid_icon_url" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "", "", "", "", localInteger, "", localInteger, "" }, GetResourceRespInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceRespInfo
 * JD-Core Version:    0.7.0.1
 */