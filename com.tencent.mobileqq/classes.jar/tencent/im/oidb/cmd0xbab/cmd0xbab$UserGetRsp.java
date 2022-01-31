package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xbab$UserGetRsp
  extends MessageMicro<UserGetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "policy", "privilege_flag", "member_number", "exp_remain_time", "exp_set_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserGetRsp.class);
  public final PBUInt32Field exp_remain_time = PBField.initUInt32(0);
  public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
  public final PBUInt32Field member_number = PBField.initUInt32(0);
  public final PBUInt32Field policy = PBField.initUInt32(0);
  public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbab.cmd0xbab.UserGetRsp
 * JD-Core Version:    0.7.0.1
 */