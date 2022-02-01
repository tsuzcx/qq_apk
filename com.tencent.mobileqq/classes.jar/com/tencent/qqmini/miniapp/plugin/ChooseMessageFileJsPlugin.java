package com.tencent.qqmini.miniapp.plugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
public class ChooseMessageFileJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "ChooseMessageFileJsPlugin";
  private ArrayList<String> validType = new ArrayList(Arrays.asList(new String[] { "all", "media", "image", "file" }));
  
  private IActivityResultListener getActivityResultListener(RequestEvent paramRequestEvent)
  {
    return new ChooseMessageFileJsPlugin.1(this, paramRequestEvent);
  }
  
  private String getRetName(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("/");
      str = paramString;
      if (arrayOfString.length > 0) {
        str = arrayOfString[(arrayOfString.length - 1)];
      }
    }
    return str;
  }
  
  private JSONArray getTempFileJsonArray(Intent paramIntent)
  {
    if (QUAUtil.isQQMainApp()) {
      return ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getChooseMessageTempFilesArray(paramIntent);
    }
    return new JSONArray(paramIntent.getStringExtra("tempFiles"));
  }
  
  private void hanldeActivityResult(Intent paramIntent, RequestEvent paramRequestEvent, int paramInt)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      try
      {
        MiniAppFileManager localMiniAppFileManager = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
        if (localMiniAppFileManager == null)
        {
          paramRequestEvent.fail("fileManager error");
          return;
        }
        paramIntent = getTempFileJsonArray(paramIntent);
        if ((paramIntent != null) && (paramIntent.length() > 0))
        {
          JSONObject localJSONObject1 = new JSONObject();
          paramInt = 0;
          if (paramInt < paramIntent.length())
          {
            JSONObject localJSONObject2 = (JSONObject)paramIntent.get(paramInt);
            if (!localJSONObject2.has("path")) {
              break label273;
            }
            String str1 = localJSONObject2.getString("path");
            String str2 = localMiniAppFileManager.getWxFilePathByExistLocalPath(str1);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("path : ");
            localStringBuilder.append(str1);
            localStringBuilder.append("; wxPath : ");
            localStringBuilder.append(str2);
            QMLog.i("ChooseMessageFileJsPlugin", localStringBuilder.toString());
            localJSONObject2.put("path", str2);
            localJSONObject2.put("name", getRetName(str1));
            break label273;
          }
          localJSONObject1.put("tempFiles", paramIntent);
          paramRequestEvent.ok(localJSONObject1);
          return;
        }
        paramRequestEvent.fail("tempFilesArray length error.");
        QMLog.e("ChooseMessageFileJsPlugin", "hanldeActivityResult tempFilesArray length error");
        return;
      }
      catch (Throwable paramIntent)
      {
        QMLog.e("ChooseMessageFileJsPlugin", "hanldeActivityResult error,", paramIntent);
        paramRequestEvent.fail("result ok exception");
        return;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("hanldeActivityResult cancel, resultCode is ");
      paramIntent.append(paramInt);
      QMLog.e("ChooseMessageFileJsPlugin", paramIntent.toString());
      paramRequestEvent.fail("cancel");
      return;
      label273:
      paramInt += 1;
    }
  }
  
  private boolean validateChooseMessageFileParams(int paramInt, String paramString)
  {
    if ((paramInt > 0) && (paramInt <= 100) && (!TextUtils.isEmpty(paramString)) && (this.validType.contains(paramString))) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("validateChooseMessageFileParams count : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; type : ");
    localStringBuilder.append(paramString);
    QMLog.e("ChooseMessageFileJsPlugin", localStringBuilder.toString());
    return false;
  }
  
  @JsEvent({"chooseMessageFile"})
  public String chooseMessageFile(RequestEvent paramRequestEvent)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramRequestEvent.jsonParams);
      if (!bool)
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        int i = ((JSONObject)localObject).optInt("count", -1);
        localObject = ((JSONObject)localObject).optString("type", "");
        if (!validateChooseMessageFileParams(i, (String)localObject))
        {
          paramRequestEvent.fail("parameter error");
          return "";
        }
        IActivityResultListener localIActivityResultListener = getActivityResultListener(paramRequestEvent);
        ActivityResultManager.g().addActivityResultListener(localIActivityResultListener);
        if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).startChooseMessageFileActivityForResult(this.mMiniAppContext.getAttachedActivity(), i, (String)localObject, 6001))
        {
          QMLog.e("ChooseMessageFileJsPlugin", "chooseMessageFile not support");
          paramRequestEvent.fail("not support");
          ActivityResultManager.g().removeActivityResultListener(localIActivityResultListener);
          return "";
        }
      }
      else
      {
        QMLog.e("ChooseMessageFileJsPlugin", "chooseMessageFile jsonParams is null.");
        paramRequestEvent.fail("parameter error");
        return "";
      }
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail("exception");
      QMLog.e("ChooseMessageFileJsPlugin", "chooseMessageFile exception.", localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ChooseMessageFileJsPlugin
 * JD-Core Version:    0.7.0.1
 */