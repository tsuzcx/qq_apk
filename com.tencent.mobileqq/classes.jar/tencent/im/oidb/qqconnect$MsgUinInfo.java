package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqconnect$MsgUinInfo
  extends MessageMicro<MsgUinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBStringField face_url = PBField.initString("");
  public final PBStringField face_url_simple = PBField.initString("");
  public final PBUInt32Field mp_type = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt32Field mtime = PBField.initUInt32(0);
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 802, 810, 818 }, new String[] { "uin", "msg_type", "appid", "app_type", "ctime", "mtime", "mp_type", "nick", "face_url", "face_url_simple" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", "", "" }, MsgUinInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.MsgUinInfo
 * JD-Core Version:    0.7.0.1
 */