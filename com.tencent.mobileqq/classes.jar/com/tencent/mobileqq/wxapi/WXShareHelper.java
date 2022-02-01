package com.tencent.mobileqq.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import aszt;
import bbnz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import npg;
import yyi;

public class WXShareHelper
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  public static final String APP_ID = "wxf0a80d0ac2e82aa7";
  private static final String APP_ID_FOR_MINIPROGRAM = "wxcb89b8fc34e4e304";
  private static final String APP_ID_FOR_QCIRCLE = "wx1d0f5457c7556472";
  public static final String CONTENT_PREFIX = "content://";
  public static final String PHOTO_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "photo/");
  private static final String TAG = "WXShareHelper";
  public static final String WX_AUTHORITY = "com.tencent.mobileqq.fileprovider";
  public static final int WX_IMAGE_THUMB_IMAGE_WIDTH = 100;
  public static final String WX_PACKAGE = "com.tencent.mm";
  private static byte[] lock = new byte[0];
  private static WXShareHelper sWXShareHelper;
  private IWXAPI api = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxf0a80d0ac2e82aa7", true);
  private IWXAPI api_for_qcircle;
  private IWXAPI api_for_tencent_doc;
  Context mContext;
  private ArrayList<WXShareHelper.WXShareListener> mObserverList = new ArrayList(1);
  private BroadcastReceiver qcircleReceiver = new WXShareHelper.2(this);
  private BroadcastReceiver tencenDocReceiver = new WXShareHelper.1(this);
  
  private WXShareHelper()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    registerApp();
    this.api_for_tencent_doc = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxcb89b8fc34e4e304", true);
    BaseApplication.getContext().registerReceiver(this.tencenDocReceiver, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    this.api_for_tencent_doc.registerApp("wxcb89b8fc34e4e304");
    this.api_for_qcircle = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wx1d0f5457c7556472", true);
    BaseApplication.getContext().registerReceiver(this.qcircleReceiver, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    this.api_for_qcircle.registerApp("wx1d0f5457c7556472");
  }
  
  private String buildTransaction(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    return paramString + System.currentTimeMillis();
  }
  
  public static byte[] compressToBytesForWX(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f = Math.max(paramInt / paramBitmap.getWidth(), paramInt / paramBitmap.getHeight());
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f, f);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new ByteArrayOutputStream();
    paramInt = 100;
    byte[] arrayOfByte;
    do
    {
      ((ByteArrayOutputStream)localObject).reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, (OutputStream)localObject);
      arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      paramInt -= 5;
    } while (arrayOfByte.length > 32768);
    return arrayOfByte;
  }
  
  public static byte[] compressToBytesForWX(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    return compressToBytesForWXWithSize(paramBitmap, 100, paramBoolean1, paramBoolean2);
  }
  
  public static byte[] compressToBytesForWXWithSize(Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBitmap == null)
    {
      localObject2 = null;
      return localObject2;
    }
    float f = Math.max(paramInt / paramBitmap.getWidth(), paramInt / paramBitmap.getHeight());
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).postScale(f, f);
    Object localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
    if (paramBoolean2)
    {
      Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, paramInt, paramInt);
      localObject1 = npg.a(localBitmap);
      localBitmap.recycle();
    }
    for (;;)
    {
      ((Bitmap)localObject2).recycle();
      localObject2 = localObject1;
      if (!paramBoolean1) {
        break;
      }
      paramBitmap.recycle();
      return localObject1;
      localObject1 = npg.a((Bitmap)localObject2);
    }
  }
  
  /* Error */
  private static void copyFileUsingFileChannels(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 235	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 238	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: invokevirtual 242	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_2
    //   14: new 244	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 245	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 246	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_1
    //   26: aload_1
    //   27: aload_2
    //   28: lconst_0
    //   29: aload_2
    //   30: invokevirtual 251	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 255	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_2
    //   38: invokevirtual 258	java/nio/channels/FileChannel:close	()V
    //   41: aload_1
    //   42: invokevirtual 258	java/nio/channels/FileChannel:close	()V
    //   45: return
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 258	java/nio/channels/FileChannel:close	()V
    //   55: aload_1
    //   56: invokevirtual 258	java/nio/channels/FileChannel:close	()V
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
  
  private Uri getFileUri(String paramString)
  {
    if (paramString.startsWith("content://"))
    {
      QLog.d("WXShareHelper", 1, "getFileUri path.startsWith(CONTENT_PREFIX)");
      return null;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      QLog.d("WXShareHelper", 1, "file == null || !file.exists()");
      return null;
    }
    paramString = BaseApplication.getContext();
    if (paramString == null)
    {
      QLog.d("WXShareHelper", 1, "null == context");
      return null;
    }
    if (checkAndroidBelowN())
    {
      QLog.d("WXShareHelper", 1, "android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N");
      return null;
    }
    if (!checkVersionValid())
    {
      QLog.d("WXShareHelper", 1, new Object[] { "api.getWXAppSupportAPI()=", Integer.valueOf(this.api.getWXAppSupportAPI()), " < 0x27000D00" });
      return null;
    }
    try
    {
      localObject = FileProvider.getUriForFile(paramString, "com.tencent.mobileqq.fileprovider", (File)localObject);
      paramString.grantUriPermission("com.tencent.mm", (Uri)localObject, 1);
      return localObject;
    }
    catch (Exception paramString)
    {
      QLog.e("WXShareHelper", 1, "getFileUri exception:", paramString);
    }
    return null;
  }
  
  public static WXShareHelper getInstance()
  {
    if (sWXShareHelper == null) {}
    synchronized (lock)
    {
      if (sWXShareHelper == null) {
        sWXShareHelper = new WXShareHelper();
      }
      return sWXShareHelper;
    }
  }
  
  private void shareImageToWX(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    QLog.d("WXShareHelper", 1, "--shareImageToWX");
    if (TextUtils.isEmpty(paramString1))
    {
      yyi.a(1, 2131695956);
      return;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    Uri localUri = getFileUri(paramString1);
    if (localUri == null) {}
    for (;;)
    {
      localWXImageObject.imagePath = paramString1;
      paramString1 = new WXMediaMessage();
      paramString1.mediaObject = localWXImageObject;
      paramString1.thumbData = paramArrayOfByte;
      if (((paramString1.thumbData == null) || (paramString1.thumbData.length > 32768)) && (QLog.isColorLevel())) {
        QLog.i("WXShareHelper", 2, "wxmsg.thumbData is invalid");
      }
      paramArrayOfByte = new SendMessageToWX.Req();
      paramArrayOfByte.transaction = paramString2;
      paramArrayOfByte.message = paramString1;
      paramArrayOfByte.scene = paramInt;
      this.api.sendReq(paramArrayOfByte);
      return;
      paramString1 = localUri.toString();
    }
  }
  
  public void addObserver(WXShareHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.mObserverList)
    {
      if (!this.mObserverList.contains(paramWXShareListener)) {
        this.mObserverList.add(paramWXShareListener);
      }
      return;
    }
  }
  
  public boolean checkAndroidBelowN()
  {
    return Build.VERSION.SDK_INT < 24;
  }
  
  public boolean checkVersionValid()
  {
    return this.api.getWXAppSupportAPI() >= 654314752;
  }
  
  public IWXAPI getApi()
  {
    return this.api;
  }
  
  public boolean isSupportShareFile()
  {
    return this.api.getWXAppSupportAPI() > 654314752;
  }
  
  public boolean isWXinstalled()
  {
    return this.api.isWXAppInstalled();
  }
  
  public boolean isWXsupportApi()
  {
    return this.api.getWXAppSupportAPI() >= 553779201;
  }
  
  public boolean isWxSupportTimeLine()
  {
    return this.api.getWXAppSupportAPI() >= 553779201;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareHelper", 2, "onReceive:");
    }
    this.mContext = paramContext;
    this.api.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareHelper", 2, "WXShareHelper.onReq:" + paramBaseReq);
    }
    try
    {
      paramBaseReq = bbnz.b(((ShowMessageFromWX.Req)paramBaseReq).message.messageExt);
      if ((paramBaseReq.get("actiontype") != null) && (((String)paramBaseReq.get("actiontype")).equals("schema")) && (paramBaseReq.get("schema") != null))
      {
        paramBaseReq = Uri.decode((String)paramBaseReq.get("schema"));
        if (QLog.isColorLevel()) {
          QLog.d("WXShareHelper", 2, "schemaInfo = " + paramBaseReq);
        }
        if ((!TextUtils.isEmpty(paramBaseReq)) && (this.mContext != null))
        {
          paramBaseReq = new Intent("android.intent.action.VIEW", Uri.parse(paramBaseReq));
          this.mContext.startActivity(paramBaseReq);
        }
      }
    }
    catch (Exception paramBaseReq)
    {
      for (;;)
      {
        QLog.e("WXShareHelper", 1, "onReq error.", paramBaseReq);
      }
    }
    this.mContext = null;
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WXShareHelper", 2, "WXShareHelper.onResp:" + paramBaseResp.errCode + " ,errStr:" + paramBaseResp.errStr);
    }
    try
    {
      synchronized (this.mObserverList)
      {
        int i = this.mObserverList.size() - 1;
        while (i >= 0)
        {
          ((WXShareHelper.WXShareListener)this.mObserverList.get(i)).onWXShareResp(paramBaseResp);
          i -= 1;
        }
        return;
      }
      return;
    }
    catch (Exception paramBaseResp)
    {
      QLog.e("WXShareHelper", 1, "WXShareHelper.onResp error, ", paramBaseResp);
    }
  }
  
  public void registerApp()
  {
    if (this.api != null) {
      this.api.registerApp("wxf0a80d0ac2e82aa7");
    }
  }
  
  public void removeObserver(WXShareHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.mObserverList)
    {
      if (this.mObserverList.contains(paramWXShareListener)) {
        this.mObserverList.remove(paramWXShareListener);
      }
      return;
    }
  }
  
  public void shareApolloGameToWXFriendOrCircle(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareHelper", 2, new Object[] { "[shareApolloGameToWXFriendOrCircle], transaction", paramString1, ",title:", paramString2, ",icon:", paramBitmap, ",description", paramString3, ",url:", paramString4, ",type:", Integer.valueOf(paramInt) });
    }
    paramString4 = new WXMediaMessage(new WXWebpageObject(paramString4));
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    if (1 == paramInt) {
      paramString2.scene = 0;
    }
    for (;;)
    {
      this.api.sendReq(paramString2);
      return;
      if (2 == paramInt) {
        paramString2.scene = 1;
      }
    }
  }
  
  public void shareFileToWx(String paramString, Bitmap paramBitmap)
  {
    QLog.d("WXShareHelper", 1, "--shareFileToWx");
    if (TextUtils.isEmpty(paramString))
    {
      yyi.a(1, 2131695956);
      return;
    }
    WXFileObject localWXFileObject = new WXFileObject();
    Object localObject = getFileUri(paramString);
    if (localObject == null) {}
    for (localObject = paramString;; localObject = ((Uri)localObject).toString())
    {
      localWXFileObject.filePath = ((String)localObject);
      localObject = compressToBytesForWX(paramBitmap, false, true);
      paramBitmap = new WXMediaMessage();
      paramBitmap.title = aszt.a(paramString);
      paramBitmap.mediaObject = localWXFileObject;
      paramBitmap.thumbData = ((byte[])localObject);
      if (((paramBitmap.thumbData == null) || (paramBitmap.thumbData.length > 32768)) && (QLog.isColorLevel())) {
        QLog.i("WXShareHelper", 2, "wxmsg.thumbData is invalid");
      }
      paramString = new SendMessageToWX.Req();
      paramString.transaction = buildTransaction("file");
      paramString.message = paramBitmap;
      paramString.scene = 0;
      this.api.sendReq(paramString);
      return;
    }
  }
  
  public void shareImageToWX(String paramString, Bitmap paramBitmap, int paramInt)
  {
    shareImageToWX(paramString, paramBitmap, paramInt, true);
  }
  
  public void shareImageToWX(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      yyi.a(1, 2131695956);
      return;
    }
    shareImageToWX(paramString1, compressToBytesForWX(paramBitmap, paramInt1), paramInt2, paramString2);
  }
  
  public void shareImageToWX(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    shareImageToWX(paramString, paramBitmap, paramInt, paramBoolean, null);
  }
  
  public void shareImageToWX(String paramString1, Bitmap paramBitmap, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      yyi.a(1, 2131695956);
      return;
    }
    shareImageToWX(paramString1, compressToBytesForWX(paramBitmap, false, paramBoolean), paramInt, paramString2);
  }
  
  public void shareMiniProgramToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WXShareHelper", 2, "shareMiniProgramToWX:");
    }
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.webpageUrl = paramString5;
    localWXMiniProgramObject.userName = paramString2;
    localWXMiniProgramObject.path = paramString1;
    paramString1 = new WXMediaMessage(localWXMiniProgramObject);
    paramString1.title = paramString3;
    paramString1.description = paramString4;
    if (paramBitmap != null) {
      paramString1.setThumbImage(paramBitmap);
    }
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = buildTransaction("miniProgram");
    paramString2.message = paramString1;
    paramString2.scene = 0;
    this.api_for_tencent_doc.sendReq(paramString2);
  }
  
  public void shareMiniProgramToWXForPicShare(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, String paramString5, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WXShareHelper", 2, "shareMiniProgramToWXForPicShare:");
    }
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.userName = paramString3;
    localWXMiniProgramObject.webpageUrl = paramString2;
    localWXMiniProgramObject.path = paramString1;
    localWXMiniProgramObject.withShareTicket = paramBoolean;
    localWXMiniProgramObject.miniprogramType = paramInt;
    paramString1 = new WXMediaMessage(localWXMiniProgramObject);
    paramString1.title = paramString4;
    paramString1.description = paramString5;
    if (paramBitmap != null) {
      paramString1.setThumbImage(paramBitmap);
    }
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = buildTransaction("miniProgram");
    paramString2.message = paramString1;
    paramString2.scene = 0;
    this.api.sendReq(paramString2);
  }
  
  public void shareMusic(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    WXMusicObject localWXMusicObject = new WXMusicObject();
    localWXMusicObject.musicLowBandUrl = paramString4;
    localWXMusicObject.musicUrl = paramString4;
    localWXMusicObject.musicDataUrl = paramString5;
    localWXMusicObject.musicLowBandDataUrl = paramString5;
    paramString4 = new WXMediaMessage(localWXMusicObject);
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = paramInt;
    this.api.sendReq(paramString2);
  }
  
  public void shareQcircleImageToWX(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    Object localObject1 = paramString;
    if (!paramString.contains(AppConstants.SDCARD_PATH + "photo/")) {
      localObject1 = System.currentTimeMillis() + ".jpeg";
    }
    Object localObject2;
    for (localObject1 = PHOTO_PATH + (String)localObject1;; localObject1 = ((Uri)localObject2).toString()) {
      try
      {
        localObject2 = new File(PHOTO_PATH);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        copyFileUsingFileChannels(new File(paramString), new File((String)localObject1));
        paramString = new WXImageObject();
        localObject2 = getFileUri((String)localObject1);
        if (localObject2 == null)
        {
          paramString.imagePath = ((String)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = paramString;
          if (paramInt == 0)
          {
            ((WXMediaMessage)localObject1).thumbData = paramArrayOfByte;
            if ((((WXMediaMessage)localObject1).thumbData == null) || (((WXMediaMessage)localObject1).thumbData.length > 32768)) {
              QLog.e("WXShareHelper", 1, "wxmsg.thumbData is invalid");
            }
          }
          paramString = new SendMessageToWX.Req();
          paramString.transaction = buildTransaction("img");
          paramString.message = ((WXMediaMessage)localObject1);
          paramString.scene = paramInt;
          if (this.api_for_qcircle.sendReq(paramString)) {
            break;
          }
          ThreadManager.getUIHandler().post(new WXShareHelper.3(this));
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("WXShareHelper", 2, "shareImage exception:", paramString);
        return;
      }
    }
  }
  
  public void shareQcircleToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXWebpageObject(paramString4));
    localWXMediaMessage.description = paramString3;
    localWXMediaMessage.title = paramString2;
    if (paramBitmap != null) {
      localWXMediaMessage.setThumbImage(paramBitmap);
    }
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString1;
    paramBitmap.message = localWXMediaMessage;
    paramBitmap.scene = paramInt;
    boolean bool = this.api_for_qcircle.sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareWebPage.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label175;
      }
    }
    label175:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WXShareHelper", 2, paramString1 + " reqResult:" + bool);
      return;
    }
  }
  
  public void shareText(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXTextObject(paramString1));
    localWXMediaMessage.description = paramString1;
    paramString1 = new SendMessageToWX.Req();
    paramString1.transaction = paramString2;
    paramString1.message = localWXMediaMessage;
    paramString1.scene = paramInt;
    this.api.sendReq(paramString1);
  }
  
  public void shareTroopToWXFriend(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    paramString4 = new WXMediaMessage(new WXWebpageObject(paramString4));
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = 0;
    this.api.sendReq(paramString2);
  }
  
  public void shareTroopToWXFriendCircle(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    paramString4 = new WXMediaMessage(new WXWebpageObject(paramString4));
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = 1;
    this.api.sendReq(paramString2);
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
    boolean bool = this.api.sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareVideo.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label187;
      }
    }
    label187:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WXShareHelper", 2, paramString1 + " reqResult:" + bool);
      return;
    }
  }
  
  public void shareWebPage(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXWebpageObject(paramString4));
    localWXMediaMessage.description = paramString3;
    localWXMediaMessage.title = paramString2;
    if (paramBitmap != null) {
      localWXMediaMessage.setThumbImage(paramBitmap);
    }
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString1;
    paramBitmap.message = localWXMediaMessage;
    paramBitmap.scene = paramInt;
    boolean bool = this.api.sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareWebPage.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label175;
      }
    }
    label175:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WXShareHelper", 2, paramString1 + " reqResult:" + bool);
      return;
    }
  }
  
  public void shareWebPageToWXFriend(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    shareWebPage(paramString1, paramString2, paramBitmap, paramString3, paramString4, 0);
  }
  
  public void shareWebPageToWXFriendCircle(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    shareWebPage(paramString1, paramString2, paramBitmap, paramString3, paramString4, 1);
  }
  
  public void unRegisterApp()
  {
    if (this.api != null) {
      this.api.unregisterApp();
    }
    if (this.api_for_tencent_doc != null) {
      this.api_for_tencent_doc.unregisterApp();
    }
    if (this.api_for_qcircle != null) {
      this.api_for_qcircle.unregisterApp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXShareHelper
 * JD-Core Version:    0.7.0.1
 */