package tencent.im.s2c.msgtype0x210.submsgtype0xf9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xf9$Video
  extends MessageMicro<Video>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_layout", "str_cover", "str_src" }, new Object[] { Integer.valueOf(0), "", "" }, Video.class);
  public final PBStringField str_cover = PBField.initString("");
  public final PBStringField str_src = PBField.initString("");
  public final PBUInt32Field uint32_layout = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.Video
 * JD-Core Version:    0.7.0.1
 */