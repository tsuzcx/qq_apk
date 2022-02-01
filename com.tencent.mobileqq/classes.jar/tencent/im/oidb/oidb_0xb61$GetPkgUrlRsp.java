package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb61$GetPkgUrlRsp
  extends MessageMicro<GetPkgUrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "app_version", "pkg_url" }, new Object[] { Integer.valueOf(0), "" }, GetPkgUrlRsp.class);
  public final PBUInt32Field app_version = PBField.initUInt32(0);
  public final PBStringField pkg_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb61.GetPkgUrlRsp
 * JD-Core Version:    0.7.0.1
 */