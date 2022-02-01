package tencent.im.s2c.msgtype0x210.submsgtype0xe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xe4$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_display_distance = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public submsgtype0xe4.GiftMsg msg_gift = new submsgtype0xe4.GiftMsg();
  public submsgtype0xe4.LikeMsg msg_like = new submsgtype0xe4.LikeMsg();
  public submsgtype0xe4.Player msg_match_player = new submsgtype0xe4.Player();
  public submsgtype0xe4.Room msg_room = new submsgtype0xe4.Room();
  public final PBStringField str_hint = PBField.initString("");
  public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_countdown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 48, 56, 66, 74, 82, 90 }, new String[] { "msg_match_player", "uint32_distance", "str_hint", "uint32_countdown", "bytes_key", "uint32_type", "uint32_call_type", "bytes_display_distance", "msg_like", "msg_gift", "msg_room" }, new Object[] { null, localInteger, "", localInteger, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, null, null, null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4.MsgBody
 * JD-Core Version:    0.7.0.1
 */