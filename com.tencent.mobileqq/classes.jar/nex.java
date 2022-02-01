import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class nex
{
  public <VH extends new<?>> VH a(int paramInt, @NonNull ViewGroup paramViewGroup, @NonNull Class<VH> paramClass)
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[] { View.class });
      localConstructor.setAccessible(true);
      paramViewGroup = (new)localConstructor.newInstance(new Object[] { LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false) });
      return paramViewGroup;
    }
    catch (NoSuchMethodException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
      throw new RuntimeException(paramClass.getName() + " has no match constructor!");
    }
    catch (IllegalAccessException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
      return null;
    }
    catch (InstantiationException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nex
 * JD-Core Version:    0.7.0.1
 */