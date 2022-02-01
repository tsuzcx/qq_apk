package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/Class;", "invoke"}, k=3, mv={1, 1, 16})
final class KPackageImpl$Data$multifileFacade$2
  extends Lambda
  implements Function0<Class<?>>
{
  KPackageImpl$Data$multifileFacade$2(KPackageImpl.Data paramData)
  {
    super(0);
  }
  
  @Nullable
  public final Class<?> invoke()
  {
    Object localObject1 = KPackageImpl.Data.access$getKotlinClass$p(this.this$0);
    Object localObject3 = null;
    if (localObject1 != null)
    {
      localObject1 = ((ReflectKotlinClass)localObject1).getClassHeader();
      if (localObject1 != null)
      {
        localObject1 = ((KotlinClassHeader)localObject1).getMultifileClassName();
        break label34;
      }
    }
    localObject1 = null;
    label34:
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      int i;
      if (((CharSequence)localObject1).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      localObject2 = localObject3;
      if (i != 0) {
        localObject2 = this.this$0.this$0.getJClass().getClassLoader().loadClass(StringsKt.replace$default((String)localObject1, '/', '.', false, 4, null));
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPackageImpl.Data.multifileFacade.2
 * JD-Core Version:    0.7.0.1
 */