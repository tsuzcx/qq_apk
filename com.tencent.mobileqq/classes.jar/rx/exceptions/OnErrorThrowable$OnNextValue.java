package rx.exceptions;

import java.util.Set;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public class OnErrorThrowable$OnNextValue
  extends RuntimeException
{
  private static final long serialVersionUID = -3454462756050397899L;
  private final Object value;
  
  public OnErrorThrowable$OnNextValue(Object paramObject)
  {
    super(localStringBuilder.toString());
    this.value = paramObject;
  }
  
  static String renderValue(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    if (OnErrorThrowable.OnNextValue.Primitives.INSTANCE.contains(paramObject.getClass())) {
      return paramObject.toString();
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Enum)) {
      return ((Enum)paramObject).name();
    }
    Object localObject = RxJavaPlugins.getInstance().getErrorHandler().handleOnNextValueRendering(paramObject);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramObject.getClass().getName());
    ((StringBuilder)localObject).append(".class");
    return ((StringBuilder)localObject).toString();
  }
  
  public Object getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.exceptions.OnErrorThrowable.OnNextValue
 * JD-Core Version:    0.7.0.1
 */