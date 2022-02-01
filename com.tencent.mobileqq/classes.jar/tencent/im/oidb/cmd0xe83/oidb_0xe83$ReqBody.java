package tencent.im.oidb.cmd0xe83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe83$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "group_id", "client_info", "last_game_dynamic_ts", "mini_app_disable", "mode" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public oidb_0xe83.ClientInfo client_info = new oidb_0xe83.ClientInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field last_game_dynamic_ts = PBField.initUInt32(0);
  public final PBUInt32Field mini_app_disable = PBField.initUInt32(0);
  public final PBUInt32Field mode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe83.oidb_0xe83.ReqBody
 * JD-Core Version:    0.7.0.1
 */