package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaAnnotationTargetMapper
{
  public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
  private static final Map<String, KotlinRetention> retentionNameList = MapsKt.mapOf(new Pair[] { TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE) });
  private static final Map<String, EnumSet<KotlinTarget>> targetNameLists = MapsKt.mapOf(new Pair[] { TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of((Enum)KotlinTarget.CLASS, (Enum)KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of((Enum)KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of((Enum)KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of((Enum)KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of((Enum)KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of((Enum)KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of((Enum)KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of((Enum)KotlinTarget.FUNCTION, (Enum)KotlinTarget.PROPERTY_GETTER, (Enum)KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of((Enum)KotlinTarget.TYPE)) });
  
  @Nullable
  public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(@Nullable JavaAnnotationArgument paramJavaAnnotationArgument)
  {
    boolean bool = paramJavaAnnotationArgument instanceof JavaEnumValueAnnotationArgument;
    Name localName = null;
    if (!bool) {
      paramJavaAnnotationArgument = null;
    }
    JavaEnumValueAnnotationArgument localJavaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument)paramJavaAnnotationArgument;
    paramJavaAnnotationArgument = localName;
    if (localJavaEnumValueAnnotationArgument != null)
    {
      Object localObject = retentionNameList;
      paramJavaAnnotationArgument = localJavaEnumValueAnnotationArgument.getEntryName();
      if (paramJavaAnnotationArgument != null) {
        paramJavaAnnotationArgument = paramJavaAnnotationArgument.asString();
      } else {
        paramJavaAnnotationArgument = null;
      }
      localObject = (KotlinRetention)((Map)localObject).get(paramJavaAnnotationArgument);
      paramJavaAnnotationArgument = localName;
      if (localObject != null)
      {
        paramJavaAnnotationArgument = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.annotationRetention);
        Intrinsics.checkExpressionValueIsNotNull(paramJavaAnnotationArgument, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
        localName = Name.identifier(((KotlinRetention)localObject).name());
        Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(retention.name)");
        paramJavaAnnotationArgument = new EnumValue(paramJavaAnnotationArgument, localName);
      }
    }
    return (ConstantValue)paramJavaAnnotationArgument;
  }
  
  @NotNull
  public final Set<KotlinTarget> mapJavaTargetArgumentByName(@Nullable String paramString)
  {
    paramString = (EnumSet)targetNameLists.get(paramString);
    if (paramString != null) {
      return (Set)paramString;
    }
    return SetsKt.emptySet();
  }
  
  @NotNull
  public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(@NotNull List<? extends JavaAnnotationArgument> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof JavaEnumValueAnnotationArgument)) {
        paramList.add(localObject2);
      }
    }
    paramList = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      paramList = (JavaEnumValueAnnotationArgument)((Iterator)localObject2).next();
      localObject3 = INSTANCE;
      paramList = paramList.getEntryName();
      if (paramList != null) {
        paramList = paramList.asString();
      } else {
        paramList = null;
      }
      CollectionsKt.addAll((Collection)localObject1, (Iterable)((JavaAnnotationTargetMapper)localObject3).mapJavaTargetArgumentByName(paramList));
    }
    localObject1 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (KotlinTarget)((Iterator)localObject1).next();
      localObject2 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.annotationTarget);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
      localObject3 = Name.identifier(((KotlinTarget)localObject3).name());
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "Name.identifier(kotlinTarget.name)");
      paramList.add(new EnumValue((ClassId)localObject2, (Name)localObject3));
    }
    return (ConstantValue)new ArrayValue((List)paramList, (Function1)JavaAnnotationTargetMapper.mapJavaTargetArguments.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper
 * JD-Core Version:    0.7.0.1
 */