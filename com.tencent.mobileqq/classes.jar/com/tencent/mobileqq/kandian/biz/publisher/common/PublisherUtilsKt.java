package com.tencent.mobileqq.kandian.biz.publisher.common;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"putAll", "", "Lorg/json/JSONObject;", "extra", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class PublisherUtilsKt
{
  private static final void b(@NotNull JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Iterator localIterator = paramJSONObject2.keys();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = paramJSONObject2.get((String)localObject2);
      if ((localObject1 instanceof JSONObject))
      {
        if ((!paramJSONObject1.has((String)localObject2)) || (!(paramJSONObject1.get((String)localObject2) instanceof JSONObject)))
        {
          paramJSONObject1.putOpt((String)localObject2, paramJSONObject2.get((String)localObject2));
        }
        else
        {
          localObject2 = paramJSONObject1.get((String)localObject2);
          if (localObject2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
          }
          b((JSONObject)localObject2, (JSONObject)localObject1);
        }
      }
      else {
        paramJSONObject1.putOpt((String)localObject2, paramJSONObject2.get((String)localObject2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtilsKt
 * JD-Core Version:    0.7.0.1
 */