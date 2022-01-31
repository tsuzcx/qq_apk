package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class userinfo$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public userinfo.AppInfo app_info = new userinfo.AppInfo();
  public userinfo.DevAttr attr = new userinfo.DevAttr();
  public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public userinfo.GPS gps = new userinfo.GPS();
  public final PBRepeatMessageField<userinfo.Cell> rpt_cell = PBField.initRepeatMessage(userinfo.Cell.class);
  public final PBRepeatMessageField<userinfo.Wifi> rpt_wifi = PBField.initRepeatMessage(userinfo.Wifi.class);
  public final PBStringField skey = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uin", "skey", "gps", "rpt_wifi", "rpt_cell", "attr", "app_info", "bytes_client_version" }, new Object[] { Long.valueOf(0L), "", null, null, null, null, null, localByteStringMicro }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.troop_search_userinfo.userinfo.UserInfo
 * JD-Core Version:    0.7.0.1
 */