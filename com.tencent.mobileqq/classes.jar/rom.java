import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;

public class rom
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  
  public rom()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static rom a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    rom localrom = new rom();
    if (paramAnswerDetail.question_rowkey.has()) {
      localrom.jdField_a_of_type_JavaLangString = paramAnswerDetail.question_rowkey.get();
    }
    if (paramAnswerDetail.question_title.has()) {
      localrom.jdField_b_of_type_JavaLangString = paramAnswerDetail.question_title.get();
    }
    if (paramAnswerDetail.answer_content.has()) {
      localrom.c = paramAnswerDetail.answer_content.get();
    }
    if (paramAnswerDetail.agreed_num.has()) {
      localrom.jdField_a_of_type_Int = paramAnswerDetail.agreed_num.get();
    }
    if (paramAnswerDetail.card_style.has()) {
      localrom.jdField_b_of_type_Int = paramAnswerDetail.card_style.get();
    }
    return localrom;
  }
  
  public articlesummary.AnswerDetail a()
  {
    articlesummary.AnswerDetail localAnswerDetail = new articlesummary.AnswerDetail();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localAnswerDetail.question_rowkey.set(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localAnswerDetail.question_title.set(this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localAnswerDetail.answer_content.set(this.c);
    }
    localAnswerDetail.agreed_num.set(this.jdField_a_of_type_Int);
    localAnswerDetail.card_style.set(this.jdField_b_of_type_Int);
    return localAnswerDetail;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rom
 * JD-Core Version:    0.7.0.1
 */