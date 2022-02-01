import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class nho
{
  private final Map<String, nhn> jdField_a_of_type_JavaUtilMap = new HashMap(3);
  private nhn jdField_a_of_type_Nhn;
  
  public nhn a()
  {
    return this.jdField_a_of_type_Nhn;
  }
  
  public nhn a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      nhn localnhn = (nhn)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject = localnhn;
      if (localnhn == null)
      {
        localnhn = new nhn(paramInt, paramString);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localnhn);
        if (this.jdField_a_of_type_JavaUtilMap.size() != 1)
        {
          localObject = localnhn;
          if (!paramBoolean) {}
        }
        else
        {
          a(paramString);
          localObject = localnhn;
        }
      }
    }
    return localObject;
  }
  
  public nhn a(String paramString)
  {
    nhn localnhn = null;
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
      localnhn = (nhn)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return localnhn;
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (!paramString.a))
    {
      if (this.jdField_a_of_type_Nhn != null) {
        this.jdField_a_of_type_Nhn.a = false;
      }
      paramString.a = true;
      this.jdField_a_of_type_Nhn = paramString;
    }
  }
  
  public nhn b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      paramString = (nhn)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if ((paramString != null) && (paramString == this.jdField_a_of_type_Nhn))
      {
        this.jdField_a_of_type_Nhn.a = false;
        this.jdField_a_of_type_Nhn = null;
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nho
 * JD-Core Version:    0.7.0.1
 */