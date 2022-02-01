package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd55$CheckMiniAppReq
  extends MessageMicro<CheckMiniAppReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "mini_app_appid", "need_check_bind" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, CheckMiniAppReq.class);
  public final PBUInt64Field mini_app_appid = PBField.initUInt64(0L);
  public final PBUInt32Field need_check_bind = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55.CheckMiniAppReq
 * JD-Core Version:    0.7.0.1
 */