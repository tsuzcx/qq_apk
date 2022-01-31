import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

public class pqp
{
  public int a;
  public long a;
  public Set<String> a;
  public Set<String> b = new HashSet();
  
  public pqp()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  @NonNull
  public String toString()
  {
    return "time:" + this.jdField_a_of_type_Long + "effectTime:" + this.jdField_a_of_type_Int + "  " + this.jdField_a_of_type_JavaUtilSet + "  " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqp
 * JD-Core Version:    0.7.0.1
 */