package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$AIOPush
  extends MessageMicro<AIOPush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBEnumField enum_c2c_join_state = PBField.initEnum(1);
  public final PBEnumField enum_play_mode = PBField.initEnum(1);
  public aio_media.PersonalSetting msg_personal_setting = new aio_media.PersonalSetting();
  public final PBEnumField msg_push_type = PBField.initEnum(1);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_joined_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64 }, new String[] { "enum_aio_type", "uint64_id", "msg_push_type", "seq", "uint32_joined_num", "enum_c2c_join_state", "msg_personal_setting", "enum_play_mode" }, new Object[] { localInteger, localLong, localInteger, localLong, Integer.valueOf(0), localInteger, null, localInteger }, AIOPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.aio.media.aio_media.AIOPush
 * JD-Core Version:    0.7.0.1
 */