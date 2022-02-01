package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.qqconnect.Appinfo;

public final class oidb_cmd0xc7a$UinInfo
  extends MessageMicro<UinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 90 }, new String[] { "uin", "nick", "face_url", "face_url_simple", "appinfo" }, new Object[] { Long.valueOf(0L), "", "", "", null }, UinInfo.class);
  public qqconnect.Appinfo appinfo = new qqconnect.Appinfo();
  public final PBStringField face_url = PBField.initString("");
  public final PBStringField face_url_simple = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.UinInfo
 * JD-Core Version:    0.7.0.1
 */