package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$simpleName$2
  extends Lambda
  implements Function0<String>
{
  KClassImpl$Data$simpleName$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @Nullable
  public final String invoke()
  {
    if (this.this$0.this$0.getJClass().isAnonymousClass()) {
      return null;
    }
    Object localObject = KClassImpl.access$getClassId$p(this.this$0.this$0);
    if (((ClassId)localObject).isLocal())
    {
      localObject = this.this$0;
      return KClassImpl.Data.access$calculateLocalClassName((KClassImpl.Data)localObject, ((KClassImpl.Data)localObject).this$0.getJClass());
    }
    localObject = ((ClassId)localObject).getShortClassName().asString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "classId.shortClassName.asString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.simpleName.2
 * JD-Core Version:    0.7.0.1
 */