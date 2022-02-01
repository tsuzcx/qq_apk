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
      Object localObject = (Pair)paramAttribPool.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i);
      JsonArray localJsonArray = new JsonArray();
      localJsonArray.add((String)((Pair)localObject).first);
      localJsonArray.add((String)((Pair)localObject).second);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      paramJsonSerializationContext.add(((StringBuilder)localObject).toString(), localJsonArray);
      i += 1;
    }
    paramType.add("numToAttrib", paramJsonSerializationContext);
    paramType.addProperty("nextNum", Integer.valueOf(paramAttribPool.jdField_a_of_type_Int));
    return paramType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.AttribPool.1
 * JD-Core Version:    0.7.0.1
 */