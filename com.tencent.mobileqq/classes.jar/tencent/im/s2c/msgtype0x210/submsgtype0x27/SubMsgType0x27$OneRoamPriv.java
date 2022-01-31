package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$OneRoamPriv
  extends MessageMicro<OneRoamPriv>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_fuin", "uint32_priv_tag", "uint32_priv_value" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, OneRoamPriv.class);
  public final PBUInt32Field uint32_priv_tag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_priv_value = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.OneRoamPriv
 * JD-Core Version:    0.7.0.1
 */