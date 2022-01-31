import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class slj
{
  public static SparseArray<Class<? extends vpv>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, upm.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, upt.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static vpv a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(ajjy.a(2131647909));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (vpv)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(ajjy.a(2131647905), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(ajjy.a(2131647908), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(ajjy.a(2131647911), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(ajjy.a(2131647907), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new uqo(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(ajjy.a(2131647912), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(ajjy.a(2131647906), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     slj
 * JD-Core Version:    0.7.0.1
 */