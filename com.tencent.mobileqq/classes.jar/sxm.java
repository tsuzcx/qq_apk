import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class sxm
{
  public static int a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getInteger(paramInt);
  }
  
  public static Boolean a(int paramInt)
  {
    return Boolean.valueOf(BaseApplicationImpl.getApplication().getResources().getBoolean(paramInt));
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    return sxz.a(paramClass, paramVarArgs);
  }
  
  public static String a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt);
  }
  
  public static String a(int paramInt, Object... paramVarArgs)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt, paramVarArgs);
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static <T extends Activity> sxv<T> a(Class<? extends sxv<T>> paramClass, Class<sxv<T>> paramClass1, Object... paramVarArgs)
  {
    return (sxv)sxz.a(paramClass, paramClass1, paramVarArgs);
  }
  
  public static wco a(Context paramContext, int paramInt)
  {
    return syc.a(paramContext, paramInt);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    syf.a(paramContext, paramInt, paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    syf.a(paramContext, paramInt, paramString);
  }
  
  public static void a(Object paramObject)
  {
    syd.a(paramObject);
  }
  
  public static boolean a()
  {
    return sye.a();
  }
  
  public static String[] a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getStringArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxm
 * JD-Core Version:    0.7.0.1
 */