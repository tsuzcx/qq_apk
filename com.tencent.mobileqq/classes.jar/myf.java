import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;

public class myf
{
  public int a;
  public String a;
  public int b = 0;
  public int c = 120;
  public int d = 5;
  public int e = 15;
  public int f = 2;
  public int g = 0;
  public int h;
  
  public myf()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public myf a()
  {
    myf localmyf = new myf();
    try
    {
      localmyf.a(this);
      return localmyf;
    }
    catch (Exception localException) {}
    return localmyf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.d = 120;
    this.d = 5;
    this.e = 15;
    this.f = 2;
    this.g = 0;
    this.h = 0;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(myf parammyf)
  {
    if (parammyf == null) {
      return;
    }
    this.jdField_a_of_type_Int = parammyf.jdField_a_of_type_Int;
    this.b = parammyf.b;
    this.c = parammyf.c;
    this.d = parammyf.d;
    this.e = parammyf.e;
    this.f = parammyf.f;
    this.g = parammyf.g;
    this.h = parammyf.h;
    this.jdField_a_of_type_JavaLangString = parammyf.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(AvGameCommon.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramGameInfo.type.get();
    this.b = mxo.a(this.jdField_a_of_type_Int);
    this.c = paramGameInfo.game_duration.get();
    this.d = paramGameInfo.game_preptime.get();
    this.e = paramGameInfo.question_duration.get();
    this.f = paramGameInfo.question_interim.get();
    this.g = paramGameInfo.finish_type.get();
    this.h = paramGameInfo.finish_question_num.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typeSvr").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("typeLoc").append("=").append(this.b).append("|");
    localStringBuilder.append("gameDuration").append("=").append(this.c).append("|");
    localStringBuilder.append("gamePrepareDuration").append("=").append(this.d).append("|");
    localStringBuilder.append("topicDuration").append("=").append(this.e).append("|");
    localStringBuilder.append("topicInterim").append("=").append(this.f).append("|");
    localStringBuilder.append("finishType").append("=").append(this.g).append("|");
    localStringBuilder.append("finishTopicNum").append("=").append(this.h).append("|");
    localStringBuilder.append("questionClass").append("=").append(this.jdField_a_of_type_JavaLangString).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myf
 * JD-Core Version:    0.7.0.1
 */