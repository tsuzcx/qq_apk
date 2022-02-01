package com.tencent.mobileqq.wbapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.mobileqq.forward.ForwardSdkUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class WBShareHelper
{
  private List<WBShareHelper.SharePair> a = new ArrayList();
  
  private WBShareHelper()
  {
    QLog.d("WBShareHelper", 1, "WBShareHelper init");
    BaseApplication localBaseApplication = BaseApplication.getContext();
    AuthInfo localAuthInfo = new AuthInfo(localBaseApplication, "94065651", "https://connect.qq.com", "status/share");
    WBAPIFactory.createWBAPI(null).registerApp(localBaseApplication, localAuthInfo);
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 65	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 74	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 79	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: goto +57 -> 80
    //   26: astore_2
    //   27: goto +16 -> 43
    //   30: astore_2
    //   31: goto +32 -> 63
    //   34: astore_1
    //   35: aconst_null
    //   36: astore_0
    //   37: goto +43 -> 80
    //   40: astore_2
    //   41: aconst_null
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: ldc 18
    //   47: iconst_1
    //   48: ldc 81
    //   50: aload_2
    //   51: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   54: aload_1
    //   55: invokestatic 79	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: ldc 18
    //   67: iconst_1
    //   68: ldc 87
    //   70: aload_2
    //   71: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload_1
    //   75: invokestatic 79	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: invokestatic 79	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramString	String
    //   8	9	1	localFileInputStream	java.io.FileInputStream
    //   22	1	1	localObject1	Object
    //   34	1	1	localObject2	Object
    //   42	43	1	localCloseable	java.io.Closeable
    //   15	6	2	localBitmap	Bitmap
    //   26	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   30	1	2	localException1	Exception
    //   40	11	2	localOutOfMemoryError2	OutOfMemoryError
    //   60	11	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	16	22	finally
    //   45	54	22	finally
    //   65	74	22	finally
    //   11	16	26	java/lang/OutOfMemoryError
    //   11	16	30	java/lang/Exception
    //   0	9	34	finally
    //   0	9	40	java/lang/OutOfMemoryError
    //   0	9	60	java/lang/Exception
  }
  
  public static WBShareHelper a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= 4)) {
      QLog.e("WBShareHelper", 1, new Object[] { "getInstance Exception", Log.getStackTraceString(new Throwable()) });
    }
    return WBShareHelper.SingletonHolder.a();
  }
  
  public static boolean a(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getIntent() != null)) {
      return paramActivity.getIntent().getBooleanExtra("use_wei_bo_sdk", false);
    }
    QLog.e("WBShareHelper", 1, "useWBSdkShare null == activity || activity.getIntent() == null");
    return false;
  }
  
  private boolean a(Activity paramActivity, WeiboMultiMessage paramWeiboMultiMessage)
  {
    if ("com.tencent.mobileqq".equals(Common.x())) {
      b(paramActivity, paramWeiboMultiMessage);
    } else {
      WBQIPCClient.a(new WBShareHelper.1(this, paramActivity, paramWeiboMultiMessage));
    }
    return true;
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    boolean bool2 = false;
    QLog.d("WBShareHelper", 1, new Object[] { "isWeiBoShare requestCode=", Integer.valueOf(paramInt) });
    if (10001 != paramInt) {
      return false;
    }
    if (paramIntent == null) {
      return false;
    }
    paramIntent = paramIntent.getExtras();
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.containsKey("_weibo_resp_errcode")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(Activity paramActivity, WeiboMultiMessage paramWeiboMultiMessage)
  {
    QLog.d("WBShareHelper", 1, "doShare");
    try
    {
      c(paramActivity).shareMessage(paramWeiboMultiMessage, false);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("WBShareHelper", 1, "Exception", paramActivity);
    }
  }
  
  private boolean b(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      return true;
    }
    QLog.d("WBShareHelper", 1, "shareImage activity == null || activity.isFinishing()");
    ForwardSdkUtil.a(MobileQQ.sMobileQQ, "UI 已经销毁");
    return false;
  }
  
  /* Error */
  private static byte[] b(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 210	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 211	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: aload_0
    //   11: getstatic 217	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   14: bipush 85
    //   16: aload_2
    //   17: invokevirtual 223	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   20: pop
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 227	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 230	java/io/ByteArrayOutputStream:close	()V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: ldc 18
    //   37: iconst_1
    //   38: ldc 87
    //   40: aload_1
    //   41: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: goto +53 -> 100
    //   50: astore_1
    //   51: aload_2
    //   52: astore_0
    //   53: aload_1
    //   54: astore_2
    //   55: goto +12 -> 67
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_1
    //   61: goto +39 -> 100
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: ldc 18
    //   71: iconst_1
    //   72: ldc 87
    //   74: aload_2
    //   75: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: aload_0
    //   79: ifnull +19 -> 98
    //   82: aload_0
    //   83: invokevirtual 230	java/io/ByteArrayOutputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: ldc 18
    //   91: iconst_1
    //   92: ldc 87
    //   94: aload_0
    //   95: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aconst_null
    //   99: areturn
    //   100: aload_1
    //   101: ifnull +20 -> 121
    //   104: aload_1
    //   105: invokevirtual 230	java/io/ByteArrayOutputStream:close	()V
    //   108: goto +13 -> 121
    //   111: astore_1
    //   112: ldc 18
    //   114: iconst_1
    //   115: ldc 87
    //   117: aload_1
    //   118: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramBitmap	Bitmap
    //   9	14	1	localObject1	Object
    //   34	7	1	localIOException1	java.io.IOException
    //   50	4	1	localException1	Exception
    //   60	45	1	localBitmap	Bitmap
    //   111	7	1	localIOException2	java.io.IOException
    //   7	48	2	localObject2	Object
    //   64	11	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	32	34	java/io/IOException
    //   10	21	46	finally
    //   23	28	46	finally
    //   69	78	46	finally
    //   10	21	50	java/lang/Exception
    //   23	28	50	java/lang/Exception
    //   0	8	58	finally
    //   0	8	64	java/lang/Exception
    //   82	86	88	java/io/IOException
    //   104	108	111	java/io/IOException
  }
  
  private static int c(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getByteCount();
  }
  
  private IWBAPI c(Activity paramActivity)
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WBShareHelper.SharePair localSharePair = (WBShareHelper.SharePair)((Iterator)localObject).next();
      if (localSharePair.a.get() == null) {
        ((Iterator)localObject).remove();
      }
      if ((localSharePair.a.get() == paramActivity) && (localSharePair.b.get() != null)) {
        return (IWBAPI)localSharePair.b.get();
      }
    }
    localObject = WBAPIFactory.createWBAPI(paramActivity);
    ((IWBAPI)localObject).setLoggerEnable(false);
    this.a.add(new WBShareHelper.SharePair(paramActivity, (IWBAPI)localObject));
    return localObject;
  }
  
  private boolean c(Activity paramActivity, String paramString)
  {
    ImageObject localImageObject = new ImageObject();
    try
    {
      paramString = a(paramString);
      if (paramString == null)
      {
        QLog.d("WBShareHelper", 1, "shareSingleBitmap text is empty");
        ForwardSdkUtil.a(paramActivity, "图片为空，禁止分享");
        return false;
      }
      localImageObject.setImageData(paramString);
      while ((localImageObject.imageData != null) && (localImageObject.imageData.length >= 630784))
      {
        ForwardSdkUtil.a(paramActivity, "图片太大，请业务压缩");
        QLog.d("WBShareHelper", 1, new Object[] { "shareSingleBitmap compress getBitmapSize=", Integer.valueOf(c(paramString)), ", arr=", Integer.valueOf(localImageObject.imageData.length) });
        paramString = a(paramString);
        localImageObject.setImageData(paramString);
      }
      if (localImageObject.imageData != null) {
        break label159;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("WBShareHelper", 1, "OutOfMemoryError", paramString);
    }
    catch (Exception paramString)
    {
      QLog.e("WBShareHelper", 1, "Exception", paramString);
    }
    paramString = "null";
    break label168;
    label159:
    paramString = Integer.valueOf(localImageObject.imageData.length);
    label168:
    QLog.d("WBShareHelper", 1, new Object[] { "shareSingleBitmap arr=", paramString });
    paramString = new WeiboMultiMessage();
    paramString.imageObject = localImageObject;
    return a(paramActivity, paramString);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(0.9F, 0.9F);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public void a(Activity paramActivity, Intent paramIntent, WbShareCallback paramWbShareCallback)
  {
    QLog.d("WBShareHelper", 1, "doResultIntent");
    c(paramActivity).doResultIntent(paramIntent, paramWbShareCallback);
  }
  
  public boolean a(Activity paramActivity, String paramString)
  {
    QLog.d("WBShareHelper", 1, "shareText");
    if (!b(paramActivity)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("WBShareHelper", 1, "shareText text is empty");
      ForwardSdkUtil.a(paramActivity, "文本为空，禁止分享");
      return false;
    }
    WeiboMultiMessage localWeiboMultiMessage = new WeiboMultiMessage();
    TextObject localTextObject = new TextObject();
    localTextObject.text = paramString;
    localWeiboMultiMessage.textObject = localTextObject;
    return a(paramActivity, localWeiboMultiMessage);
  }
  
  public boolean a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!b(paramActivity)) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!c(paramActivity).isWBAppSupportMultipleImage())
      {
        QLog.d("WBShareHelper", 1, "shareVideo not support Multi Image");
        ForwardSdkUtil.a(paramActivity, "版本较低，不支持视频分享");
        return false;
      }
      QLog.d("WBShareHelper", 1, new Object[] { "shareUrl text=", paramString1, ", videoPath=", paramString2 });
      WeiboMultiMessage localWeiboMultiMessage = new WeiboMultiMessage();
      TextObject localTextObject = new TextObject();
      localTextObject.text = paramString1;
      localWeiboMultiMessage.textObject = localTextObject;
      paramString1 = new VideoSourceObject();
      paramString1.videoPath = Uri.fromFile(new File(paramString2));
      localWeiboMultiMessage.videoSourceObject = paramString1;
      return a(paramActivity, localWeiboMultiMessage);
    }
    QLog.d("WBShareHelper", 1, "shareVideo invalid params");
    ForwardSdkUtil.a(paramActivity, "参数不合法，禁止分享");
    return false;
  }
  
  public boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    QLog.d("WBShareHelper", 1, "shareUrl");
    if (!b(paramActivity)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("WBShareHelper", 1, "shareUrl title empty");
      ForwardSdkUtil.a(paramActivity, "title为空，禁止分享");
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("WBShareHelper", 1, "shareUrl description empty");
      ForwardSdkUtil.a(paramActivity, "description为空，禁止分享");
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      QLog.d("WBShareHelper", 1, "shareUrl actionUrl empty");
      ForwardSdkUtil.a(paramActivity, "actionUrl为空，禁止分享");
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      QLog.d("WBShareHelper", 1, "shareUrl defaultText empty");
      ForwardSdkUtil.a(paramActivity, "defaultText为空，禁止分享");
      return false;
    }
    WebpageObject localWebpageObject = new WebpageObject();
    localWebpageObject.identify = UUID.randomUUID().toString();
    localWebpageObject.title = paramString1;
    localWebpageObject.description = paramString2;
    localWebpageObject.actionUrl = paramString3;
    localWebpageObject.defaultText = paramString4;
    if (paramBitmap != null) {
      for (localWebpageObject.thumbData = b(paramBitmap); (localWebpageObject.thumbData != null) && (localWebpageObject.thumbData.length >= 32768); localWebpageObject.thumbData = b(paramBitmap))
      {
        ForwardSdkUtil.a(paramActivity, "图片太大，请业务压缩");
        QLog.d("WBShareHelper", 1, new Object[] { "shareUrl compress getBitmapSize=", Integer.valueOf(c(paramBitmap)), "arr=", Integer.valueOf(localWebpageObject.thumbData.length) });
        paramBitmap = a(paramBitmap);
      }
    }
    paramString1 = new TextObject();
    paramString1.text = paramString4;
    paramString2 = new WeiboMultiMessage();
    paramString2.textObject = paramString1;
    paramString2.mediaObject = localWebpageObject;
    return a(paramActivity, paramString2);
  }
  
  public boolean a(Activity paramActivity, String paramString, ArrayList<Uri> paramArrayList)
  {
    if (!b(paramActivity)) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      if (!c(paramActivity).isWBAppSupportMultipleImage())
      {
        QLog.d("WBShareHelper", 1, "shareMultImage not support Multi Image");
        ForwardSdkUtil.a(paramActivity, "版本较低，不支持多图分享");
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareMultImage imageUrls.size=");
      ((StringBuilder)localObject).append(paramArrayList.size());
      QLog.d("WBShareHelper", 1, ((StringBuilder)localObject).toString());
      localObject = new WeiboMultiMessage();
      TextObject localTextObject = new TextObject();
      localTextObject.text = paramString;
      ((WeiboMultiMessage)localObject).textObject = localTextObject;
      paramString = new MultiImageObject();
      paramString.imageList = paramArrayList;
      ((WeiboMultiMessage)localObject).multiImageObject = paramString;
      return a(paramActivity, (WeiboMultiMessage)localObject);
    }
    QLog.d("WBShareHelper", 1, "shareMultImage invalid params");
    ForwardSdkUtil.a(paramActivity, "参数不合法，禁止分享");
    return false;
  }
  
  public boolean a(Activity paramActivity, String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfString.length;
      while (i < j)
      {
        localArrayList.add(Uri.fromFile(new File(paramArrayOfString[i])));
        i += 1;
      }
      return a(paramActivity, paramString, localArrayList);
    }
    QLog.d("WBShareHelper", 1, "null == imageUrls || imageUrls.length == 0");
    return false;
  }
  
  public boolean b(Activity paramActivity, String paramString)
  {
    if (!b(paramActivity)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("WBShareHelper", 1, "shareImage text is empty");
      ForwardSdkUtil.a(paramActivity, "图片为空，禁止分享");
      return false;
    }
    QLog.d("WBShareHelper", 1, "shareImage");
    if (c(paramActivity).isWBAppSupportMultipleImage()) {
      return a(paramActivity, " ", new String[] { paramString });
    }
    return c(paramActivity, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.wbapi.WBShareHelper
 * JD-Core Version:    0.7.0.1
 */