package com.tencent.mobileqq.triton.internal.script.plugin;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.ApiUtil;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin.DefaultImpls;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/plugin/FontPlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", "getTextLineHeight", "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "loadFont", "onCall", "eventName", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class FontPlugin
  implements ComposableScriptPlugin
{
  private static final String API_GET_TEXT_LINE_HEIGHT = "getTextLineHeight";
  private static final String API_LOAD_FONT = "loadFont";
  public static final FontPlugin.Companion Companion = new FontPlugin.Companion(null);
  private static final Set<String> supportedEvents = SetsKt.setOf(new String[] { "loadFont", "getTextLineHeight" });
  private final EngineContext engineContext;
  
  public FontPlugin(@NotNull EngineContext paramEngineContext)
  {
    this.engineContext = paramEngineContext;
  }
  
  private final int getTextLineHeight(Argument paramArgument)
  {
    String str1 = paramArgument.getParams().optString("fontStyle");
    String str2 = paramArgument.getParams().optString("fontWeight");
    int i = paramArgument.getParams().optInt("fontSize", 0);
    String str3 = paramArgument.getParams().optString("fontFamily");
    paramArgument = paramArgument.getParams().optString("text");
    return this.engineContext.getFontBitmapManager().getTextLineHeight(str1, str2, i, str3, paramArgument);
  }
  
  private final String loadFont(Argument paramArgument)
  {
    paramArgument = paramArgument.getParams().optString("path");
    GameDataFileSystem localGameDataFileSystem = this.engineContext.getDataFileSystem();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "path");
    paramArgument = localGameDataFileSystem.getFile(paramArgument);
    return this.engineContext.getFontBitmapManager().loadFont(paramArgument);
  }
  
  @NotNull
  public Set<String> getSupportedEvents()
  {
    return supportedEvents;
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    switch (paramString.hashCode())
    {
    }
    JSONObject localJSONObject;
    do
    {
      do
      {
        return null;
      } while (!paramString.equals("getTextLineHeight"));
      int i = getTextLineHeight(paramArgument);
      localJSONObject = new JSONObject();
      localJSONObject.put("lineHeight", i);
      paramString = ApiUtil.wrapCallbackOk(paramString, localJSONObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "ApiUtil.wrapCallbackOk(e…tName, resObj).toString()");
      paramArgument.callback(paramString);
      return paramString;
    } while (!paramString.equals("loadFont"));
    paramArgument = loadFont(paramArgument);
    if (!TextUtils.isEmpty((CharSequence)paramArgument))
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("familyName", paramArgument);
      return ApiUtil.wrapCallbackOk(paramString, localJSONObject).toString();
    }
    return ApiUtil.wrapCallbackFail(paramString, null).toString();
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ComposableScriptPlugin.DefaultImpls.onCreate(this, paramTritonEngine);
  }
  
  public void onDestroy()
  {
    ComposableScriptPlugin.DefaultImpls.onDestroy(this);
  }
  
  public void onFirstFrame()
  {
    ComposableScriptPlugin.DefaultImpls.onFirstFrame(this);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ComposableScriptPlugin.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    ComposableScriptPlugin.DefaultImpls.onStart(this);
  }
  
  public void onStop()
  {
    ComposableScriptPlugin.DefaultImpls.onStop(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.plugin.FontPlugin
 * JD-Core Version:    0.7.0.1
 */