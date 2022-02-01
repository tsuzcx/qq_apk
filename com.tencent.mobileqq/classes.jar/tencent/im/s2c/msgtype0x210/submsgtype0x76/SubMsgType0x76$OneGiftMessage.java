package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x76$OneGiftMessage
  extends MessageMicro<OneGiftMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField background_color = PBField.initString("");
  public final PBUInt32Field gift_id = PBField.initUInt32(0);
  public final PBStringField gift_name = PBField.initString("");
  public final PBStringField gift_url = PBField.initString("");
  public final PBUInt32Field play_cnt = PBField.initUInt32(0);
  public final PBUInt32Field price = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 58 }, new String[] { "gift_id", "gift_name", "type", "gift_url", "price", "play_cnt", "background_color" }, new Object[] { localInteger, "", localInteger, "", localInteger, localInteger, "" }, OneGiftMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneGiftMessage
 * JD-Core Version:    0.7.0.1
 */