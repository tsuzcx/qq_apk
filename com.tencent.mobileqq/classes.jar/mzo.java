import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import trpc.qq_vgame.common.AvGameCommon.CommonQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.QuestionFeedbackInfo;
import trpc.qq_vgame.common.AvGameCommon.QuestionItemInfo;
import trpc.qq_vgame.common.AvGameCommon.QuestionTipsInfo;

public abstract class mzo
  extends mzm
  implements myq
{
  public ArrayList<Pair<Integer, String>> a;
  List<mzo> a;
  public mzd a;
  protected int b;
  public ArrayList<mzd> b;
  public mzd b;
  public int c;
  
  public mzo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Mzd = new mzd();
    this.jdField_b_of_type_Mzd = new mzd();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_b_of_type_Mzd.jdField_a_of_type_JavaLangString;
  }
  
  public List<mzo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public myp a()
  {
    mzo localmzo = a();
    try
    {
      localmzo.a(this);
      return localmzo;
    }
    catch (Exception localException) {}
    return localmzo;
  }
  
  public mzd a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > paramInt) {
      return (mzd)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  protected abstract mzo a();
  
  protected void a(mzo parammzo)
  {
    this.jdField_a_of_type_Boolean = parammzo.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Int = parammzo.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = parammzo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = parammzo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parammzo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ArrayOfJavaLangString = parammzo.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_Mzd.a(parammzo.jdField_a_of_type_Mzd);
    this.jdField_b_of_type_Mzd.a(parammzo.jdField_b_of_type_Mzd);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(parammzo.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.addAll(parammzo.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilList.addAll(parammzo.jdField_a_of_type_JavaUtilList);
    this.c = parammzo.c;
  }
  
  protected void a(AvGameCommon.CommonQuestionInfo paramCommonQuestionInfo)
  {
    Object localObject1 = (AvGameCommon.QuestionItemInfo)paramCommonQuestionInfo.item.get();
    if (localObject1 != null)
    {
      this.jdField_a_of_type_Mzd.a(((AvGameCommon.QuestionItemInfo)localObject1).question_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_duration.get());
      this.jdField_b_of_type_Mzd.a(((AvGameCommon.QuestionItemInfo)localObject1).answer_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_duration.get());
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = ((AvGameCommon.QuestionItemInfo)localObject1).reward_type.get();
      this.jdField_a_of_type_ArrayOfJavaLangString[1] = ((AvGameCommon.QuestionItemInfo)localObject1).extra_reward.get();
      this.jdField_a_of_type_ArrayOfJavaLangString[2] = ((AvGameCommon.QuestionItemInfo)localObject1).reward_stroke_color.get();
    }
    localObject1 = paramCommonQuestionInfo.feedbacks.get();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AvGameCommon.QuestionFeedbackInfo)((Iterator)localObject1).next();
        mzd localmzd = new mzd();
        localmzd.a((AvGameCommon.QuestionFeedbackInfo)localObject2);
        this.jdField_b_of_type_JavaUtilArrayList.add(localmzd);
      }
    }
    localObject1 = paramCommonQuestionInfo.tips.get();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AvGameCommon.QuestionTipsInfo)((Iterator)localObject1).next();
        localObject2 = new Pair(Integer.valueOf(((AvGameCommon.QuestionTipsInfo)localObject2).show_delay_ts.get()), ((AvGameCommon.QuestionTipsInfo)localObject2).tips.get());
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    this.c = paramCommonQuestionInfo.size.get();
  }
  
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    this.jdField_a_of_type_Int = paramGameQuestionInfo.id.get();
    this.jdField_b_of_type_Int = Math.max(0, paramGameQuestionInfo.index.get() - 1);
    if (paramGameQuestionInfo.questions.get() != null)
    {
      paramGameQuestionInfo = paramGameQuestionInfo.questions.get().iterator();
      while (paramGameQuestionInfo.hasNext())
      {
        AvGameCommon.CommonQuestionInfo localCommonQuestionInfo = (AvGameCommon.CommonQuestionInfo)paramGameQuestionInfo.next();
        mzo localmzo = a();
        localmzo.a(localCommonQuestionInfo);
        localmzo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
        localmzo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localmzo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(localmzo);
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      a((mzo)this.jdField_a_of_type_JavaUtilList.get(0));
    }
  }
  
  public boolean a(myp parammyp)
  {
    if (parammyp == null) {}
    while ((!bhjx.a(b(), parammyp.b())) || (!bhjx.a(a(), parammyp.a()))) {
      return false;
    }
    return true;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Mzd.jdField_a_of_type_JavaLangString;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Mzd == null) {
      return 0;
    }
    return this.jdField_a_of_type_Mzd.jdField_a_of_type_Int;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (this.jdField_a_of_type_Boolean)
    {
      localStringBuilder.append("\n【题库】:");
      localStringBuilder.append("topicsCount").append("=").append(this.jdField_a_of_type_JavaUtilList.size()).append("|");
      localStringBuilder.append("【题目列表】").append("=").append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray())).append("|");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("\n【题目】:");
      localStringBuilder.append("id").append("=").append(this.jdField_a_of_type_Int).append("|");
      localStringBuilder.append("gameType").append("=").append(b()).append("|");
      localStringBuilder.append("index").append("=").append(this.jdField_b_of_type_Int).append("|");
      localStringBuilder.append("contentRes").append("=").append(this.jdField_a_of_type_Mzd).append("|");
      localStringBuilder.append("answerRes").append("=").append(this.jdField_b_of_type_Mzd).append("|");
      localStringBuilder.append("tips").append("=").append(myn.a(this.jdField_a_of_type_JavaUtilArrayList)).append("|");
      localStringBuilder.append("feedBacks").append("=").append(Arrays.toString(this.jdField_b_of_type_JavaUtilArrayList.toArray())).append("|");
    }
  }
  
  public int g_()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzo
 * JD-Core Version:    0.7.0.1
 */