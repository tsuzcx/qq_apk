import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessActionQuestionInfo;

public class nge
  extends ngd
{
  public nfh a()
  {
    nge localnge = new nge();
    try
    {
      localnge.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localnge.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localnge.b = this.b;
      localnge.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localnge.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      return localnge;
    }
    catch (Exception localException) {}
    return localnge;
  }
  
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    AvGameCommon.GuessActionQuestionInfo localGuessActionQuestionInfo = (AvGameCommon.GuessActionQuestionInfo)paramGameQuestionInfo.topic.get();
    this.jdField_a_of_type_Int = paramGameQuestionInfo.id.get();
    this.jdField_a_of_type_JavaLangString = localGuessActionQuestionInfo.question.get();
    this.b = localGuessActionQuestionInfo.answer.get();
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = localGuessActionQuestionInfo.reward_type.get();
    this.jdField_a_of_type_ArrayOfJavaLangString[1] = localGuessActionQuestionInfo.extra_reward.get();
    this.jdField_a_of_type_ArrayOfJavaLangString[2] = localGuessActionQuestionInfo.reward_stroke_color.get();
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nge
 * JD-Core Version:    0.7.0.1
 */