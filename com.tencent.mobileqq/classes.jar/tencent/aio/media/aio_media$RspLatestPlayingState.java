package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$RspLatestPlayingState
  extends MessageMicro<RspLatestPlayingState>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 74, 80, 160, 168, 176, 184, 402, 410 }, new String[] { "msg_result", "enum_aio_state", "enum_media_type", "msg_music", "uint64_create_uin", "enum_user_state", "uint32_joined_num", "enum_c2c_join_state", "msg_personal_setting", "uint64_aio_identification", "enum_joined_aio_type", "uint64_joined_id", "bool_joined_is_creater", "enum_joined_media_type", "msg_room_info", "msg_ksing_info" }, new Object[] { null, Integer.valueOf(1), Integer.valueOf(1), null, Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), null, Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(1), null, null }, RspLatestPlayingState.class);
  public final PBBoolField bool_joined_is_creater = PBField.initBool(false);
  public final PBEnumField enum_aio_state = PBField.initEnum(1);
  public final PBEnumField enum_c2c_join_state = PBField.initEnum(1);
  public final PBEnumField enum_joined_aio_type = PBField.initEnum(1);
  public final PBEnumField enum_joined_media_type = PBField.initEnum(1);
  public final PBEnumField enum_media_type = PBField.initEnum(1);
  public final PBEnumField enum_user_state = PBField.initEnum(1);
  public aio_media.TypeKSing msg_ksing_info = new aio_media.TypeKSing();
  public aio_media.TypeMusic msg_music = new aio_media.TypeMusic();
  public aio_media.PersonalSetting msg_personal_setting = new aio_media.PersonalSetting();
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  public aio_media.TypeVideo msg_room_info = new aio_media.TypeVideo();
  public final PBUInt32Field uint32_joined_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_aio_identification = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_joined_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.media.aio_media.RspLatestPlayingState
 * JD-Core Version:    0.7.0.1
 */