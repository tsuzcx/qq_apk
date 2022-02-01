package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1
  extends Lambda
  implements Function2<List<? extends FqName>, T, T>
{
  SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1(Annotations paramAnnotations)
  {
    super(2);
  }
  
  @Nullable
  public final <T> T invoke(@NotNull List<FqName> paramList, @NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$ifPresent");
    Intrinsics.checkParameterIsNotNull(paramT, "qualifier");
    paramList = (Iterable)paramList;
    boolean bool = paramList instanceof Collection;
    int j = 0;
    int i;
    if ((bool) && (((Collection)paramList).isEmpty()))
    {
      i = j;
    }
    else
    {
      paramList = paramList.iterator();
      do
      {
        i = j;
        if (!paramList.hasNext()) {
          break;
        }
        FqName localFqName = (FqName)paramList.next();
        if (this.$composedAnnotation.findAnnotation(localFqName) != null) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i == 0);
      i = 1;
    }
    if (i != 0) {
      return paramT;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations.1
 * JD-Core Version:    0.7.0.1
 */