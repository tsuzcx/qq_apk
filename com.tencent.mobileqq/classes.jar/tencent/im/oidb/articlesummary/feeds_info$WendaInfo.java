package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$WendaInfo
  extends MessageMicro<WendaInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_answer_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_question_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_question_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_question_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wenda_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField super_wenda_button_title = PBField.initString("");
  public final PBUInt32Field uint32_answer_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_super_wenda = PBField.initUInt32(0);
  public final PBUInt32Field uint32_question_status = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 66, 72, 82, 186 }, new String[] { "uint32_is_super_wenda", "bytes_question_rowkey", "bytes_question_desc", "bytes_question_pic_url", "bytes_wenda_url", "uint32_follow_count", "uint32_answer_count", "bytes_icon_url", "uint32_question_status", "bytes_answer_url", "super_wenda_button_title" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, "" }, WendaInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.WendaInfo
 * JD-Core Version:    0.7.0.1
 */