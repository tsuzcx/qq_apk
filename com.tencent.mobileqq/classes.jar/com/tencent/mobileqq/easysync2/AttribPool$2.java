package com.tencent.mobileqq.easysync2;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.util.Pair;
import java.lang.reflect.Type;

final class AttribPool$2
  implements JsonDeserializer<AttribPool>
{
  public AttribPool a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
  {
    paramType = paramJsonElement.getAsJsonObject();
    paramJsonElement = new AttribPool();
    paramJsonElement.c = paramType.get("nextNum").getAsInt();
    paramType = paramType.get("numToAttrib").getAsJsonObject();
    int i = 0;
    while (i < paramJsonElement.c)
    {
      paramJsonDeserializationContext = new StringBuilder();
      paramJsonDeserializationContext.append(i);
      paramJsonDeserializationContext.append("");
      Object localObject = paramType.get(paramJsonDeserializationContext.toString()).getAsJsonArray();
      paramJsonDeserializationContext = ((JsonArray)localObject).get(0).getAsString();
      localObject = ((JsonArray)localObject).get(1).getAsString();
      paramJsonElement.a.put(i, new Pair(paramJsonDeserializationContext, localObject));
      paramJsonElement.b.put(AttribPool.a(paramJsonDeserializationContext, (String)localObject), Integer.valueOf(i));
      i += 1;
    }
    return paramJsonElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.AttribPool.2
 * JD-Core Version:    0.7.0.1
 */