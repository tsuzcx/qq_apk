import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.QuestionFeedbackInfo;

public class nae
{
  public int a;
  public String a;
  public String b = "";
  
  public nae()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(nae paramnae)
  {
    this.jdField_a_of_type_JavaLangString = paramnae.jdField_a_of_type_JavaLangString;
    this.b = paramnae.b;
    this.jdField_a_of_type_Int = paramnae.jdField_a_of_type_Int;
  }
  
  public void a(AvGameCommon.QuestionFeedbackInfo paramQuestionFeedbackInfo)
  {
    if (paramQuestionFeedbackInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramQuestionFeedbackInfo.content.get();
    this.jdField_a_of_type_Int = paramQuestionFeedbackInfo.duration.get();
    this.b = paramQuestionFeedbackInfo.content_md5.get();
  }
  
  public String b()
  {
    return this.b;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.b).append(",").append(this.jdField_a_of_type_Int).append("s").append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nae
 * JD-Core Version:    0.7.0.1
 */