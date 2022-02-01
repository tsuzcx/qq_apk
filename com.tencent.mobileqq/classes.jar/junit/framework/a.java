package junit.framework;

@Deprecated
public class a
{
  public static void a(int paramInt1, int paramInt2)
  {
    a(null, paramInt1, paramInt2);
  }
  
  public static void a(Object paramObject)
  {
    a(null, paramObject);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      throw new RuntimeException(paramString);
    }
    throw new RuntimeException(paramString);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public static void a(String paramString, Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramString, bool);
  }
  
  public static void a(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return;
    }
    if ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return;
    }
    b(paramString, paramObject1, paramObject2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(null, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 == null) && (paramString3 == null)) {
      return;
    }
    if ((paramString2 != null) && (paramString2.equals(paramString3))) {
      return;
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    throw new RuntimeException(paramString2);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  public static void b(String paramString, Object paramObject1, Object paramObject2)
  {
    a(c(paramString, paramObject1, paramObject2));
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean ^ true);
  }
  
  public static void b(boolean paramBoolean)
  {
    b(null, paramBoolean);
  }
  
  public static String c(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("expected:<");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("> but was:<");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.framework.a
 * JD-Core Version:    0.7.0.1
 */