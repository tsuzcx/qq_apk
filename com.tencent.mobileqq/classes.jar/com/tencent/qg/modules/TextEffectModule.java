package com.tencent.qg.modules;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.ark.dict.WordSegmentResult;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class TextEffectModule
  extends BaseJsModule
{
  private WeakReference<AppInterface> a;
  
  public TextEffectModule()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof ToolRuntimePeak)) {
      this.a = new WeakReference((AppInterface)((ToolRuntimePeak)localAppRuntime).getAppRuntime("peak"));
    }
  }
  
  public String getModuleName()
  {
    return "textEffect";
  }
  
  public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleJsRequest method = ");
    ((StringBuilder)localObject).append(paramString);
    SLog.b("TextEffectModule", ((StringBuilder)localObject).toString());
    try
    {
      if ("wordSplit".equals(paramString))
      {
        if (paramJSONObject == null)
        {
          paramInvokeCallback.exec(4);
          return false;
        }
        localObject = new JSONArray();
        paramJSONObject = paramJSONObject.optString("text");
        boolean bool = TextUtils.isEmpty(paramJSONObject);
        if (bool)
        {
          paramInvokeCallback.exec(0, "success", (JSONArray)localObject);
          return true;
        }
        AppInterface localAppInterface = (AppInterface)this.a.get();
        if (localAppInterface == null)
        {
          paramInvokeCallback.exec(-1, "app is null.");
          return false;
        }
        paramJSONObject = ((IArkDictManager)localAppInterface.getRuntimeService(IArkDictManager.class, "all")).wordSegment(paramJSONObject);
        if (!paramJSONObject.a)
        {
          paramInvokeCallback.exec(-1, "sdk init failed! soLoaded.");
          return false;
        }
        if (paramJSONObject.c != null)
        {
          paramJSONObject = paramJSONObject.c;
          int j = paramJSONObject.length;
          int i = 0;
          while (i < j)
          {
            ((JSONArray)localObject).put(paramJSONObject[i]);
            i += 1;
          }
        }
        paramInvokeCallback.exec(0, "success", (JSONArray)localObject);
        return true;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramInvokeCallback = new StringBuilder();
      paramInvokeCallback.append("handle method ");
      paramInvokeCallback.append(paramString);
      paramInvokeCallback.append("failed");
      QLog.e("TextEffectModule", 1, paramInvokeCallback.toString(), paramJSONObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.modules.TextEffectModule
 * JD-Core Version:    0.7.0.1
 */