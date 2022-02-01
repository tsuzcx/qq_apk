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

public abstract class ngf
  extends ngd
  implements nfi
{
  public ArrayList<Pair<Integer, String>> a;
  List<ngf> a;
  public nfu a;
  protected int b;
  public ArrayList<nfu> b;
  public nfu b;
  public int c;
  
  public ngf()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Nfu = new nfu();
    this.jdField_b_of_type_Nfu = new nfu();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_b_of_type_Nfu.jdField_a_of_type_JavaLangString;
  }
  
  public List<ngf> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public nfh a()
  {
    ngf localngf = a();
    try
    {
      localngf.a(this);
      return localngf;
    }
    catch (Exception localException) {}
    return localngf;
  }
  
  public nfu a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > paramInt) {
      return (nfu)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  protected abstract ngf a();
  
  protected void a(ngf paramngf)
  {
    this.jdField_a_of_type_Boolean = paramngf.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Int = paramngf.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = paramngf.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramngf.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramngf.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramngf.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_Nfu.a(paramngf.jdField_a_of_type_Nfu);
    this.jdField_b_of_type_Nfu.a(paramngf.jdField_b_of_type_Nfu);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramngf.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramngf.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilList.addAll(paramngf.jdField_a_of_type_JavaUtilList);
    this.c = paramngf.c;
  }
  
  protected void a(AvGameCommon.CommonQuestionInfo paramCommonQuestionInfo)
  {
    Object localObject1 = (AvGameCommon.QuestionItemInfo)paramCommonQuestionInfo.item.get();
    if (localObject1 != null)
    {
      this.jdField_a_of_type_Nfu.a(((AvGameCommon.QuestionItemInfo)localObject1).question_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_duration.get());
      this.jdField_b_of_type_Nfu.a(((AvGameCommon.QuestionItemInfo)localObject1).answer_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_duration.get());
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
        nfu localnfu = new nfu();
        localnfu.a((AvGameCommon.QuestionFeedbackInfo)localObject2);
        this.jdField_b_of_type_JavaUtilArrayList.add(localnfu);
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
        ngf localngf = a();
        localngf.a(localCommonQuestionInfo);
        localngf.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
        localngf.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localngf.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(localngf);
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      a((ngf)this.jdField_a_of_type_JavaUtilList.get(0));
    }
  }
  
  public boolean a(nfh paramnfh)
  {
    if (paramnfh == null) {}
    while ((!bhbx.a(b(), paramnfh.b())) || (!bhbx.a(a(), paramnfh.a()))) {
      return false;
    }
    return true;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Nfu.jdField_a_of_type_JavaLangString;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Nfu == null) {
      return 0;
    }
    return this.jdField_a_of_type_Nfu.jdField_a_of_type_Int;
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
      localStringBuilder.append("contentRes").append("=").append(this.jdField_a_of_type_Nfu).append("|");
      localStringBuilder.append("answerRes").append("=").append(this.jdField_b_of_type_Nfu).append("|");
      localStringBuilder.append("tips").append("=").append(nff.a(this.jdField_a_of_type_JavaUtilArrayList)).append("|");
      localStringBuilder.append("feedBacks").append("=").append(Arrays.toString(this.jdField_b_of_type_JavaUtilArrayList.toArray())).append("|");
    }
  }
  
  public int e_()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngf
 * JD-Core Version:    0.7.0.1
 */