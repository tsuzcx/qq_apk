import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;

public class qaj
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  
  public qaj()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static qaj a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    qaj localqaj = new qaj();
    if (paramAnswerDetail.question_rowkey.has()) {
      localqaj.jdField_a_of_type_JavaLangString = paramAnswerDetail.question_rowkey.get();
    }
    if (paramAnswerDetail.question_title.has()) {
      localqaj.jdField_b_of_type_JavaLangString = paramAnswerDetail.question_title.get();
    }
    if (paramAnswerDetail.answer_content.has()) {
      localqaj.c = paramAnswerDetail.answer_content.get();
    }
    if (paramAnswerDetail.agreed_num.has()) {
      localqaj.jdField_a_of_type_Int = paramAnswerDetail.agreed_num.get();
    }
    if (paramAnswerDetail.card_style.has()) {
      localqaj.jdField_b_of_type_Int = paramAnswerDetail.card_style.get();
    }
    return localqaj;
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
 * Qualified Name:     qaj
 * JD-Core Version:    0.7.0.1
 */