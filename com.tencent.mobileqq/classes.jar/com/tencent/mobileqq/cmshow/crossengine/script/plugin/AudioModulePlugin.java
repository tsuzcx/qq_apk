package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import com.tencent.mobileqq.apollo.audio.ApolloMusicPlayer;
import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.script.plugin.PluginCmdConstant.PlugPriority;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/AudioModulePlugin;", "Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/IModuleEventPlugin;", "()V", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "player", "Lcom/tencent/mobileqq/apollo/audio/ApolloMusicPlayer;", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleModuleEvent", "Lorg/json/JSONObject;", "argument", "Lcom/tencent/mobileqq/cmshow/crossengine/model/CEArgument;", "onDestroy", "", "play", "stop", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModulePlugin
  implements IModuleEventPlugin
{
  public static final AudioModulePlugin.Companion a;
  private final ApolloMusicPlayer jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer = new ApolloMusicPlayer();
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.GENERAL;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineScriptPluginAudioModulePlugin$Companion = new AudioModulePlugin.Companion(null);
  }
  
  private final JSONObject b(CEArgument paramCEArgument)
  {
    if (paramCEArgument.b() != null) {
      try
      {
        paramCEArgument = new JSONObject(paramCEArgument.b());
        localObject = paramCEArgument.optString("path");
        int i = paramCEArgument.optInt("type");
        int j = paramCEArgument.optInt("loopCount");
        this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.a(i, j, (String)localObject, -1, -1.0F);
      }
      catch (Exception paramCEArgument)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[play] error, ");
        ((StringBuilder)localObject).append(paramCEArgument);
        QLog.e("[cmshow][CECMShowOffscreenEngine]_AudioModulePlugin", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private final JSONObject c(CEArgument paramCEArgument)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.a();
    return null;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  }
  
  @NotNull
  public String a()
  {
    return "Audio";
  }
  
  @Deprecated(message="ModuleEventPlugin通过handleModuleEvent进行分发", replaceWith=@ReplaceWith(expression="null", imports={}))
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    return IModuleEventPlugin.DefaultImpls.a(this, paramArgument);
  }
  
  @Deprecated(message="ModuleEventPlugin依赖moduleName进行分发", replaceWith=@ReplaceWith(expression="emptyList()", imports={}))
  @NotNull
  public List<String> a()
  {
    return IModuleEventPlugin.DefaultImpls.a(this);
  }
  
  @Nullable
  public JSONObject a(@NotNull CEArgument paramCEArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramCEArgument, "argument");
    String str = paramCEArgument.c();
    int i = str.hashCode();
    if (i != 3443508)
    {
      if ((i == 3540994) && (str.equals("stop"))) {
        return c(paramCEArgument);
      }
    }
    else if (str.equals("play")) {
      return b(paramCEArgument);
    }
    return IModuleEventPlugin.DefaultImpls.a(this, paramCEArgument);
  }
  
  public boolean a()
  {
    return IModuleEventPlugin.DefaultImpls.a(this);
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IModuleEventPlugin.DefaultImpls.a(this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.AudioModulePlugin
 * JD-Core Version:    0.7.0.1
 */