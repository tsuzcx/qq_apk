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
  
  private static int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getByteCount();
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 81	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 84	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 90	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 95	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: astore_0
    //   27: ldc 18
    //   29: iconst_1
    //   30: ldc 97
    //   32: aload_2
    //   33: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_1
    //   37: invokestatic 95	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   40: aconst_null
    //   41: areturn
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: ldc 18
    //   49: iconst_1
    //   50: ldc 103
    //   52: aload_2
    //   53: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   56: aload_1
    //   57: invokestatic 95	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_0
    //   66: astore_1
    //   67: aload_2
    //   68: invokestatic 95	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Ljava/io/Closeable;)V
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: astore_2
    //   76: goto -9 -> 67
    //   79: astore_2
    //   80: goto -35 -> 45
    //   83: astore_2
    //   84: goto -59 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramString	String
    //   8	64	1	localObject1	Object
    //   73	1	1	localObject2	Object
    //   15	6	2	localBitmap	Bitmap
    //   22	11	2	localException1	Exception
    //   42	11	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   64	12	2	localObject3	Object
    //   79	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   83	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	22	java/lang/Exception
    //   0	9	42	java/lang/OutOfMemoryError
    //   0	9	62	finally
    //   11	16	73	finally
    //   27	36	73	finally
    //   47	56	73	finally
    //   11	16	79	java/lang/OutOfMemoryError
    //   11	16	83	java/lang/Exception
  }
  
  private IWBAPI a(Activity paramActivity)
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
  
  public static WBShareHelper a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= 4)) {
      QLog.e("WBShareHelper", 1, new Object[] { "getInstance Exception", Log.getStackTraceString(new Throwable()) });
    }
    return WBShareHelper.SingletonHolder.a();
  }
  
  private void a(Activity paramActivity, WeiboMultiMessage paramWeiboMultiMessage)
  {
    QLog.d("WBShareHelper", 1, "doShare");
    try
    {
      a(paramActivity).shareMessage(paramWeiboMultiMessage, false);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("WBShareHelper", 1, "Exception", paramActivity);
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getIntent() == null))
    {
      QLog.e("WBShareHelper", 1, "useWBSdkShare null == activity || activity.getIntent() == null");
      return false;
    }
    return paramActivity.getIntent().getBooleanExtra("use_wei_bo_sdk", false);
  }
  
  private boolean a(Activity paramActivity, WeiboMultiMessage paramWeiboMultiMessage)
  {
    if ("com.tencent.mobileqq".equals(Common.r())) {
      a(paramActivity, paramWeiboMultiMessage);
    }
    for (;;)
    {
      return true;
      WBQIPCClient.a(new WBShareHelper.1(this, paramActivity, paramWeiboMultiMessage));
    }
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    boolean bool = true;
    QLog.d("WBShareHelper", 1, new Object[] { "isWeiBoShare requestCode=", Integer.valueOf(paramInt) });
    if (10001 != paramInt) {}
    while (paramIntent == null) {
      return false;
    }
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (paramIntent.containsKey("_weibo_resp_errcode"))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  private static byte[] a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 249	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 250	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_1
    //   13: aload_0
    //   14: getstatic 256	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   17: bipush 85
    //   19: aload_2
    //   20: invokevirtual 260	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   23: pop
    //   24: aload_2
    //   25: astore_1
    //   26: aload_2
    //   27: invokevirtual 264	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_0
    //   32: astore_1
    //   33: aload_2
    //   34: ifnull +9 -> 43
    //   37: aload_2
    //   38: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   41: aload_0
    //   42: astore_1
    //   43: aload_1
    //   44: areturn
    //   45: astore_1
    //   46: ldc 18
    //   48: iconst_1
    //   49: ldc 97
    //   51: aload_1
    //   52: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: aload_0
    //   56: areturn
    //   57: astore_3
    //   58: aconst_null
    //   59: astore_0
    //   60: aload_0
    //   61: astore_1
    //   62: ldc 18
    //   64: iconst_1
    //   65: ldc 97
    //   67: aload_3
    //   68: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload 4
    //   73: astore_1
    //   74: aload_0
    //   75: ifnull -32 -> 43
    //   78: aload_0
    //   79: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: ldc 18
    //   87: iconst_1
    //   88: ldc 97
    //   90: aload_0
    //   91: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   107: aload_0
    //   108: athrow
    //   109: astore_1
    //   110: ldc 18
    //   112: iconst_1
    //   113: ldc 97
    //   115: aload_1
    //   116: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: goto -12 -> 107
    //   122: astore_0
    //   123: goto -24 -> 99
    //   126: astore_3
    //   127: aload_2
    //   128: astore_0
    //   129: goto -69 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramBitmap	Bitmap
    //   12	32	1	localObject1	Object
    //   45	7	1	localIOException1	java.io.IOException
    //   61	43	1	localObject2	Object
    //   109	7	1	localIOException2	java.io.IOException
    //   10	118	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   57	11	3	localException1	Exception
    //   126	1	3	localException2	Exception
    //   1	71	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	41	45	java/io/IOException
    //   3	11	57	java/lang/Exception
    //   78	82	84	java/io/IOException
    //   3	11	96	finally
    //   103	107	109	java/io/IOException
    //   13	24	122	finally
    //   26	31	122	finally
    //   62	71	122	finally
    //   13	24	126	java/lang/Exception
    //   26	31	126	java/lang/Exception
  }
  
  private boolean b(Activity paramActivity)
  {
    boolean bool = true;
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.d("WBShareHelper", 1, "shareImage activity == null || activity.isFinishing()");
      ForwardSdkUtil.a(paramActivity, "UI 已经销毁");
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  private boolean c(Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: new 281	com/sina/weibo/sdk/api/ImageObject
    //   3: dup
    //   4: invokespecial 282	com/sina/weibo/sdk/api/ImageObject:<init>	()V
    //   7: astore_3
    //   8: aload_2
    //   9: invokestatic 284	com/tencent/mobileqq/wbapi/WBShareHelper:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +21 -> 35
    //   17: ldc 18
    //   19: iconst_1
    //   20: ldc_w 286
    //   23: invokestatic 26	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: ldc_w 288
    //   30: invokestatic 277	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual 292	com/sina/weibo/sdk/api/ImageObject:setImageData	(Landroid/graphics/Bitmap;)V
    //   40: aload_3
    //   41: getfield 296	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   44: ifnull +88 -> 132
    //   47: aload_3
    //   48: getfield 296	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   51: arraylength
    //   52: ldc_w 297
    //   55: if_icmplt +77 -> 132
    //   58: aload_1
    //   59: ldc_w 299
    //   62: invokestatic 277	com/tencent/mobileqq/forward/ForwardSdkUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   65: ldc 18
    //   67: iconst_1
    //   68: iconst_4
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: ldc_w 301
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: aload_2
    //   81: invokestatic 303	com/tencent/mobileqq/wbapi/WBShareHelper:a	(Landroid/graphics/Bitmap;)I
    //   84: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: ldc_w 305
    //   93: aastore
    //   94: dup
    //   95: iconst_3
    //   96: aload_3
    //   97: getfield 296	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   100: arraylength
    //   101: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: aload_2
    //   110: invokevirtual 308	com/tencent/mobileqq/wbapi/WBShareHelper:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   113: astore_2
    //   114: aload_3
    //   115: aload_2
    //   116: invokevirtual 292	com/sina/weibo/sdk/api/ImageObject:setImageData	(Landroid/graphics/Bitmap;)V
    //   119: goto -79 -> 40
    //   122: astore_2
    //   123: ldc 18
    //   125: iconst_1
    //   126: ldc 97
    //   128: aload_2
    //   129: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_3
    //   133: getfield 296	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   136: ifnonnull +60 -> 196
    //   139: ldc_w 310
    //   142: astore_2
    //   143: ldc 18
    //   145: iconst_1
    //   146: iconst_2
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: ldc_w 312
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_2
    //   159: aastore
    //   160: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   163: new 314	com/sina/weibo/sdk/api/WeiboMultiMessage
    //   166: dup
    //   167: invokespecial 315	com/sina/weibo/sdk/api/WeiboMultiMessage:<init>	()V
    //   170: astore_2
    //   171: aload_2
    //   172: aload_3
    //   173: putfield 319	com/sina/weibo/sdk/api/WeiboMultiMessage:imageObject	Lcom/sina/weibo/sdk/api/ImageObject;
    //   176: aload_0
    //   177: aload_1
    //   178: aload_2
    //   179: invokespecial 321	com/tencent/mobileqq/wbapi/WBShareHelper:a	(Landroid/app/Activity;Lcom/sina/weibo/sdk/api/WeiboMultiMessage;)Z
    //   182: ireturn
    //   183: astore_2
    //   184: ldc 18
    //   186: iconst_1
    //   187: ldc 103
    //   189: aload_2
    //   190: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -61 -> 132
    //   196: aload_3
    //   197: getfield 296	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   200: arraylength
    //   201: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: astore_2
    //   205: goto -62 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	WBShareHelper
    //   0	208	1	paramActivity	Activity
    //   0	208	2	paramString	String
    //   7	190	3	localImageObject	com.sina.weibo.sdk.api.ImageObject
    // Exception table:
    //   from	to	target	type
    //   8	13	122	java/lang/Exception
    //   17	33	122	java/lang/Exception
    //   35	40	122	java/lang/Exception
    //   40	119	122	java/lang/Exception
    //   8	13	183	java/lang/OutOfMemoryError
    //   17	33	183	java/lang/OutOfMemoryError
    //   35	40	183	java/lang/OutOfMemoryError
    //   40	119	183	java/lang/OutOfMemoryError
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
    a(paramActivity).doResultIntent(paramIntent, paramWbShareCallback);
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d("WBShareHelper", 1, "shareVideo invalid params");
      ForwardSdkUtil.a(paramActivity, "参数不合法，禁止分享");
      return false;
    }
    if (!a(paramActivity).isWBAppSupportMultipleImage())
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
      for (localWebpageObject.thumbData = a(paramBitmap); (localWebpageObject.thumbData != null) && (localWebpageObject.thumbData.length >= 32768); localWebpageObject.thumbData = a(paramBitmap))
      {
        ForwardSdkUtil.a(paramActivity, "图片太大，请业务压缩");
        QLog.d("WBShareHelper", 1, new Object[] { "shareUrl compress getBitmapSize=", Integer.valueOf(a(paramBitmap)), "arr=", Integer.valueOf(localWebpageObject.thumbData.length) });
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
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      QLog.d("WBShareHelper", 1, "shareMultImage invalid params");
      ForwardSdkUtil.a(paramActivity, "参数不合法，禁止分享");
      return false;
    }
    if (!a(paramActivity).isWBAppSupportMultipleImage())
    {
      QLog.d("WBShareHelper", 1, "shareMultImage not support Multi Image");
      ForwardSdkUtil.a(paramActivity, "版本较低，不支持多图分享");
      return false;
    }
    QLog.d("WBShareHelper", 1, "shareMultImage imageUrls.size=" + paramArrayList.size());
    WeiboMultiMessage localWeiboMultiMessage = new WeiboMultiMessage();
    TextObject localTextObject = new TextObject();
    localTextObject.text = paramString;
    localWeiboMultiMessage.textObject = localTextObject;
    paramString = new MultiImageObject();
    paramString.imageList = paramArrayList;
    localWeiboMultiMessage.multiImageObject = paramString;
    return a(paramActivity, localWeiboMultiMessage);
  }
  
  public boolean a(Activity paramActivity, String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      QLog.d("WBShareHelper", 1, "null == imageUrls || imageUrls.length == 0");
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      localArrayList.add(Uri.fromFile(new File(paramArrayOfString[i])));
      i += 1;
    }
    return a(paramActivity, paramString, localArrayList);
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
    if (a(paramActivity).isWBAppSupportMultipleImage()) {
      return a(paramActivity, " ", new String[] { paramString });
    }
    return c(paramActivity, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wbapi.WBShareHelper
 * JD-Core Version:    0.7.0.1
 */