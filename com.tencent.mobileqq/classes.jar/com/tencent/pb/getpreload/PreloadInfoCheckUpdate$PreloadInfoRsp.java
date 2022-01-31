package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$PreloadInfoRsp
  extends MessageMicro<PreloadInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "head", "preload_switch", "preload", "interval", "applist", "red_ram", "click_ram", "preload_result" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, PreloadInfoRsp.class);
  public final PBRepeatField<String> applist = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field click_ram = PBField.initInt32(0);
  public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
  public final PBInt32Field interval = PBField.initInt32(0);
  public final PBBoolField preload = PBField.initBool(false);
  public final PBRepeatMessageField<PreloadInfoCheckUpdate.PreloadResult> preload_result = PBField.initRepeatMessage(PreloadInfoCheckUpdate.PreloadResult.class);
  public final PBInt32Field preload_switch = PBField.initInt32(0);
  public final PBInt32Field red_ram = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadInfoRsp
 * JD-Core Version:    0.7.0.1
 */