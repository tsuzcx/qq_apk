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
import bcut;
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
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  implements IWXAPIEventHandler
{
  public static final int MINIPROGRAMTHUMSIZE = 400;
  public static final String PHOTO_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "photo/");
  public static final String QZONE_WEIXINDOWNLOAD = "https://app.qq.com/#id=detail&appid=100733732";
  public static String TAG = WXShareFromQZHelper.class.getSimpleName();
  public static final String WX_APPID = "wx34b037fdb0f655ee";
  public static final String WX_DEBUG_APPID = "wxf22d22dbcb68a585";
  public static final String WX_DEBUG_APPID_EXPERIMENTAL = "wxc577faa50460d9e5";
  public static final String WX_RELEASE_APPID = "wx34b037fdb0f655ee";
  private static byte[] lock = new byte[0];
  private static WXShareFromQZHelper sWXShareHelper;
  private IWXAPI api = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wx34b037fdb0f655ee", true);
  private CopyOnWriteArrayList<WXShareFromQZHelper.WXShareListener> mObserverList = new CopyOnWriteArrayList();
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
    //   2: new 127	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: invokevirtual 134	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_2
    //   14: new 136	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 137	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 138	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_1
    //   26: aload_1
    //   27: aload_2
    //   28: lconst_0
    //   29: aload_2
    //   30: invokevirtual 144	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 148	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_2
    //   38: invokevirtual 151	java/nio/channels/FileChannel:close	()V
    //   41: aload_1
    //   42: invokevirtual 151	java/nio/channels/FileChannel:close	()V
    //   45: return
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 151	java/nio/channels/FileChannel:close	()V
    //   55: aload_1
    //   56: invokevirtual 151	java/nio/channels/FileChannel:close	()V
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -13 -> 51
    //   67: astore_0
    //   68: goto -17 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile1	File
    //   0	71	1	paramFile2	File
    //   13	39	2	localObject1	Object
    //   1	49	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	46	finally
    //   14	26	61	finally
    //   26	37	67	finally
  }
  
  public static void doParseApp(Activity paramActivity, BaseReq paramBaseReq)
  {
    if ((paramActivity != null) && (paramBaseReq != null)) {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        try
        {
          localObject2 = ((ShowMessageFromWX.Req)paramBaseReq).message.messageExt;
          paramBaseReq = bcut.b((String)localObject2);
          if ((paramBaseReq.get("actiontype") != null) && (((String)paramBaseReq.get("actiontype")).equals("schema")) && (paramBaseReq.get("schema") != null))
          {
            localObject1 = Uri.decode((String)paramBaseReq.get("schema"));
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((!((String)localObject1).startsWith("mqzone")) && (!((String)localObject1).startsWith("mqqzone")) && (!((String)localObject1).startsWith("mqqapi://qzoneschema")))) {
              break;
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("cmd", "Schema");
            ((Intent)localObject2).putExtra("schema", (String)localObject1);
            QZoneHelper.forwardToQzoneTransluentActivity(paramActivity, QZoneHelper.UserInfo.getInstance(), (Intent)localObject2);
            paramActivity = (String)paramBaseReq.get("appid");
            if (paramActivity == null)
            {
              i = 0;
              new LpReportInfo_pf00064(2000, 3000, i).reportImediately();
              return;
            }
            int i = Integer.parseInt(paramActivity);
            continue;
          }
          if ((paramBaseReq.get("appid") == null) || (!((String)paramBaseReq.get("appid")).equals("1000398")) || ((!paramBaseReq.containsKey("albumId")) && (!paramBaseReq.containsKey("aid")))) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("cmd", "Schema");
          if ("1".equals(paramBaseReq.get("pagetype")))
          {
            paramBaseReq = ((String)localObject2).replace("aid", "albumid");
            ((Intent)localObject1).putExtra("schema", "mqzone://arouse/album?" + paramBaseReq + "&source=doNotJumpQzone");
            QZoneHelper.forwardToQzoneTransluentActivity(paramActivity, QZoneHelper.UserInfo.getInstance(), (Intent)localObject1);
            return;
          }
        }
        catch (Throwable paramActivity)
        {
          paramActivity.printStackTrace();
          return;
        }
        if ("0".equals(paramBaseReq.get("pagetype"))) {
          ((Intent)localObject1).putExtra("schema", "mqzone://arouse/photofromwxapp?" + (String)localObject2 + "&source=doNotJumpQzone");
        }
      }
    }
  }
  
  public static Uri getFileUri(Context paramContext, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
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
    return null;
  }
  
  public static WXShareFromQZHelper getInstance()
  {
    if (sWXShareHelper == null) {}
    synchronized (lock)
    {
      if (sWXShareHelper == null) {
        sWXShareHelper = new WXShareFromQZHelper();
      }
      return sWXShareHelper;
    }
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
  
  public void addObserver(WXShareFromQZHelper.WXShareListener paramWXShareListener)
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
    return paramString + System.currentTimeMillis();
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
      this.api.handleIntent(paramIntent, this);
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
    if (this.wxEntryActivityRef != null) {}
    for (Activity localActivity = (Activity)this.wxEntryActivityRef.get();; localActivity = null)
    {
      doParseApp(localActivity, paramBaseReq);
      return;
    }
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.mObserverList)
    {
      Iterator localIterator = this.mObserverList.iterator();
      if (localIterator.hasNext()) {
        ((WXShareFromQZHelper.WXShareListener)localIterator.next()).onWXShareResp(paramBaseResp);
      }
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
  
  public void removeObserver(WXShareFromQZHelper.WXShareListener paramWXShareListener)
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
    String str = paramString;
    if (!paramString.contains(AppConstants.SDCARD_PATH + "photo/"))
    {
      str = System.currentTimeMillis() + ".jpeg";
      str = PHOTO_PATH + str;
    }
    try
    {
      File localFile = new File(PHOTO_PATH);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      copyFileUsingFileChannels(new File(paramString), new File(str));
      paramString = new WXImageObject();
      if ((checkVersionValid(paramContext)) && (checkAndroidNotBelowN()))
      {
        QZLog.d(TAG, 1, "shareImage... use getFileUri");
        paramContext = getFileUri(paramContext, new File(str));
        if (paramContext == null)
        {
          QLog.e(TAG, 1, "uri is invalid");
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QZLog.e(TAG, "shareImage exception:", paramContext);
      return;
    }
    for (paramString.imagePath = paramContext.toString();; paramString.imagePath = str)
    {
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
      if (this.api.sendReq(paramString)) {
        break;
      }
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.2(this));
      return;
      QZLog.d(TAG, 1, "shareImage... use old path");
    }
  }
  
  public void shareMiniProgram(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.webpageUrl = paramString3;
    localWXMiniProgramObject.userName = paramString5;
    if (!TextUtils.isEmpty(paramString6))
    {
      localWXMiniProgramObject.path = (paramString4 + "&sk=" + paramString6);
      paramString3 = new WXMediaMessage(localWXMiniProgramObject);
      paramString3.title = paramString1;
      paramString3.description = paramString2;
      if (paramBitmap == null) {
        break label431;
      }
      try
      {
        float f = Math.min(400.0F / paramBitmap.getWidth(), 400.0F / paramBitmap.getHeight());
        paramString1 = new Matrix();
        paramString1.postScale(f, f);
        paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramString1, true);
        paramString3.thumbData = Bitmap2Bytes(paramString1, 100);
        QZLog.e(TAG, "wxshare thumbData:" + paramString3.thumbData.length);
        int j = 4;
        int i = 100;
        while ((paramString3.thumbData != null) && (paramString3.thumbData.length >= 131072))
        {
          j -= 1;
          if (j > 0)
          {
            i -= 10;
            paramString3.thumbData = Bitmap2Bytes(paramString1, i);
            QZLog.e(TAG, "wxshare thumbData -- :" + paramString3.thumbData.length);
            continue;
            paramString1 = new SendMessageToWX.Req();
          }
        }
      }
      catch (Throwable paramString1)
      {
        QZLog.e(TAG, "excetion:" + paramString1.getMessage());
        ThreadManager.getUIHandler().post(new WXShareFromQZHelper.4(this));
      }
    }
    for (;;)
    {
      paramString1.transaction = buildTransaction("webpage");
      paramString1.message = paramString3;
      paramString1.scene = paramInt;
      boolean bool = this.api.sendReq(paramString1);
      if (!bool)
      {
        QZLog.e(TAG, "wxshare failed ,ret:" + bool);
        ThreadManager.getUIHandler().post(new WXShareFromQZHelper.5(this));
      }
      return;
      localWXMiniProgramObject.path = paramString4;
      break;
      paramString1.recycle();
      continue;
      label431:
      QZLog.e(TAG, "wxshare bmp null");
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
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.3(this));
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
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.WXShareFromQZHelper
 * JD-Core Version:    0.7.0.1
 */