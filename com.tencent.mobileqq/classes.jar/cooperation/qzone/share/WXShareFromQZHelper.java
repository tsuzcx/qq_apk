package cooperation.qzone.share;

import amzw;
import amzx;
import amzy;
import amzz;
import anaa;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
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
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class WXShareFromQZHelper
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WXShareFromQZHelper jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper;
  public static String a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b;
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wx34b037fdb0f655ee", true);
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = WXShareFromQZHelper.class.getSimpleName();
    b = AppConstants.aJ + "photo/";
  }
  
  private WXShareFromQZHelper()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    a();
  }
  
  public static WXShareFromQZHelper a()
  {
    if (jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper == null) {
        jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper = new WXShareFromQZHelper();
      }
      return jdField_a_of_type_CooperationQzoneShareWXShareFromQZHelper;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", QzoneConfig.getInstance().getConfig("H5Url", "WeiXinDownload", "http://a.myapp.com/h/?g_f=990542#id=appdetail&appid=48157&icfa=13145982048157020000"));
      localIntent.putExtra("fromQZone", true);
      localIntent.addFlags(268435456);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    return paramString + System.currentTimeMillis();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wx34b037fdb0f655ee");
  }
  
  public void a(Context paramContext, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
    localIntent.setAction("android.intent.action.SEND_MULTIPLE");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(Uri.fromFile((File)paramArrayList.next()));
    }
    localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
    paramContext.startActivity(localIntent);
  }
  
  public void a(WXShareFromQZHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramWXShareListener);
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new WXTextObject(paramString);
    paramString = new WXMediaMessage();
    paramString.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
    localObject = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject).transaction = a("text");
    ((SendMessageToWX.Req)localObject).message = paramString;
    ((SendMessageToWX.Req)localObject).scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq((BaseReq)localObject)) {
      ThreadManager.getUIHandler().post(new amzy(this));
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = new WXMediaMessage(new WXWebpageObject(paramString3));
    paramString3.description = paramString2;
    paramString3.title = paramString1;
    paramString3.thumbData = WXShareHelper.a(paramBitmap, false, true);
    paramString1 = new SendMessageToWX.Req();
    paramString1.transaction = a("webpage");
    paramString1.message = paramString3;
    paramString1.scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString1)) {
      ThreadManager.getUIHandler().post(new amzw(this));
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.webpageUrl = paramString3;
    localWXMiniProgramObject.userName = paramString5;
    localWXMiniProgramObject.path = (paramString4 + "&sk=" + paramString6);
    paramString3 = new WXMediaMessage(localWXMiniProgramObject);
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    if (paramBitmap != null) {
      try
      {
        float f = Math.max(400.0F / paramBitmap.getWidth(), 400.0F / paramBitmap.getHeight());
        paramString1 = new Matrix();
        paramString1.postScale(f, f);
        paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramString1, true);
        paramBitmap = Bitmap.createBitmap(paramString1, 0, 0, 400, 400);
        paramString3.thumbData = a(paramBitmap, 100);
        QZLog.e(jdField_a_of_type_JavaLangString, "wxshare thumbData:" + paramString3.thumbData.length);
        int j = 4;
        int i = 100;
        while ((paramString3.thumbData != null) && (paramString3.thumbData.length >= 131072))
        {
          j -= 1;
          if (j > 0)
          {
            i -= 10;
            paramString3.thumbData = a(paramBitmap, i);
            QZLog.e(jdField_a_of_type_JavaLangString, "wxshare thumbData -- :" + paramString3.thumbData.length);
            continue;
            paramString1 = new SendMessageToWX.Req();
          }
        }
      }
      catch (Throwable paramString1)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, "excetion:" + paramString1.getMessage());
        ThreadManager.getUIHandler().post(new amzz(this));
      }
    }
    for (;;)
    {
      paramString1.transaction = a("webpage");
      paramString1.message = paramString3;
      paramString1.scene = paramInt;
      boolean bool = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString1);
      if (!bool)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, "wxshare failed ,ret:" + bool);
        ThreadManager.getUIHandler().post(new anaa(this));
      }
      return;
      paramString1.recycle();
      paramBitmap.recycle();
      continue;
      QZLog.e(jdField_a_of_type_JavaLangString, "wxshare bmp null");
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.imagePath = paramString;
    paramString = new WXMediaMessage();
    paramString.mediaObject = localWXImageObject;
    if (paramInt == 0)
    {
      paramString.thumbData = paramArrayOfByte;
      if ((paramString.thumbData == null) || ((paramString.thumbData != null) && (paramString.thumbData.length > 32768))) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "wxmsg.thumbData is invalid");
      }
    }
    paramArrayOfByte = new SendMessageToWX.Req();
    paramArrayOfByte.transaction = a("img");
    paramArrayOfByte.message = paramString;
    paramArrayOfByte.scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramArrayOfByte)) {
      ThreadManager.getUIHandler().post(new amzx(this));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public void b(WXShareFromQZHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramWXShareListener);
      }
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppSupportAPI();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((WXShareFromQZHelper.WXShareListener)localIterator.next()).a(paramBaseResp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.WXShareFromQZHelper
 * JD-Core Version:    0.7.0.1
 */