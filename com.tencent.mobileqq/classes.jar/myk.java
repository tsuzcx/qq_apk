import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessActionQuestionInfo;

public class myk
  extends myj
{
  public mxq a()
  {
    myk localmyk = new myk();
    try
    {
      localmyk.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localmyk.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localmyk.b = this.b;
      localmyk.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      return localmyk;
    }
    catch (Exception localException) {}
    return localmyk;
  }
  
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    AvGameCommon.GuessActionQuestionInfo localGuessActionQuestionInfo = (AvGameCommon.GuessActionQuestionInfo)paramGameQuestionInfo.topic.get();
    this.jdField_a_of_type_Int = paramGameQuestionInfo.id.get();
    this.jdField_a_of_type_JavaLangString = localGuessActionQuestionInfo.question.get();
    this.b = localGuessActionQuestionInfo.answer.get();
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myk
 * JD-Core Version:    0.7.0.1
 */