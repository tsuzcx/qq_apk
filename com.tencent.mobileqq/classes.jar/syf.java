import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class syf
{
  public static SparseArray<Class<? extends wcr>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, vci.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, vcp.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static wcr a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(ajyc.a(2131713696));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (wcr)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(ajyc.a(2131713692), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(ajyc.a(2131713695), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(ajyc.a(2131713698), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(ajyc.a(2131713694), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new vdk(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(ajyc.a(2131713699), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(ajyc.a(2131713693), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syf
 * JD-Core Version:    0.7.0.1
 */