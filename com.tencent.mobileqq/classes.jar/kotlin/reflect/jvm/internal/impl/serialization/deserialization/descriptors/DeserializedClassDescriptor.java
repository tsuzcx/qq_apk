package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDescriptor
  extends AbstractClassDescriptor
{
  @NotNull
  private final Annotations annotations;
  @NotNull
  private final DeserializationContext c;
  private final ClassId classId;
  @NotNull
  private final ProtoBuf.Class classProto;
  private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
  private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
  private final DeclarationDescriptor containingDeclaration;
  private final DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntries;
  private final ClassKind kind;
  private final ScopesHolderForClass<DeserializedClassDescriptor.DeserializedClassMemberScope> memberScopeHolder;
  @NotNull
  private final BinaryVersion metadataVersion;
  private final Modality modality;
  private final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
  private final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
  private final SourceElement sourceElement;
  private final MemberScopeImpl staticScope;
  @NotNull
  private final ProtoContainer.Class thisAsProtoContainer;
  private final DeserializedClassDescriptor.DeserializedClassTypeConstructor typeConstructor;
  private final Visibility visibility;
  
  public DeserializedClassDescriptor(@NotNull DeserializationContext paramDeserializationContext, @NotNull ProtoBuf.Class paramClass, @NotNull NameResolver paramNameResolver, @NotNull BinaryVersion paramBinaryVersion, @NotNull SourceElement paramSourceElement)
  {
    super(paramDeserializationContext.getStorageManager(), NameResolverUtilKt.getClassId(paramNameResolver, paramClass.getFqName()).getShortClassName());
    this.classProto = paramClass;
    this.metadataVersion = paramBinaryVersion;
    this.sourceElement = paramSourceElement;
    this.classId = NameResolverUtilKt.getClassId(paramNameResolver, this.classProto.getFqName());
    this.modality = ProtoEnumFlags.INSTANCE.modality((ProtoBuf.Modality)Flags.MODALITY.get(this.classProto.getFlags()));
    this.visibility = ProtoEnumFlags.INSTANCE.visibility((ProtoBuf.Visibility)Flags.VISIBILITY.get(this.classProto.getFlags()));
    this.kind = ProtoEnumFlags.INSTANCE.classKind((ProtoBuf.Class.Kind)Flags.CLASS_KIND.get(this.classProto.getFlags()));
    paramClass = (DeclarationDescriptor)this;
    paramBinaryVersion = this.classProto.getTypeParameterList();
    Intrinsics.checkExpressionValueIsNotNull(paramBinaryVersion, "classProto.typeParameterList");
    paramSourceElement = this.classProto.getTypeTable();
    Intrinsics.checkExpressionValueIsNotNull(paramSourceElement, "classProto.typeTable");
    paramSourceElement = new TypeTable(paramSourceElement);
    Object localObject1 = VersionRequirementTable.Companion;
    Object localObject2 = this.classProto.getVersionRequirementTable();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "classProto.versionRequirementTable");
    this.c = paramDeserializationContext.childContext(paramClass, paramBinaryVersion, paramNameResolver, paramSourceElement, ((VersionRequirementTable.Companion)localObject1).create((ProtoBuf.VersionRequirementTable)localObject2), this.metadataVersion);
    if (this.kind == ClassKind.ENUM_CLASS) {
      paramClass = new StaticScopeForKotlinEnum(this.c.getStorageManager(), (ClassDescriptor)this);
    } else {
      paramClass = MemberScope.Empty.INSTANCE;
    }
    this.staticScope = ((MemberScopeImpl)paramClass);
    this.typeConstructor = new DeserializedClassDescriptor.DeserializedClassTypeConstructor(this);
    this.memberScopeHolder = ScopesHolderForClass.Companion.create((ClassDescriptor)this, this.c.getStorageManager(), this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), (Function1)new DeserializedClassDescriptor.memberScopeHolder.1((DeserializedClassDescriptor)this));
    paramClass = this.kind;
    paramBinaryVersion = ClassKind.ENUM_CLASS;
    paramNameResolver = null;
    if (paramClass == paramBinaryVersion) {
      paramClass = new DeserializedClassDescriptor.EnumEntryClassDescriptors(this);
    } else {
      paramClass = null;
    }
    this.enumEntries = paramClass;
    this.containingDeclaration = paramDeserializationContext.getContainingDeclaration();
    this.primaryConstructor = this.c.getStorageManager().createNullableLazyValue((Function0)new DeserializedClassDescriptor.primaryConstructor.1(this));
    this.constructors = this.c.getStorageManager().createLazyValue((Function0)new DeserializedClassDescriptor.constructors.1(this));
    this.companionObjectDescriptor = this.c.getStorageManager().createNullableLazyValue((Function0)new DeserializedClassDescriptor.companionObjectDescriptor.1(this));
    this.sealedSubclasses = this.c.getStorageManager().createLazyValue((Function0)new DeserializedClassDescriptor.sealedSubclasses.1(this));
    paramBinaryVersion = this.classProto;
    paramSourceElement = this.c.getNameResolver();
    localObject1 = this.c.getTypeTable();
    localObject2 = this.sourceElement;
    paramClass = this.containingDeclaration;
    paramDeserializationContext = paramClass;
    if (!(paramClass instanceof DeserializedClassDescriptor)) {
      paramDeserializationContext = null;
    }
    paramClass = (DeserializedClassDescriptor)paramDeserializationContext;
    paramDeserializationContext = paramNameResolver;
    if (paramClass != null) {
      paramDeserializationContext = paramClass.thisAsProtoContainer;
    }
    this.thisAsProtoContainer = new ProtoContainer.Class(paramBinaryVersion, paramSourceElement, (TypeTable)localObject1, (SourceElement)localObject2, paramDeserializationContext);
    if (!Flags.HAS_ANNOTATIONS.get(this.classProto.getFlags()).booleanValue()) {
      paramDeserializationContext = Annotations.Companion.getEMPTY();
    } else {
      paramDeserializationContext = (Annotations)new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), (Function0)new DeserializedClassDescriptor.annotations.1(this));
    }
    this.annotations = paramDeserializationContext;
  }
  
  private final ClassDescriptor computeCompanionObjectDescriptor()
  {
    if (!this.classProto.hasCompanionObjectName()) {
      return null;
    }
    Object localObject = NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getCompanionObjectName());
    ClassifierDescriptor localClassifierDescriptor = getMemberScope().getContributedClassifier((Name)localObject, (LookupLocation)NoLookupLocation.FROM_DESERIALIZATION);
    localObject = localClassifierDescriptor;
    if (!(localClassifierDescriptor instanceof ClassDescriptor)) {
      localObject = null;
    }
    return (ClassDescriptor)localObject;
  }
  
  private final Collection<ClassConstructorDescriptor> computeConstructors()
  {
    return (Collection)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)computeSecondaryConstructors(), (Iterable)CollectionsKt.listOfNotNull(getUnsubstitutedPrimaryConstructor())), (Iterable)this.c.getComponents().getAdditionalClassPartsProvider().getConstructors((ClassDescriptor)this));
  }
  
  private final ClassConstructorDescriptor computePrimaryConstructor()
  {
    if (this.kind.isSingleton())
    {
      localObject1 = DescriptorFactory.createPrimaryConstructorForObject((ClassDescriptor)this, SourceElement.NO_SOURCE);
      ((ClassConstructorDescriptorImpl)localObject1).setReturnType((KotlinType)getDefaultType());
      return (ClassConstructorDescriptor)localObject1;
    }
    Object localObject1 = this.classProto.getConstructorList();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "classProto.constructorList");
    Object localObject3 = ((Iterable)localObject1).iterator();
    Object localObject2;
    ProtoBuf.Constructor localConstructor;
    Flags.BooleanFlagField localBooleanFlagField;
    do
    {
      boolean bool = ((Iterator)localObject3).hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      localObject1 = ((Iterator)localObject3).next();
      localConstructor = (ProtoBuf.Constructor)localObject1;
      localBooleanFlagField = Flags.IS_SECONDARY;
      Intrinsics.checkExpressionValueIsNotNull(localConstructor, "it");
    } while (!(localBooleanFlagField.get(localConstructor.getFlags()).booleanValue() ^ true));
    break label127;
    localObject1 = null;
    label127:
    localObject3 = (ProtoBuf.Constructor)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = this.c.getMemberDeserializer().loadConstructor((ProtoBuf.Constructor)localObject3, true);
    }
    return localObject1;
  }
  
  private final List<ClassConstructorDescriptor> computeSecondaryConstructors()
  {
    Object localObject1 = this.classProto.getConstructorList();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "classProto.constructorList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (ProtoBuf.Constructor)localObject3;
      Flags.BooleanFlagField localBooleanFlagField = Flags.IS_SECONDARY;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "it");
      localObject4 = localBooleanFlagField.get(((ProtoBuf.Constructor)localObject4).getFlags());
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "Flags.IS_SECONDARY.get(it.flags)");
      if (((Boolean)localObject4).booleanValue()) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ProtoBuf.Constructor)((Iterator)localObject2).next();
      localObject4 = this.c.getMemberDeserializer();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
      ((Collection)localObject1).add(((MemberDeserializer)localObject4).loadConstructor((ProtoBuf.Constructor)localObject3, false));
    }
    return (List)localObject1;
  }
  
  private final Collection<ClassDescriptor> computeSubclassesForSealedClass()
  {
    if (this.modality != Modality.SEALED) {
      return (Collection)CollectionsKt.emptyList();
    }
    Object localObject1 = this.classProto.getSealedSubclassFqNameList();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "fqNames");
    if ((((Collection)localObject1).isEmpty() ^ true))
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Integer)((Iterator)localObject2).next();
        DeserializationComponents localDeserializationComponents = this.c.getComponents();
        NameResolver localNameResolver = this.c.getNameResolver();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "index");
        localObject3 = localDeserializationComponents.deserializeClass(NameResolverUtilKt.getClassId(localNameResolver, ((Integer)localObject3).intValue()));
        if (localObject3 != null) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      return (Collection)localObject1;
    }
    return DescriptorUtilsKt.computeSealedSubclasses((ClassDescriptor)this);
  }
  
  private final DeserializedClassDescriptor.DeserializedClassMemberScope getMemberScope()
  {
    return (DeserializedClassDescriptor.DeserializedClassMemberScope)this.memberScopeHolder.getScope(this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return this.annotations;
  }
  
  @NotNull
  public final DeserializationContext getC()
  {
    return this.c;
  }
  
  @NotNull
  public final ProtoBuf.Class getClassProto()
  {
    return this.classProto;
  }
  
  @Nullable
  public ClassDescriptor getCompanionObjectDescriptor()
  {
    return (ClassDescriptor)this.companionObjectDescriptor.invoke();
  }
  
  @NotNull
  public Collection<ClassConstructorDescriptor> getConstructors()
  {
    return (Collection)this.constructors.invoke();
  }
  
  @NotNull
  public DeclarationDescriptor getContainingDeclaration()
  {
    return this.containingDeclaration;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    return this.c.getTypeDeserializer().getOwnTypeParameters();
  }
  
  @NotNull
  public ClassKind getKind()
  {
    return this.kind;
  }
  
  @NotNull
  public final BinaryVersion getMetadataVersion()
  {
    return this.metadataVersion;
  }
  
  @NotNull
  public Modality getModality()
  {
    return this.modality;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getSealedSubclasses()
  {
    return (Collection)this.sealedSubclasses.invoke();
  }
  
  @NotNull
  public SourceElement getSource()
  {
    return this.sourceElement;
  }
  
  @NotNull
  public MemberScopeImpl getStaticScope()
  {
    return this.staticScope;
  }
  
  @NotNull
  public final ProtoContainer.Class getThisAsProtoContainer$deserialization()
  {
    return this.thisAsProtoContainer;
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    return (TypeConstructor)this.typeConstructor;
  }
  
  @NotNull
  protected MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return this.memberScopeHolder.getScope(paramKotlinTypeRefiner);
  }
  
  @Nullable
  public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor()
  {
    return (ClassConstructorDescriptor)this.primaryConstructor.invoke();
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    return this.visibility;
  }
  
  public final boolean hasNestedClass$deserialization(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return getMemberScope().getClassNames$deserialization().contains(paramName);
  }
  
  public boolean isActual()
  {
    return false;
  }
  
  public boolean isCompanionObject()
  {
    return (ProtoBuf.Class.Kind)Flags.CLASS_KIND.get(this.classProto.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
  }
  
  public boolean isData()
  {
    Boolean localBoolean = Flags.IS_DATA.get(this.classProto.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localBoolean, "Flags.IS_DATA.get(classProto.flags)");
    return localBoolean.booleanValue();
  }
  
  public boolean isExpect()
  {
    Boolean localBoolean = Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localBoolean, "Flags.IS_EXPECT_CLASS.get(classProto.flags)");
    return localBoolean.booleanValue();
  }
  
  public boolean isExternal()
  {
    Boolean localBoolean = Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localBoolean, "Flags.IS_EXTERNAL_CLASS.get(classProto.flags)");
    return localBoolean.booleanValue();
  }
  
  public boolean isInline()
  {
    Boolean localBoolean = Flags.IS_INLINE_CLASS.get(this.classProto.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localBoolean, "Flags.IS_INLINE_CLASS.get(classProto.flags)");
    return localBoolean.booleanValue();
  }
  
  public boolean isInner()
  {
    Boolean localBoolean = Flags.IS_INNER.get(this.classProto.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localBoolean, "Flags.IS_INNER.get(classProto.flags)");
    return localBoolean.booleanValue();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deserialized ");
    String str;
    if (isExpect()) {
      str = "expect";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" class ");
    localStringBuilder.append(getName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
 * JD-Core Version:    0.7.0.1
 */