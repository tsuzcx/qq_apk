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
import android.text.TextUtils;
import aywp;
import bevx;
import bevy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.FileProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import ndi;
import xxb;

public class WXShareHelper
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WXShareHelper jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bevx(this);
  Context jdField_a_of_type_AndroidContentContext;
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxf0a80d0ac2e82aa7", true);
  private ArrayList<bevy> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  private IWXAPI b;
  
  private WXShareHelper()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    a();
    this.b = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wxcb89b8fc34e4e304", true);
    BaseApplication.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    this.b.registerApp("wxcb89b8fc34e4e304");
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
    if (e())
    {
      QLog.d("WXShareHelper", 1, "android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N");
      return null;
    }
    if (!d())
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
    if (jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper == null) {
        jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper = new WXShareHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper;
    }
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    return paramString + System.currentTimeMillis();
  }
  
  private void a(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    QLog.d("WXShareHelper", 1, "--shareImageToWX");
    if (TextUtils.isEmpty(paramString1))
    {
      xxb.a(1, 2131696944);
      return;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    Uri localUri = a(paramString1);
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
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramArrayOfByte);
      return;
      paramString1 = localUri.toString();
    }
  }
  
  public static byte[] a(Bitmap paramBitmap, int paramInt)
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
  
  public static byte[] a(Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
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
      localObject1 = ndi.a(localBitmap);
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
      localObject1 = ndi.a((Bitmap)localObject2);
    }
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
    if (this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI != null) {
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wxf0a80d0ac2e82aa7");
    }
  }
  
  public void a(bevy parambevy)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambevy)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(parambevy);
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
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    a(paramString, paramBitmap, paramInt, true);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      xxb.a(1, 2131696944);
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
      xxb.a(1, 2131696944);
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
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString2);
      return;
      if (2 == paramInt) {
        paramString2.scene = 1;
      }
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public void b(bevy parambevy)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(parambevy)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(parambevy);
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
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 553779201;
  }
  
  public void c(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    b(paramString1, paramString2, paramBitmap, paramString3, paramString4, 1);
  }
  
  public void c(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
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
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 553779201;
  }
  
  public void d(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    b(paramString1, paramString2, paramBitmap, paramString3, paramString4, 0);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 654314752;
  }
  
  public boolean e()
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
    if (QLog.isColorLevel()) {
      QLog.d("WXShareHelper", 2, "WXShareHelper.onReq:" + paramBaseReq);
    }
    try
    {
      paramBaseReq = aywp.b(((ShowMessageFromWX.Req)paramBaseReq).message.messageExt);
      if ((paramBaseReq.get("actiontype") != null) && (((String)paramBaseReq.get("actiontype")).equals("schema")) && (paramBaseReq.get("schema") != null))
      {
        paramBaseReq = Uri.decode((String)paramBaseReq.get("schema"));
        if (QLog.isColorLevel()) {
          QLog.d("WXShareHelper", 2, "schemaInfo = " + paramBaseReq);
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
      for (;;)
      {
        QLog.e("WXShareHelper", 1, "onReq error.", paramBaseReq);
      }
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WXShareHelper", 2, "WXShareHelper.onResp:" + paramBaseResp.errCode + " ,errStr:" + paramBaseResp.errStr);
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        while (i >= 0)
        {
          ((bevy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramBaseResp);
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