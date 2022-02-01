package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsSettings$Companion
{
  private final Set<String> buildPrimitiveStringConstructorsSet()
  {
    SignatureBuildingComponents localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    Object localObject = (Iterable)CollectionsKt.listOf(new JvmPrimitiveType[] { JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT });
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((JvmPrimitiveType)((Iterator)localObject).next()).getWrapperFqName().shortName().asString();
      Intrinsics.checkExpressionValueIsNotNull(str, "it.wrapperFqName.shortName().asString()");
      String[] arrayOfString = localSignatureBuildingComponents.constructors(new String[] { "Ljava/lang/String;" });
      CollectionsKt.addAll(localCollection, (Iterable)localSignatureBuildingComponents.inJavaLang(str, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
    }
    return (Set)localCollection;
  }
  
  private final Set<String> buildPrimitiveValueMethodsSet()
  {
    SignatureBuildingComponents localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    Object localObject = (Iterable)CollectionsKt.listOf(new JvmPrimitiveType[] { JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR });
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      JvmPrimitiveType localJvmPrimitiveType = (JvmPrimitiveType)((Iterator)localObject).next();
      String str = localJvmPrimitiveType.getWrapperFqName().shortName().asString();
      Intrinsics.checkExpressionValueIsNotNull(str, "it.wrapperFqName.shortName().asString()");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localJvmPrimitiveType.getJavaKeywordName());
      localStringBuilder.append("Value()");
      localStringBuilder.append(localJvmPrimitiveType.getDesc());
      CollectionsKt.addAll(localCollection, (Iterable)localSignatureBuildingComponents.inJavaLang(str, new String[] { localStringBuilder.toString() }));
    }
    return (Set)localCollection;
  }
  
  private final boolean isArrayOrPrimitiveArray(FqNameUnsafe paramFqNameUnsafe)
  {
    return (Intrinsics.areEqual(paramFqNameUnsafe, KotlinBuiltIns.FQ_NAMES.array)) || (KotlinBuiltIns.isPrimitiveArray(paramFqNameUnsafe));
  }
  
  @NotNull
  public final Set<String> getBLACK_LIST_METHOD_SIGNATURES()
  {
    return JvmBuiltInsSettings.access$getBLACK_LIST_METHOD_SIGNATURES$cp();
  }
  
  @NotNull
  public final Set<String> getDROP_LIST_METHOD_SIGNATURES()
  {
    return JvmBuiltInsSettings.access$getDROP_LIST_METHOD_SIGNATURES$cp();
  }
  
  @NotNull
  public final Set<String> getWHITE_LIST_METHOD_SIGNATURES()
  {
    return JvmBuiltInsSettings.access$getWHITE_LIST_METHOD_SIGNATURES$cp();
  }
  
  public final boolean isSerializableInJava(@NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    Intrinsics.checkParameterIsNotNull(paramFqNameUnsafe, "fqName");
    if (((Companion)this).isArrayOrPrimitiveArray(paramFqNameUnsafe)) {
      return true;
    }
    paramFqNameUnsafe = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(paramFqNameUnsafe);
    if (paramFqNameUnsafe != null) {}
    try
    {
      paramFqNameUnsafe = Class.forName(paramFqNameUnsafe.asSingleFqName().asString());
      return Serializable.class.isAssignableFrom(paramFqNameUnsafe);
    }
    catch (ClassNotFoundException paramFqNameUnsafe) {}
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.Companion
 * JD-Core Version:    0.7.0.1
 */