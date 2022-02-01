import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfoItem;

public class myi
{
  public String a;
  public String b;
  public String c;
  
  public myi a()
  {
    myi localmyi = new myi();
    localmyi.a(this);
    return localmyi;
  }
  
  public void a(myi parammyi)
  {
    if (parammyi == null) {
      return;
    }
    this.a = parammyi.a;
    this.b = parammyi.b;
    this.c = parammyi.c;
  }
  
  public final void a(AvGameList.QuestionClassInfoItem paramQuestionClassInfoItem)
  {
    if (paramQuestionClassInfoItem == null) {
      return;
    }
    String str;
    if (paramQuestionClassInfoItem.question_class.has())
    {
      str = paramQuestionClassInfoItem.question_class.get();
      this.a = str;
      if (!paramQuestionClassInfoItem.question_class_name_url.has()) {
        break label81;
      }
      str = paramQuestionClassInfoItem.question_class_name_url.get();
      label46:
      this.b = str;
      if (!paramQuestionClassInfoItem.question_class_bg_url.has()) {
        break label87;
      }
    }
    label81:
    label87:
    for (paramQuestionClassInfoItem = paramQuestionClassInfoItem.question_class_bg_url.get();; paramQuestionClassInfoItem = "")
    {
      this.c = paramQuestionClassInfoItem;
      return;
      str = "";
      break;
      str = "";
      break label46;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name").append("=").append(this.a).append("|");
    localStringBuilder.append("nameImageUrl").append("=").append(this.b).append("|");
    localStringBuilder.append("backgroundImageUrl").append("=").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myi
 * JD-Core Version:    0.7.0.1
 */