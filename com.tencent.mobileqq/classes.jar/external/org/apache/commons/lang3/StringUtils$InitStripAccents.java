package external.org.apache.commons.lang3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

class StringUtils$InitStripAccents
{
  private static final Throwable java6Exception;
  private static final Method java6NormalizeMethod;
  private static final Object java6NormalizerFormNFD;
  private static final Pattern java6Pattern = sunPattern;
  private static final Method sunDecomposeMethod;
  private static final Throwable sunException;
  private static final Pattern sunPattern;
  
  static
  {
    Object localObject5 = null;
    sunPattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    for (;;)
    {
      try
      {
        localObject3 = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer$Form");
        Object localObject1 = ((Class)localObject3).getField("NFD").get(null);
        try
        {
          Method localMethod2 = Thread.currentThread().getContextClassLoader().loadClass("sun.text.Normalizer").getMethod("decompose", new Class[] { String.class, Boolean.TYPE, Integer.TYPE });
          localObject4 = localObject3;
          localMethod1 = null;
          localObject3 = localMethod2;
        }
        catch (Exception localException3)
        {
          Object localObject4 = localObject3;
          Method localMethod1 = null;
          localObject3 = null;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localMethod1 = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer").getMethod("normalize", new Class[] { CharSequence.class, localObject3 });
          localMethod2 = null;
          localObject3 = null;
          localObject4 = localObject1;
          localObject1 = localMethod2;
          java6Exception = localObject1;
          java6NormalizerFormNFD = localObject4;
          java6NormalizeMethod = localMethod1;
          sunException = localObject5;
          sunDecomposeMethod = (Method)localObject3;
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject3 = localException1;
            Object localObject2 = localException2;
          }
        }
        localException1 = localException1;
        localObject3 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.StringUtils.InitStripAccents
 * JD-Core Version:    0.7.0.1
 */