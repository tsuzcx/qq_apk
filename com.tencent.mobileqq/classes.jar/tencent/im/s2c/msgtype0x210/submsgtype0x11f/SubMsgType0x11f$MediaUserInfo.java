package tencent.im.s2c.msgtype0x210.submsgtype0x11f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x11f$MediaUserInfo
  extends MessageMicro<MediaUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_to_uin", "uint32_join_state" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MediaUserInfo.class);
  public final PBUInt32Field uint32_join_state = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.MediaUserInfo
 * JD-Core Version:    0.7.0.1
 */