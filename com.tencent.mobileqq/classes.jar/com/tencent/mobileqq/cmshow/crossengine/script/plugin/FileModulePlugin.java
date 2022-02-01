package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.script.plugin.PluginCmdConstant.PlugPriority;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/FileModulePlugin;", "Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/IModuleEventPlugin;", "()V", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "doReadFile", "Lorg/json/JSONObject;", "filePath", "getResourceAbsolutePath", "argument", "Lcom/tencent/mobileqq/cmshow/crossengine/model/CEArgument;", "handleModuleEvent", "isFileExists", "readFile", "readFileAsync", "readFileBatchAsync", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class FileModulePlugin
  implements IModuleEventPlugin
{
  public static final FileModulePlugin.Companion a;
  @NotNull
  private final PluginCmdConstant.PlugPriority a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineScriptPluginFileModulePlugin$Companion = new FileModulePlugin.Companion(null);
  }
  
  public FileModulePlugin()
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.GENERAL;
  }
  
  private final JSONObject a(String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        paramString = FileUtils.readFileContent(paramString);
        if (!TextUtils.isEmpty((CharSequence)paramString))
        {
          JSONObject localJSONObject = EngineHelper.a.a();
          localJSONObject.put("content", paramString);
          return localJSONObject;
        }
        return EngineHelper.a.a("empty fileContent!");
      }
      return EngineHelper.a.a("file not exits!");
    }
    return EngineHelper.a.a("params is invalid!");
  }
  
  private final JSONObject b(CEArgument paramCEArgument)
  {
    if (paramCEArgument.b() != null) {
      try
      {
        localObject2 = new JSONObject(paramCEArgument.b());
        localObject1 = ((JSONObject)localObject2).optString("path");
        paramCEArgument = (CEArgument)localObject1;
        if (((JSONObject)localObject2).optInt("pathType") > 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "filePath");
          paramCEArgument = CMGetResPathUtil.a((String)localObject1, "");
        }
        Intrinsics.checkExpressionValueIsNotNull(paramCEArgument, "absoluteFilePath");
        paramCEArgument = a(paramCEArgument);
        return paramCEArgument;
      }
      catch (Exception paramCEArgument)
      {
        Object localObject1 = EngineHelper.a.a(paramCEArgument.getMessage());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[print] error, ");
        ((StringBuilder)localObject2).append(paramCEArgument);
        QLog.e("[cmshow][CECMShowOffscreenEngine]_FileModulePlugin", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
    }
    return EngineHelper.a.a("params is invalid!");
  }
  
  private final JSONObject c(CEArgument paramCEArgument)
  {
    ThreadManager.getFileThreadHandler().post((Runnable)new FileModulePlugin.readFileAsync.1(this, paramCEArgument));
    return null;
  }
  
  private final JSONObject d(CEArgument paramCEArgument)
  {
    ThreadManager.getFileThreadHandler().post((Runnable)new FileModulePlugin.readFileBatchAsync.1(this, paramCEArgument));
    return null;
  }
  
  private final JSONObject e(CEArgument paramCEArgument)
  {
    if (paramCEArgument.b() != null) {
      try
      {
        paramCEArgument = new JSONObject(paramCEArgument.b()).optString("path");
        if (!TextUtils.isEmpty((CharSequence)paramCEArgument))
        {
          if (new File(paramCEArgument).exists()) {
            return EngineHelper.a.a();
          }
          return EngineHelper.a.a("file not exits!");
        }
        paramCEArgument = EngineHelper.a.a("params is invalid!");
        return paramCEArgument;
      }
      catch (Exception paramCEArgument)
      {
        JSONObject localJSONObject = EngineHelper.a.a(paramCEArgument.getMessage());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[print] error, ");
        localStringBuilder.append(paramCEArgument);
        QLog.e("[cmshow][CECMShowOffscreenEngine]_FileModulePlugin", 1, localStringBuilder.toString());
        return localJSONObject;
      }
    }
    return EngineHelper.a.a("params is invalid!");
  }
  
  private final JSONObject f(CEArgument paramCEArgument)
  {
    if (paramCEArgument.b() != null) {
      try
      {
        paramCEArgument = new JSONObject(paramCEArgument.b()).optString("name");
        if (!TextUtils.isEmpty((CharSequence)paramCEArgument))
        {
          Intrinsics.checkExpressionValueIsNotNull(paramCEArgument, "resName");
          String str = CMGetResPathUtil.a(paramCEArgument, "");
          if (!TextUtils.isEmpty((CharSequence)str))
          {
            paramCEArgument = EngineHelper.a.a();
            paramCEArgument.put("path", str);
          }
          else
          {
            paramCEArgument = EngineHelper.a.a("file not exits!");
          }
        }
        else
        {
          paramCEArgument = EngineHelper.a.a("params is invalid!");
        }
      }
      catch (Exception localException)
      {
        paramCEArgument = EngineHelper.a.a(localException.getMessage());
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[print] error, ");
        localStringBuilder2.append(localException);
        QLog.e("[cmshow][CECMShowOffscreenEngine]_FileModulePlugin", 1, localStringBuilder2.toString());
      }
    } else {
      paramCEArgument = EngineHelper.a.a("params is invalid!");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[getResourceAbsolutePath] ");
      localStringBuilder1.append(paramCEArgument);
      QLog.d("[cmshow][CECMShowOffscreenEngine]_FileModulePlugin", 2, localStringBuilder1.toString());
    }
    return paramCEArgument;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  }
  
  @NotNull
  public String a()
  {
    return "File";
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
    switch (str.hashCode())
    {
    default: 
      break;
    case 1042110826: 
      if (str.equals("readFileAsync")) {
        return c(paramCEArgument);
      }
      break;
    case -161753903: 
      if (str.equals("isFileExist")) {
        return e(paramCEArgument);
      }
      break;
    case -424313548: 
      if (str.equals("readFileBatchAsync")) {
        return d(paramCEArgument);
      }
      break;
    case -867956686: 
      if (str.equals("readFile")) {
        return b(paramCEArgument);
      }
      break;
    case -1823702560: 
      if (str.equals("getResourceAbsolutePath")) {
        return f(paramCEArgument);
      }
      break;
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.FileModulePlugin
 * JD-Core Version:    0.7.0.1
 */