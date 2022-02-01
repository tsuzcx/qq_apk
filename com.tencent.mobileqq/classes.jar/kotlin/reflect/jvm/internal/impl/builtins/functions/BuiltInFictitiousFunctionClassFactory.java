package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltInFictitiousFunctionClassFactory
  implements ClassDescriptorFactory
{
  public static final BuiltInFictitiousFunctionClassFactory.Companion Companion = new BuiltInFictitiousFunctionClassFactory.Companion(null);
  private final ModuleDescriptor module;
  private final StorageManager storageManager;
  
  public BuiltInFictitiousFunctionClassFactory(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor)
  {
    this.storageManager = paramStorageManager;
    this.module = paramModuleDescriptor;
  }
  
  @Nullable
  public ClassDescriptor createClass(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    if (!paramClassId.isLocal())
    {
      if (paramClassId.isNestedClass()) {
        return null;
      }
      Object localObject1 = paramClassId.getRelativeClassName().asString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "classId.relativeClassName.asString()");
      if (!StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"Function", false, 2, null)) {
        return null;
      }
      paramClassId = paramClassId.getPackageFqName();
      Intrinsics.checkExpressionValueIsNotNull(paramClassId, "classId.packageFqName");
      Object localObject2 = BuiltInFictitiousFunctionClassFactory.Companion.access$parseClassName(Companion, (String)localObject1, paramClassId);
      if (localObject2 != null)
      {
        localObject1 = ((BuiltInFictitiousFunctionClassFactory.KindWithArity)localObject2).component1();
        int i = ((BuiltInFictitiousFunctionClassFactory.KindWithArity)localObject2).component2();
        localObject2 = (Iterable)this.module.getPackage(paramClassId).getFragments();
        paramClassId = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if ((localObject3 instanceof BuiltInsPackageFragment)) {
            paramClassId.add(localObject3);
          }
        }
        localObject2 = (List)paramClassId;
        Object localObject3 = (Iterable)localObject2;
        paramClassId = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if ((localObject4 instanceof FunctionInterfacePackageFragment)) {
            paramClassId.add(localObject4);
          }
        }
        paramClassId = (FunctionInterfacePackageFragment)CollectionsKt.firstOrNull((List)paramClassId);
        if (paramClassId == null) {
          paramClassId = CollectionsKt.first((List)localObject2);
        }
        paramClassId = (BuiltInsPackageFragment)paramClassId;
        return (ClassDescriptor)new FunctionClassDescriptor(this.storageManager, (PackageFragmentDescriptor)paramClassId, (FunctionClassDescriptor.Kind)localObject1, i);
      }
    }
    return null;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "packageFqName");
    return (Collection)SetsKt.emptySet();
  }
  
  public boolean shouldCreateClass(@NotNull FqName paramFqName, @NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "packageFqName");
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    paramName = paramName.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramName, "name.asString()");
    boolean bool2 = false;
    boolean bool1;
    if ((!StringsKt.startsWith$default(paramName, "Function", false, 2, null)) && (!StringsKt.startsWith$default(paramName, "KFunction", false, 2, null)) && (!StringsKt.startsWith$default(paramName, "SuspendFunction", false, 2, null)))
    {
      bool1 = bool2;
      if (!StringsKt.startsWith$default(paramName, "KSuspendFunction", false, 2, null)) {}
    }
    else
    {
      bool1 = bool2;
      if (BuiltInFictitiousFunctionClassFactory.Companion.access$parseClassName(Companion, paramName, paramFqName) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory
 * JD-Core Version:    0.7.0.1
 */