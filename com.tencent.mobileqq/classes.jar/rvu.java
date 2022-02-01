import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class rvu
{
  public int a;
  public ArrayList<Integer> a;
  public boolean a;
  
  private String a(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayList.size() * 2);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Integer localInteger = (Integer)paramArrayList.next();
      if (localInteger != null) {
        localStringBuilder.append(localInteger);
      }
      if (paramArrayList.hasNext()) {
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_sceneType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_indexList", a(this.jdField_a_of_type_JavaUtilArrayList));
    localHashMap.put("param_isAutoPlay", String.valueOf(this.jdField_a_of_type_Boolean));
    return localHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.isEmpty();
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("mSceneType: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mIsAutoPlay: ").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mIndexList: ").append(a(this.jdField_a_of_type_JavaUtilArrayList));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvu
 * JD-Core Version:    0.7.0.1
 */