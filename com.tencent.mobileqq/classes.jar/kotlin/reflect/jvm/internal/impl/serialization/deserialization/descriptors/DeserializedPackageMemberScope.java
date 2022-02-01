package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeserializedPackageMemberScope
  extends DeserializedMemberScope
{
  private final PackageFragmentDescriptor packageDescriptor;
  private final FqName packageFqName;
  
  public DeserializedPackageMemberScope(@NotNull PackageFragmentDescriptor paramPackageFragmentDescriptor, @NotNull ProtoBuf.Package paramPackage, @NotNull NameResolver paramNameResolver, @NotNull BinaryVersion paramBinaryVersion, @Nullable DeserializedContainerSource paramDeserializedContainerSource, @NotNull DeserializationComponents paramDeserializationComponents, @NotNull Function0<? extends Collection<Name>> paramFunction0)
  {
    super(paramNameResolver, paramBinaryVersion, paramDeserializedContainerSource, (Collection)paramPackage, paramFunction0);
    this.packageDescriptor = paramPackageFragmentDescriptor;
    this.packageFqName = this.packageDescriptor.getFqName();
  }
  
  protected void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> paramCollection, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "result");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
  }
  
  @NotNull
  protected ClassId createClassId(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return new ClassId(this.packageFqName, paramName);
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    recordLookup(paramName, paramLookupLocation);
    return super.getContributedClassifier(paramName, paramLookupLocation);
  }
  
  @NotNull
  public List<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    paramDescriptorKindFilter = computeDescriptors(paramDescriptorKindFilter, paramFunction1, (LookupLocation)NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    Object localObject = getC().getComponents().getFictitiousClassDescriptorFactories();
    paramFunction1 = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      CollectionsKt.addAll(paramFunction1, (Iterable)((ClassDescriptorFactory)((Iterator)localObject).next()).getAllContributedClassesIfPossible(this.packageFqName));
    }
    return CollectionsKt.plus(paramDescriptorKindFilter, (Iterable)paramFunction1);
  }
  
  @NotNull
  protected Set<Name> getNonDeclaredFunctionNames()
  {
    return SetsKt.emptySet();
  }
  
  @NotNull
  protected Set<Name> getNonDeclaredVariableNames()
  {
    return SetsKt.emptySet();
  }
  
  protected boolean hasClass(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    boolean bool2 = super.hasClass(paramName);
    boolean bool1 = true;
    if (!bool2)
    {
      Object localObject = getC().getComponents().getFictitiousClassDescriptorFactories();
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject).hasNext())
        {
          i = 0;
          break;
          localObject = ((Iterable)localObject).iterator();
        }
      } while (!((ClassDescriptorFactory)((Iterator)localObject).next()).shouldCreateClass(this.packageFqName, paramName));
      int i = 1;
      if (i != 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void recordLookup(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    UtilsKt.record(getC().getComponents().getLookupTracker(), paramLookupLocation, this.packageDescriptor, paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope
 * JD-Core Version:    0.7.0.1
 */