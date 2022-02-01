package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe34$BindUinInfo
  extends MessageMicro<BindUinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_uin", "uint32_app_id", "uint32_instance_id", "msg_login_sig" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, BindUinInfo.class);
  public cmd0xe34.LoginSig msg_login_sig = new cmd0xe34.LoginSig();
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe34.cmd0xe34.BindUinInfo
 * JD-Core Version:    0.7.0.1
 */