package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd69$DeleteReqBody
  extends MessageMicro<DeleteReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "doubt_uin" }, new Object[] { Long.valueOf(0L) }, DeleteReqBody.class);
  public final PBUInt64Field doubt_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DeleteReqBody
 * JD-Core Version:    0.7.0.1
 */