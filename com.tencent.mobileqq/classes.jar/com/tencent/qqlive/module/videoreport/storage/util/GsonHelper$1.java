package com.tencent.qqlive.module.videoreport.storage.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

final class GsonHelper$1
  implements JsonSerializer<Number>
{
  public JsonElement a(Number paramNumber, Type paramType, JsonSerializationContext paramJsonSerializationContext)
  {
    return new JsonPrimitive(String.valueOf(paramNumber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.util.GsonHelper.1
 * JD-Core Version:    0.7.0.1
 */