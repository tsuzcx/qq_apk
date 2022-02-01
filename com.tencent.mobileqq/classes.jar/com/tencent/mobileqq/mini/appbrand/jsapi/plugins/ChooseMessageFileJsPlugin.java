package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class ChooseMessageFileJsPlugin
  extends BaseJsPlugin
{
  public static final int ACTION_REQUEST_CODE_CHOOSE_MESSAGE_FILE = 6001;
  public static final String API_CHOOSE_MESSAGE_FILE = "chooseMessageFile";
  private static final Set<String> S_EVENT_MAP = new ChooseMessageFileJsPlugin.1();
  public static final String TAG = "ChooseMessageFileJsPlugin";
  private ArrayList<String> validType = new ArrayList(Arrays.asList(new String[] { "all", "media", "image", "file" }));
  
  @NotNull
  private MiniAppController.ActivityResultListener getActivityResultListener(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    return new ChooseMessageFileJsPlugin.2(this, paramJsRuntime, paramString, paramInt);
  }
  
  private String getRetName(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.contains(MiniAppGlobal.STR_WXFILE)) {
        str = paramString.substring(MiniAppGlobal.STR_WXFILE.length());
      }
    }
    return str;
  }
  
  private String getRetType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "file";
    case 0: 
      return "image";
    }
    return "media";
  }
  
  private void handleActivityResult(int paramInt1, Intent paramIntent, JsRuntime paramJsRuntime, String paramString, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      if (paramIntent != null)
      {
        JSONArray localJSONArray;
        try
        {
          Object localObject = paramIntent.getParcelableArrayListExtra("reslut_select_file_info_list");
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break label259;
          }
          paramIntent = new JSONObject();
          localJSONArray = new JSONArray();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
            if (localFileInfo != null)
            {
              JSONObject localJSONObject = new JSONObject();
              String str = MiniAppFileManager.getInstance().getWxFilePath(localFileInfo.c());
              localJSONObject.put("path", str);
              localJSONObject.put("size", localFileInfo.a());
              localJSONObject.put("name", getRetName(str));
              localJSONObject.put("type", getRetType(localFileInfo.a()));
              localJSONObject.put("time", localFileInfo.b());
              localJSONArray.put(localJSONObject);
            }
          }
          paramIntent.put("tempFiles", localJSONArray);
        }
        catch (Throwable paramIntent)
        {
          QLog.e("ChooseMessageFileJsPlugin", 1, "ChooseMessageFile error,", paramIntent);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, "exception", paramInt2);
          return;
        }
        QLog.i("ChooseMessageFileJsPlugin", 1, "tempFiles : " + localJSONArray.toString());
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, paramIntent, paramInt2);
        return;
        label259:
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, "tempFilesArray length error.", paramInt2);
        return;
      }
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, "data is null", paramInt2);
      return;
    }
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, "cancel", paramInt2);
  }
  
  private boolean validateChooseMessageFileParams(int paramInt, String paramString)
  {
    boolean bool = true;
    if ((paramInt <= 0) || (paramInt > 100) || (TextUtils.isEmpty(paramString)) || (!this.validType.contains(paramString)))
    {
      QLog.e("ChooseMessageFileJsPlugin", 1, "validateChooseMessageFileParams count : " + paramInt + "; type : " + paramString);
      bool = false;
    }
    return bool;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("ChooseMessageFileJsPlugin", 1, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    if ("chooseMessageFile".equals(paramString1)) {}
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("count", -1);
      paramString2 = paramString2.optString("type", "");
      if (!validateChooseMessageFileParams(i, paramString2))
      {
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "parameter error", paramInt);
        return "";
      }
      MiniAppController.getInstance().setActivityResultListener(getActivityResultListener(paramString1, paramJsRuntime, paramInt));
      if ((getAppBrandRuntime() != null) && (getAppBrandRuntime().activity != null) && (!getAppBrandRuntime().activity.isFinishing())) {
        FMActivity.a(getAppBrandRuntime().activity, 6001, i, new ArrayList(Arrays.asList(new String[] { paramString2 })));
      }
    }
    catch (Throwable paramString1)
    {
      label188:
      break label188;
    }
    return "";
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ChooseMessageFileJsPlugin
 * JD-Core Version:    0.7.0.1
 */