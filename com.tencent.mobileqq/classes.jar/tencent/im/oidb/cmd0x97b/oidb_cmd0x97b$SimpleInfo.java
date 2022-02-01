package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x97b$SimpleInfo
  extends MessageMicro<SimpleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_header_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_like_total = PBField.initInt64(0L);
  public final PBInt64Field int64_publish_feeds_total = PBField.initInt64(0L);
  public oidb_cmd0x97b.ColumnInfo msg_column_info = new oidb_cmd0x97b.ColumnInfo();
  public oidb_cmd0x97b.SignIn msg_sign_in = new oidb_cmd0x97b.SignIn();
  public final PBRepeatMessageField<oidb_cmd0x97b.MedalInfo> rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0x97b.MedalInfo.class);
  public final PBUInt32Field uint32_is_vip = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 48, 56, 66, 90, 98 }, new String[] { "bytes_nick", "bytes_header_url", "uint32_is_vip", "bytes_desc", "int64_like_total", "int64_publish_feeds_total", "rpt_msg_medal_info", "msg_sign_in", "msg_column_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localLong, localLong, null, null, null }, SimpleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SimpleInfo
 * JD-Core Version:    0.7.0.1
 */