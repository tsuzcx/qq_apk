package com.tencent.mobileqq.cmshow.engine.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class Argument$params$2
  extends Lambda
  implements Function0<String>
{
  Argument$params$2(Argument paramArgument)
  {
    super(0);
  }
  
  public final String invoke()
  {
    return this.this$0.d().optString("params");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.Argument.params.2
 * JD-Core Version:    0.7.0.1
 */