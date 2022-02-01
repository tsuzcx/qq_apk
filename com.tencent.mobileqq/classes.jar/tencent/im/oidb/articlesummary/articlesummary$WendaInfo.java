package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$WendaInfo
  extends MessageMicro<WendaInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public articlesummary.AnswerDetail answer_detail = new articlesummary.AnswerDetail();
  public final PBStringField author_nick = PBField.initString("");
  public final PBBytesField bytes_answer_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_question_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_question_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_question_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wenda_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field channel_id = PBField.initUInt32(0);
  public final PBStringField channel_id_name = PBField.initString("");
  public final PBUInt32Field channel_second_id = PBField.initUInt32(0);
  public final PBStringField channel_second_id_name = PBField.initString("");
  public final PBStringField icon_color = PBField.initString("");
  public final PBStringField icon_name = PBField.initString("");
  public final PBRepeatField<String> images_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField super_wenda_button_title = PBField.initString("");
  public final PBRepeatField<Integer> tag_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<String> tag_id_name = PBField.initRepeat(PBStringField.__repeatHelper__);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 66, 72, 82, 88, 98, 104, 114, 120, 130, 138, 146, 154, 162, 170, 178, 186 }, new String[] { "uint32_is_super_wenda", "bytes_question_rowkey", "bytes_question_desc", "bytes_question_pic_url", "bytes_wenda_url", "uint32_follow_count", "uint32_answer_count", "bytes_icon_url", "uint32_question_status", "bytes_answer_url", "channel_id", "channel_id_name", "channel_second_id", "channel_second_id_name", "tag_id", "tag_id_name", "author_nick", "jump_url", "images_url", "icon_name", "icon_color", "answer_detail", "super_wenda_button_title" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", "", "", "", null, "" }, WendaInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.WendaInfo
 * JD-Core Version:    0.7.0.1
 */