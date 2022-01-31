import android.support.annotation.NonNull;

public class lrm
{
  public float a;
  public int a;
  public float b;
  public int b;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[apiLevel: ").append(this.jdField_a_of_type_Int).append(", cpuNum: ").append(this.jdField_b_of_type_Int).append(", maxFreqGHZ: ").append(this.jdField_a_of_type_Float).append(", ramSizeGB:").append(this.jdField_b_of_type_Float).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrm
 * JD-Core Version:    0.7.0.1
 */