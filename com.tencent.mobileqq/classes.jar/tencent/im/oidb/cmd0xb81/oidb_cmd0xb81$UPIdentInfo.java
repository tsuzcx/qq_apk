package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$UPIdentInfo
  extends MessageMicro<UPIdentInfo>
{
  public static final int Level0 = 0;
  public static final int Level1 = 1;
  public static final int Level2 = 2;
  public static final int Level3 = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82, 90, 98 }, new String[] { "level", "timestamp", "icon_url", "large_icon_url", "summary" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "", "" }, UPIdentInfo.class);
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField large_icon_url = PBField.initString("");
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
  public final PBInt64Field timestamp = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UPIdentInfo
 * JD-Core Version:    0.7.0.1
 */