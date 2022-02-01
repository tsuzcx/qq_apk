package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class C2CType0x211_SubC2CType0x9$MsgBody$SupportFileInfo
  extends MessageMicro<SupportFileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_file_suffix = PBField.initString("");
  public final PBUInt32Field uint32_copies = PBField.initUInt32(0);
  public final PBUInt32Field uint32_duplex = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_file_suffix", "uint32_copies", "uint32_duplex" }, new Object[] { "", localInteger, localInteger }, SupportFileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo
 * JD-Core Version:    0.7.0.1
 */