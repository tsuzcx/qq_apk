import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class syc
{
  public static SparseArray<Class<? extends wco>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, vcf.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, vcm.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static wco a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(ajya.a(2131713707));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (wco)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(ajya.a(2131713703), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(ajya.a(2131713706), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(ajya.a(2131713709), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(ajya.a(2131713705), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new vdh(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(ajya.a(2131713710), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(ajya.a(2131713704), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syc
 * JD-Core Version:    0.7.0.1
 */