package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$DeserializedClassTypeConstructor
  extends AbstractClassTypeConstructor
{
  private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
  
  public DeserializedClassDescriptor$DeserializedClassTypeConstructor()
  {
    super(localObject.getC().getStorageManager());
    this.parameters = localObject.getC().getStorageManager().createLazyValue((Function0)new DeserializedClassDescriptor.DeserializedClassTypeConstructor.parameters.1(this));
  }
  
  @NotNull
  protected Collection<KotlinType> computeSupertypes()
  {
    Object localObject2 = (Iterable)ProtoTypeTableUtilKt.supertypes(this.this$0.getClassProto(), this.this$0.getC().getTypeTable());
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ProtoBuf.Type)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.this$0.getC().getTypeDeserializer().type((ProtoBuf.Type)localObject3));
    }
    Object localObject3 = (Iterable)CollectionsKt.plus((Collection)localObject1, (Iterable)this.this$0.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes((ClassDescriptor)this.this$0));
    Object localObject4 = (Collection)new ArrayList();
    Object localObject5 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = ((KotlinType)((Iterator)localObject5).next()).getConstructor().getDeclarationDescriptor();
      localObject1 = localObject2;
      if (!(localObject2 instanceof NotFoundClasses.MockClassDescriptor)) {
        localObject1 = null;
      }
      localObject1 = (NotFoundClasses.MockClassDescriptor)localObject1;
      if (localObject1 != null) {
        ((Collection)localObject4).add(localObject1);
      }
    }
    localObject1 = (List)localObject4;
    if ((((Collection)localObject1).isEmpty() ^ true))
    {
      localObject2 = this.this$0.getC().getComponents().getErrorReporter();
      localObject4 = (ClassDescriptor)this.this$0;
      localObject1 = (Iterable)localObject1;
      localObject5 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        NotFoundClasses.MockClassDescriptor localMockClassDescriptor = (NotFoundClasses.MockClassDescriptor)localIterator.next();
        localObject1 = DescriptorUtilsKt.getClassId((ClassifierDescriptor)localMockClassDescriptor);
        if (localObject1 != null)
        {
          localObject1 = ((ClassId)localObject1).asSingleFqName();
          if (localObject1 != null)
          {
            localObject1 = ((FqName)localObject1).asString();
            if (localObject1 != null) {
              break label353;
            }
          }
        }
        localObject1 = localMockClassDescriptor.getName().asString();
        label353:
        ((Collection)localObject5).add(localObject1);
      }
      ((ErrorReporter)localObject2).reportIncompleteHierarchy((ClassDescriptor)localObject4, (List)localObject5);
    }
    return (Collection)CollectionsKt.toList((Iterable)localObject3);
  }
  
  @NotNull
  public DeserializedClassDescriptor getDeclarationDescriptor()
  {
    return this.this$0;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    return (List)this.parameters.invoke();
  }
  
  @NotNull
  protected SupertypeLoopChecker getSupertypeLoopChecker()
  {
    return (SupertypeLoopChecker)SupertypeLoopChecker.EMPTY.INSTANCE;
  }
  
  public boolean isDenotable()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    String str = this.this$0.getName().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "name.toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassTypeConstructor
 * JD-Core Version:    0.7.0.1
 */