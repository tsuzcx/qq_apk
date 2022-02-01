package tencent.im.oidb.cmd0xd71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd71$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_id", "game_switch_status", "show_game_switch_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field game_switch_status = PBField.initUInt32(0);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field show_game_switch_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd71.oidb_0xd71.RspBody
 * JD-Core Version:    0.7.0.1
 */