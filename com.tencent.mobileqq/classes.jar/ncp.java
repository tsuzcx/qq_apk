import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ncp
{
  private char jdField_a_of_type_Char = '\r';
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private char b = '\t';
  
  public ncp()
  {
    this.jdField_a_of_type_Char = '\r';
    this.b = '\t';
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public ncp(char paramChar1, char paramChar2)
  {
    this.jdField_a_of_type_Char = paramChar1;
    this.b = paramChar2;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public int a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public int a(String paramString, int paramInt)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    int i = paramInt;
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      ncl.a("GlStringParser", "getInt, key[" + paramString + "], value[" + str + "], def[" + paramInt + "]", localException);
    }
    return paramInt;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append(this.jdField_a_of_type_Char);
      localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilMap.get(str));
      localStringBuilder.append(this.b);
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilMap.clear();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      paramString = new StringTokenizer(paramString, ((StringBuilder)localObject).toString());
      while (paramString.hasMoreElements())
      {
        String str = paramString.nextToken();
        int i = str.indexOf(this.jdField_a_of_type_Char);
        if (i != -1)
        {
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          this.jdField_a_of_type_JavaUtilMap.put(localObject, str);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.toString(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.indexOf(this.b) != -1) || (paramString1.indexOf(this.jdField_a_of_type_Char) != -1)) {}
    while ((paramString2 == null) || (paramString2.indexOf(this.jdField_a_of_type_Char) != -1) || (paramString2.indexOf(this.b) != -1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncp
 * JD-Core Version:    0.7.0.1
 */