package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

public enum KotlinTarget
{
  @NotNull
  private static final Set<KotlinTarget> ALL_TARGET_SET = ArraysKt.toSet(values());
  public static final KotlinTarget.Companion Companion;
  @NotNull
  private static final Set<KotlinTarget> DEFAULT_TARGET_SET;
  @NotNull
  private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = MapsKt.mapOf(new Pair[] { TuplesKt.to(AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.FIELD, FIELD), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, PROPERTY), TuplesKt.to(AnnotationUseSiteTarget.FILE, FILE), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, FIELD) });
  private static final HashMap<String, KotlinTarget> map;
  @NotNull
  private final String description;
  private final boolean isDefault;
  
  static
  {
    Object localObject1 = new KotlinTarget("CLASS", 0, "class", false, 2, null);
    CLASS = (KotlinTarget)localObject1;
    Object localObject2 = new KotlinTarget("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
    ANNOTATION_CLASS = (KotlinTarget)localObject2;
    KotlinTarget localKotlinTarget1 = new KotlinTarget("TYPE_PARAMETER", 2, "type parameter", false);
    TYPE_PARAMETER = localKotlinTarget1;
    KotlinTarget localKotlinTarget2 = new KotlinTarget("PROPERTY", 3, "property", false, 2, null);
    PROPERTY = localKotlinTarget2;
    KotlinTarget localKotlinTarget3 = new KotlinTarget("FIELD", 4, "field", false, 2, null);
    FIELD = localKotlinTarget3;
    KotlinTarget localKotlinTarget4 = new KotlinTarget("LOCAL_VARIABLE", 5, "local variable", false, 2, null);
    LOCAL_VARIABLE = localKotlinTarget4;
    KotlinTarget localKotlinTarget5 = new KotlinTarget("VALUE_PARAMETER", 6, "value parameter", false, 2, null);
    VALUE_PARAMETER = localKotlinTarget5;
    KotlinTarget localKotlinTarget6 = new KotlinTarget("CONSTRUCTOR", 7, "constructor", false, 2, null);
    CONSTRUCTOR = localKotlinTarget6;
    KotlinTarget localKotlinTarget7 = new KotlinTarget("FUNCTION", 8, "function", false, 2, null);
    FUNCTION = localKotlinTarget7;
    KotlinTarget localKotlinTarget8 = new KotlinTarget("PROPERTY_GETTER", 9, "getter", false, 2, null);
    PROPERTY_GETTER = localKotlinTarget8;
    KotlinTarget localKotlinTarget9 = new KotlinTarget("PROPERTY_SETTER", 10, "setter", false, 2, null);
    PROPERTY_SETTER = localKotlinTarget9;
    KotlinTarget localKotlinTarget10 = new KotlinTarget("TYPE", 11, "type usage", false);
    TYPE = localKotlinTarget10;
    KotlinTarget localKotlinTarget11 = new KotlinTarget("EXPRESSION", 12, "expression", false);
    EXPRESSION = localKotlinTarget11;
    KotlinTarget localKotlinTarget12 = new KotlinTarget("FILE", 13, "file", false);
    FILE = localKotlinTarget12;
    KotlinTarget localKotlinTarget13 = new KotlinTarget("TYPEALIAS", 14, "typealias", false);
    TYPEALIAS = localKotlinTarget13;
    KotlinTarget localKotlinTarget14 = new KotlinTarget("TYPE_PROJECTION", 15, "type projection", false);
    TYPE_PROJECTION = localKotlinTarget14;
    KotlinTarget localKotlinTarget15 = new KotlinTarget("STAR_PROJECTION", 16, "star projection", false);
    STAR_PROJECTION = localKotlinTarget15;
    KotlinTarget localKotlinTarget16 = new KotlinTarget("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    PROPERTY_PARAMETER = localKotlinTarget16;
    KotlinTarget localKotlinTarget17 = new KotlinTarget("CLASS_ONLY", 18, "class", false);
    CLASS_ONLY = localKotlinTarget17;
    KotlinTarget localKotlinTarget18 = new KotlinTarget("OBJECT", 19, "object", false);
    OBJECT = localKotlinTarget18;
    KotlinTarget localKotlinTarget19 = new KotlinTarget("COMPANION_OBJECT", 20, "companion object", false);
    COMPANION_OBJECT = localKotlinTarget19;
    KotlinTarget localKotlinTarget20 = new KotlinTarget("INTERFACE", 21, "interface", false);
    INTERFACE = localKotlinTarget20;
    KotlinTarget localKotlinTarget21 = new KotlinTarget("ENUM_CLASS", 22, "enum class", false);
    ENUM_CLASS = localKotlinTarget21;
    KotlinTarget localKotlinTarget22 = new KotlinTarget("ENUM_ENTRY", 23, "enum entry", false);
    ENUM_ENTRY = localKotlinTarget22;
    KotlinTarget localKotlinTarget23 = new KotlinTarget("LOCAL_CLASS", 24, "local class", false);
    LOCAL_CLASS = localKotlinTarget23;
    KotlinTarget localKotlinTarget24 = new KotlinTarget("LOCAL_FUNCTION", 25, "local function", false);
    LOCAL_FUNCTION = localKotlinTarget24;
    KotlinTarget localKotlinTarget25 = new KotlinTarget("MEMBER_FUNCTION", 26, "member function", false);
    MEMBER_FUNCTION = localKotlinTarget25;
    KotlinTarget localKotlinTarget26 = new KotlinTarget("TOP_LEVEL_FUNCTION", 27, "top level function", false);
    TOP_LEVEL_FUNCTION = localKotlinTarget26;
    KotlinTarget localKotlinTarget27 = new KotlinTarget("MEMBER_PROPERTY", 28, "member property", false);
    MEMBER_PROPERTY = localKotlinTarget27;
    KotlinTarget localKotlinTarget28 = new KotlinTarget("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
    MEMBER_PROPERTY_WITH_BACKING_FIELD = localKotlinTarget28;
    KotlinTarget localKotlinTarget29 = new KotlinTarget("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
    MEMBER_PROPERTY_WITH_DELEGATE = localKotlinTarget29;
    KotlinTarget localKotlinTarget30 = new KotlinTarget("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = localKotlinTarget30;
    KotlinTarget localKotlinTarget31 = new KotlinTarget("TOP_LEVEL_PROPERTY", 32, "top level property", false);
    TOP_LEVEL_PROPERTY = localKotlinTarget31;
    KotlinTarget localKotlinTarget32 = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = localKotlinTarget32;
    KotlinTarget localKotlinTarget33 = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
    TOP_LEVEL_PROPERTY_WITH_DELEGATE = localKotlinTarget33;
    KotlinTarget localKotlinTarget34 = new KotlinTarget("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = localKotlinTarget34;
    KotlinTarget localKotlinTarget35 = new KotlinTarget("INITIALIZER", 36, "initializer", false);
    INITIALIZER = localKotlinTarget35;
    KotlinTarget localKotlinTarget36 = new KotlinTarget("DESTRUCTURING_DECLARATION", 37, "destructuring declaration", false);
    DESTRUCTURING_DECLARATION = localKotlinTarget36;
    KotlinTarget localKotlinTarget37 = new KotlinTarget("LAMBDA_EXPRESSION", 38, "lambda expression", false);
    LAMBDA_EXPRESSION = localKotlinTarget37;
    KotlinTarget localKotlinTarget38 = new KotlinTarget("ANONYMOUS_FUNCTION", 39, "anonymous function", false);
    ANONYMOUS_FUNCTION = localKotlinTarget38;
    KotlinTarget localKotlinTarget39 = new KotlinTarget("OBJECT_LITERAL", 40, "object literal", false);
    OBJECT_LITERAL = localKotlinTarget39;
    $VALUES = new KotlinTarget[] { localObject1, localObject2, localKotlinTarget1, localKotlinTarget2, localKotlinTarget3, localKotlinTarget4, localKotlinTarget5, localKotlinTarget6, localKotlinTarget7, localKotlinTarget8, localKotlinTarget9, localKotlinTarget10, localKotlinTarget11, localKotlinTarget12, localKotlinTarget13, localKotlinTarget14, localKotlinTarget15, localKotlinTarget16, localKotlinTarget17, localKotlinTarget18, localKotlinTarget19, localKotlinTarget20, localKotlinTarget21, localKotlinTarget22, localKotlinTarget23, localKotlinTarget24, localKotlinTarget25, localKotlinTarget26, localKotlinTarget27, localKotlinTarget28, localKotlinTarget29, localKotlinTarget30, localKotlinTarget31, localKotlinTarget32, localKotlinTarget33, localKotlinTarget34, localKotlinTarget35, localKotlinTarget36, localKotlinTarget37, localKotlinTarget38, localKotlinTarget39 };
    Companion = new KotlinTarget.Companion(null);
    map = new HashMap();
    localObject1 = values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      ((Map)map).put(((KotlinTarget)localObject2).name(), localObject2);
      i += 1;
    }
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localKotlinTarget1 = localObject1[i];
      if (localKotlinTarget1.isDefault) {
        ((Collection)localObject2).add(localKotlinTarget1);
      }
      i += 1;
    }
    DEFAULT_TARGET_SET = CollectionsKt.toSet((Iterable)localObject2);
  }
  
  private KotlinTarget(String paramString, boolean paramBoolean)
  {
    this.description = paramString;
    this.isDefault = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget
 * JD-Core Version:    0.7.0.1
 */