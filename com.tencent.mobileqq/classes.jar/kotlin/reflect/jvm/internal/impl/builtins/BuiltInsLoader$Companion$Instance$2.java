package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class BuiltInsLoader$Companion$Instance$2
  extends Lambda
  implements Function0<BuiltInsLoader>
{
  public static final 2 INSTANCE = new 2();
  
  BuiltInsLoader$Companion$Instance$2()
  {
    super(0);
  }
  
  @NotNull
  public final BuiltInsLoader invoke()
  {
    Object localObject = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "implementations");
    localObject = (BuiltInsLoader)CollectionsKt.firstOrNull((Iterable)localObject);
    if (localObject != null) {
      return localObject;
    }
    throw ((Throwable)new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader.Companion.Instance.2
 * JD-Core Version:    0.7.0.1
 */