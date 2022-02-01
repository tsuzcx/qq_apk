package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface ModuleVisibilityHelper
{
  public abstract boolean isInFriendModule(@NotNull DeclarationDescriptor paramDeclarationDescriptor1, @NotNull DeclarationDescriptor paramDeclarationDescriptor2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
 * JD-Core Version:    0.7.0.1
 */