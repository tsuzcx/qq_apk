package com.tencent.mobileqq.cmshow.crossengine.util;

import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/util/CEChannelUtil;", "", "()V", "genChannelData", "", "respData", "genNativeChannelEventScript", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "cmd", "genNativeChannelEventScript$cmshow_impl_release", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEChannelUtil
{
  public static final CEChannelUtil a = new CEChannelUtil();
  
  @NotNull
  public final Script a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    paramString2 = a(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("engine.Channel.C2S('");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("', ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(')');
    return new Script(localStringBuilder.toString());
  }
  
  @NotNull
  public final String a(@Nullable String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramString != null)
    {
      try
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("msg", "success");
        localJSONObject.put("result", new JSONObject(paramString));
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[genChannelJSONObject] error. ");
        localStringBuilder.append(paramString);
        QLog.e("[cmshow][CECMShowOffscreenEngine]", 1, localStringBuilder.toString());
      }
    }
    else
    {
      localJSONObject.put("ret", 1);
      localJSONObject.put("msg", "invalid response!");
    }
    paramString = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "resultJSON.toString()");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.util.CEChannelUtil
 * JD-Core Version:    0.7.0.1
 */