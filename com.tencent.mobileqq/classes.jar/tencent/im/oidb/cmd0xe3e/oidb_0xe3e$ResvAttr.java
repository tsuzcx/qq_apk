package tencent.im.oidb.cmd0xe3e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe3e$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_friend_banned_flag", "uint32_gray_tips_from" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ResvAttr.class);
  public final PBUInt32Field uint32_friend_banned_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gray_tips_from = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3e.oidb_0xe3e.ResvAttr
 * JD-Core Version:    0.7.0.1
 */