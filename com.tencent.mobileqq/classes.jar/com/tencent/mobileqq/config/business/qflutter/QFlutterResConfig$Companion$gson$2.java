package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class QFlutterResConfig$Companion$gson$2
  extends Lambda
  implements Function0<Gson>
{
  public static final 2 INSTANCE = new 2();
  
  QFlutterResConfig$Companion$gson$2()
  {
    super(0);
  }
  
  public final Gson invoke()
  {
    return new GsonBuilder().registerTypeAdapter((Type)PreloadEngineOption.class, new PreloadEngineOptionAdapter()).registerTypeAdapter((Type)ExpandModuleKey.class, new ExpandModuleAdapter()).create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig.Companion.gson.2
 * JD-Core Version:    0.7.0.1
 */