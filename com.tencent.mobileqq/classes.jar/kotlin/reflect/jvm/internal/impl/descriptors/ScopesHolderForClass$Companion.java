package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ScopesHolderForClass$Companion
{
  @NotNull
  public final <T extends MemberScope> ScopesHolderForClass<T> create(@NotNull ClassDescriptor paramClassDescriptor, @NotNull StorageManager paramStorageManager, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner, @NotNull Function1<? super KotlinTypeRefiner, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    Intrinsics.checkParameterIsNotNull(paramStorageManager, "storageManager");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "scopeFactory");
    return new ScopesHolderForClass(paramClassDescriptor, paramStorageManager, paramFunction1, paramKotlinTypeRefiner, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion
 * JD-Core Version:    0.7.0.1
 */