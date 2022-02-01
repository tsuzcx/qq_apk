package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import amtj;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class BookShelfJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_BOOKSHELF_INSERT = "insertBookshelf";
  public static final String EVENT_BOOKSHELF_MAVIGATETO = "navigateToBookshelf";
  public static final String EVENT_BOOKSHELF_QUERY = "queryBookshelf";
  public static final String EVENT_BOOKSHELF_UPDATE = "updateBookshelfReadTime";
  private static final Set<String> S_EVENT_MAP = new BookShelfJsPlugin.1();
  private static final String TAG = "BookShelfJsPlugin";
  
  private String handleInsertBookshelf(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject(paramString2);
      paramString2 = this.jsPluginEngine.appBrandRuntime.appId;
      String str = ((JSONObject)localObject).optString("category");
      ArrayList localArrayList = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("contentIds");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add((String)((JSONArray)localObject).get(i));
          i += 1;
        }
      }
      MiniAppCmdUtil.getInstance().insertBookShelf(paramString2, str, localArrayList, new BookShelfJsPlugin.2(this, paramString1, paramJsRuntime, paramInt));
      return "";
    }
    catch (Throwable paramString2)
    {
      QLog.e("BookShelfJsPlugin", 1, "handleInsertBookshelf exception!", paramString2);
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null);
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString1.toString());
    }
    return paramString1.toString();
  }
  
  private String handleNavigateToBookshelf(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      if (jumpToBookShelfApp()) {
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk(paramString1, null).toString());
      }
      for (;;)
      {
        return "";
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
      }
      return paramString1.toString();
    }
    catch (Throwable paramString2)
    {
      QLog.e("BookShelfJsPlugin", 1, "handleNavigateToBookshelf exception!", paramString2);
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null);
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString1.toString());
    }
  }
  
  private String handleQueryBookshelf(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject(paramString2);
      paramString2 = this.jsPluginEngine.appBrandRuntime.appId;
      ArrayList localArrayList = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("contentIds");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add((String)((JSONArray)localObject).get(i));
          i += 1;
        }
      }
      MiniAppCmdUtil.getInstance().queryBookShelf(paramString2, localArrayList, new BookShelfJsPlugin.5(this, paramString1, paramJsRuntime, paramInt));
      return "";
    }
    catch (Throwable paramString2)
    {
      QLog.e("BookShelfJsPlugin", 1, "handleQueryBookshelf exception!", paramString2);
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null);
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString1.toString());
    }
    return paramString1.toString();
  }
  
  private String handleUpdateBookshelf(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject(paramString2);
      paramString2 = this.jsPluginEngine.appBrandRuntime.appId;
      String str = ((JSONObject)localObject).optString("category");
      localObject = ((JSONObject)localObject).optString("contentId");
      MiniAppCmdUtil.getInstance().updateBookshelfReadtime(paramString2, str, (String)localObject, new BookShelfJsPlugin.6(this, paramString1, paramJsRuntime, paramInt));
      return "";
    }
    catch (Throwable paramString2)
    {
      QLog.e("BookShelfJsPlugin", 1, "handleUpdateBookshelf exception!", paramString2);
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null);
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString1.toString());
    }
    return paramString1.toString();
  }
  
  private boolean jumpToBookShelfApp()
  {
    try
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "bookshelf_mini_scheme", "");
      if (!TextUtils.isEmpty(str))
      {
        LaunchParam localLaunchParam = new LaunchParam();
        localLaunchParam.scene = 1037;
        localLaunchParam.fromMiniAppId = this.jsPluginEngine.appBrandRuntime.appId;
        MiniAppController.startAppByLink(this.jsPluginEngine.activityContext, str, 2, localLaunchParam, null);
        return true;
      }
      Toast.makeText(this.jsPluginEngine.activityContext, "书架暂未发布，敬请期待", 0).show();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BookShelfJsPlugin", 1, "jumpToBookShelfApp exception! ", localThrowable);
      }
    }
    return false;
  }
  
  private void showInsertSuccDialog()
  {
    try
    {
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jsPluginEngine.activityContext, 2131755826);
      localQQCustomDialog.setContentView(2131558992);
      localQQCustomDialog.setTitle(2131693776);
      localQQCustomDialog.setTitleMutiLine();
      localQQCustomDialog.getTitleTextView().setGravity(3);
      localQQCustomDialog.setMessage("");
      localQQCustomDialog.getMessageTextView().setTypeface(Typeface.defaultFromStyle(1));
      localQQCustomDialog.setPositiveButton(amtj.a(2131693775), new BookShelfJsPlugin.3(this));
      localQQCustomDialog.getBtnight().setTextColor(-12541697);
      localQQCustomDialog.setNegativeButton(amtj.a(2131693789), new BookShelfJsPlugin.4(this));
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      QLog.i("BookShelfJsPlugin", 1, "Show BookShelf Dialog");
      localQQCustomDialog.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BookShelfJsPlugin", 1, "", localThrowable);
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if ("insertBookshelf".equals(paramString1)) {
      return handleInsertBookshelf(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    if ("queryBookshelf".equals(paramString1)) {
      return handleQueryBookshelf(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    if ("updateBookshelfReadTime".equals(paramString1)) {
      return handleUpdateBookshelf(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    if ("navigateToBookshelf".equals(paramString1)) {
      return handleNavigateToBookshelf(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BookShelfJsPlugin
 * JD-Core Version:    0.7.0.1
 */