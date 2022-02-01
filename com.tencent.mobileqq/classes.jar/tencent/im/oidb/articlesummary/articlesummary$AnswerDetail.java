package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$AnswerDetail
  extends MessageMicro<AnswerDetail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field agreed_num = PBField.initUInt32(0);
  public final PBStringField answer_content = PBField.initString("");
  public final PBUInt32Field card_style = PBField.initUInt32(0);
  public final PBStringField question_rowkey = PBField.initString("");
  public final PBStringField question_title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "question_rowkey", "question_title", "answer_content", "agreed_num", "card_style" }, new Object[] { "", "", "", localInteger, localInteger }, AnswerDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.AnswerDetail
 * JD-Core Version:    0.7.0.1
 */