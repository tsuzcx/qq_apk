import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class skt
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
    return slg.a(paramClass, paramVarArgs);
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
  
  public static <T extends Activity> slc<T> a(Class<? extends slc<T>> paramClass, Class<slc<T>> paramClass1, Object... paramVarArgs)
  {
    return (slc)slg.a(paramClass, paramClass1, paramVarArgs);
  }
  
  public static vpv a(Context paramContext, int paramInt)
  {
    return slj.a(paramContext, paramInt);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    slm.a(paramContext, paramInt, paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    slm.a(paramContext, paramInt, paramString);
  }
  
  public static void a(Object paramObject)
  {
    slk.a(paramObject);
  }
  
  public static boolean a()
  {
    return sll.a();
  }
  
  public static String[] a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getStringArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     skt
 * JD-Core Version:    0.7.0.1
 */