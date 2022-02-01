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

public class mym
  extends myl
{
  protected myl a()
  {
    return new mym();
  }
  
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    if (paramGameQuestionInfo.type.get() == 2)
    {
      if (paramGameQuestionInfo.picture.has())
      {
        Object localObject = (AvGameCommon.GuessPictureQuestionInfo)paramGameQuestionInfo.picture.get();
        if (paramGameQuestionInfo.id.has())
        {
          i = paramGameQuestionInfo.id.get();
          this.jdField_a_of_type_Int = i;
          myb localmyb = this.jdField_a_of_type_Myb;
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject).url.has()) {
            break label225;
          }
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject).url.get();
          label79:
          localmyb.a(paramGameQuestionInfo, null, 0);
          localmyb = this.b;
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject).answer.has()) {
            break label231;
          }
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject).answer.get();
          label111:
          localmyb.a(paramGameQuestionInfo, null, 0);
          if (!((AvGameCommon.GuessPictureQuestionInfo)localObject).size.has()) {
            break label237;
          }
        }
        label225:
        label231:
        label237:
        for (int i = ((AvGameCommon.GuessPictureQuestionInfo)localObject).size.get();; i = this.c)
        {
          this.c = i;
          paramGameQuestionInfo = ((AvGameCommon.GuessPictureQuestionInfo)localObject).tip_list.get();
          if (paramGameQuestionInfo == null) {
            return;
          }
          paramGameQuestionInfo = paramGameQuestionInfo.iterator();
          while (paramGameQuestionInfo.hasNext())
          {
            localObject = (AvGameCommon.GuessPictureTipsInfo)paramGameQuestionInfo.next();
            localObject = new Pair(Integer.valueOf(((AvGameCommon.GuessPictureTipsInfo)localObject).show_delay_ts.get()), ((AvGameCommon.GuessPictureTipsInfo)localObject).tips.get());
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          i = this.jdField_a_of_type_Int;
          break;
          paramGameQuestionInfo = "";
          break label79;
          paramGameQuestionInfo = "";
          break label111;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mym
 * JD-Core Version:    0.7.0.1
 */