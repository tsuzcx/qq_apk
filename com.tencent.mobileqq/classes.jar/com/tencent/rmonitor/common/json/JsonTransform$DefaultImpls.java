package com.tencent.rmonitor.common.json;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
public final class JsonTransform$DefaultImpls
{
  @NotNull
  public static String a(JsonTransform paramJsonTransform)
  {
    paramJsonTransform = new Gson().toJson(paramJsonTransform);
    Intrinsics.checkExpressionValueIsNotNull(paramJsonTransform, "Gson().toJson(this)");
    return paramJsonTransform;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.json.JsonTransform.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */