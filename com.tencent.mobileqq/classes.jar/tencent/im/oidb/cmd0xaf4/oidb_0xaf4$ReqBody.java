package tencent.im.oidb.cmd0xaf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xaf4$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "group_id", "client_info", "last_game_dynamic_ts" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, ReqBody.class);
  public oidb_0xaf4.ClientInfo client_info = new oidb_0xaf4.ClientInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field last_game_dynamic_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ReqBody
 * JD-Core Version:    0.7.0.1
 */