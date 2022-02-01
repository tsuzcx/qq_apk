package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReflectProperties$LazySoftVal<T>
  extends ReflectProperties.Val<T>
{
  private final Function0<T> initializer;
  private volatile SoftReference<Object> value = null;
  
  public ReflectProperties$LazySoftVal(@Nullable T paramT, @NotNull Function0<T> paramFunction0)
  {
    this.initializer = paramFunction0;
    if (paramT != null) {
      this.value = new SoftReference(escape(paramT));
    }
  }
  
  public T invoke()
  {
    Object localObject = this.value;
    if (localObject != null)
    {
      localObject = ((SoftReference)localObject).get();
      if (localObject != null) {
        return unescape(localObject);
      }
    }
    localObject = this.initializer.invoke();
    this.value = new SoftReference(escape(localObject));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal
 * JD-Core Version:    0.7.0.1
 */