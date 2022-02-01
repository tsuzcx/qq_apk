package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

public final class ModuleVisibilityHelper$EMPTY
  implements ModuleVisibilityHelper
{
  public static final EMPTY INSTANCE = new EMPTY();
  
  public boolean isInFriendModule(@NotNull DeclarationDescriptor paramDeclarationDescriptor1, @NotNull DeclarationDescriptor paramDeclarationDescriptor2)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor1, "what");
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor2, "from");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.EMPTY
 * JD-Core Version:    0.7.0.1
 */