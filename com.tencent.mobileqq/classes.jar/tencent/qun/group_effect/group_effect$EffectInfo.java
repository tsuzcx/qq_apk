package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_effect$EffectInfo
  extends MessageMicro<EffectInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 114, 122, 130, 138, 146, 808, 816 }, new String[] { "effect_id", "name", "wording", "get_mode", "svip_level", "group_level", "price", "gif_url", "pic_url", "mp4_url", "duration", "status", "sort_num", "attr_id", "small_pic_url", "bg_pic_url", "spirit_url", "spirit_config", "ttl", "user_config_status" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Boolean.valueOf(false) }, EffectInfo.class);
  public final PBStringField attr_id = PBField.initString("");
  public final PBStringField bg_pic_url = PBField.initString("");
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBUInt32Field effect_id = PBField.initUInt32(0);
  public final PBUInt32Field get_mode = PBField.initUInt32(0);
  public final PBStringField gif_url = PBField.initString("");
  public final PBUInt32Field group_level = PBField.initUInt32(0);
  public final PBStringField mp4_url = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField pic_url = PBField.initString("");
  public final PBUInt32Field price = PBField.initUInt32(0);
  public final PBStringField small_pic_url = PBField.initString("");
  public final PBUInt32Field sort_num = PBField.initUInt32(0);
  public final PBStringField spirit_config = PBField.initString("");
  public final PBStringField spirit_url = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt32Field svip_level = PBField.initUInt32(0);
  public final PBInt32Field ttl = PBField.initInt32(0);
  public final PBBoolField user_config_status = PBField.initBool(false);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect.EffectInfo
 * JD-Core Version:    0.7.0.1
 */