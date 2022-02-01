package com.tencent.qqmini.sdk.core.manager;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IShareManager;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;
import com.tencent.qqmini.sdk.utils.MiniProgramShareUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

@MiniKeep
public class ShareManager
  implements IShareManager
{
  private static final String TAG = "ShareManager";
  
  private void downloadImageByURL(IMiniAppContext paramIMiniAppContext, String paramString, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, ((MiniAppFileManager)paramIMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString), 60, paramDownloadListener);
  }
  
  private AsyncResult getShareInfoResult(InnerShareData paramInnerShareData)
  {
    return new ShareManager.1(this, paramInnerShareData);
  }
  
  public static Bitmap getSharePicBitmap(Activity paramActivity, String paramString)
  {
    Object localObject1;
    try
    {
      paramString = ImageUtil.drawableToBitmap(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(paramActivity, paramString, 0, 0, paramActivity.getResources().getDrawable(R.drawable.mini_sdk_qzone_miniapp_more_button)));
      localObject1 = paramString;
      if (paramString != null)
      {
        localObject1 = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject1);
        Object localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length original:");
        ((StringBuilder)localObject1).append(localObject2.length);
        QMLog.d("ShareManager", ((StringBuilder)localObject1).toString());
        int i = 0;
        localObject1 = paramString;
        paramString = (String)localObject2;
        while ((i < 10) && (paramString.length > 32768))
        {
          paramString = new Matrix();
          paramString.setScale(0.7F, 0.7F);
          localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramString, true);
          paramString = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 85, paramString);
          paramString = paramString.toByteArray();
          i += 1;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:");
          ((StringBuilder)localObject2).append(paramString.length);
          QMLog.d("ShareManager", ((StringBuilder)localObject2).toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length done:");
        ((StringBuilder)localObject1).append(paramString.length);
        QMLog.d("ShareManager", ((StringBuilder)localObject1).toString());
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSharePicBitmap. get an exception when handling URLbmp:");
      ((StringBuilder)localObject1).append(paramString);
      QMLog.w("ShareManager", ((StringBuilder)localObject1).toString());
      localObject1 = ImageUtil.drawableToBitmap(paramActivity.getResources().getDrawable(R.drawable.mini_sdk_qzone_miniapp_more_button));
    }
    return localObject1;
  }
  
  private static void launchShareTransitiveFragment(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    if (localActivity == null)
    {
      QMLog.e("ShareManager", "Failed to start ShareTransitiveFragment, activity is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_origin_task_id", localActivity.getTaskId());
    localIntent.putExtra("key_share_data", paramInnerShareData);
    localIntent.setFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniFragmentLauncher.startTranslucent(localActivity, localIntent, MiniFragmentLauncher.FragmentType.FRAGMENT_SHARE_TRANSITIVE);
  }
  
  private void shareLocalPicMessage(InnerShareData paramInnerShareData)
  {
    if (!paramInnerShareData.isLocalPic)
    {
      QMLog.w("ShareManager", "shareLocalPicMessage. not local pic");
      return;
    }
    if (paramInnerShareData.sharePicPath == null)
    {
      QMLog.w("ShareManager", "shareLocalPicMessage. local pic is null");
      return;
    }
    if (((ShareProxy)ProxyManager.get(ShareProxy.class)).isShareTargetAvailable(paramInnerShareData.fromActivity, paramInnerShareData.shareTarget))
    {
      if (paramInnerShareData.shareInMiniProcess)
      {
        ((ShareProxy)ProxyManager.get(ShareProxy.class)).share(paramInnerShareData.fromActivity, paramInnerShareData);
        return;
      }
      launchShareTransitiveFragment(paramInnerShareData);
    }
  }
  
  private void shareNetworkPicMessage(IMiniAppContext paramIMiniAppContext, InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    ThreadManager.getUIHandler().post(new ShareManager.2(this, localActivity, paramIMiniAppContext, paramInnerShareData));
  }
  
  public void newShareInfoRequest(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null)
    {
      QMLog.e("ShareManager", "Failed to create newShareInfoRequest");
      return;
    }
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("newShareInfoRequest. title=");
      ((StringBuilder)localObject).append(paramInnerShareData.title);
      ((StringBuilder)localObject).append(",sharePicPath=");
      ((StringBuilder)localObject).append(paramInnerShareData.sharePicPath);
      ((StringBuilder)localObject).append(",entryPath=");
      ((StringBuilder)localObject).append(paramInnerShareData.entryPath);
      QMLog.d("ShareManager", ((StringBuilder)localObject).toString());
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QMLog.e("ShareManager", "newShareInfoRequest. mini app info is null!");
      return;
    }
    String str = paramInnerShareData.summary;
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = localMiniAppInfo.desc;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getShareInfo(MiniProgramShareUtils.newShareInfoRequest(localMiniAppInfo.appId, paramInnerShareData.summary, (String)localObject, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), 1, 1, localMiniAppInfo.getReportType(), paramInnerShareData.sharePicPath, null, paramInnerShareData.entryPath, localMiniAppInfo.iconUrl, null, localMiniAppInfo.verType, localMiniAppInfo.versionId, paramInnerShareData.getShareType(), paramInnerShareData.withShareTicket, paramInnerShareData.webURL, null, paramInnerShareData.templateId, paramInnerShareData.templateData, paramInnerShareData.recvOpenId), getShareInfoResult(paramInnerShareData));
  }
  
  public void shareAppMessage(InnerShareData paramInnerShareData)
  {
    if (QUAUtil.isQQMainApp())
    {
      ((ShareProxy)ProxyManager.get(ShareProxy.class)).onJsShareAppMessage(paramInnerShareData);
      return;
    }
    newShareInfoRequest(paramInnerShareData);
  }
  
  public void shareAppPictureMessage(IMiniAppContext paramIMiniAppContext, InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null)
    {
      QMLog.e("ShareManager", "Failed to shareAppPictureMessage. shareData is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareAppPictureMessage. shareData=");
    localStringBuilder.append(paramInnerShareData);
    QMLog.d("ShareManager", localStringBuilder.toString());
    if (QUAUtil.isQQMainApp())
    {
      ((ShareProxy)ProxyManager.get(ShareProxy.class)).onJsShareAppPictureMessage(paramInnerShareData);
      return;
    }
    if (paramInnerShareData.isLocalPic)
    {
      shareLocalPicMessage(paramInnerShareData);
      return;
    }
    shareNetworkPicMessage(paramIMiniAppContext, paramInnerShareData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager
 * JD-Core Version:    0.7.0.1
 */