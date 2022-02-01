import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class lbo
{
  public int a;
  public long a;
  public String a;
  public ArrayList<Integer> a;
  public HashMap<String, lbn> a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("TestInfo{");
    localStringBuffer.append("taskId='").append(this.jdField_a_of_type_Int).append('\'');
    localStringBuffer.append(", codec=").append(this.b);
    localStringBuffer.append(", min_sdk=").append(this.c);
    localStringBuffer.append(", async_min_sdk=").append(this.d);
    localStringBuffer.append(", min_version=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append(", test_ver=").append(this.e);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      localStringBuffer.append(", disable_sdks=").append(Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (lbn)((Map.Entry)localObject).getValue();
        localStringBuffer.append(", codecKey=").append(str);
        localStringBuffer.append(", codecValue=").append(localObject);
      }
    }
    localStringBuffer.append(", upload = ").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", expdate = ").append(this.jdField_a_of_type_Long);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbo
 * JD-Core Version:    0.7.0.1
 */