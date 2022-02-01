package com.tencent.mobileqq.easysync2;

import android.support.v4.util.SparseArrayCompat;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.util.Pair;
import java.lang.reflect.Type;

final class AttribPool$1
  implements JsonSerializer<AttribPool>
{
  public JsonElement a(AttribPool paramAttribPool, Type paramType, JsonSerializationContext paramJsonSerializationContext)
  {
    paramType = new JsonObject();
    paramJsonSerializationContext = new JsonObject();
    int i = 0;
    while (i < paramAttribPool.jdField_a_of_type_Int)
    {
      Pair localPair = (Pair)paramAttribPool.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i);
      JsonArray localJsonArray = new JsonArray();
      localJsonArray.add((String)localPair.first);
      localJsonArray.add((String)localPair.second);
      paramJsonSerializationContext.add(i + "", localJsonArray);
      i += 1;
    }
    paramType.add("numToAttrib", paramJsonSerializationContext);
    paramType.addProperty("nextNum", Integer.valueOf(paramAttribPool.jdField_a_of_type_Int));
    return paramType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.AttribPool.1
 * JD-Core Version:    0.7.0.1
 */