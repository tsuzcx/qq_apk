package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory.Companion;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionTypesKt
{
  @JvmOverloads
  @NotNull
  public static final SimpleType createFunctionType(@NotNull KotlinBuiltIns paramKotlinBuiltIns, @NotNull Annotations paramAnnotations, @Nullable KotlinType paramKotlinType1, @NotNull List<? extends KotlinType> paramList, @Nullable List<Name> paramList1, @NotNull KotlinType paramKotlinType2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinBuiltIns, "builtIns");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramList, "parameterTypes");
    Intrinsics.checkParameterIsNotNull(paramKotlinType2, "returnType");
    paramKotlinType2 = getFunctionTypeArgumentProjections(paramKotlinType1, paramList, paramList1, paramKotlinType2, paramKotlinBuiltIns);
    int i = paramList.size();
    if (paramKotlinType1 != null) {
      i += 1;
    }
    if (paramBoolean) {
      paramList = paramKotlinBuiltIns.getSuspendFunction(i);
    } else {
      paramList = paramKotlinBuiltIns.getFunction(i);
    }
    Intrinsics.checkExpressionValueIsNotNull(paramList, "if (suspendFunction) bui…tFunction(parameterCount)");
    paramList1 = paramAnnotations;
    if (paramKotlinType1 != null)
    {
      paramKotlinType1 = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
      Intrinsics.checkExpressionValueIsNotNull(paramKotlinType1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
      if (paramAnnotations.findAnnotation(paramKotlinType1) != null)
      {
        paramList1 = paramAnnotations;
      }
      else
      {
        paramKotlinType1 = Annotations.Companion;
        paramAnnotations = (Iterable)paramAnnotations;
        paramList1 = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
        Intrinsics.checkExpressionValueIsNotNull(paramList1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        paramList1 = paramKotlinType1.create(kotlin.collections.CollectionsKt.plus(paramAnnotations, new BuiltInAnnotationDescriptor(paramKotlinBuiltIns, paramList1, MapsKt.emptyMap())));
      }
    }
    return KotlinTypeFactory.simpleNotNullType(paramList1, paramList, paramKotlinType2);
  }
  
  @Nullable
  public static final Name extractParameterNameFromFunctionTypeArgument(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$extractParameterNameFromFunctionTypeArgument");
    paramKotlinType = paramKotlinType.getAnnotations();
    Object localObject = KotlinBuiltIns.FQ_NAMES.parameterName;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "KotlinBuiltIns.FQ_NAMES.parameterName");
    paramKotlinType = paramKotlinType.findAnnotation((FqName)localObject);
    if (paramKotlinType != null)
    {
      localObject = kotlin.collections.CollectionsKt.singleOrNull((Iterable)paramKotlinType.getAllValueArguments().values());
      paramKotlinType = (KotlinType)localObject;
      if (!(localObject instanceof StringValue)) {
        paramKotlinType = null;
      }
      paramKotlinType = (StringValue)paramKotlinType;
      if (paramKotlinType != null)
      {
        paramKotlinType = (String)paramKotlinType.getValue();
        if (paramKotlinType != null)
        {
          if (!Name.isValidIdentifier(paramKotlinType)) {
            paramKotlinType = null;
          }
          if (paramKotlinType != null) {
            return Name.identifier(paramKotlinType);
          }
        }
      }
    }
    return null;
  }
  
  @NotNull
  public static final List<TypeProjection> getFunctionTypeArgumentProjections(@Nullable KotlinType paramKotlinType1, @NotNull List<? extends KotlinType> paramList, @Nullable List<Name> paramList1, @NotNull KotlinType paramKotlinType2, @NotNull KotlinBuiltIns paramKotlinBuiltIns)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "parameterTypes");
    Intrinsics.checkParameterIsNotNull(paramKotlinType2, "returnType");
    Intrinsics.checkParameterIsNotNull(paramKotlinBuiltIns, "builtIns");
    int k = paramList.size();
    int j = 0;
    if (paramKotlinType1 != null) {
      i = 1;
    } else {
      i = 0;
    }
    ArrayList localArrayList = new ArrayList(k + i + 1);
    Collection localCollection = (Collection)localArrayList;
    if (paramKotlinType1 != null) {
      paramKotlinType1 = TypeUtilsKt.asTypeProjection(paramKotlinType1);
    } else {
      paramKotlinType1 = null;
    }
    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(localCollection, paramKotlinType1);
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = j;
    while (localIterator.hasNext())
    {
      paramKotlinType1 = localIterator.next();
      if (i < 0) {
        kotlin.collections.CollectionsKt.throwIndexOverflow();
      }
      KotlinType localKotlinType = (KotlinType)paramKotlinType1;
      if (paramList1 != null)
      {
        paramKotlinType1 = (Name)paramList1.get(i);
        if ((paramKotlinType1 != null) && (!paramKotlinType1.isSpecial())) {}
      }
      else
      {
        paramKotlinType1 = null;
      }
      paramList = localKotlinType;
      if (paramKotlinType1 != null)
      {
        paramList = KotlinBuiltIns.FQ_NAMES.parameterName;
        Intrinsics.checkExpressionValueIsNotNull(paramList, "KotlinBuiltIns.FQ_NAMES.parameterName");
        Name localName = Name.identifier("name");
        paramKotlinType1 = paramKotlinType1.asString();
        Intrinsics.checkExpressionValueIsNotNull(paramKotlinType1, "name.asString()");
        paramKotlinType1 = new BuiltInAnnotationDescriptor(paramKotlinBuiltIns, paramList, MapsKt.mapOf(TuplesKt.to(localName, new StringValue(paramKotlinType1))));
        paramList = TypeUtilsKt.replaceAnnotations(localKotlinType, Annotations.Companion.create(kotlin.collections.CollectionsKt.plus((Iterable)localKotlinType.getAnnotations(), paramKotlinType1)));
      }
      localCollection.add(TypeUtilsKt.asTypeProjection(paramList));
      i += 1;
    }
    localArrayList.add(TypeUtilsKt.asTypeProjection(paramKotlinType2));
    return (List)localArrayList;
  }
  
  @Nullable
  public static final FunctionClassDescriptor.Kind getFunctionalClassKind(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$getFunctionalClassKind");
    if (!(paramDeclarationDescriptor instanceof ClassDescriptor)) {
      return null;
    }
    if (!KotlinBuiltIns.isUnderKotlinPackage(paramDeclarationDescriptor)) {
      return null;
    }
    return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(paramDeclarationDescriptor));
  }
  
  private static final FunctionClassDescriptor.Kind getFunctionalClassKind(@NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    if ((paramFqNameUnsafe.isSafe()) && (!paramFqNameUnsafe.isRoot()))
    {
      BuiltInFictitiousFunctionClassFactory.Companion localCompanion = BuiltInFictitiousFunctionClassFactory.Companion;
      String str = paramFqNameUnsafe.shortName().asString();
      Intrinsics.checkExpressionValueIsNotNull(str, "shortName().asString()");
      paramFqNameUnsafe = paramFqNameUnsafe.toSafe().parent();
      Intrinsics.checkExpressionValueIsNotNull(paramFqNameUnsafe, "toSafe().parent()");
      return localCompanion.getFunctionalClassKind(str, paramFqNameUnsafe);
    }
    return null;
  }
  
  @Nullable
  public static final KotlinType getReceiverTypeFromFunctionType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getReceiverTypeFromFunctionType");
    boolean bool = isBuiltinFunctionalType(paramKotlinType);
    if ((_Assertions.ENABLED) && (!bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Not a function type: ");
      localStringBuilder.append(paramKotlinType);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
    if (isTypeAnnotatedWithExtensionFunctionType(paramKotlinType)) {
      return ((TypeProjection)kotlin.collections.CollectionsKt.first(paramKotlinType.getArguments())).getType();
    }
    return null;
  }
  
  @NotNull
  public static final KotlinType getReturnTypeFromFunctionType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getReturnTypeFromFunctionType");
    boolean bool = isBuiltinFunctionalType(paramKotlinType);
    if ((_Assertions.ENABLED) && (!bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Not a function type: ");
      localStringBuilder.append(paramKotlinType);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
    paramKotlinType = ((TypeProjection)kotlin.collections.CollectionsKt.last(paramKotlinType.getArguments())).getType();
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "arguments.last().type");
    return paramKotlinType;
  }
  
  @NotNull
  public static final List<TypeProjection> getValueParameterTypesFromFunctionType(@NotNull KotlinType paramKotlinType)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean isBuiltinExtensionFunctionalType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isBuiltinExtensionFunctionalType");
    return (isBuiltinFunctionalType(paramKotlinType)) && (isTypeAnnotatedWithExtensionFunctionType(paramKotlinType));
  }
  
  public static final boolean isBuiltinFunctionalType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isBuiltinFunctionalType");
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType != null) {
      paramKotlinType = getFunctionalClassKind((DeclarationDescriptor)paramKotlinType);
    } else {
      paramKotlinType = null;
    }
    return (paramKotlinType == FunctionClassDescriptor.Kind.Function) || (paramKotlinType == FunctionClassDescriptor.Kind.SuspendFunction);
  }
  
  public static final boolean isFunctionType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isFunctionType");
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType != null) {
      paramKotlinType = getFunctionalClassKind((DeclarationDescriptor)paramKotlinType);
    } else {
      paramKotlinType = null;
    }
    return paramKotlinType == FunctionClassDescriptor.Kind.Function;
  }
  
  public static final boolean isSuspendFunctionType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isSuspendFunctionType");
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType != null) {
      paramKotlinType = getFunctionalClassKind((DeclarationDescriptor)paramKotlinType);
    } else {
      paramKotlinType = null;
    }
    return paramKotlinType == FunctionClassDescriptor.Kind.SuspendFunction;
  }
  
  private static final boolean isTypeAnnotatedWithExtensionFunctionType(@NotNull KotlinType paramKotlinType)
  {
    paramKotlinType = paramKotlinType.getAnnotations();
    FqName localFqName = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
    return paramKotlinType.findAnnotation(localFqName) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt
 * JD-Core Version:    0.7.0.1
 */