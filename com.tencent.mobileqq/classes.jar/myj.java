import androidx.annotation.NonNull;
import java.util.List;
import javax.annotation.Nullable;

public abstract class myj
  implements mxq
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  String b = "";
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public String a()
  {
    return this.b;
  }
  
  public List<? extends mxq> a()
  {
    return null;
  }
  
  public abstract mxq a();
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(mxq parammxq)
  {
    return (parammxq != null) && (parammxq.a() == a()) && (parammxq.b() == b());
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int c()
  {
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("isTopicBank").append("=").append(this.jdField_a_of_type_Boolean).append("|");
    localStringBuilder.append("gameType").append("=").append(b()).append("|");
    localStringBuilder.append("content").append("=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("answer").append("=").append(this.b).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myj
 * JD-Core Version:    0.7.0.1
 */