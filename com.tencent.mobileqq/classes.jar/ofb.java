import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ofb
{
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<ofc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private HashMap<String, String> b = new HashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String a(int paramInt, String paramString)
  {
    String str2 = "";
    ofc localofc = a(paramInt);
    String str1 = str2;
    if (localofc != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (!"style_ID".equalsIgnoreCase(paramString)) {
          break label46;
        }
        str1 = localofc.jdField_a_of_type_JavaLangString;
      }
    }
    return str1;
    label46:
    return (String)localofc.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public ofc a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (ofc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public String b(String paramString)
  {
    return (String)this.b.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofb
 * JD-Core Version:    0.7.0.1
 */