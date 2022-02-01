import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfoItem;

public class nam
{
  public String a;
  public String b;
  public String c;
  
  public nam a()
  {
    nam localnam = new nam();
    localnam.a(this);
    return localnam;
  }
  
  public void a(nam paramnam)
  {
    if (paramnam == null) {
      return;
    }
    this.a = paramnam.a;
    this.b = paramnam.b;
    this.c = paramnam.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nam
 * JD-Core Version:    0.7.0.1
 */