package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe34$C2CMsgUnreadNumInfo
  extends MessageMicro<C2CMsgUnreadNumInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "peer_uin_num", "msg_num", "last_msg_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, C2CMsgUnreadNumInfo.class);
  public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  public final PBUInt32Field peer_uin_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe34.cmd0xe34.C2CMsgUnreadNumInfo
 * JD-Core Version:    0.7.0.1
 */