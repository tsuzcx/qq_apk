package com.tencent.qqmini.sdk.plugins;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.RequestServer;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
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
      String str = WnsConfig.getConfig("qqminiapp", "bookshelf_mini_scheme", "mqqapi://miniapp/open?_atype=0&_mappid=1110651677&_mvid=&_path=pages%2Findex%2Findex&_vt=3&via=2016_61&_sig=3788661843");
      if (!TextUtils.isEmpty(str))
      {
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openSchema(this.mMiniAppContext.getContext(), str, 1037, null);
        return true;
      }
      Toast.makeText(this.mMiniAppContext.getAttachedActivity(), "书架暂未发布，敬请期待", 0).show();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("BookShelfJsPlugin", "handleUpdateBookshelf exception: ", localThrowable);
      }
    }
    return false;
  }
  
  private void showInsertSuccDialog()
  {
    Object localObject1 = DialogUtil.createCustomDialog(this.mMiniAppContext.getAttachedActivity(), 230, "已成功同步至\"我的书架\"", "可在QQ小程序下拉-游戏中心-小程序中查看", "稍候再说", "前往书架", new BookShelfJsPlugin.2(this), new BookShelfJsPlugin.3(this));
    ((MiniCustomDialog)localObject1).setTitleMutiLine();
    ((MiniCustomDialog)localObject1).getTitleTextView().setGravity(1);
    ((MiniCustomDialog)localObject1).getMessageTextView().setGravity(1);
    ((MiniCustomDialog)localObject1).getMessageTextView().setTextColor(-7894119);
    ((MiniCustomDialog)localObject1).getBtnight().setTextColor(-12541697);
    ((MiniCustomDialog)localObject1).getBtnLeft().setTypeface(Typeface.defaultFromStyle(1));
    Object localObject2 = WnsConfig.getConfig("qqminiapp", "bookshelf_guide_url", "https://down.qq.com/miniapp/image/bookshelf_iSpt_2.png");
    localObject2 = ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getGifDrawable((String)localObject2);
    if (localObject2 != null)
    {
      ((MiniCustomDialog)localObject1).getDialogImage().setVisibility(0);
      ((MiniCustomDialog)localObject1).getDialogImage().setImageDrawable((Drawable)localObject2);
      ((MiniCustomDialog)localObject1).setCanceledOnTouchOutside(false);
      ((MiniCustomDialog)localObject1).show();
      localObject2 = this.mMiniAppContext.getMiniAppInfo();
      if (localObject2 == null) {
        break label207;
      }
    }
    label207:
    for (localObject1 = "" + ((MiniAppInfo)localObject2).getReportType();; localObject1 = "0")
    {
      SDKMiniProgramLpReportDC04239.reportForSDK((MiniAppInfo)localObject2, (String)localObject1, null, "bookshelf_enter", "toast_enter", "expo", "");
      return;
      ((MiniCustomDialog)localObject1).getDialogImage().setVisibility(8);
      break;
    }
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
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      RequestServer.getInstance().insertBookShelf(str1, str2, localArrayList, new BookShelfJsPlugin.1(this, paramRequestEvent));
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
    for (;;)
    {
      try
      {
        MiniAppInfo localMiniAppInfo = this.mMiniAppContext.getMiniAppInfo();
        if (localMiniAppInfo != null)
        {
          String str1 = "" + localMiniAppInfo.getReportType();
          SDKMiniProgramLpReportDC04239.reportForSDK(localMiniAppInfo, str1, null, "bookshelf_enter", "cp_enter", "click", "");
          if (jumpToBookShelfApp()) {
            return paramRequestEvent.ok();
          }
          str1 = paramRequestEvent.fail();
          return str1;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("BookShelfJsPlugin", "handleUpdateBookshelf exception: ", localThrowable);
        return paramRequestEvent.fail();
      }
      String str2 = "0";
    }
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
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      RequestServer.getInstance().queryBookShelf(str, localArrayList, new BookShelfJsPlugin.4(this, paramRequestEvent));
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
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      RequestServer.getInstance().updateBookshelfReadtime(str1, str2, (String)localObject, new BookShelfJsPlugin.5(this, paramRequestEvent));
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