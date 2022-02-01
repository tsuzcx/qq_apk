import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessPictureQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessPictureTipsInfo;

public class ngg
  extends ngf
{
  protected ngf a()
  {
    return new ngg();
  }
  
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    if (paramGameQuestionInfo.type.get() == 2)
    {
      if (paramGameQuestionInfo.picture.has())
      {
        Object localObject1 = (AvGameCommon.GuessPictureQuestionInfo)paramGameQuestionInfo.picture.get();
        this.jdField_b_of_type_Int = Math.max(0, paramGameQuestionInfo.index.get() - 1);
        int i;
        Object localObject2;
        if (paramGameQuestionInfo.id.has())
        {
          i = paramGameQuestionInfo.id.get();
          this.jdField_a_of_type_Int = i;
          localObject2 = this.jdField_a_of_type_Nfu;
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject1).url.has()) {
            break label329;
          }
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject1).url.get();
          label96:
          ((nfu)localObject2).a(paramGameQuestionInfo, null, 0);
          localObject2 = this.jdField_b_of_type_Nfu;
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject1).answer.has()) {
            break label335;
          }
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject1).answer.get();
          label128:
          ((nfu)localObject2).a(paramGameQuestionInfo, null, 0);
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject1).size.has()) {
            break label341;
          }
          i = ((AvGameCommon.GuessPictureQuestionInfo)localObject1).size.get();
          label154:
          this.c = i;
          localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject1).reward_type.has()) {
            break label349;
          }
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject1).reward_type.get();
          label183:
          localObject2[0] = paramGameQuestionInfo;
          localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject1).extra_reward.has()) {
            break label355;
          }
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject1).extra_reward.get();
          label212:
          localObject2[1] = paramGameQuestionInfo;
          localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject1).reward_stroke_color.has()) {
            break label361;
          }
        }
        label329:
        label335:
        label341:
        label349:
        label355:
        label361:
        for (paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject1).reward_stroke_color.get();; paramGameQuestionInfo = "")
        {
          localObject2[2] = paramGameQuestionInfo;
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject1).tip_list.get();
          if (paramGameQuestionInfo == null) {
            return;
          }
          paramGameQuestionInfo = paramGameQuestionInfo.iterator();
          while (paramGameQuestionInfo.hasNext())
          {
            localObject1 = (AvGameCommon.GuessPictureTipsInfo)paramGameQuestionInfo.next();
            localObject1 = new Pair(Integer.valueOf(((AvGameCommon.GuessPictureTipsInfo)localObject1).show_delay_ts.get()), ((AvGameCommon.GuessPictureTipsInfo)localObject1).tips.get());
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          }
          i = this.jdField_a_of_type_Int;
          break;
          paramGameQuestionInfo = "";
          break label96;
          paramGameQuestionInfo = "";
          break label128;
          i = this.c;
          break label154;
          paramGameQuestionInfo = "";
          break label183;
          paramGameQuestionInfo = "";
          break label212;
        }
      }
    }
    else {
      super.a(paramGameQuestionInfo);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngg
 * JD-Core Version:    0.7.0.1
 */