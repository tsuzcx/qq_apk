package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x68b$SetTopCookie
  extends MessageMicro<SetTopCookie>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_one_set_top_cookie" }, new Object[] { null }, SetTopCookie.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.OneSetTopCookie> rpt_one_set_top_cookie = PBField.initRepeatMessage(oidb_cmd0x68b.OneSetTopCookie.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SetTopCookie
 * JD-Core Version:    0.7.0.1
 */