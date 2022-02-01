package com.tencent.mobileqq.cmshow.engine.script;

import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/ScriptHelper;", "", "()V", "TAG", "", "buildBusinessScriptContent", "businessId", "", "businessContent", "verifyScript", "", "path", "toScript", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ScriptHelper
{
  public static final ScriptHelper a = new ScriptHelper();
  
  @NotNull
  public final String a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessContent");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(function(){");
    localStringBuilder.append(paramString);
    localStringBuilder.append(";registerFunction(\"playAction_bid_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\", playSpriteAction);");
    localStringBuilder.append("registerFunction(\"sendMsg_bid_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\", sendSpriteMsg);");
    localStringBuilder.append("registerFunction(\"stopAction_bid_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\", stopSpriteAction);");
    localStringBuilder.append("})();");
    paramString = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "StringBuilder().apply(builderAction).toString()");
    return paramString;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".sig");
    if (!new RSAVerify(localStringBuilder.toString(), paramString).a(1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("verify fails, path:");
      localStringBuilder.append(paramString);
      QLog.w("[cmshow]ScriptHelper", 1, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  @NotNull
  public final Script b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toScript");
    return new Script(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.ScriptHelper
 * JD-Core Version:    0.7.0.1
 */