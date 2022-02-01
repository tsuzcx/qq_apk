import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;

public class mzi
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
  
  public mzi()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public mzi a()
  {
    mzi localmzi = new mzi();
    try
    {
      localmzi.a(this);
      return localmzi;
    }
    catch (Exception localException) {}
    return localmzi;
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
  
  public void a(mzi parammzi)
  {
    if (parammzi == null) {
      return;
    }
    this.jdField_a_of_type_Int = parammzi.jdField_a_of_type_Int;
    this.b = parammzi.b;
    this.c = parammzi.c;
    this.d = parammzi.d;
    this.e = parammzi.e;
    this.f = parammzi.f;
    this.g = parammzi.g;
    this.h = parammzi.h;
    this.jdField_a_of_type_JavaLangString = parammzi.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(AvGameCommon.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramGameInfo.type.get();
    this.b = myn.a(this.jdField_a_of_type_Int);
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
 * Qualified Name:     mzi
 * JD-Core Version:    0.7.0.1
 */