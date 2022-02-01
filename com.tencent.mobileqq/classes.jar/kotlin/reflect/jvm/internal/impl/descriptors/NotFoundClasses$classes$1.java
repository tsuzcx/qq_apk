package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

final class NotFoundClasses$classes$1
  extends Lambda
  implements Function1<NotFoundClasses.ClassRequest, NotFoundClasses.MockClassDescriptor>
{
  NotFoundClasses$classes$1(NotFoundClasses paramNotFoundClasses)
  {
    super(1);
  }
  
  @NotNull
  public final NotFoundClasses.MockClassDescriptor invoke(@NotNull NotFoundClasses.ClassRequest paramClassRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramClassRequest, "<name for destructuring parameter 0>");
    Object localObject1 = paramClassRequest.component1();
    Object localObject2 = paramClassRequest.component2();
    if (!((ClassId)localObject1).isLocal())
    {
      paramClassRequest = ((ClassId)localObject1).getOuterClassId();
      if (paramClassRequest != null)
      {
        localObject3 = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(paramClassRequest, "outerClassId");
        paramClassRequest = ((NotFoundClasses)localObject3).getClass(paramClassRequest, CollectionsKt.drop((Iterable)localObject2, 1));
        if (paramClassRequest != null)
        {
          paramClassRequest = (ClassOrPackageFragmentDescriptor)paramClassRequest;
          break label110;
        }
      }
      paramClassRequest = NotFoundClasses.access$getPackageFragments$p(this.this$0);
      Object localObject3 = ((ClassId)localObject1).getPackageFqName();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "classId.packageFqName");
      paramClassRequest = (ClassOrPackageFragmentDescriptor)paramClassRequest.invoke(localObject3);
      label110:
      boolean bool = ((ClassId)localObject1).isNestedClass();
      localObject3 = NotFoundClasses.access$getStorageManager$p(this.this$0);
      paramClassRequest = (DeclarationDescriptor)paramClassRequest;
      localObject1 = ((ClassId)localObject1).getShortClassName();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "classId.shortClassName");
      localObject2 = (Integer)CollectionsKt.firstOrNull((List)localObject2);
      int i;
      if (localObject2 != null) {
        i = ((Integer)localObject2).intValue();
      } else {
        i = 0;
      }
      return new NotFoundClasses.MockClassDescriptor((StorageManager)localObject3, paramClassRequest, (Name)localObject1, bool, i);
    }
    paramClassRequest = new StringBuilder();
    paramClassRequest.append("Unresolved local class: ");
    paramClassRequest.append(localObject1);
    throw ((Throwable)new UnsupportedOperationException(paramClassRequest.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.classes.1
 * JD-Core Version:    0.7.0.1
 */