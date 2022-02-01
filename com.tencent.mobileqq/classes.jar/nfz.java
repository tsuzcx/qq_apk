import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;

public class nfz
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
  
  public nfz()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public nfz a()
  {
    nfz localnfz = new nfz();
    try
    {
      localnfz.a(this);
      return localnfz;
    }
    catch (Exception localException) {}
    return localnfz;
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
  
  public void a(nfz paramnfz)
  {
    if (paramnfz == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramnfz.jdField_a_of_type_Int;
    this.b = paramnfz.b;
    this.c = paramnfz.c;
    this.d = paramnfz.d;
    this.e = paramnfz.e;
    this.f = paramnfz.f;
    this.g = paramnfz.g;
    this.h = paramnfz.h;
    this.jdField_a_of_type_JavaLangString = paramnfz.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(AvGameCommon.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramGameInfo.type.get();
    this.b = nff.a(this.jdField_a_of_type_Int);
    this.c = paramGameInfo.game_duration.get();
    this.d = paramGameInfo.game_preptime.get();
    this.e = paramGameInfo.question_duration.get();
    this.f = paramGameInfo.question_interim.get();
    this.g = paramGameInfo.finish_type.get();
    this.h = paramGameInfo.finish_question_num.get();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(getClass().getName(), 2, "finishType = " + this.g);
    }
    return this.g == 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfz
 * JD-Core Version:    0.7.0.1
 */