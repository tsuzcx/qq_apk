package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class FunctionClassScope
  extends GivenFunctionsMemberScope
{
  public FunctionClassScope(@NotNull StorageManager paramStorageManager, @NotNull FunctionClassDescriptor paramFunctionClassDescriptor)
  {
    super(paramStorageManager, (ClassDescriptor)paramFunctionClassDescriptor);
  }
  
  @NotNull
  protected List<FunctionDescriptor> computeDeclaredFunctions()
  {
    Object localObject = getContainingClass();
    if (localObject != null)
    {
      localObject = ((FunctionClassDescriptor)localObject).getFunctionKind();
      int i = FunctionClassScope.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return CollectionsKt.emptyList();
        }
        return CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor)getContainingClass(), true));
      }
      return CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor)getContainingClass(), false));
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassScope
 * JD-Core Version:    0.7.0.1
 */