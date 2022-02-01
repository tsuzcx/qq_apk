package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/Class;", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClasses$defaultType$1
  extends Lambda
  implements Function0<Class<? extends Object>>
{
  KClasses$defaultType$1(KClass paramKClass)
  {
    super(0);
  }
  
  @NotNull
  public final Class<? extends Object> invoke()
  {
    return ((KClassImpl)this.$this_defaultType).getJClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KClasses.defaultType.1
 * JD-Core Version:    0.7.0.1
 */