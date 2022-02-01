package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$WereWolfPush$Role
  extends MessageMicro<Role>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field enum_dead_op = PBField.initUInt32(0);
  public final PBUInt32Field enum_operation = PBField.initUInt32(0);
  public final PBUInt32Field enum_state = PBField.initUInt32(0);
  public final PBUInt32Field enum_type = PBField.initUInt32(0);
  public TroopTips0x857.WereWolfPush.GameRecord msg_game_record = new TroopTips0x857.WereWolfPush.GameRecord();
  public final PBUInt32Field uint32_already_checked = PBField.initUInt32(0);
  public final PBUInt32Field uint32_already_poisoned = PBField.initUInt32(0);
  public final PBUInt32Field uint32_already_saved = PBField.initUInt32(0);
  public final PBUInt32Field uint32_can_listen = PBField.initUInt32(0);
  public final PBUInt32Field uint32_can_speak = PBField.initUInt32(0);
  public final PBUInt32Field uint32_can_vote = PBField.initUInt32(0);
  public final PBUInt32Field uint32_can_voted = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_sheriff = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_werewolf = PBField.initUInt32(0);
  public final PBUInt32Field uint32_operation_round = PBField.initUInt32(0);
  public final PBUInt32Field uint32_player_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_position = PBField.initUInt32(0);
  public final PBUInt64Field uint64_defended_user = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_dst_user = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 138, 144, 152, 160 }, new String[] { "uint64_uin", "enum_type", "enum_state", "uint32_can_speak", "uint32_can_listen", "uint32_position", "uint32_can_vote", "uint32_can_voted", "uint32_already_checked", "uint32_already_saved", "uint32_already_poisoned", "uint32_player_state", "enum_dead_op", "enum_operation", "uint64_dst_user", "uint32_operation_round", "msg_game_record", "uint32_is_werewolf", "uint64_defended_user", "uint32_is_sheriff" }, new Object[] { localLong, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localLong, localInteger, null, localInteger, localLong, localInteger }, Role.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush.Role
 * JD-Core Version:    0.7.0.1
 */