package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class DeserializedTypeParameterDescriptor
  extends AbstractLazyTypeParameterDescriptor
{
  @NotNull
  private final DeserializedAnnotations annotations;
  private final DeserializationContext c;
  @NotNull
  private final ProtoBuf.TypeParameter proto;
  
  public DeserializedTypeParameterDescriptor(@NotNull DeserializationContext paramDeserializationContext, @NotNull ProtoBuf.TypeParameter paramTypeParameter, int paramInt)
  {
    super(localStorageManager, localDeclarationDescriptor, localName, localProtoEnumFlags.variance(localVariance), paramTypeParameter.getReified(), paramInt, SourceElement.NO_SOURCE, (SupertypeLoopChecker)SupertypeLoopChecker.EMPTY.INSTANCE);
    this.c = paramDeserializationContext;
    this.proto = paramTypeParameter;
    this.annotations = new DeserializedAnnotations(this.c.getStorageManager(), (Function0)new DeserializedTypeParameterDescriptor.annotations.1(this));
  }
  
  @NotNull
  public DeserializedAnnotations getAnnotations()
  {
    return this.annotations;
  }
  
  @NotNull
  public final ProtoBuf.TypeParameter getProto()
  {
    return this.proto;
  }
  
  @NotNull
  protected Void reportSupertypeLoopError(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    paramKotlinType = new StringBuilder();
    paramKotlinType.append("There should be no cycles for deserialized type parameters, but found for: ");
    paramKotlinType.append(this);
    throw ((Throwable)new IllegalStateException(paramKotlinType.toString()));
  }
  
  @NotNull
  protected List<KotlinType> resolveUpperBounds()
  {
    Object localObject1 = ProtoTypeTableUtilKt.upperBounds(this.proto, this.c.getTypeTable());
    if (((List)localObject1).isEmpty()) {
      return CollectionsKt.listOf(DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)this).getDefaultBound());
    }
    Object localObject2 = (Iterable)localObject1;
    localObject1 = this.c.getTypeDeserializer();
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localCollection.add(((TypeDeserializer)localObject1).type((ProtoBuf.Type)((Iterator)localObject2).next()));
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor
 * JD-Core Version:    0.7.0.1
 */