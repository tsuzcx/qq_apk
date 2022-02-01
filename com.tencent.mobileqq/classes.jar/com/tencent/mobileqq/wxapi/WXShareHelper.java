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
import com.tencent.mobileqq.service.qzone.QzoneMapUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class WXShareHelper
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WXShareHelper jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper = null;
  public static final String a;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  Context jdField_a_of_type_AndroidContentContext;
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxf0a80d0ac2e82aa7", true);
  private ArrayList<WXShareHelper.WXShareListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  private IWXAPI b;
  private IWXAPI c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("photo/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  private WXShareHelper()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    a();
    this.b = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxcb89b8fc34e4e304", true);
    this.b.registerApp("wxcb89b8fc34e4e304");
    this.c = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wx1d0f5457c7556472", true);
    this.c.registerApp("wx1d0f5457c7556472");
  }
  
  private Uri a(String paramString)
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
    if (f())
    {
      QLog.d("WXShareHelper", 1, "android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N");
      return null;
    }
    if (!e())
    {
      QLog.d("WXShareHelper", 1, new Object[] { "api.getWXAppSupportAPI()=", Integer.valueOf(this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI()), " < 0x27000D00" });
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
  
  public static WXShareHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper == null) {
          jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper = new WXShareHelper();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper;
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(System.currentTimeMillis());
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 200	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 203	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: invokevirtual 207	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_0
    //   14: new 209	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 210	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 211	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: lconst_0
    //   29: aload_0
    //   30: invokevirtual 216	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 220	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_0
    //   38: invokevirtual 223	java/nio/channels/FileChannel:close	()V
    //   41: aload_2
    //   42: invokevirtual 223	java/nio/channels/FileChannel:close	()V
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
    //   62: invokevirtual 223	java/nio/channels/FileChannel:close	()V
    //   65: aload_2
    //   66: invokevirtual 223	java/nio/channels/FileChannel:close	()V
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
  
  private void a(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    QLog.d("WXShareHelper", 1, "--shareImageToWX");
    if (TextUtils.isEmpty(paramString1))
    {
      QQToastUtil.a(1, 2131696479);
      return;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    Uri localUri = a(paramString1);
    if (localUri != null) {
      paramString1 = localUri.toString();
    }
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
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramArrayOfByte);
  }
  
  public static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f = paramInt;
    f = Math.max(f / paramBitmap.getWidth(), f / paramBitmap.getHeight());
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
  
  public static byte[] a(Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f = paramInt;
    f = Math.max(f / paramBitmap.getWidth(), f / paramBitmap.getHeight());
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f, f);
    Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    if (paramBoolean2)
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, paramInt, paramInt);
      localObject = BaseImageUtil.a(localBitmap2);
      localBitmap2.recycle();
    }
    else
    {
      localObject = BaseImageUtil.a(localBitmap1);
    }
    localBitmap1.recycle();
    if (paramBoolean1) {
      paramBitmap.recycle();
    }
    return localObject;
  }
  
  public static byte[] a(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBitmap, 100, paramBoolean1, paramBoolean2);
  }
  
  public IWXAPI a()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI;
  }
  
  public void a()
  {
    IWXAPI localIWXAPI = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI;
    if (localIWXAPI != null) {
      localIWXAPI.registerApp("wxf0a80d0ac2e82aa7");
    }
  }
  
  public void a(WXShareHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramWXShareListener);
      }
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
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
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString1);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    QLog.d("WXShareHelper", 1, "--shareFileToWx");
    if (TextUtils.isEmpty(paramString))
    {
      QQToastUtil.a(1, 2131696479);
      return;
    }
    WXFileObject localWXFileObject = new WXFileObject();
    Object localObject = a(paramString);
    if (localObject == null) {
      localObject = paramString;
    } else {
      localObject = ((Uri)localObject).toString();
    }
    localWXFileObject.filePath = ((String)localObject);
    localObject = a(paramBitmap, false, true);
    paramBitmap = new WXMediaMessage();
    paramBitmap.title = FileUtils.getFileName(paramString);
    paramBitmap.mediaObject = localWXFileObject;
    paramBitmap.thumbData = ((byte[])localObject);
    if (((paramBitmap.thumbData == null) || (paramBitmap.thumbData.length > 32768)) && (QLog.isColorLevel())) {
      QLog.i("WXShareHelper", 2, "wxmsg.thumbData is invalid");
    }
    paramString = new SendMessageToWX.Req();
    paramString.transaction = a("file");
    paramString.message = paramBitmap;
    paramString.scene = 0;
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    a(paramString, paramBitmap, paramInt, true);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QQToastUtil.a(1, 2131696479);
      return;
    }
    a(paramString1, a(paramBitmap, paramInt1), paramInt2, paramString2);
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    a(paramString, paramBitmap, paramInt, paramBoolean, null);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QQToastUtil.a(1, 2131696479);
      return;
    }
    a(paramString1, a(paramBitmap, false, paramBoolean), paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    paramString4 = new WXMediaMessage(new WXWebpageObject(paramString4));
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = 1;
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
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
    boolean bool = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramBitmap);
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
      QLog.i("WXShareHelper", 2, paramBitmap.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt, String paramString5)
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
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, String paramString5)
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
    paramString2.transaction = a("miniProgram");
    paramString2.message = paramString1;
    paramString2.scene = 0;
    this.b.sendReq(paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, String paramString5, boolean paramBoolean, int paramInt)
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
    paramString2.transaction = a("miniProgram");
    paramString2.message = paramString1;
    paramString2.scene = 0;
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString2);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramString == null) {
      return;
    }
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
      ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      try
      {
        localObject2 = new File(jdField_a_of_type_JavaLangString);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        a(new File(paramString), new File((String)localObject1));
      }
      catch (Throwable paramString)
      {
        QLog.e("WXShareHelper", 2, "shareImage exception:", paramString);
        return;
      }
    }
    paramString = new WXImageObject();
    localObject2 = a((String)localObject1);
    if (localObject2 != null) {
      localObject1 = ((Uri)localObject2).toString();
    }
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
    paramString.transaction = a("img");
    paramString.message = ((WXMediaMessage)localObject1);
    paramString.scene = paramInt;
    if (!this.c.sendReq(paramString)) {
      ThreadManager.getUIHandler().post(new WXShareHelper.1(this));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public void b(WXShareHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramWXShareListener);
      }
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    paramString4 = new WXMediaMessage(new WXWebpageObject(paramString4));
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = 0;
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString2);
  }
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
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
    boolean bool = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramBitmap);
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
      QLog.i("WXShareHelper", 2, paramBitmap.toString());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 553779201;
  }
  
  public void c(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramBitmap, paramString3, paramString4, 1);
  }
  
  public void c(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
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
    boolean bool = this.c.sendReq(paramBitmap);
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
      QLog.i("WXShareHelper", 2, paramBitmap.toString());
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 553779201;
  }
  
  public void d(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramBitmap, paramString3, paramString4, 0);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() > 654314752;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 654314752;
  }
  
  public boolean f()
  {
    return Build.VERSION.SDK_INT < 24;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareHelper", 2, "onReceive:");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WXShareHelper.onReq:");
      localStringBuilder.append(paramBaseReq);
      QLog.d("WXShareHelper", 2, localStringBuilder.toString());
    }
    try
    {
      paramBaseReq = QzoneMapUtil.b(((ShowMessageFromWX.Req)paramBaseReq).message.messageExt);
      if ((paramBaseReq.get("actiontype") != null) && (((String)paramBaseReq.get("actiontype")).equals("schema")) && (paramBaseReq.get("schema") != null))
      {
        paramBaseReq = Uri.decode((String)paramBaseReq.get("schema"));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("schemaInfo = ");
          localStringBuilder.append(paramBaseReq);
          QLog.d("WXShareHelper", 2, localStringBuilder.toString());
        }
        if ((!TextUtils.isEmpty(paramBaseReq)) && (this.jdField_a_of_type_AndroidContentContext != null))
        {
          paramBaseReq = new Intent("android.intent.action.VIEW", Uri.parse(paramBaseReq));
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramBaseReq);
        }
      }
    }
    catch (Exception paramBaseReq)
    {
      QLog.e("WXShareHelper", 1, "onReq error.", paramBaseReq);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
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
      QLog.i("WXShareHelper", 2, ((StringBuilder)???).toString());
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        while (i >= 0)
        {
          ((WXShareHelper.WXShareListener)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onWXShareResp(paramBaseResp);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXShareHelper
 * JD-Core Version:    0.7.0.1
 */