import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class nog
{
  private final Map<String, nof> jdField_a_of_type_JavaUtilMap = new HashMap(3);
  private nof jdField_a_of_type_Nof;
  
  public nof a()
  {
    return this.jdField_a_of_type_Nof;
  }
  
  public nof a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      nof localnof = (nof)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject = localnof;
      if (localnof == null)
      {
        localnof = new nof(paramInt, paramString);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localnof);
        if (this.jdField_a_of_type_JavaUtilMap.size() != 1)
        {
          localObject = localnof;
          if (!paramBoolean) {}
        }
        else
        {
          a(paramString);
          localObject = localnof;
        }
      }
    }
    return localObject;
  }
  
  public nof a(String paramString)
  {
    nof localnof = null;
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
      localnof = (nof)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return localnof;
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (!paramString.a))
    {
      if (this.jdField_a_of_type_Nof != null) {
        this.jdField_a_of_type_Nof.a = false;
      }
      paramString.a = true;
      this.jdField_a_of_type_Nof = paramString;
    }
  }
  
  public nof b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      paramString = (nof)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if ((paramString != null) && (paramString == this.jdField_a_of_type_Nof))
      {
        this.jdField_a_of_type_Nof.a = false;
        this.jdField_a_of_type_Nof = null;
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nog
 * JD-Core Version:    0.7.0.1
 */