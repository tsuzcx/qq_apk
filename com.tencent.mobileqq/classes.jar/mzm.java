import androidx.annotation.NonNull;
import java.util.List;
import javax.annotation.Nullable;

public abstract class mzm
  implements myp
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  String b = "";
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public String a()
  {
    return this.b;
  }
  
  public List<? extends myp> a()
  {
    return null;
  }
  
  public abstract myp a();
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(myp parammyp)
  {
    return (parammyp != null) && (parammyp.a() == a()) && (parammyp.b() == b());
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
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
    localStringBuilder.append("buff type").append("=").append(this.jdField_a_of_type_ArrayOfJavaLangString[0]).append("|");
    localStringBuilder.append("buff point").append("=").append(this.jdField_a_of_type_ArrayOfJavaLangString[1]).append("|");
    localStringBuilder.append("buff color").append("=").append(this.jdField_a_of_type_ArrayOfJavaLangString[2]).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzm
 * JD-Core Version:    0.7.0.1
 */