package tencent.im.s2c.msgtype0x210.submsgtype0xe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xe4$GiftMsg
  extends MessageMicro<GiftMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField gift_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField packageurl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_roomid = PBField.initString("");
  public final PBUInt32Field uint32_all_add_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cur_add_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_gift_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 400, 408 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_product_id", "uint32_gift_id", "uint64_gift_num", "str_roomid", "gift_wording", "packageurl", "uint32_cur_add_duration", "uint32_all_add_duration" }, new Object[] { localLong, localLong, localInteger, localInteger, localLong, "", localByteStringMicro1, localByteStringMicro2, localInteger, localInteger }, GiftMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4.GiftMsg
 * JD-Core Version:    0.7.0.1
 */