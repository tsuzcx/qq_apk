package com.tencent.mobileqq.mini.appbrand;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import bbdh;
import bcqf;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public abstract class BaseAppBrandRuntime
{
  private static final String TAG = "BaseAppBrandRuntime";
  public Activity activity;
  public String appId;
  public MiniAppInterface appInterface;
  public boolean isGettingScreenShot;
  public List<IJsPlugin> pluginList;
  private bcqf shareScreenshotProgressDialog;
  
  public boolean canLaunchApp()
  {
    return false;
  }
  
  public String cutAndSaveShareScreenshot(Bitmap paramBitmap)
  {
    Object localObject;
    int j;
    if (this.activity != null)
    {
      localObject = this.activity.getResources().getDisplayMetrics();
      j = ((DisplayMetrics)localObject).widthPixels;
    }
    for (int i = (int)(((DisplayMetrics)localObject).widthPixels * 0.8D);; i = (int)(bbdh.l() * 0.8D))
    {
      paramBitmap = ImageUtil.cutOutImg(Bitmap.createBitmap(paramBitmap), j, i);
      localObject = ImageUtil.compressImage(paramBitmap, 1044480);
      File localFile = new File(MiniAppFileManager.getInstance().getTmpPath("png"));
      boolean bool = ImageUtil.saveBitmapToFile((byte[])localObject, localFile);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      if (!bool) {
        break;
      }
      return localFile.getAbsolutePath();
      j = (int)bbdh.k();
    }
    return null;
  }
  
  public void dismissShareScreenshotProgress()
  {
    ThreadManagerV2.getUIHandlerV2().post(new BaseAppBrandRuntime.2(this));
  }
  
  public void evaluateServiceSubcribeJS(String paramString1, String paramString2) {}
  
  public ApkgInfo getApkgInfo()
  {
    return null;
  }
  
  public View getContainer()
  {
    return null;
  }
  
  public AbsAppBrandPage getCurPage()
  {
    return null;
  }
  
  public WebviewContainer getCurWebviewContainer()
  {
    return null;
  }
  
  public int getLaunchAppScene()
  {
    return 9999;
  }
  
  public PageWebview getPageWebView()
  {
    return null;
  }
  
  public List<IJsPlugin> getPluginList()
  {
    return this.pluginList;
  }
  
  public void getShareScreenshot(BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback) {}
  
  protected boolean isMiniAppRuntime()
  {
    return getApkgInfo().isEngineTypeMiniApp();
  }
  
  protected boolean isMiniGameRuntime()
  {
    return getApkgInfo().isEngineTypeMiniGame();
  }
  
  public void moveAppBrandToBack() {}
  
  public void onAppCreate(ApkgInfo paramApkgInfo, String paramString, boolean paramBoolean) {}
  
  public void onAttachWindow(Activity paramActivity) {}
  
  public void setPluginList(List<IJsPlugin> paramList)
  {
    this.pluginList = paramList;
  }
  
  protected void showShareScreenshotProgress()
  {
    ThreadManagerV2.getUIHandlerV2().post(new BaseAppBrandRuntime.1(this));
  }
  
  public void startShare(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, EntryModel paramEntryModel, ShareChatModel paramShareChatModel, int paramInt1, int paramInt2, String paramString7, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "startShare. content=" + paramString1 + ",sharePicPath=" + paramString2 + ",entryPath=" + paramString3);
    }
    Object localObject = paramString1;
    String str2 = paramString3;
    if (isMiniAppRuntime())
    {
      String str1 = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        str1 = paramString1;
        if (getCurPage() != null)
        {
          str1 = paramString1;
          if (getCurPage().getNavBar() != null) {
            str1 = getCurPage().getNavBar().getTitleText();
          }
        }
      }
      localObject = str1;
      str2 = paramString3;
      if (TextUtils.isEmpty(paramString3))
      {
        localObject = str1;
        str2 = paramString3;
        if (getCurPage() != null)
        {
          str2 = getCurPage().getUrl();
          localObject = str1;
        }
      }
    }
    paramString3 = getApkgInfo();
    if (((isMiniAppRuntime()) && (!TextUtils.isEmpty(str2))) || (isMiniGameRuntime()))
    {
      paramString1 = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString1 = paramString3.appConfig.config.desc;
      }
      boolean bool2 = false;
      boolean bool1;
      if (isMiniAppRuntime()) {
        bool1 = getPageWebView().withShareTicket;
      }
      for (;;)
      {
        MiniProgramShareUtils.shareAsArkMessage(this.activity, new MiniArkShareModelBuilder().setAppId(this.appId).setTitle(paramString3.apkgName).setDescription(paramString1).setShareScene(1).setShareTemplateType(1).setShareBusinessType(paramString3.appConfig.config.getReportType()).setPicUrl(paramString2).setVidUrl(null).setJumpUrl(str2).setIconUrl(paramString3.iconUrl).setVersionType(paramString3.appConfig.config.verType).setVersionId(paramString3.appConfig.config.versionId).setWebURL(paramString4).setTemplateId(paramString5).setTemplateData(paramString6).setEntryModel(paramEntryModel).setShareChatModel(paramShareChatModel).setShareTarget(paramInt2).setRcvOpenId(paramString7).createMiniArkShareModel(), bool1, paramInt1, paramOnShareListener);
        return;
        bool1 = bool2;
        if (isMiniGameRuntime())
        {
          bool1 = bool2;
          if ((this instanceof GameBrandRuntime)) {
            bool1 = ((GameBrandRuntime)this).withShareTicket;
          }
        }
      }
    }
    QLog.e("BaseAppBrandRuntime", 2, "startShare perform share failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */