package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class WxShareHelperFromReadInjoy
  extends BroadcastReceiver
  implements IWXAPIEventHandler, IWxShareHelperFromReadInjoy
{
  private static final String APP_ID = "wxeaef4303c20f3dea";
  private static final int LAUNCH_WX_PENDING_INTENT_REQUEST_CODE = 1;
  private static final String TAG = "WxShareHelperFromReadInjoy";
  private static final int TIME_GAP = 300;
  public static final int WX_IMAGE_THUMB_IMAGE_WIDTH = 100;
  private static byte[] lock = new byte[0];
  private static WxShareHelperFromReadInjoy sWXShareHelper = null;
  private IWXAPI api = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxeaef4303c20f3dea", true);
  private Boolean isInstallWechat;
  private ArrayList<IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener> mObserverList = new ArrayList(1);
  private int mWXAppSupportAPI = this.api.getWXAppSupportAPI();
  private String mWXJumpUrlLastTime = "";
  private Long mWXJumpUrlLastTimeTime = Long.valueOf(0L);
  private WeakReference<Activity> mWxEntryActivityRef = null;
  
  private WxShareHelperFromReadInjoy()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    registerApp();
  }
  
  private static byte[] bitmap2Bytes(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      QLog.e("WxShareHelperFromReadInjoy", 1, "[bitmap2Bytes] bitmap is null.");
      return null;
    }
    int i = 100;
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    for (localObject = ((ByteArrayOutputStream)localObject).toByteArray(); (localObject.length >= 131072) && (i > 0); localObject = ((ByteArrayOutputStream)localObject).toByteArray())
    {
      i -= 10;
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
    }
    paramBitmap = new StringBuilder();
    paramBitmap.append("[bitmap2Bytes] length = ");
    paramBitmap.append(localObject.length);
    paramBitmap.append(", quality = ");
    paramBitmap.append(i);
    QLog.i("WxShareHelperFromReadInjoy", 1, paramBitmap.toString());
    return localObject;
  }
  
  public static byte[] compressToBytesForWX(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f = Math.max(100.0F / paramBitmap.getWidth(), 100.0F / paramBitmap.getHeight());
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f, f);
    Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    if (paramBoolean2)
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, 100, 100);
      localObject = ImageUtil.a(localBitmap2);
      localBitmap2.recycle();
    }
    else
    {
      localObject = ImageUtil.a(localBitmap1);
    }
    localBitmap1.recycle();
    if (paramBoolean1) {
      paramBitmap.recycle();
    }
    return localObject;
  }
  
  public static WxShareHelperFromReadInjoy getInstance()
  {
    if (sWXShareHelper == null) {
      synchronized (lock)
      {
        if (sWXShareHelper == null) {
          sWXShareHelper = new WxShareHelperFromReadInjoy();
        }
      }
    }
    return sWXShareHelper;
  }
  
  private boolean getSwitchValueByKey(String paramString)
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean(paramString, false);
    }
    return false;
  }
  
  private void handleWXStartReport(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("WxShareHelperFromReadInjoy", 2, "handleWXStartReport error, url is empty ");
      return;
    }
    Object localObject1 = Uri.parse(paramString);
    paramString = ((Uri)localObject1).getQueryParameter("from_source");
    localObject1 = ((Uri)localObject1).getQueryParameter("from_rowkey");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleWXStartReport fromSource = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" fromRowkey = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("WxShareHelperFromReadInjoy", 2, ((StringBuilder)localObject2).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("from_source", paramString);
        ((JSONObject)localObject2).put("from_rowkey", localObject1);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800A7BF", "0X800A7BF", 0, 0, "", "", "", ((JSONObject)localObject2).toString(), false);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void launchWXUsingPendingIntent()
  {
    try
    {
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      if (QLog.isColorLevel()) {
        QLog.i("WxShareHelperFromReadInjoy", 2, "launchWXUsingPendingIntent");
      }
      PendingIntent.getActivity(localContext, 1, localContext.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"), 134217728).send(localContext, 1, null, new WxShareHelperFromReadInjoy.2(this), null);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchWXUsingPendingIntent pendingIntent send failed: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("WxShareHelperFromReadInjoy", 1, localStringBuilder.toString());
      this.api.openWXApp();
    }
  }
  
  private boolean sendReq(SendMessageToWX.Req paramReq)
  {
    WxShareHelperFromReadInjoy.3 local3 = new WxShareHelperFromReadInjoy.3(this);
    WXShareHelper.a().a(local3);
    return this.api.sendReq(paramReq);
  }
  
  public void addObserver(IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener)
  {
    synchronized (this.mObserverList)
    {
      if (!this.mObserverList.contains(paramWXShareHelperFromReadInjoyListener)) {
        this.mObserverList.add(paramWXShareHelperFromReadInjoyListener);
      }
      return;
    }
  }
  
  public boolean doOpenMiniProgram(String paramString1, String paramString2, int paramInt)
  {
    if ((isWXAppInstalled()) && (isSupportLaunchMiniProgram()))
    {
      if (Build.VERSION.SDK_INT >= 29) {
        launchWXUsingPendingIntent();
      }
      WXLaunchMiniProgram.Req localReq = new WXLaunchMiniProgram.Req();
      localReq.userName = paramString1;
      localReq.path = paramString2;
      localReq.miniprogramType = paramInt;
      return this.api.sendReq(localReq);
    }
    return false;
  }
  
  public void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WxShareHelperFromReadInjoy", 2, "handleWXEntryActivityIntent");
    }
    if (this.api != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WxShareHelperFromReadInjoy", 2, "handleWXEntryActivityIntent api != null");
      }
      this.mWxEntryActivityRef = new WeakReference(paramActivity);
      this.api.handleIntent(paramIntent, this);
    }
  }
  
  public boolean isSupportLaunchMiniProgram()
  {
    return this.mWXAppSupportAPI >= 620757000;
  }
  
  public boolean isWXAppInstalled()
  {
    if (this.isInstallWechat == null) {
      this.isInstallWechat = Boolean.valueOf(this.api.isWXAppInstalled());
    }
    return this.isInstallWechat.booleanValue();
  }
  
  public boolean isWXinstalled()
  {
    return this.api.isWXAppInstalled();
  }
  
  public boolean isWXsupportApi()
  {
    return this.api.getWXAppSupportAPI() >= 553779201;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.api.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WXShareHelper.onReq:");
      ((StringBuilder)localObject1).append(paramBaseReq.getType());
      QLog.i("WxShareHelperFromReadInjoy", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.mWxEntryActivityRef;
    if (localObject1 != null) {
      localObject1 = (Activity)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WXShareHelper.onReq:");
      ((StringBuilder)localObject1).append(paramBaseReq.getType());
      ((StringBuilder)localObject1).append(" activity == null.");
      QLog.e("WxShareHelperFromReadInjoy", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    if (paramBaseReq.getType() != 4) {
      return;
    }
    if ((paramBaseReq instanceof ShowMessageFromWX.Req))
    {
      paramBaseReq = ((ShowMessageFromWX.Req)paramBaseReq).message.messageExt;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("WXShareHelper.onReq: url = ");
        ((StringBuilder)localObject2).append(paramBaseReq);
        QLog.i("WxShareHelperFromReadInjoy", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = Long.valueOf(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramBaseReq))
      {
        if ((paramBaseReq.equals(this.mWXJumpUrlLastTime)) && (((Long)localObject2).longValue() - this.mWXJumpUrlLastTimeTime.longValue() < 300L)) {
          return;
        }
        Intent localIntent = new Intent((Context)localObject1, JumpActivity.class);
        localIntent.setData(Uri.parse(paramBaseReq));
        ((Activity)localObject1).startActivity(localIntent);
        handleWXStartReport(paramBaseReq);
        this.mWXJumpUrlLastTime = paramBaseReq;
        this.mWXJumpUrlLastTimeTime = ((Long)localObject2);
      }
    }
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("WXShareHelper.onResp:");
      ((StringBuilder)???).append(paramBaseResp.errCode);
      ((StringBuilder)???).append(" ,errStr:");
      ((StringBuilder)???).append(paramBaseResp.errStr);
      QLog.i("WxShareHelperFromReadInjoy", 2, ((StringBuilder)???).toString());
    }
    try
    {
      synchronized (this.mObserverList)
      {
        int i = this.mObserverList.size() - 1;
        while (i >= 0)
        {
          ((IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener)this.mObserverList.get(i)).a(paramBaseResp);
          i -= 1;
        }
        return;
      }
      return;
    }
    catch (Exception paramBaseResp)
    {
      QLog.e("WxShareHelperFromReadInjoy", 1, "WXShareHelper.onResp error, ", paramBaseResp);
    }
  }
  
  public void registerApp()
  {
    this.api.registerApp("wxeaef4303c20f3dea");
  }
  
  public void removeObserver(IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener)
  {
    synchronized (this.mObserverList)
    {
      this.mObserverList.remove(paramWXShareHelperFromReadInjoyListener);
      return;
    }
  }
  
  public void shareImageToWX(String paramString, Bitmap paramBitmap, int paramInt)
  {
    shareImageToWX(paramString, paramBitmap, paramInt, true);
  }
  
  public void shareImageToWX(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131696479);
      return;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.imagePath = paramString;
    paramString = new WXMediaMessage();
    paramString.mediaObject = localWXImageObject;
    paramString.thumbData = compressToBytesForWX(paramBitmap, false, paramBoolean);
    if (((paramString.thumbData == null) || ((paramString.thumbData != null) && (paramString.thumbData.length > 32768))) && (QLog.isColorLevel())) {
      QLog.i("WxShareHelperFromReadInjoy", 2, "wxmsg.thumbData is invalid");
    }
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.message = paramString;
    paramBitmap.scene = paramInt;
    sendReq(paramBitmap);
  }
  
  public void shareImageToWX(String paramString1, Bitmap paramBitmap, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QRUtils.a(1, 2131696479);
      return;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.imagePath = paramString1;
    paramString1 = new WXMediaMessage();
    paramString1.mediaObject = localWXImageObject;
    paramString1.thumbData = compressToBytesForWX(paramBitmap, false, paramBoolean);
    if (((paramString1.thumbData == null) || ((paramString1.thumbData != null) && (paramString1.thumbData.length > 32768))) && (QLog.isColorLevel())) {
      QLog.i("WxShareHelperFromReadInjoy", 2, "wxmsg.thumbData is invalid");
    }
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString2;
    paramBitmap.message = paramString1;
    paramBitmap.scene = paramInt;
    sendReq(paramBitmap);
  }
  
  public void shareMiniProgram(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/pages/index/index?share=1&share_type=2&channel_id=10&rowkey=");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("&title=");
    localStringBuilder.append(URLEncoder.encode(paramString2));
    localStringBuilder.append("&timeTips=");
    localStringBuilder.append(new SimpleDateFormat("MM-dd").format(new Date()));
    shareToMiniProgramWithPath(paramString1, paramString2, paramBitmap, paramString3, paramString4, localStringBuilder.toString());
  }
  
  public void shareToMiniProgramWithPath(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
  {
    shareToMiniProgramWithPathAndId(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramString5, "gh_eaa1f0b1626b");
  }
  
  public void shareToMiniProgramWithPathAndId(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ThreadManagerV2.excute(new WxShareHelperFromReadInjoy.1(this, paramString4, paramString6, paramString5, paramString2, paramString3, paramBitmap, paramString1), 16, null, true);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("shareToMiniProgramWithPathAndId, title = ");
      paramString1.append(paramString2);
      paramString1.append(", description = ");
      paramString1.append(paramString3);
      paramString1.append(", path = ");
      paramString1.append(paramString5);
      paramString1.append(", webPageUrl = ");
      paramString1.append(paramString4);
      paramString1.append(", id = ");
      paramString1.append(paramString6);
      QLog.d("WxShareHelperFromReadInjoy", 2, paramString1.toString());
    }
  }
  
  public void shareVideo(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    Object localObject = new WXVideoObject();
    ((WXVideoObject)localObject).videoUrl = paramString4;
    ((WXVideoObject)localObject).videoLowBandUrl = paramString4;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).description = paramString3;
    ((WXMediaMessage)localObject).title = paramString2;
    ((WXMediaMessage)localObject).setThumbImage(paramBitmap);
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString1;
    paramBitmap.message = ((WXMediaMessage)localObject);
    paramBitmap.scene = paramInt;
    boolean bool = sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("shareVideo.transaction: ");
      paramBitmap.append(paramString1);
      paramBitmap.append(" title:");
      paramBitmap.append(paramString2);
      paramBitmap.append(" description:");
      paramBitmap.append(paramString3);
      paramBitmap.append(" webPageUrl:");
      paramBitmap.append(paramString4);
      paramBitmap.append(" scene:");
      if (paramInt == 0) {
        paramString1 = "Friend";
      } else {
        paramString1 = "FriendCircle";
      }
      paramBitmap.append(paramString1);
      paramBitmap.append(" reqResult:");
      paramBitmap.append(bool);
      QLog.i("WxShareHelperFromReadInjoy", 2, paramBitmap.toString());
    }
  }
  
  public void shareVideoMiniProgram(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/pages/index/index?share=1&share_type=1&channel_id=10&rowkey=");
    localStringBuilder.append(paramString5);
    shareToMiniProgramWithPath(paramString1, paramString2, paramBitmap, paramString3, paramString4, localStringBuilder.toString());
  }
  
  public void shareWebPage(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXWebpageObject(paramString4));
    localWXMediaMessage.description = paramString3;
    localWXMediaMessage.title = paramString2;
    localWXMediaMessage.setThumbImage(paramBitmap);
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString1;
    paramBitmap.message = localWXMediaMessage;
    paramBitmap.scene = paramInt;
    boolean bool = sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("shareWebPage.transaction: ");
      paramBitmap.append(paramString1);
      paramBitmap.append(" title:");
      paramBitmap.append(paramString2);
      paramBitmap.append(" description:");
      paramBitmap.append(paramString3);
      paramBitmap.append(" webPageUrl:");
      paramBitmap.append(paramString4);
      paramBitmap.append(" scene:");
      if (paramInt == 0) {
        paramString1 = "Friend";
      } else {
        paramString1 = "FriendCircle";
      }
      paramBitmap.append(paramString1);
      paramBitmap.append(" reqResult:");
      paramBitmap.append(bool);
      QLog.i("WxShareHelperFromReadInjoy", 2, paramBitmap.toString());
    }
  }
  
  public void unRegisterApp()
  {
    this.api.unregisterApp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy
 * JD-Core Version:    0.7.0.1
 */