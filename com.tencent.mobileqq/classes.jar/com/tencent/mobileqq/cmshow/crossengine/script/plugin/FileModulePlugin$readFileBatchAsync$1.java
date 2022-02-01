package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.crossengine.resource.util.CEGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FileModulePlugin$readFileBatchAsync$1
  implements Runnable
{
  FileModulePlugin$readFileBatchAsync$1(FileModulePlugin paramFileModulePlugin, CEArgument paramCEArgument) {}
  
  public final void run()
  {
    if (this.a.e() != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.a.e()).optJSONArray("files");
        localObject2 = new JSONArray();
        int i = 0;
        int j = localJSONArray.length();
        if (i < j)
        {
          localObject1 = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject1).optString("path");
          if (((JSONObject)localObject1).optInt("pathType") <= 0) {
            break label227;
          }
          Intrinsics.checkExpressionValueIsNotNull(str, "filePath");
          localObject1 = CEGetResPathUtil.a(str, "");
          FileModulePlugin localFileModulePlugin = this.this$0;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "absoluteFilePath");
          localObject1 = FileModulePlugin.a(localFileModulePlugin, (String)localObject1);
          ((JSONObject)localObject1).put("path", str);
          ((JSONArray)localObject2).put(localObject1);
          i += 1;
          continue;
        }
        localObject1 = EngineHelper.a.b();
        ((JSONObject)localObject1).put("data", localObject2);
      }
      catch (Exception localException)
      {
        localObject1 = EngineHelper.a.c(localException.getMessage());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[print] error, ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("[cmshow][CECMShowOffscreenEngine]_FileModulePlugin", 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = EngineHelper.a.c("params is invalid!");
      this.a.a((JSONObject)localObject1);
      return;
      label227:
      localObject1 = localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.FileModulePlugin.readFileBatchAsync.1
 * JD-Core Version:    0.7.0.1
 */