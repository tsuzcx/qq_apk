package com.tencent.videocut.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/GsonUtils;", "", "()V", "TAG", "", "TEST_DATA_DIR", "TWO", "", "gson", "Lcom/google/gson/Gson;", "clone", "T", "t", "(Ljava/lang/Object;)Ljava/lang/Object;", "confirmValueIsArray", "", "fatherNode", "Lcom/google/gson/JsonObject;", "key", "getBoolean", "", "jsonObject", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getDouble", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Double;", "getInteger", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "getIntegerValue", "getJsonObject", "getLongValue", "", "getObjectFromFile", "fileName", "classOfT", "Ljava/lang/Class;", "gsonBuilder", "Lcom/google/gson/GsonBuilder;", "(Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/GsonBuilder;)Ljava/lang/Object;", "getString", "getStringFromFile", "json2Map", "", "json", "json2Obj", "clazz", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "cls", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "json2ObjList", "", "jsonString", "map2Json", "map", "obj2Json", "obj", "(Ljava/lang/Object;)Ljava/lang/String;", "tTYpe", "(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;", "(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;", "(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;", "obj2Map", "objList2Json", "list", "saveObjectToFile", "sourceObject", "str2JsonArray", "Lcom/google/gson/JsonArray;", "str2Obj", "string2JsonString", "args", "", "([Ljava/lang/String;)Ljava/lang/String;", "string2JsonStringWithOrigin", "origin", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "toJsonTree", "Lcom/google/gson/JsonElement;", "src", "MapDeserializerDoubleAsIntFix", "ProxyJsonReader", "SuperclassExclusionStrategy", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class GsonUtils
{
  @NotNull
  public static final GsonUtils a = new GsonUtils();
  private static Gson b;
  
  static
  {
    Gson localGson = new GsonBuilder().serializeSpecialFloatingPointValues().serializeNulls().create();
    Intrinsics.checkNotNullExpressionValue(localGson, "GsonBuilder().serializeS…serializeNulls().create()");
    b = localGson;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.GsonUtils
 * JD-Core Version:    0.7.0.1
 */