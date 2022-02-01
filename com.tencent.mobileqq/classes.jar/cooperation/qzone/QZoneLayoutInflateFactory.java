package cooperation.qzone;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

public class QZoneLayoutInflateFactory
  implements LayoutInflater.Factory
{
  private static final ClassLoader BOOT_CLASS_LOADER = LayoutInflater.class.getClassLoader();
  private static final ConcurrentHashMap<String, Constructor<? extends View>> sConstructorMap = new ConcurrentHashMap();
  LayoutInflater inflater;
  
  public QZoneLayoutInflateFactory(LayoutInflater paramLayoutInflater)
  {
    this.inflater = paramLayoutInflater;
  }
  
  private final boolean verifyClassLoader(Constructor<? extends View> paramConstructor)
  {
    ClassLoader localClassLoader2 = paramConstructor.getDeclaringClass().getClassLoader();
    if (localClassLoader2 == BOOT_CLASS_LOADER) {
      return true;
    }
    paramConstructor = this.inflater.getContext().getClassLoader();
    ClassLoader localClassLoader1;
    do
    {
      if (localClassLoader2 == paramConstructor) {
        return true;
      }
      localClassLoader1 = paramConstructor.getParent();
      paramConstructor = localClassLoader1;
    } while (localClassLoader1 != null);
    return false;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneLayoutInflateFactory
 * JD-Core Version:    0.7.0.1
 */