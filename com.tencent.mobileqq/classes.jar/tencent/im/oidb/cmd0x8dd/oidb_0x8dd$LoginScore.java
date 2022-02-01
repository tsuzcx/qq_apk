package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$LoginScore
  extends MessageMicro<LoginScore>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_login_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_login_score = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_login_day", "uint32_login_score" }, new Object[] { localInteger, localInteger }, LoginScore.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.LoginScore
 * JD-Core Version:    0.7.0.1
 */