package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$DeliverGiftMsg
  extends MessageMicro<DeliverGiftMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_animation_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_animation_package_url_a = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_animation_package_url_i = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comefrom_link = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gray_tip_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_receiver_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_receiver_pic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remind_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stmessage_comefrom = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stmessage_gifturl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stmessage_message = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stmessage_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stmessage_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_to_all_gift_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_animation_package_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gift_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_stmessage_exflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_stmessage_giftpicid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 56, 66, 72, 80, 90, 98, 106, 112, 122, 128, 138, 146, 154, 162, 170, 178 }, new String[] { "bytes_gray_tip_content", "uint32_animation_package_id", "bytes_animation_package_url_a", "bytes_animation_package_url_i", "bytes_remind_brief", "uint32_gift_id", "uint32_gift_count", "bytes_animation_brief", "uint64_sender_uin", "uint64_receiver_uin", "bytes_stmessage_title", "bytes_stmessage_subtitle", "bytes_stmessage_message", "uint32_stmessage_giftpicid", "bytes_stmessage_comefrom", "uint32_stmessage_exflag", "bytes_to_all_gift_id", "bytes_comefrom_link", "bytes_pb_reserve", "bytes_receiver_name", "bytes_receiver_pic", "bytes_stmessage_gifturl" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15 }, DeliverGiftMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.DeliverGiftMsg
 * JD-Core Version:    0.7.0.1
 */