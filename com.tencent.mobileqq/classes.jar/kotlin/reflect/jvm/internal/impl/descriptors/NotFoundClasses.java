package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class NotFoundClasses
{
  private final MemoizedFunctionToNotNull<NotFoundClasses.ClassRequest, ClassDescriptor> classes;
  private final ModuleDescriptor module;
  private final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
  private final StorageManager storageManager;
  
  public NotFoundClasses(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor)
  {
    this.storageManager = paramStorageManager;
    this.module = paramModuleDescriptor;
    this.packageFragments = this.storageManager.createMemoizedFunction((Function1)new NotFoundClasses.packageFragments.1(this));
    this.classes = this.storageManager.createMemoizedFunction((Function1)new NotFoundClasses.classes.1(this));
  }
  
  @NotNull
  public final ClassDescriptor getClass(@NotNull ClassId paramClassId, @NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    Intrinsics.checkParameterIsNotNull(paramList, "typeParametersCount");
    return (ClassDescriptor)this.classes.invoke(new NotFoundClasses.ClassRequest(paramClassId, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses
 * JD-Core Version:    0.7.0.1
 */