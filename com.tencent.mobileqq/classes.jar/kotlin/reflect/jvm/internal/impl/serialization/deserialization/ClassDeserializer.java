package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassDeserializer
{
  @NotNull
  private static final Set<ClassId> BLACK_LIST = SetsKt.setOf(ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.cloneable.toSafe()));
  public static final ClassDeserializer.Companion Companion = new ClassDeserializer.Companion(null);
  private final Function1<ClassDeserializer.ClassKey, ClassDescriptor> classes;
  private final DeserializationComponents components;
  
  public ClassDeserializer(@NotNull DeserializationComponents paramDeserializationComponents)
  {
    this.components = paramDeserializationComponents;
    this.classes = ((Function1)this.components.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new ClassDeserializer.classes.1(this)));
  }
  
  private final ClassDescriptor createClass(ClassDeserializer.ClassKey paramClassKey)
  {
    Object localObject3 = paramClassKey.getClassId();
    Object localObject1 = this.components.getFictitiousClassDescriptorFactories().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((ClassDescriptorFactory)((Iterator)localObject1).next()).createClass((ClassId)localObject3);
      if (localObject2 != null) {
        return localObject2;
      }
    }
    if (BLACK_LIST.contains(localObject3)) {
      return null;
    }
    paramClassKey = paramClassKey.getClassData();
    if (paramClassKey == null) {
      paramClassKey = this.components.getClassDataFinder().findClassData((ClassId)localObject3);
    }
    if (paramClassKey != null)
    {
      localObject2 = paramClassKey.component1();
      ProtoBuf.Class localClass = paramClassKey.component2();
      BinaryVersion localBinaryVersion = paramClassKey.component3();
      SourceElement localSourceElement = paramClassKey.component4();
      paramClassKey = ((ClassId)localObject3).getOuterClassId();
      if (paramClassKey != null)
      {
        localObject1 = deserializeClass$default(this, paramClassKey, null, 2, null);
        paramClassKey = (ClassDeserializer.ClassKey)localObject1;
        if (!(localObject1 instanceof DeserializedClassDescriptor)) {
          paramClassKey = null;
        }
        paramClassKey = (DeserializedClassDescriptor)paramClassKey;
        if (paramClassKey != null)
        {
          localObject1 = ((ClassId)localObject3).getShortClassName();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "classId.shortClassName");
          if (!paramClassKey.hasNestedClass$deserialization((Name)localObject1)) {
            return null;
          }
        }
      }
      Object localObject4;
      Object localObject5;
      for (paramClassKey = paramClassKey.getC();; paramClassKey = ((DeserializationComponents)localObject1).createContext(paramClassKey, (NameResolver)localObject2, (TypeTable)localObject3, ((VersionRequirementTable.Companion)localObject4).create((ProtoBuf.VersionRequirementTable)localObject5), localBinaryVersion, null))
      {
        break;
        return null;
        paramClassKey = this.components.getPackageFragmentProvider();
        localObject1 = ((ClassId)localObject3).getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "classId.packageFqName");
        localObject1 = ((Iterable)paramClassKey.getPackageFragments((FqName)localObject1)).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramClassKey = ((Iterator)localObject1).next();
          localObject4 = (PackageFragmentDescriptor)paramClassKey;
          if ((localObject4 instanceof DeserializedPackageFragment))
          {
            localObject4 = (DeserializedPackageFragment)localObject4;
            localObject5 = ((ClassId)localObject3).getShortClassName();
            Intrinsics.checkExpressionValueIsNotNull(localObject5, "classId.shortClassName");
            if (!((DeserializedPackageFragment)localObject4).hasTopLevelClass((Name)localObject5))
            {
              i = 0;
              break label302;
            }
          }
          int i = 1;
          label302:
          if (i != 0) {
            break label311;
          }
        }
        paramClassKey = null;
        label311:
        paramClassKey = (PackageFragmentDescriptor)paramClassKey;
        if (paramClassKey == null) {
          break label412;
        }
        localObject1 = this.components;
        localObject3 = localClass.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "classProto.typeTable");
        localObject3 = new TypeTable((ProtoBuf.TypeTable)localObject3);
        localObject4 = VersionRequirementTable.Companion;
        localObject5 = localClass.getVersionRequirementTable();
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "classProto.versionRequirementTable");
      }
      return (ClassDescriptor)new DeserializedClassDescriptor(paramClassKey, localClass, (NameResolver)localObject2, localBinaryVersion, localSourceElement);
    }
    label412:
    return null;
  }
  
  @Nullable
  public final ClassDescriptor deserializeClass(@NotNull ClassId paramClassId, @Nullable ClassData paramClassData)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    return (ClassDescriptor)this.classes.invoke(new ClassDeserializer.ClassKey(paramClassId, paramClassData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer
 * JD-Core Version:    0.7.0.1
 */