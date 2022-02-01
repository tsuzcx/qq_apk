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
    try
    {
      paramString = ImageUtil.drawableToBitmap(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(paramActivity, paramString, 0, 0, paramActivity.getResources().getDrawable(R.drawable.mini_sdk_qzone_miniapp_more_button)));
      Object localObject = paramString;
      if (paramString != null)
      {
        localObject = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        QMLog.d("ShareManager", "getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + localObject.length);
        int i = 0;
        while ((i < 10) && (localObject.length > 32768))
        {
          localObject = new Matrix();
          ((Matrix)localObject).setScale(0.7F, 0.7F);
          paramString = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), (Matrix)localObject, true);
          localObject = new ByteArrayOutputStream();
          paramString.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
          localObject = ((ByteArrayOutputStream)localObject).toByteArray();
          QMLog.d("ShareManager", "getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + localObject.length);
          i += 1;
        }
        QMLog.d("ShareManager", "getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + localObject.length);
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      QMLog.w("ShareManager", "getSharePicBitmap. get an exception when handling URLbmp:" + paramString);
    }
    return ImageUtil.drawableToBitmap(paramActivity.getResources().getDrawable(R.drawable.mini_sdk_qzone_miniapp_more_button));
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
    if (!paramInnerShareData.isLocalPic) {
      QMLog.w("ShareManager", "shareLocalPicMessage. not local pic");
    }
    do
    {
      return;
      if (paramInnerShareData.sharePicPath == null)
      {
        QMLog.w("ShareManager", "shareLocalPicMessage. local pic is null");
        return;
      }
    } while (!((ShareProxy)ProxyManager.get(ShareProxy.class)).isShareTargetAvailable(paramInnerShareData.fromActivity, paramInnerShareData.shareTarget));
    if (paramInnerShareData.shareInMiniProcess)
    {
      ((ShareProxy)ProxyManager.get(ShareProxy.class)).share(paramInnerShareData.fromActivity, paramInnerShareData);
      return;
    }
    launchShareTransitiveFragment(paramInnerShareData);
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
    if (QMLog.isColorLevel()) {
      QMLog.d("ShareManager", "newShareInfoRequest. title=" + paramInnerShareData.title + ",sharePicPath=" + paramInnerShareData.sharePicPath + ",entryPath=" + paramInnerShareData.entryPath);
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QMLog.e("ShareManager", "newShareInfoRequest. mini app info is null!");
      return;
    }
    String str2 = paramInnerShareData.summary;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getShareInfo(MiniProgramShareUtils.newShareInfoRequest(localMiniAppInfo.appId, paramInnerShareData.summary, str1, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), 1, 1, localMiniAppInfo.getReportType(), paramInnerShareData.sharePicPath, null, paramInnerShareData.entryPath, localMiniAppInfo.iconUrl, null, localMiniAppInfo.verType, localMiniAppInfo.versionId, paramInnerShareData.getShareType(), paramInnerShareData.withShareTicket, paramInnerShareData.webURL, null, paramInnerShareData.templateId, paramInnerShareData.templateData, paramInnerShareData.recvOpenId), getShareInfoResult(paramInnerShareData));
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
    QMLog.d("ShareManager", "shareAppPictureMessage. shareData=" + paramInnerShareData);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager
 * JD-Core Version:    0.7.0.1
 */