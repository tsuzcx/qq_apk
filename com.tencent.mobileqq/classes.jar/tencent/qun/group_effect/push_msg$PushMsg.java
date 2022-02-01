package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class push_msg$PushMsg
  extends MessageMicro<PushMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public group_effect.EffectInfo effect_info = new group_effect.EffectInfo();
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field group_level = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field rc = PBField.initInt32(0);
  public final PBUInt64Field set_mode = PBField.initUInt64(0L);
  public final PBUInt32Field svip_level = PBField.initUInt32(0);
  public final PBUInt32Field svip_type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 162, 168 }, new String[] { "rc", "msg", "uin", "group_code", "svip_level", "svip_type", "group_level", "effect_info", "set_mode" }, new Object[] { localInteger, "", localLong, localLong, localInteger, localInteger, localInteger, null, localLong }, PushMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.qun.group_effect.push_msg.PushMsg
 * JD-Core Version:    0.7.0.1
 */