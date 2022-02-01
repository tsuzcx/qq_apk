package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$AlumnusConf
  extends MessageMicro<AlumnusConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_alumnus_entrance_open", "str_alumnus_pic_url", "str_alumnus_pic_md5" }, new Object[] { Integer.valueOf(0), "", "" }, AlumnusConf.class);
  public final PBStringField str_alumnus_pic_md5 = PBField.initString("");
  public final PBStringField str_alumnus_pic_url = PBField.initString("");
  public final PBUInt32Field uint32_alumnus_entrance_open = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.AlumnusConf
 * JD-Core Version:    0.7.0.1
 */