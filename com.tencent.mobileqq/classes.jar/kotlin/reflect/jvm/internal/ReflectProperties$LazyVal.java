package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public class ReflectProperties$LazyVal<T>
  extends ReflectProperties.Val<T>
{
  private final Function0<T> initializer;
  private volatile Object value = null;
  
  public ReflectProperties$LazyVal(@NotNull Function0<T> paramFunction0)
  {
    this.initializer = paramFunction0;
  }
  
  public T invoke()
  {
    Object localObject = this.value;
    if (localObject != null) {
      return unescape(localObject);
    }
    localObject = this.initializer.invoke();
    this.value = escape(localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ReflectProperties.LazyVal
 * JD-Core Version:    0.7.0.1
 */