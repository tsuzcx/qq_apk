package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$RecommPeopleConf
  extends MessageMicro<RecommPeopleConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField recommend_cookie = PBField.initString("");
  public final PBStringField str_icon_url = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBUInt32Field uint32_postion = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "str_icon_url", "str_title", "uint32_postion", "uint32_show_num", "recommend_cookie" }, new Object[] { "", "", localInteger, localInteger, "" }, RecommPeopleConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.RecommPeopleConf
 * JD-Core Version:    0.7.0.1
 */