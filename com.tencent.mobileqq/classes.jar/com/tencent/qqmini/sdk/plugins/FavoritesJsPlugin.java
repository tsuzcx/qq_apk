package com.tencent.qqmini.sdk.plugins;

import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.FavoritesAction;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.InnerFavoritesData;
import com.tencent.qqmini.sdk.launcher.model.InnerFavoritesData.Builder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.MiniProgramShareUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@JsPlugin
public class FavoritesJsPlugin
  extends BaseJsPlugin
{
  private static final String KEY_BIZ_DATA_LIST = "bitDataList";
  private static final String KEY_ENTRY_PATH = "entryPath";
  private static final String KEY_PIC_PATH = "picPath";
  private static final String KEY_SUMMARY = "summary";
  private static final String KEY_TITLE = "title";
  private static final String TAG = "FavoritesJsPlugin";
  
  public static void addFavoritesBundle(Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    InnerFavoritesData.Builder localBuilder = new InnerFavoritesData.Builder();
    localBuilder.setTitle(paramBundle.getString("title"));
    localBuilder.setSummary(paramBundle.getString("summary"));
    localBuilder.setEntryPath(paramBundle.getString("entryPath"));
    localBuilder.setPicPath(paramBundle.getString("picPath"));
    localBuilder.setAction(1);
    localBuilder.setBizDataList(paramBundle.getString("bitDataList"));
    paramBundle = localBuilder.build();
    if (ProxyManager.get(FavoritesProxy.class) != null)
    {
      ((FavoritesProxy)ProxyManager.get(FavoritesProxy.class)).onJsAddToFavorites(paramBundle);
      if (paramMiniCmdCallback == null) {
        return;
      }
      try
      {
        paramMiniCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (Throwable paramBundle)
      {
        QMLog.e("FavoritesJsPlugin", "addFavoritesBundle", paramBundle);
        return;
      }
    }
    if (paramMiniCmdCallback != null) {
      try
      {
        paramMiniCmdCallback.onCmdResult(false, new Bundle());
        return;
      }
      catch (Throwable paramBundle)
      {
        QMLog.e("FavoritesJsPlugin", "addFavoritesBundle", paramBundle);
      }
    }
  }
  
  private String fixEntryPath(String paramString1, String paramString2)
  {
    if (this.mMiniAppContext.isMiniGame())
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "miniGamePath";
      }
      paramString1 = new StringBuilder();
      paramString1.append("?");
      paramString1.append(paramString2);
      return paramString1.toString();
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = this.mApkgInfo.getAppConfigInfo().entryPagePath;
    }
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append(str);
      paramString1.append("?");
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    return paramString1;
  }
  
  private String fixPicPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return getDefaultPic();
    }
    Object localObject1 = paramString;
    try
    {
      if (!paramString.startsWith("http"))
      {
        if (this.mMiniAppContext.isMiniGame()) {
          return ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
        }
        localObject1 = this.mApkgInfo.readApkgToStream(paramString);
        if (localObject1 != null)
        {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          Object localObject2 = new byte[4096];
          for (;;)
          {
            int i = ((ByteArrayInputStream)localObject1).read((byte[])localObject2);
            if (i == -1) {
              break;
            }
            localByteArrayOutputStream.write((byte[])localObject2, 0, i);
          }
          paramString = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);
          new File(paramString).setWritable(true);
          localObject2 = new FileOutputStream(paramString);
          ((FileOutputStream)localObject2).write(localByteArrayOutputStream.toByteArray());
          ((FileOutputStream)localObject2).close();
          localByteArrayOutputStream.close();
          ((ByteArrayInputStream)localObject1).close();
          return paramString;
        }
        paramString = getDefaultPic();
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("FavoritesJsPlugin", "fixPicPath", paramString);
      localObject1 = getDefaultPic();
    }
    return localObject1;
  }
  
  private String fixTitle(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = this.mMiniAppInfo.name;
      str = paramString;
      if (paramString == null) {
        str = "";
      }
    }
    return str;
  }
  
  private String getDefaultPic()
  {
    String str2 = this.mMiniAppInfo.iconUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  private static void sendAddFavoritesToQQ(InnerFavoritesData paramInnerFavoritesData, RequestEvent paramRequestEvent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramInnerFavoritesData.title);
    localBundle.putString("summary", paramInnerFavoritesData.summary);
    localBundle.putString("entryPath", paramInnerFavoritesData.entryPath);
    localBundle.putString("picPath", paramInnerFavoritesData.picPath);
    localBundle.putString("bitDataList", paramInnerFavoritesData.bizDataList);
    AppBrandCmdProxy.g().sendCmd("cmd_add_qq_favorites", localBundle, new FavoritesJsPlugin.2(paramRequestEvent));
  }
  
  private void showErrorToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new FavoritesJsPlugin.3(this, paramString));
  }
  
  @JsEvent({"addFavorites"})
  public void addFavorites(RequestEvent paramRequestEvent)
  {
    GetShareState.obtain(this.mMiniAppContext).launchFrom = 1;
    paramRequestEvent = FavoritesAction.obtain(1);
    this.mMiniAppContext.performAction(paramRequestEvent);
  }
  
  @JsEvent({"addToFavorites"})
  public void addToFavorites(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = fixTitle(((JSONObject)localObject).optString("title", ""));
      String str2 = fixPicPath(((JSONObject)localObject).optString("imageUrl", ""));
      localObject = fixEntryPath(((JSONObject)localObject).optString("path", ""), ((JSONObject)localObject).optString("query", ""));
      addToFavoritesHelp(new InnerFavoritesData.Builder().setTitle(str1).setEntryPath((String)localObject).setMiniAppInfo(this.mMiniAppInfo).setSummary(this.mMiniAppInfo.desc).setPicPath(str2).setBizDataList(null).setAction(1).build(), paramRequestEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("FavoritesJsPlugin", "addToFavorites", localThrowable);
      showErrorToast("收藏失败，请稍后重试");
      paramRequestEvent.fail(localThrowable.getMessage());
    }
  }
  
  public void addToFavoritesHelp(InnerFavoritesData paramInnerFavoritesData, RequestEvent paramRequestEvent)
  {
    Object localObject = paramInnerFavoritesData.getMiniAppInfo();
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    localObject = MiniProgramShareUtils.newShareInfoRequest(((MiniAppInfo)localObject).appId, paramInnerFavoritesData.summary, paramInnerFavoritesData.summary, i, 1, 1, ((MiniAppInfo)localObject).getReportType(), paramInnerFavoritesData.picPath, null, paramInnerFavoritesData.entryPath, ((MiniAppInfo)localObject).iconUrl, null, ((MiniAppInfo)localObject).verType, ((MiniAppInfo)localObject).versionId, 7, false, "", null, "", "", "");
    paramInnerFavoritesData = new FavoritesJsPlugin.1(this, paramInnerFavoritesData, paramRequestEvent);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getShareInfo((MiniProgramShare.StAdaptShareInfoReq)localObject, paramInnerFavoritesData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin
 * JD-Core Version:    0.7.0.1
 */