package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

public class KotlinBuiltIns$FqNames
{
  public final FqNameUnsafe _boolean = fqNameUnsafe("Boolean");
  public final FqNameUnsafe _byte = fqNameUnsafe("Byte");
  public final FqNameUnsafe _char = fqNameUnsafe("Char");
  public final FqNameUnsafe _double = fqNameUnsafe("Double");
  public final FqNameUnsafe _enum = fqNameUnsafe("Enum");
  public final FqNameUnsafe _float = fqNameUnsafe("Float");
  public final FqNameUnsafe _int = fqNameUnsafe("Int");
  public final FqNameUnsafe _long = fqNameUnsafe("Long");
  public final FqNameUnsafe _short = fqNameUnsafe("Short");
  public final FqName annotation = fqName("Annotation");
  public final FqName annotationRetention = annotationName("AnnotationRetention");
  public final FqName annotationTarget = annotationName("AnnotationTarget");
  public final FqNameUnsafe any = fqNameUnsafe("Any");
  public final FqNameUnsafe array = fqNameUnsafe("Array");
  public final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
  public final FqNameUnsafe charSequence = fqNameUnsafe("CharSequence");
  public final FqNameUnsafe cloneable = fqNameUnsafe("Cloneable");
  public final FqName collection = collectionsFqName("Collection");
  public final FqName comparable = fqName("Comparable");
  public final FqName deprecated = fqName("Deprecated");
  public final FqName deprecationLevel = fqName("DeprecationLevel");
  public final FqName extensionFunctionType = fqName("ExtensionFunctionType");
  public final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
  public final FqNameUnsafe functionSupertype = fqNameUnsafe("Function");
  public final FqNameUnsafe intRange = rangesFqName("IntRange");
  public final FqName iterable = collectionsFqName("Iterable");
  public final FqName iterator = collectionsFqName("Iterator");
  public final FqNameUnsafe kCallable = reflect("KCallable");
  public final FqNameUnsafe kClass = reflect("KClass");
  public final FqNameUnsafe kDeclarationContainer = reflect("KDeclarationContainer");
  public final FqNameUnsafe kMutableProperty0 = reflect("KMutableProperty0");
  public final FqNameUnsafe kMutableProperty1 = reflect("KMutableProperty1");
  public final FqNameUnsafe kMutableProperty2 = reflect("KMutableProperty2");
  public final FqNameUnsafe kMutablePropertyFqName = reflect("KMutableProperty");
  public final ClassId kProperty = ClassId.topLevel(this.kPropertyFqName.toSafe());
  public final FqNameUnsafe kProperty0 = reflect("KProperty0");
  public final FqNameUnsafe kProperty1 = reflect("KProperty1");
  public final FqNameUnsafe kProperty2 = reflect("KProperty2");
  public final FqNameUnsafe kPropertyFqName = reflect("KProperty");
  public final FqName list = collectionsFqName("List");
  public final FqName listIterator = collectionsFqName("ListIterator");
  public final FqNameUnsafe longRange = rangesFqName("LongRange");
  public final FqName map = collectionsFqName("Map");
  public final FqName mapEntry = this.map.child(Name.identifier("Entry"));
  public final FqName mustBeDocumented = annotationName("MustBeDocumented");
  public final FqName mutableCollection = collectionsFqName("MutableCollection");
  public final FqName mutableIterable = collectionsFqName("MutableIterable");
  public final FqName mutableIterator = collectionsFqName("MutableIterator");
  public final FqName mutableList = collectionsFqName("MutableList");
  public final FqName mutableListIterator = collectionsFqName("MutableListIterator");
  public final FqName mutableMap = collectionsFqName("MutableMap");
  public final FqName mutableMapEntry = this.mutableMap.child(Name.identifier("MutableEntry"));
  public final FqName mutableSet = collectionsFqName("MutableSet");
  public final FqNameUnsafe nothing = fqNameUnsafe("Nothing");
  public final FqNameUnsafe number = fqNameUnsafe("Number");
  public final FqName parameterName = fqName("ParameterName");
  public final Set<Name> primitiveArrayTypeShortNames = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
  public final Set<Name> primitiveTypeShortNames = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
  public final FqName publishedApi = fqName("PublishedApi");
  public final FqName repeatable = annotationName("Repeatable");
  public final FqName replaceWith = fqName("ReplaceWith");
  public final FqName retention = annotationName("Retention");
  public final FqName set = collectionsFqName("Set");
  public final FqNameUnsafe string = fqNameUnsafe("String");
  public final FqName suppress = fqName("Suppress");
  public final FqName target = annotationName("Target");
  public final FqName throwable = fqName("Throwable");
  public final ClassId uByte = ClassId.topLevel(this.uByteFqName);
  public final FqName uByteFqName = fqName("UByte");
  public final ClassId uInt = ClassId.topLevel(this.uIntFqName);
  public final FqName uIntFqName = fqName("UInt");
  public final ClassId uLong = ClassId.topLevel(this.uLongFqName);
  public final FqName uLongFqName = fqName("ULong");
  public final ClassId uShort = ClassId.topLevel(this.uShortFqName);
  public final FqName uShortFqName = fqName("UShort");
  public final FqNameUnsafe unit = fqNameUnsafe("Unit");
  public final FqName unsafeVariance = fqName("UnsafeVariance");
  
  public KotlinBuiltIns$FqNames()
  {
    PrimitiveType[] arrayOfPrimitiveType = PrimitiveType.values();
    int j = arrayOfPrimitiveType.length;
    int i = 0;
    while (i < j)
    {
      PrimitiveType localPrimitiveType = arrayOfPrimitiveType[i];
      this.primitiveTypeShortNames.add(localPrimitiveType.getTypeName());
      this.primitiveArrayTypeShortNames.add(localPrimitiveType.getArrayTypeName());
      this.fqNameToPrimitiveType.put(fqNameUnsafe(localPrimitiveType.getTypeName().asString()), localPrimitiveType);
      this.arrayClassFqNameToPrimitiveType.put(fqNameUnsafe(localPrimitiveType.getArrayTypeName().asString()), localPrimitiveType);
      i += 1;
    }
  }
  
  @NotNull
  private static FqName annotationName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(10);
    }
    paramString = KotlinBuiltIns.access$100().child(Name.identifier(paramString));
    if (paramString == null) {
      $$$reportNull$$$0(11);
    }
    return paramString;
  }
  
  @NotNull
  private static FqName collectionsFqName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(4);
    }
    paramString = KotlinBuiltIns.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(paramString));
    if (paramString == null) {
      $$$reportNull$$$0(5);
    }
    return paramString;
  }
  
  @NotNull
  private static FqName fqName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(2);
    }
    paramString = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(paramString));
    if (paramString == null) {
      $$$reportNull$$$0(3);
    }
    return paramString;
  }
  
  @NotNull
  private static FqNameUnsafe fqNameUnsafe(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(0);
    }
    paramString = fqName(paramString).toUnsafe();
    if (paramString == null) {
      $$$reportNull$$$0(1);
    }
    return paramString;
  }
  
  @NotNull
  private static FqNameUnsafe rangesFqName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(6);
    }
    paramString = KotlinBuiltIns.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(paramString)).toUnsafe();
    if (paramString == null) {
      $$$reportNull$$$0(7);
    }
    return paramString;
  }
  
  @NotNull
  private static FqNameUnsafe reflect(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(8);
    }
    paramString = ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME().child(Name.identifier(paramString)).toUnsafe();
    if (paramString == null) {
      $$$reportNull$$$0(9);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames
 * JD-Core Version:    0.7.0.1
 */