package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeac$MsgProcessInfo
  extends MessageMicro<MsgProcessInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "msg", "error_code", "digest_uin", "digest_time" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, MsgProcessInfo.class);
  public final PBUInt32Field digest_time = PBField.initUInt32(0);
  public final PBUInt64Field digest_uin = PBField.initUInt64(0L);
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public oidb_0xeac.MsgInfo msg = new oidb_0xeac.MsgInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.MsgProcessInfo
 * JD-Core Version:    0.7.0.1
 */