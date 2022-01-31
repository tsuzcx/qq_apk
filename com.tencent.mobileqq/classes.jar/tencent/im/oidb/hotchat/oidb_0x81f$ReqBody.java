package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x81f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_uin", "msg_extern_param", "msg_auth_data", "gc" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt64Field gc = PBField.initUInt64(0L);
  public oidb_0x81f.GetAuthDataReq msg_auth_data = new oidb_0x81f.GetAuthDataReq();
  public oidb_0x81f.ExtParam msg_extern_param = new oidb_0x81f.ExtParam();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x81f.ReqBody
 * JD-Core Version:    0.7.0.1
 */