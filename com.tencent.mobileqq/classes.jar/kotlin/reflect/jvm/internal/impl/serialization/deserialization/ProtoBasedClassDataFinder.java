package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoBasedClassDataFinder
  implements ClassDataFinder
{
  private final Map<ClassId, ProtoBuf.Class> classIdToProto;
  private final Function1<ClassId, SourceElement> classSource;
  private final BinaryVersion metadataVersion;
  private final NameResolver nameResolver;
  
  public ProtoBasedClassDataFinder(@NotNull ProtoBuf.PackageFragment paramPackageFragment, @NotNull NameResolver paramNameResolver, @NotNull BinaryVersion paramBinaryVersion, @NotNull Function1<? super ClassId, ? extends SourceElement> paramFunction1)
  {
    this.nameResolver = paramNameResolver;
    this.metadataVersion = paramBinaryVersion;
    this.classSource = paramFunction1;
    paramPackageFragment = paramPackageFragment.getClass_List();
    Intrinsics.checkExpressionValueIsNotNull(paramPackageFragment, "proto.class_List");
    paramNameResolver = (Iterable)paramPackageFragment;
    paramPackageFragment = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(paramNameResolver, 10)), 16));
    paramNameResolver = paramNameResolver.iterator();
    while (paramNameResolver.hasNext())
    {
      paramBinaryVersion = paramNameResolver.next();
      paramFunction1 = (ProtoBuf.Class)paramBinaryVersion;
      NameResolver localNameResolver = this.nameResolver;
      Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "klass");
      paramPackageFragment.put(NameResolverUtilKt.getClassId(localNameResolver, paramFunction1.getFqName()), paramBinaryVersion);
    }
    this.classIdToProto = paramPackageFragment;
  }
  
  @Nullable
  public ClassData findClassData(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    ProtoBuf.Class localClass = (ProtoBuf.Class)this.classIdToProto.get(paramClassId);
    if (localClass != null) {
      return new ClassData(this.nameResolver, localClass, this.metadataVersion, (SourceElement)this.classSource.invoke(paramClassId));
    }
    return null;
  }
  
  @NotNull
  public final Collection<ClassId> getAllClassIds()
  {
    return (Collection)this.classIdToProto.keySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoBasedClassDataFinder
 * JD-Core Version:    0.7.0.1
 */