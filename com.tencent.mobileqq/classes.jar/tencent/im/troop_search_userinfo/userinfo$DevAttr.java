package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class userinfo$DevAttr
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_imei", "str_imsi", "str_phonenum" }, new Object[] { "", "", "" }, DevAttr.class);
  public final PBStringField str_imei = PBField.initString("");
  public final PBStringField str_imsi = PBField.initString("");
  public final PBStringField str_phonenum = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.troop_search_userinfo.userinfo.DevAttr
 * JD-Core Version:    0.7.0.1
 */