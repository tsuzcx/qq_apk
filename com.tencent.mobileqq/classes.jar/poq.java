import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;

public class poq
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  
  public poq()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static poq a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    poq localpoq = new poq();
    if (paramAnswerDetail.question_rowkey.has()) {
      localpoq.jdField_a_of_type_JavaLangString = paramAnswerDetail.question_rowkey.get();
    }
    if (paramAnswerDetail.question_title.has()) {
      localpoq.jdField_b_of_type_JavaLangString = paramAnswerDetail.question_title.get();
    }
    if (paramAnswerDetail.answer_content.has()) {
      localpoq.c = paramAnswerDetail.answer_content.get();
    }
    if (paramAnswerDetail.agreed_num.has()) {
      localpoq.jdField_a_of_type_Int = paramAnswerDetail.agreed_num.get();
    }
    if (paramAnswerDetail.card_style.has()) {
      localpoq.jdField_b_of_type_Int = paramAnswerDetail.card_style.get();
    }
    return localpoq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     poq
 * JD-Core Version:    0.7.0.1
 */