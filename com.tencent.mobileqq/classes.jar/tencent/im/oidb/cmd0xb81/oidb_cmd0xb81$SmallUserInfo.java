package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$SmallUserInfo
  extends MessageMicro<SmallUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field upgc_flag = PBField.initUInt32(0);
  public final PBUInt32Field user_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "user_type", "upgc_flag" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, SmallUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.SmallUserInfo
 * JD-Core Version:    0.7.0.1
 */