package com.tencent.mobileqq.cmshow.engine.model;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k=3, mv={1, 1, 16})
final class Argument$data$2
  extends Lambda
  implements Function0<JSONObject>
{
  Argument$data$2(Argument paramArgument)
  {
    super(0);
  }
  
  @NotNull
  public final JSONObject invoke()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.this$0.d());
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      String str = String.valueOf(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse rawParams:");
      localStringBuilder.append(this.this$0.d());
      localStringBuilder.append(" exception:");
      QLog.e(str, 1, localStringBuilder.toString(), localThrowable);
    }
    return new JSONObject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.Argument.data.2
 * JD-Core Version:    0.7.0.1
 */