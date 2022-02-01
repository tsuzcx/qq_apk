package tencent.im.oidb.cmd0xf90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf90$TodoInfo
  extends MessageMicro<TodoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_name = PBField.initString("");
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBEnumField msg_type = PBField.initEnum(0);
  public final PBStringField nickname = PBField.initString("");
  public final PBUInt32Field random = PBField.initUInt32(0);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBStringField title = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96 }, new String[] { "group_code", "seq", "random", "uin", "nickname", "title", "jump_url", "icon_url", "create_time", "app_name", "appid", "msg_type" }, new Object[] { localLong, localLong, localInteger, localLong, "", "", "", "", localInteger, "", localLong, localInteger }, TodoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf90.oidb_0xf90.TodoInfo
 * JD-Core Version:    0.7.0.1
 */