package cooperation.qzone.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.qzone.QzoneMapUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class WXShareFromQZHelper
{
  public static String TAG = "WXShareFromQZHelper";
  private static byte[] lock = new byte[0];
  private static WXShareFromQZHelper sWXShareHelper = null;
  private IWXAPI api = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wx34b037fdb0f655ee", true);
  private IWXAPIEventHandler handler = new WXShareFromQZHelper.1(this);
  private CopyOnWriteArrayList<IQzoneShareApi.WXShareListener> mObserverList = new CopyOnWriteArrayList();
  WeakReference<Activity> wxEntryActivityRef = null;
  
  private WXShareFromQZHelper()
  {
    registerApp();
  }
  
  public static byte[] Bitmap2Bytes(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  /* Error */
  private static void copyFileUsingFileChannels(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 92	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: invokevirtual 99	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_0
    //   14: new 101	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 103	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: lconst_0
    //   29: aload_0
    //   30: invokevirtual 109	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 113	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_0
    //   38: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   41: aload_2
    //   42: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   45: return
    //   46: astore_1
    //   47: goto +14 -> 61
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: goto +8 -> 61
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_3
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   65: aload_2
    //   66: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile1	File
    //   0	71	1	paramFile2	File
    //   25	41	2	localFileChannel	java.nio.channels.FileChannel
    //   1	59	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	37	46	finally
    //   14	26	50	finally
    //   2	14	56	finally
  }
  
  public static void doParseApp(Activity paramActivity, BaseReq paramBaseReq)
  {
    if ((paramActivity != null) && (paramBaseReq != null)) {
      try
      {
        Object localObject2 = ((ShowMessageFromWX.Req)paramBaseReq).message.messageExt;
        paramBaseReq = QzoneMapUtil.b((String)localObject2);
        Object localObject1 = paramBaseReq.get("actiontype");
        if ((localObject1 != null) && (((String)paramBaseReq.get("actiontype")).equals("schema")) && (paramBaseReq.get("schema") != null))
        {
          localObject1 = Uri.decode((String)paramBaseReq.get("schema"));
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith("mqzone")) || (((String)localObject1).startsWith("mqqzone")) || (((String)localObject1).startsWith("mqqapi://qzoneschema"))))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("cmd", "Schema");
            ((Intent)localObject2).putExtra("schema", (String)localObject1);
            QZoneHelper.forwardToQzoneTransluentActivity(paramActivity, QZoneHelper.UserInfo.getInstance(), (Intent)localObject2);
            paramActivity = (String)paramBaseReq.get("appid");
            int i;
            if (paramActivity == null) {
              i = 0;
            } else {
              i = Integer.parseInt(paramActivity);
            }
            new LpReportInfo_pf00064(2000, 3000, i).reportImediately();
          }
        }
        else if ((paramBaseReq.get("appid") != null) && (((String)paramBaseReq.get("appid")).equals("1000398")))
        {
          boolean bool = paramBaseReq.containsKey("albumId");
          if ((bool) || (paramBaseReq.containsKey("aid")))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("cmd", "Schema");
            bool = "1".equals(paramBaseReq.get("pagetype"));
            if (bool)
            {
              paramBaseReq = ((String)localObject2).replace("aid", "albumid");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("mqzone://arouse/album?");
              ((StringBuilder)localObject2).append(paramBaseReq);
              ((StringBuilder)localObject2).append("&source=doNotJumpQzone");
              ((Intent)localObject1).putExtra("schema", ((StringBuilder)localObject2).toString());
            }
            else if ("0".equals(paramBaseReq.get("pagetype")))
            {
              paramBaseReq = new StringBuilder();
              paramBaseReq.append("mqzone://arouse/photofromwxapp?");
              paramBaseReq.append((String)localObject2);
              paramBaseReq.append("&source=doNotJumpQzone");
              ((Intent)localObject1).putExtra("schema", paramBaseReq.toString());
            }
            QZoneHelper.forwardToQzoneTransluentActivity(paramActivity, QZoneHelper.UserInfo.getInstance(), (Intent)localObject1);
            return;
          }
        }
      }
      catch (Throwable paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static Uri getFileUri(Context paramContext, File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return null;
      }
      try
      {
        paramFile = FileProvider.getUriForFile(paramContext, "com.tencent.mobileqq.fileprovider", paramFile);
        paramContext.grantUriPermission("com.tencent.mm", paramFile, 1);
        return paramFile;
      }
      catch (Exception paramContext)
      {
        QZLog.e(TAG, "getFileUri exception:", paramContext);
      }
    }
    return null;
  }
  
  public static WXShareFromQZHelper getInstance()
  {
    if (sWXShareHelper == null) {
      synchronized (lock)
      {
        if (sWXShareHelper == null) {
          sWXShareHelper = new WXShareFromQZHelper();
        }
      }
    }
    return sWXShareHelper;
  }
  
  public static void jmpWeixinDetail(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", QzoneConfig.getInstance().getConfig("H5Url", "WeiXinDownload", "https://app.qq.com/#id=detail&appid=100733732"));
      localIntent.putExtra("fromQZone", true);
      localIntent.addFlags(268435456);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public void addObserver(IQzoneShareApi.WXShareListener paramWXShareListener)
  {
    synchronized (this.mObserverList)
    {
      if (!this.mObserverList.contains(paramWXShareListener)) {
        this.mObserverList.add(paramWXShareListener);
      }
      return;
    }
  }
  
  public String buildTransaction(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(System.currentTimeMillis());
    return localStringBuilder.toString();
  }
  
  public boolean checkAndroidNotBelowN()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public boolean checkVersionValid(Context paramContext)
  {
    return this.api.getWXAppSupportAPI() >= 654314752;
  }
  
  public void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent)
  {
    if (this.api != null)
    {
      this.wxEntryActivityRef = new WeakReference(paramActivity);
      this.api.handleIntent(paramIntent, this.handler);
    }
  }
  
  public boolean isWXinstalled()
  {
    try
    {
      boolean bool = this.api.isWXAppInstalled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, "isWXinstalled error ", localThrowable);
    }
    return false;
  }
  
  @Deprecated
  public boolean isWXsupportApi()
  {
    return this.api.getWXAppSupportAPI() >= 553779201;
  }
  
  public boolean isWxSupportMiniProgramm()
  {
    return this.api.getWXAppSupportAPI() >= 620756993;
  }
  
  public boolean isWxSupportTimeLine()
  {
    return this.api.getWXAppSupportAPI() >= 553779201;
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    Object localObject = this.wxEntryActivityRef;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    doParseApp((Activity)localObject, paramBaseReq);
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = this.mObserverList.iterator();
      while (localIterator.hasNext()) {
        ((IQzoneShareApi.WXShareListener)localIterator.next()).onWXShareResp(paramBaseResp);
      }
      return;
    }
    for (;;)
    {
      throw paramBaseResp;
    }
  }
  
  public void registerApp()
  {
    try
    {
      this.api.registerApp("wx34b037fdb0f655ee");
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
  }
  
  public void removeObserver(IQzoneShareApi.WXShareListener paramWXShareListener)
  {
    synchronized (this.mObserverList)
    {
      if (this.mObserverList.contains(paramWXShareListener)) {
        this.mObserverList.remove(paramWXShareListener);
      }
      return;
    }
  }
  
  public void shareImage(Context paramContext, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject2).append("photo/");
    Object localObject1 = paramString;
    if (!paramString.contains(((StringBuilder)localObject2).toString()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(".jpeg");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(IQzoneShareApi.PHOTO_PATH);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      try
      {
        localObject2 = new File(IQzoneShareApi.PHOTO_PATH);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        copyFileUsingFileChannels(new File(paramString), new File((String)localObject1));
      }
      catch (Throwable paramContext)
      {
        QZLog.e(TAG, "shareImage exception:", paramContext);
        return;
      }
    }
    paramString = new WXImageObject();
    if ((checkVersionValid(paramContext)) && (checkAndroidNotBelowN()))
    {
      QZLog.d(TAG, 1, "shareImage... use getFileUri");
      paramContext = getFileUri(paramContext, new File((String)localObject1));
      if (paramContext == null)
      {
        QLog.e(TAG, 1, "uri is invalid");
        return;
      }
      paramString.imagePath = paramContext.toString();
    }
    else
    {
      QZLog.d(TAG, 1, "shareImage... use old path");
      paramString.imagePath = ((String)localObject1);
    }
    paramContext = new WXMediaMessage();
    paramContext.mediaObject = paramString;
    if (paramInt == 0)
    {
      paramContext.thumbData = paramArrayOfByte;
      if ((paramContext.thumbData == null) || ((paramContext.thumbData != null) && (paramContext.thumbData.length > 32768))) {
        QLog.e(TAG, 1, "wxmsg.thumbData is invalid");
      }
    }
    paramString = new SendMessageToWX.Req();
    paramString.transaction = buildTransaction("img");
    paramString.message = paramContext;
    paramString.scene = paramInt;
    if (!this.api.sendReq(paramString)) {
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.3(this));
    }
  }
  
  public void shareMiniProgram(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.webpageUrl = paramString3;
    localWXMiniProgramObject.userName = paramString5;
    if (!TextUtils.isEmpty(paramString6))
    {
      paramString3 = new StringBuilder();
      paramString3.append(paramString4);
      paramString3.append("&sk=");
      paramString3.append(paramString6);
      localWXMiniProgramObject.path = paramString3.toString();
    }
    else
    {
      localWXMiniProgramObject.path = paramString4;
    }
    paramString3 = new WXMediaMessage(localWXMiniProgramObject);
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    int i = 100;
    if (paramBitmap != null) {}
    try
    {
      float f = Math.min(400.0F / paramBitmap.getWidth(), 400.0F / paramBitmap.getHeight());
      paramString1 = new Matrix();
      paramString1.postScale(f, f);
      paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramString1, true);
      paramString3.thumbData = Bitmap2Bytes(paramString1, 100);
      paramBitmap = TAG;
      paramString2 = new StringBuilder();
      paramString2.append("wxshare thumbData:");
      paramString2.append(paramString3.thumbData.length);
      QZLog.e(paramBitmap, paramString2.toString());
      int j = 4;
      while ((paramString3.thumbData != null) && (paramString3.thumbData.length >= 131072))
      {
        j -= 1;
        if (j <= 0) {
          break;
        }
        i -= 10;
        paramString3.thumbData = Bitmap2Bytes(paramString1, i);
        paramBitmap = TAG;
        paramString2 = new StringBuilder();
        paramString2.append("wxshare thumbData -- :");
        paramString2.append(paramString3.thumbData.length);
        QZLog.e(paramBitmap, paramString2.toString());
      }
      paramString1.recycle();
    }
    catch (Throwable paramString1)
    {
      paramBitmap = TAG;
      paramString2 = new StringBuilder();
      paramString2.append("excetion:");
      paramString2.append(paramString1.getMessage());
      QZLog.e(paramBitmap, paramString2.toString());
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.5(this));
    }
    QZLog.e(TAG, "wxshare bmp null");
    paramString1 = new SendMessageToWX.Req();
    paramString1.transaction = buildTransaction("webpage");
    paramString1.message = paramString3;
    paramString1.scene = paramInt;
    boolean bool = this.api.sendReq(paramString1);
    if (!bool)
    {
      paramString1 = TAG;
      paramBitmap = new StringBuilder();
      paramBitmap.append("wxshare failed ,ret:");
      paramBitmap.append(bool);
      QZLog.e(paramString1, paramBitmap.toString());
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.6(this));
    }
  }
  
  public void shareMutilPicToWehat(Context paramContext, ArrayList<File> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
    localIntent.setAction("android.intent.action.SEND_MULTIPLE");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Uri localUri = getFileUri(paramContext, (File)paramArrayList.next());
      if (localUri != null) {
        localArrayList.add(localUri);
      }
    }
    localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
    FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getApplication(), localIntent);
    paramContext.startActivity(localIntent);
  }
  
  public void shareText(String paramString, int paramInt)
  {
    Object localObject = new WXTextObject(paramString);
    paramString = new WXMediaMessage();
    paramString.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
    localObject = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject).transaction = buildTransaction("text");
    ((SendMessageToWX.Req)localObject).message = paramString;
    ((SendMessageToWX.Req)localObject).scene = paramInt;
    if (!this.api.sendReq((BaseReq)localObject)) {
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.4(this));
    }
  }
  
  public void shareWebPage(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = new WXMediaMessage(new WXWebpageObject(paramString3));
    paramString3.description = paramString2;
    paramString3.title = paramString1;
    paramString3.thumbData = WXShareHelper.a(paramBitmap, false, true);
    paramString1 = new SendMessageToWX.Req();
    paramString1.transaction = buildTransaction("webpage");
    paramString1.message = paramString3;
    paramString1.scene = paramInt;
    if (!this.api.sendReq(paramString1)) {
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.WXShareFromQZHelper
 * JD-Core Version:    0.7.0.1
 */