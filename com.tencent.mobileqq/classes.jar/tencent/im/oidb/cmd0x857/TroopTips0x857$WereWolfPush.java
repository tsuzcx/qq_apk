package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$WereWolfPush
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_judge_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_judge_words = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field enum_game_state = PBField.initUInt32(0);
  public final PBUInt32Field enum_operation = PBField.initUInt32(0);
  public final PBRepeatField rpt_dead_users = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField rpt_roles = PBField.initRepeatMessage(TroopTips0x857.WereWolfPush.Role.class);
  public final PBRepeatField rpt_voted_tie_users = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_game_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_game_round = PBField.initUInt32(0);
  public final PBUInt32Field uint32_kill_confirmed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timeout_sec = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_user = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_game_room = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_judge_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_speaker = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_user = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 72, 80, 88, 96, 104, 112, 120, 130, 136 }, new String[] { "uint32_push_type", "uint64_game_room", "enum_game_state", "uint32_game_round", "rpt_roles", "uint64_speaker", "uint64_judge_uin", "bytes_judge_words", "enum_operation", "uint64_src_user", "uint64_dst_user", "rpt_dead_users", "uint32_game_result", "uint32_timeout_sec", "uint32_kill_confirmed", "bytes_judge_nickname", "rpt_voted_tie_users" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L) }, WereWolfPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush
 * JD-Core Version:    0.7.0.1
 */