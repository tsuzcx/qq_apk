package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C>
  implements AnnotationAndConstantLoader<A, C>
{
  public static final AbstractBinaryClassAnnotationAndConstantLoader.Companion Companion = new AbstractBinaryClassAnnotationAndConstantLoader.Companion(null);
  @NotNull
  private static final Set<ClassId> SPECIAL_ANNOTATIONS;
  private final KotlinClassFinder kotlinClassFinder;
  private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AbstractBinaryClassAnnotationAndConstantLoader.Storage<A, C>> storage;
  
  static
  {
    Object localObject = (Iterable)CollectionsKt.listOf(new FqName[] { JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("java.lang.annotation.Target"), new FqName("java.lang.annotation.Retention"), new FqName("java.lang.annotation.Documented") });
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(ClassId.topLevel((FqName)((Iterator)localObject).next()));
    }
    SPECIAL_ANNOTATIONS = CollectionsKt.toSet((Iterable)localCollection);
  }
  
  public AbstractBinaryClassAnnotationAndConstantLoader(@NotNull StorageManager paramStorageManager, @NotNull KotlinClassFinder paramKotlinClassFinder)
  {
    this.kotlinClassFinder = paramKotlinClassFinder;
    this.storage = paramStorageManager.createMemoizedFunction((Function1)new AbstractBinaryClassAnnotationAndConstantLoader.storage.1(this));
  }
  
  private final int computeJvmParameterIndexShift(ProtoContainer paramProtoContainer, MessageLite paramMessageLite)
  {
    if ((paramMessageLite instanceof ProtoBuf.Function)) {
      if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function)paramMessageLite)) {
        return 1;
      }
    }
    do
    {
      do
      {
        return 0;
        if (!(paramMessageLite instanceof ProtoBuf.Property)) {
          break;
        }
      } while (!ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property)paramMessageLite));
      return 1;
      if (!(paramMessageLite instanceof ProtoBuf.Constructor)) {
        break label87;
      }
      if (paramProtoContainer == null) {
        break;
      }
      paramProtoContainer = (ProtoContainer.Class)paramProtoContainer;
      if (paramProtoContainer.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) {
        return 2;
      }
    } while (!paramProtoContainer.isInner());
    return 1;
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
    label87:
    paramProtoContainer = new StringBuilder();
    paramProtoContainer.append("Unsupported message: ");
    paramProtoContainer.append(paramMessageLite.getClass());
    paramProtoContainer = (Throwable)new UnsupportedOperationException(paramProtoContainer.toString());
    for (;;)
    {
      throw paramProtoContainer;
    }
  }
  
  private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer paramProtoContainer, MemberSignature paramMemberSignature, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    paramProtoContainer = findClassWithAnnotationsAndInitializers(paramProtoContainer, getSpecialCaseContainerClass(paramProtoContainer, paramBoolean1, paramBoolean2, paramBoolean, paramBoolean3));
    if (paramProtoContainer != null)
    {
      paramProtoContainer = (List)((AbstractBinaryClassAnnotationAndConstantLoader.Storage)this.storage.invoke(paramProtoContainer)).getMemberAnnotations().get(paramMemberSignature);
      if (paramProtoContainer != null) {
        return paramProtoContainer;
      }
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.emptyList();
  }
  
  private final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer paramProtoContainer, KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    if (paramKotlinJvmBinaryClass != null) {
      return paramKotlinJvmBinaryClass;
    }
    if ((paramProtoContainer instanceof ProtoContainer.Class)) {
      return toBinaryClass((ProtoContainer.Class)paramProtoContainer);
    }
    return null;
  }
  
  private final MemberSignature getCallableSignature(MessageLite paramMessageLite, NameResolver paramNameResolver, TypeTable paramTypeTable, AnnotatedCallableKind paramAnnotatedCallableKind, boolean paramBoolean)
  {
    boolean bool = paramMessageLite instanceof ProtoBuf.Constructor;
    Object localObject2 = null;
    if (bool)
    {
      paramAnnotatedCallableKind = MemberSignature.Companion;
      paramMessageLite = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor)paramMessageLite, paramNameResolver, paramTypeTable);
      if (paramMessageLite != null) {
        return paramAnnotatedCallableKind.fromJvmMemberSignature((JvmMemberSignature)paramMessageLite);
      }
      return null;
    }
    if ((paramMessageLite instanceof ProtoBuf.Function))
    {
      paramAnnotatedCallableKind = MemberSignature.Companion;
      paramMessageLite = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function)paramMessageLite, paramNameResolver, paramTypeTable);
      if (paramMessageLite != null) {
        return paramAnnotatedCallableKind.fromJvmMemberSignature((JvmMemberSignature)paramMessageLite);
      }
      return null;
    }
    Object localObject1 = localObject2;
    if ((paramMessageLite instanceof ProtoBuf.Property))
    {
      localObject1 = (GeneratedMessageLite.ExtendableMessage)paramMessageLite;
      Object localObject3 = JvmProtoBuf.propertySignature;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "propertySignature");
      localObject3 = (JvmProtoBuf.JvmPropertySignature)ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage)localObject1, (GeneratedMessageLite.GeneratedExtension)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        int i = AbstractBinaryClassAnnotationAndConstantLoader.WhenMappings.$EnumSwitchMapping$0[paramAnnotatedCallableKind.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return null;
            }
            return getPropertySignature((ProtoBuf.Property)paramMessageLite, paramNameResolver, paramTypeTable, true, true, paramBoolean);
          }
          localObject1 = localObject2;
          if (((JvmProtoBuf.JvmPropertySignature)localObject3).hasSetter())
          {
            paramMessageLite = MemberSignature.Companion;
            paramTypeTable = ((JvmProtoBuf.JvmPropertySignature)localObject3).getSetter();
            Intrinsics.checkExpressionValueIsNotNull(paramTypeTable, "signature.setter");
            return paramMessageLite.fromMethod(paramNameResolver, paramTypeTable);
          }
        }
        else
        {
          localObject1 = localObject2;
          if (((JvmProtoBuf.JvmPropertySignature)localObject3).hasGetter())
          {
            paramMessageLite = MemberSignature.Companion;
            paramTypeTable = ((JvmProtoBuf.JvmPropertySignature)localObject3).getGetter();
            Intrinsics.checkExpressionValueIsNotNull(paramTypeTable, "signature.getter");
            localObject1 = paramMessageLite.fromMethod(paramNameResolver, paramTypeTable);
          }
        }
      }
    }
    return localObject1;
  }
  
  private final MemberSignature getPropertySignature(ProtoBuf.Property paramProperty, NameResolver paramNameResolver, TypeTable paramTypeTable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = (GeneratedMessageLite.ExtendableMessage)paramProperty;
    GeneratedMessageLite.GeneratedExtension localGeneratedExtension = JvmProtoBuf.propertySignature;
    Intrinsics.checkExpressionValueIsNotNull(localGeneratedExtension, "propertySignature");
    localObject = (JvmProtoBuf.JvmPropertySignature)ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage)localObject, localGeneratedExtension);
    if (localObject != null)
    {
      if (paramBoolean1)
      {
        paramProperty = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(paramProperty, paramNameResolver, paramTypeTable, paramBoolean3);
        if (paramProperty != null) {
          return MemberSignature.Companion.fromJvmMemberSignature((JvmMemberSignature)paramProperty);
        }
        return null;
      }
      if ((paramBoolean2) && (((JvmProtoBuf.JvmPropertySignature)localObject).hasSyntheticMethod()))
      {
        paramProperty = MemberSignature.Companion;
        paramTypeTable = ((JvmProtoBuf.JvmPropertySignature)localObject).getSyntheticMethod();
        Intrinsics.checkExpressionValueIsNotNull(paramTypeTable, "signature.syntheticMethod");
        return paramProperty.fromMethod(paramNameResolver, paramTypeTable);
      }
    }
    return null;
  }
  
  private final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer paramProtoContainer, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      if (paramBoolean != null)
      {
        Object localObject;
        if ((paramProtoContainer instanceof ProtoContainer.Class))
        {
          localObject = (ProtoContainer.Class)paramProtoContainer;
          if (((ProtoContainer.Class)localObject).getKind() == ProtoBuf.Class.Kind.INTERFACE)
          {
            paramProtoContainer = this.kotlinClassFinder;
            paramBoolean = ((ProtoContainer.Class)localObject).getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
            Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
            return KotlinClassFinderKt.findKotlinClass(paramProtoContainer, paramBoolean);
          }
        }
        if ((paramBoolean.booleanValue()) && ((paramProtoContainer instanceof ProtoContainer.Package)))
        {
          localObject = paramProtoContainer.getSource();
          paramBoolean = (Boolean)localObject;
          if (!(localObject instanceof JvmPackagePartSource)) {
            paramBoolean = null;
          }
          paramBoolean = (JvmPackagePartSource)paramBoolean;
          if (paramBoolean != null) {
            paramBoolean = paramBoolean.getFacadeClassName();
          } else {
            paramBoolean = null;
          }
          if (paramBoolean != null)
          {
            paramProtoContainer = this.kotlinClassFinder;
            paramBoolean = paramBoolean.getInternalName();
            Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "facadeClassName.internalName");
            paramBoolean = ClassId.topLevel(new FqName(StringsKt.replace$default(paramBoolean, '/', '.', false, 4, null)));
            Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
            return KotlinClassFinderKt.findKotlinClass(paramProtoContainer, paramBoolean);
          }
        }
      }
      else
      {
        paramBoolean = new StringBuilder();
        paramBoolean.append("isConst should not be null for property (container=");
        paramBoolean.append(paramProtoContainer);
        paramBoolean.append(')');
        throw ((Throwable)new IllegalStateException(paramBoolean.toString().toString()));
      }
    }
    if ((paramBoolean2) && ((paramProtoContainer instanceof ProtoContainer.Class)))
    {
      paramBoolean = (ProtoContainer.Class)paramProtoContainer;
      if (paramBoolean.getKind() == ProtoBuf.Class.Kind.COMPANION_OBJECT)
      {
        paramBoolean = paramBoolean.getOuterClass();
        if ((paramBoolean != null) && ((paramBoolean.getKind() == ProtoBuf.Class.Kind.CLASS) || (paramBoolean.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) || ((paramBoolean3) && ((paramBoolean.getKind() == ProtoBuf.Class.Kind.INTERFACE) || (paramBoolean.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS))))) {
          return toBinaryClass(paramBoolean);
        }
      }
    }
    if (((paramProtoContainer instanceof ProtoContainer.Package)) && ((paramProtoContainer.getSource() instanceof JvmPackagePartSource)))
    {
      paramProtoContainer = paramProtoContainer.getSource();
      if (paramProtoContainer != null)
      {
        paramProtoContainer = (JvmPackagePartSource)paramProtoContainer;
        paramBoolean = paramProtoContainer.getKnownJvmBinaryClass();
        if (paramBoolean != null) {
          return paramBoolean;
        }
        return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, paramProtoContainer.getClassId());
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
    }
    return null;
  }
  
  private final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId paramClassId, SourceElement paramSourceElement, List<A> paramList)
  {
    if (SPECIAL_ANNOTATIONS.contains(paramClassId)) {
      return null;
    }
    return loadAnnotation(paramClassId, paramSourceElement, paramList);
  }
  
  private final AbstractBinaryClassAnnotationAndConstantLoader.Storage<A, C> loadAnnotationsAndInitializers(KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    paramKotlinJvmBinaryClass.visitMembers((KotlinJvmBinaryClass.MemberVisitor)new AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1(this, localHashMap1, localHashMap2), getCachedFileContent(paramKotlinJvmBinaryClass));
    return new AbstractBinaryClassAnnotationAndConstantLoader.Storage((Map)localHashMap1, (Map)localHashMap2);
  }
  
  private final List<A> loadPropertyAnnotations(ProtoContainer paramProtoContainer, ProtoBuf.Property paramProperty, AbstractBinaryClassAnnotationAndConstantLoader.PropertyRelatedElement paramPropertyRelatedElement)
  {
    Object localObject = Flags.IS_CONST.get(paramProperty.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Flags.IS_CONST.get(proto.flags)");
    boolean bool2 = ((Boolean)localObject).booleanValue();
    boolean bool3 = JvmProtoBufUtil.isMovedFromInterfaceCompanion(paramProperty);
    if (paramPropertyRelatedElement == AbstractBinaryClassAnnotationAndConstantLoader.PropertyRelatedElement.PROPERTY)
    {
      paramProperty = getPropertySignature$default(this, paramProperty, paramProtoContainer.getNameResolver(), paramProtoContainer.getTypeTable(), false, true, false, 40, null);
      if (paramProperty != null) {
        return findClassAndLoadMemberAnnotations$default(this, paramProtoContainer, paramProperty, true, false, Boolean.valueOf(bool2), bool3, 8, null);
      }
      return CollectionsKt.emptyList();
    }
    paramProperty = getPropertySignature$default(this, paramProperty, paramProtoContainer.getNameResolver(), paramProtoContainer.getTypeTable(), true, false, false, 48, null);
    if (paramProperty != null)
    {
      localObject = (CharSequence)paramProperty.getSignature$descriptors_jvm();
      CharSequence localCharSequence = (CharSequence)"$delegate";
      boolean bool1 = false;
      boolean bool4 = StringsKt.contains$default((CharSequence)localObject, localCharSequence, false, 2, null);
      if (paramPropertyRelatedElement == AbstractBinaryClassAnnotationAndConstantLoader.PropertyRelatedElement.DELEGATE_FIELD) {
        bool1 = true;
      }
      if (bool4 != bool1) {
        return CollectionsKt.emptyList();
      }
      return findClassAndLoadMemberAnnotations(paramProtoContainer, paramProperty, true, true, Boolean.valueOf(bool2), bool3);
    }
    return CollectionsKt.emptyList();
  }
  
  private final KotlinJvmBinaryClass toBinaryClass(@NotNull ProtoContainer.Class paramClass)
  {
    paramClass = paramClass.getSource();
    boolean bool = paramClass instanceof KotlinJvmBinarySourceElement;
    Object localObject = null;
    if (!bool) {
      paramClass = null;
    }
    KotlinJvmBinarySourceElement localKotlinJvmBinarySourceElement = (KotlinJvmBinarySourceElement)paramClass;
    paramClass = localObject;
    if (localKotlinJvmBinarySourceElement != null) {
      paramClass = localKotlinJvmBinarySourceElement.getBinaryClass();
    }
    return paramClass;
  }
  
  @Nullable
  protected byte[] getCachedFileContent(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinJvmBinaryClass, "kotlinClass");
    return null;
  }
  
  @Nullable
  protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId paramClassId, @NotNull SourceElement paramSourceElement, @NotNull List<A> paramList);
  
  @NotNull
  public List<A> loadCallableAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull MessageLite paramMessageLite, @NotNull AnnotatedCallableKind paramAnnotatedCallableKind)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramMessageLite, "proto");
    Intrinsics.checkParameterIsNotNull(paramAnnotatedCallableKind, "kind");
    if (paramAnnotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
      return loadPropertyAnnotations(paramProtoContainer, (ProtoBuf.Property)paramMessageLite, AbstractBinaryClassAnnotationAndConstantLoader.PropertyRelatedElement.PROPERTY);
    }
    paramMessageLite = getCallableSignature$default(this, paramMessageLite, paramProtoContainer.getNameResolver(), paramProtoContainer.getTypeTable(), paramAnnotatedCallableKind, false, 16, null);
    if (paramMessageLite != null) {
      return findClassAndLoadMemberAnnotations$default(this, paramProtoContainer, paramMessageLite, false, false, null, false, 60, null);
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "container");
    Object localObject = toBinaryClass(paramClass);
    if (localObject != null)
    {
      paramClass = new ArrayList(1);
      ((KotlinJvmBinaryClass)localObject).loadClassAnnotations((KotlinJvmBinaryClass.AnnotationVisitor)new AbstractBinaryClassAnnotationAndConstantLoader.loadClassAnnotations.1(this, paramClass), getCachedFileContent((KotlinJvmBinaryClass)localObject));
      return (List)paramClass;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Class for loading annotations is not found: ");
    ((StringBuilder)localObject).append(paramClass.debugFqName());
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
  
  @Nullable
  protected abstract C loadConstant(@NotNull String paramString, @NotNull Object paramObject);
  
  @NotNull
  public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.EnumEntry paramEnumEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramEnumEntry, "proto");
    MemberSignature.Companion localCompanion = MemberSignature.Companion;
    paramEnumEntry = paramProtoContainer.getNameResolver().getString(paramEnumEntry.getName());
    String str = ((ProtoContainer.Class)paramProtoContainer).getClassId().asString();
    Intrinsics.checkExpressionValueIsNotNull(str, "(container as ProtoConta…Class).classId.asString()");
    return findClassAndLoadMemberAnnotations$default(this, paramProtoContainer, localCompanion.fromFieldNameAndDesc(paramEnumEntry, ClassMapperLite.mapClass(str)), false, false, null, false, 60, null);
  }
  
  @NotNull
  public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull MessageLite paramMessageLite, @NotNull AnnotatedCallableKind paramAnnotatedCallableKind)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramMessageLite, "proto");
    Intrinsics.checkParameterIsNotNull(paramAnnotatedCallableKind, "kind");
    paramMessageLite = getCallableSignature$default(this, paramMessageLite, paramProtoContainer.getNameResolver(), paramProtoContainer.getTypeTable(), paramAnnotatedCallableKind, false, 16, null);
    if (paramMessageLite != null) {
      return findClassAndLoadMemberAnnotations$default(this, paramProtoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(paramMessageLite, 0), false, false, null, false, 60, null);
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.Property paramProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramProperty, "proto");
    return loadPropertyAnnotations(paramProtoContainer, paramProperty, AbstractBinaryClassAnnotationAndConstantLoader.PropertyRelatedElement.BACKING_FIELD);
  }
  
  @Nullable
  public C loadPropertyConstant(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.Property paramProperty, @NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramProperty, "proto");
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "expectedType");
    KotlinJvmBinaryClass localKotlinJvmBinaryClass = findClassWithAnnotationsAndInitializers(paramProtoContainer, getSpecialCaseContainerClass(paramProtoContainer, true, true, Flags.IS_CONST.get(paramProperty.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(paramProperty)));
    if (localKotlinJvmBinaryClass != null)
    {
      boolean bool = localKotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isAtLeast((BinaryVersion)DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm());
      paramProtoContainer = getCallableSignature((MessageLite)paramProperty, paramProtoContainer.getNameResolver(), paramProtoContainer.getTypeTable(), AnnotatedCallableKind.PROPERTY, bool);
      if (paramProtoContainer != null)
      {
        paramProperty = ((AbstractBinaryClassAnnotationAndConstantLoader.Storage)this.storage.invoke(localKotlinJvmBinaryClass)).getPropertyConstants().get(paramProtoContainer);
        if (paramProperty != null)
        {
          paramProtoContainer = paramProperty;
          if (UnsignedTypes.INSTANCE.isUnsignedType(paramKotlinType)) {
            paramProtoContainer = transformToUnsignedConstant(paramProperty);
          }
          return paramProtoContainer;
        }
      }
    }
    return null;
  }
  
  @NotNull
  public List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull ProtoBuf.Property paramProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramProperty, "proto");
    return loadPropertyAnnotations(paramProtoContainer, paramProperty, AbstractBinaryClassAnnotationAndConstantLoader.PropertyRelatedElement.DELEGATE_FIELD);
  }
  
  @NotNull
  protected abstract A loadTypeAnnotation(@NotNull ProtoBuf.Annotation paramAnnotation, @NotNull NameResolver paramNameResolver);
  
  @NotNull
  public List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type paramType, @NotNull NameResolver paramNameResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "proto");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    paramType = paramType.getExtension(JvmProtoBuf.typeAnnotation);
    Intrinsics.checkExpressionValueIsNotNull(paramType, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
    Object localObject = (Iterable)paramType;
    paramType = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ProtoBuf.Annotation localAnnotation = (ProtoBuf.Annotation)((Iterator)localObject).next();
      Intrinsics.checkExpressionValueIsNotNull(localAnnotation, "it");
      paramType.add(loadTypeAnnotation(localAnnotation, paramNameResolver));
    }
    return (List)paramType;
  }
  
  @NotNull
  public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter paramTypeParameter, @NotNull NameResolver paramNameResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameter, "proto");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    paramTypeParameter = paramTypeParameter.getExtension(JvmProtoBuf.typeParameterAnnotation);
    Intrinsics.checkExpressionValueIsNotNull(paramTypeParameter, "proto.getExtension(JvmPr….typeParameterAnnotation)");
    Object localObject = (Iterable)paramTypeParameter;
    paramTypeParameter = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ProtoBuf.Annotation localAnnotation = (ProtoBuf.Annotation)((Iterator)localObject).next();
      Intrinsics.checkExpressionValueIsNotNull(localAnnotation, "it");
      paramTypeParameter.add(loadTypeAnnotation(localAnnotation, paramNameResolver));
    }
    return (List)paramTypeParameter;
  }
  
  @NotNull
  public List<A> loadValueParameterAnnotations(@NotNull ProtoContainer paramProtoContainer, @NotNull MessageLite paramMessageLite, @NotNull AnnotatedCallableKind paramAnnotatedCallableKind, int paramInt, @NotNull ProtoBuf.ValueParameter paramValueParameter)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramMessageLite, "callableProto");
    Intrinsics.checkParameterIsNotNull(paramAnnotatedCallableKind, "kind");
    Intrinsics.checkParameterIsNotNull(paramValueParameter, "proto");
    paramAnnotatedCallableKind = getCallableSignature$default(this, paramMessageLite, paramProtoContainer.getNameResolver(), paramProtoContainer.getTypeTable(), paramAnnotatedCallableKind, false, 16, null);
    if (paramAnnotatedCallableKind != null)
    {
      int i = computeJvmParameterIndexShift(paramProtoContainer, paramMessageLite);
      return findClassAndLoadMemberAnnotations$default(this, paramProtoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(paramAnnotatedCallableKind, paramInt + i), false, false, null, false, 60, null);
    }
    return CollectionsKt.emptyList();
  }
  
  @Nullable
  protected abstract C transformToUnsignedConstant(@NotNull C paramC);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
 * JD-Core Version:    0.7.0.1
 */