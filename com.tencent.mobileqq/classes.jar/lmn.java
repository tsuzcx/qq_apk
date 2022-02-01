import com.tencent.av.gaudio.AVNotifyCenter;
import java.util.Vector;

public class lmn
{
  public long a;
  public Vector<lmq> a;
  
  public lmn(AVNotifyCenter paramAVNotifyCenter)
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
 * Qualified Name:     lmn
 * JD-Core Version:    0.7.0.1
 */