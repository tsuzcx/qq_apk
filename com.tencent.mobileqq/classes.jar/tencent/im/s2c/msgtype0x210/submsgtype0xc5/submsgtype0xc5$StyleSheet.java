package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xc5$StyleSheet
  extends MessageMicro<StyleSheet>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_orange_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField folder_red_type = PBField.initEnum(0);
  public submsgtype0xc5.BiuBody msg_biu_body = new submsgtype0xc5.BiuBody();
  public submsgtype0xc5.TipsBody msg_tip_body = new submsgtype0xc5.TipsBody();
  public final PBEnumField msg_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_is_low = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_folder = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_lock_screen = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 72 }, new String[] { "uint32_show_folder", "folder_red_type", "bytes_orange_word", "bytes_summary", "msg_tip_body", "uint32_show_lock_screen", "msg_type", "msg_biu_body", "uint32_is_low" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, null, localInteger, localInteger, null, localInteger }, StyleSheet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet
 * JD-Core Version:    0.7.0.1
 */