package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xde0$FeedsCtxFeature
  extends MessageMicro<FeedsCtxFeature>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ctx_device_id = PBField.initString("");
  public final PBStringField ctx_device_model = PBField.initString("");
  public final PBUInt32Field ctx_enter_reason = PBField.initUInt32(0);
  public final PBBoolField ctx_headset = PBField.initBool(false);
  public final PBFloatField ctx_lightness = PBField.initFloat(0.0F);
  public final PBUInt32Field ctx_network_type = PBField.initUInt32(0);
  public final PBFloatField ctx_power = PBField.initFloat(0.0F);
  public final PBUInt64Field ctx_scene = PBField.initUInt64(0L);
  public final PBStringField ctx_screen_info = PBField.initString("");
  public final PBFloatField ctx_volume = PBField.initFloat(0.0F);
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 53, 58, 69, 77, 80, 88 }, new String[] { "ctx_device_id", "timestamp", "ctx_enter_reason", "ctx_device_model", "ctx_network_type", "ctx_power", "ctx_screen_info", "ctx_lightness", "ctx_volume", "ctx_headset", "ctx_scene" }, new Object[] { "", localLong, localInteger, "", localInteger, localFloat, "", localFloat, localFloat, Boolean.valueOf(false), localLong }, FeedsCtxFeature.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsCtxFeature
 * JD-Core Version:    0.7.0.1
 */