import com.tencent.avcore.jni.data.NetAddr;
import java.util.List;

public class lfu
{
  private static lfu a;
  public int a;
  public long a;
  public List<NetAddr> a;
  public int b;
  
  static
  {
    jdField_a_of_type_Lfu = new lfu();
  }
  
  public static lfu a()
  {
    return jdField_a_of_type_Lfu;
  }
  
  public String toString()
  {
    return "mChannelType[" + this.jdField_a_of_type_Int + "], mSessionId[" + this.jdField_a_of_type_Long + "], mTransType[" + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfu
 * JD-Core Version:    0.7.0.1
 */