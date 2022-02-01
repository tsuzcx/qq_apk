package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58b$GetConfNameForPushReq
  extends MessageMicro<GetConfNameForPushReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_conf_uin" }, new Object[] { Long.valueOf(0L) }, GetConfNameForPushReq.class);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfNameForPushReq
 * JD-Core Version:    0.7.0.1
 */