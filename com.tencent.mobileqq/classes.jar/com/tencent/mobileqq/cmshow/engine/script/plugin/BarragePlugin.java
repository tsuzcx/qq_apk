package com.tencent.mobileqq.cmshow.engine.script.plugin;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageUI;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BarragePlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "barrageUI", "Lcom/tencent/mobileqq/apollo/barrage/BarrageUI;", "(Lcom/tencent/mobileqq/apollo/barrage/BarrageUI;)V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleEvent", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleShowBarrage", "reqData", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BarragePlugin
  implements IEventPlugin
{
  @Deprecated
  public static final BarragePlugin.Companion a = new BarragePlugin.Companion(null);
  @NotNull
  private static final List<String> e = CollectionsKt.listOf("cs.script_show_barrage.local");
  @NotNull
  private final PluginCmdConstant.PlugPriority c;
  private final BarrageUI d;
  
  public BarragePlugin(@NotNull BarrageUI paramBarrageUI)
  {
    this.d = paramBarrageUI;
    this.c = PluginCmdConstant.PlugPriority.UI;
  }
  
  private final String b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (1 == paramString.optInt("isShow"))
      {
        paramString = paramString.optString("text");
        Intrinsics.checkExpressionValueIsNotNull(paramString, "text");
        Object localObject = Charset.forName("utf-8");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Charset.forName(charsetName)");
        if (paramString != null)
        {
          paramString = paramString.getBytes((Charset)localObject);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
          paramString = Base64Util.decode(paramString, 0);
          localObject = this.d;
          Context localContext = (Context)BaseApplicationImpl.getContext();
          Intrinsics.checkExpressionValueIsNotNull(paramString, "textBytes");
          ApolloBarrageUtil.a((BarrageUI)localObject, localContext, "", new String(paramString, Charsets.UTF_8), true);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else
      {
        this.d.a(true);
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][BarragePlugin]", 1, "handleShowBarrage exception", paramString);
    }
    return null;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.c;
  }
  
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    String str = paramArgument.f();
    if ((str.hashCode() == 2120721) && (str.equals("cs.script_show_barrage.local"))) {
      return b(paramArgument.e());
    }
    return null;
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IEventPlugin.DefaultImpls.a(this, paramString);
  }
  
  @NotNull
  public List<String> c()
  {
    return e;
  }
  
  public boolean d()
  {
    return IEventPlugin.DefaultImpls.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.BarragePlugin
 * JD-Core Version:    0.7.0.1
 */