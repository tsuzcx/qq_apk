package com.tencent.mobileqq.cmshow.crossengine.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CEArgument$isAsync$2
  extends Lambda
  implements Function0<Boolean>
{
  CEArgument$isAsync$2(CEArgument paramCEArgument)
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    return this.this$0.a().optBoolean("isAsync");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.model.CEArgument.isAsync.2
 * JD-Core Version:    0.7.0.1
 */