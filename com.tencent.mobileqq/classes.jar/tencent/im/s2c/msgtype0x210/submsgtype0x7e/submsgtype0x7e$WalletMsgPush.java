package tencent.im.s2c.msgtype0x210.submsgtype0x7e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x7e$WalletMsgPush
  extends MessageMicro<WalletMsgPush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_extend = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_appinfo = PBField.initString("");
  public final PBStringField str_billno = PBField.initString("");
  public final PBStringField str_jumpurl = PBField.initString("");
  public final PBStringField str_serialno = PBField.initString("");
  public final PBUInt32Field uint32_action = PBField.initUInt32(0);
  public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 66 }, new String[] { "uint32_action", "uint32_timestamp", "bytes_extend", "str_serialno", "str_billno", "str_appinfo", "uint32_amount", "str_jumpurl" }, new Object[] { localInteger, localInteger, localByteStringMicro, "", "", "", localInteger, "" }, WalletMsgPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e.WalletMsgPush
 * JD-Core Version:    0.7.0.1
 */