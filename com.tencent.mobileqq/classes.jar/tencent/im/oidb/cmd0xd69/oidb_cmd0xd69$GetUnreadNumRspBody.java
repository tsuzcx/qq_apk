package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd69$GetUnreadNumRspBody
  extends MessageMicro<GetUnreadNumRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "doubt_unread_num" }, new Object[] { Integer.valueOf(0) }, GetUnreadNumRspBody.class);
  public final PBUInt32Field doubt_unread_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetUnreadNumRspBody
 * JD-Core Version:    0.7.0.1
 */