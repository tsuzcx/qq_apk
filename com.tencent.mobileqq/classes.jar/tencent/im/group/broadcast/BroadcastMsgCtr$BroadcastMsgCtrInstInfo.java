package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BroadcastMsgCtr$BroadcastMsgCtrInstInfo
  extends MessageMicro<BroadcastMsgCtrInstInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_appid", "uint32_inst_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BroadcastMsgCtrInstInfo.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.BroadcastMsgCtrInstInfo
 * JD-Core Version:    0.7.0.1
 */