import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessActionQuestionInfo;

public class mzn
  extends mzm
{
  public myp a()
  {
    mzn localmzn = new mzn();
    try
    {
      localmzn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localmzn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localmzn.b = this.b;
      localmzn.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localmzn.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      return localmzn;
    }
    catch (Exception localException) {}
    return localmzn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzn
 * JD-Core Version:    0.7.0.1
 */