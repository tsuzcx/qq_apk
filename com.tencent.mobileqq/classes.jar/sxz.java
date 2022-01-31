import java.util.concurrent.ConcurrentHashMap;

public class sxz
{
  public static ConcurrentHashMap<Class<?>, Class<?>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static
  {
    a.put(uju.class, sxw.class);
    b.put(tco.class, sxx.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(uju.class))
      {
        Object localObject = paramClass1.cast(new sxw());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ved.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)a.get(paramClass);
        if (paramClass != null)
        {
          if (sxl.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        ved.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return sya.a(paramClass1);
    }
    label110:
    paramClass = sya.a(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (!sxl.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass != null)
      {
        if (sxl.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      ved.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return sya.a(paramClass, paramVarArgs);
    label124:
    Object localObject = sya.a(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxz
 * JD-Core Version:    0.7.0.1
 */