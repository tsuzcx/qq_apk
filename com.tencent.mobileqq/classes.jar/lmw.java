import com.tencent.av.gaudio.AVNotifyCenter;
import java.util.Vector;

public class lmw
{
  public long a;
  public Vector<lmz> a;
  
  public lmw(AVNotifyCenter paramAVNotifyCenter)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilVector = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("roomNum[").append(this.jdField_a_of_type_Long).append("], list[");
    if (this.jdField_a_of_type_JavaUtilVector == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size())) {
      return localObject + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     lmw
 * JD-Core Version:    0.7.0.1
 */