package common.config.helper;

import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class QzoneConfigStringHelper
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 0, 0, 0, 0, 0, 63, 0, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 0, 0, 0, 0, 95, 0, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 0, 125, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public QzoneConfigStringHelper()
  {
    if ("com.tencent.mobileqq:qzone".equals(a()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(1024);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private String a()
  {
    if (MobileQQ.sMobileQQ != null) {
      return MobileQQ.sMobileQQ.getQQProcessName();
    }
    return null;
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      localObject = paramString.toCharArray();
      k = 0;
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int k;
        int i;
        int j;
        continue;
        i += 1;
      }
    }
    j = k;
    if (i < localObject.length)
    {
      localObject[i] = jdField_a_of_type_ArrayOfChar[localObject[i]];
      if (localObject[i] != 0) {
        break label84;
      }
      j = 1;
    }
    if (j != 0) {
      return paramString.toLowerCase();
    }
    localObject = new String((char[])localObject);
    return localObject;
    return paramString.toLowerCase();
  }
  
  public String a(String paramString)
  {
    Object localObject2 = null;
    if (paramString == null) {
      return null;
    }
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    Object localObject1 = localObject2;
    if (localConcurrentHashMap != null)
    {
      localObject1 = localObject2;
      if (localConcurrentHashMap.containsKey(paramString)) {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = b(paramString);
      localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      localObject2 = localObject1;
      if (localConcurrentHashMap != null)
      {
        localConcurrentHashMap.put(paramString, localObject1);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.config.helper.QzoneConfigStringHelper
 * JD-Core Version:    0.7.0.1
 */