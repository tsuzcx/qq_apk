package com.tencent.qqmini.sdk.plugins;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
public class BookShelfJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "BookShelfJsPlugin";
  
  private String getAppId()
  {
    if (this.mMiniAppContext.getMiniAppInfo() != null) {
      return this.mMiniAppContext.getMiniAppInfo().appId;
    }
    return "";
  }
  
  private boolean jumpToBookShelfApp()
  {
    try
    {
      String str = WnsConfig.getConfig("qqminiapp", "bookshelf_mini_scheme", "");
      if (!TextUtils.isEmpty(str))
      {
        MiniSDK.startMiniApp(this.mMiniAppContext.getAttachedActivity(), str, 2, 1037);
        return true;
      }
      Toast.makeText(this.mMiniAppContext.getAttachedActivity(), "书架暂未发布，敬请期待", 0).show();
      return false;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BookShelfJsPlugin", "handleUpdateBookshelf exception: ", localThrowable);
    }
    return false;
  }
  
  private void showInsertSuccDialog()
  {
    MiniCustomDialog localMiniCustomDialog = DialogUtil.createCustomDialog(this.mMiniAppContext.getAttachedActivity(), 230, "加入书架成功，可在\"我的书架\"进行查看", null, "稍候再说", "去书架", new BookShelfJsPlugin.2(this), new BookShelfJsPlugin.3(this));
    localMiniCustomDialog.setTitleMutiLine();
    localMiniCustomDialog.getTitleTextView().setGravity(3);
    localMiniCustomDialog.setMessage("");
    localMiniCustomDialog.getBtnight().setTextColor(-12541697);
    localMiniCustomDialog.getBtnLeft().setTypeface(Typeface.defaultFromStyle(1));
    localMiniCustomDialog.setCanceledOnTouchOutside(false);
    localMiniCustomDialog.show();
  }
  
  @JsEvent({"insertBookshelf"})
  public String handleInsertBookshelf(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = getAppId();
      String str2 = ((JSONObject)localObject).optString("category");
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
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).insertBookShelf(str1, str2, localArrayList, new BookShelfJsPlugin.1(this, paramRequestEvent));
      return "";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BookShelfJsPlugin", "handleInsertBookshelf exception: ", localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
  
  @JsEvent({"navigateToBookshelf"})
  public String handleNavigateToBookshelf(RequestEvent paramRequestEvent)
  {
    try
    {
      if (jumpToBookShelfApp()) {
        return paramRequestEvent.ok();
      }
      String str = paramRequestEvent.fail();
      return str;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BookShelfJsPlugin", "handleUpdateBookshelf exception: ", localThrowable);
    }
    return paramRequestEvent.fail();
  }
  
  @JsEvent({"queryBookshelf"})
  public String handleQueryBookshelf(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = getAppId();
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
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).queryBookShelf(str, localArrayList, new BookShelfJsPlugin.4(this, paramRequestEvent));
      return "";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BookShelfJsPlugin", "handleQueryBookshelf exception: ", localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
  
  @JsEvent({"updateBookshelfReadTime"})
  public String handleUpdateBookshelf(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = getAppId();
      String str2 = ((JSONObject)localObject).optString("category");
      localObject = ((JSONObject)localObject).optString("contentId");
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBookshelfReadtime(str1, str2, (String)localObject, new BookShelfJsPlugin.5(this, paramRequestEvent));
      return "";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BookShelfJsPlugin", "handleUpdateBookshelf exception: ", localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin
 * JD-Core Version:    0.7.0.1
 */