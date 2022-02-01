import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfo;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfoItem;

public class mzk
{
  public int a;
  public ArrayList<mzl> a;
  
  public mzk()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public mzk a()
  {
    mzk localmzk = new mzk();
    localmzk.a(this);
    return localmzk;
  }
  
  public void a(mzk parammzk)
  {
    if (parammzk == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = parammzk.jdField_a_of_type_Int;
    } while (parammzk.jdField_a_of_type_JavaUtilArrayList == null);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(parammzk.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public final void a(AvGameList.QuestionClassInfo paramQuestionClassInfo)
  {
    int j = 0;
    if (paramQuestionClassInfo == null) {
      return;
    }
    if (paramQuestionClassInfo.game_type.has()) {}
    for (int i = paramQuestionClassInfo.game_type.get();; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      paramQuestionClassInfo = paramQuestionClassInfo.question_class_list.get();
      if ((paramQuestionClassInfo == null) || (paramQuestionClassInfo.size() == 0)) {
        break;
      }
      i = j;
      while (i < paramQuestionClassInfo.size())
      {
        AvGameList.QuestionClassInfoItem localQuestionClassInfoItem = (AvGameList.QuestionClassInfoItem)paramQuestionClassInfo.get(i);
        mzl localmzl = new mzl();
        localmzl.a(localQuestionClassInfoItem);
        this.jdField_a_of_type_JavaUtilArrayList.add(localmzl);
        i += 1;
      }
      break;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typeSvr").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("questionClassListSize").append("=").append(this.jdField_a_of_type_JavaUtilArrayList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzk
 * JD-Core Version:    0.7.0.1
 */