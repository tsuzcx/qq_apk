package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$qualifiedName$2
  extends Lambda
  implements Function0<String>
{
  KClassImpl$Data$qualifiedName$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @Nullable
  public final String invoke()
  {
    if (this.this$0.this$0.getJClass().isAnonymousClass()) {
      return null;
    }
    ClassId localClassId = KClassImpl.access$getClassId$p(this.this$0.this$0);
    if (localClassId.isLocal()) {
      return null;
    }
    return localClassId.asSingleFqName().asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.qualifiedName.2
 * JD-Core Version:    0.7.0.1
 */