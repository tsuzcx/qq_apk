package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ScreenShotImageUtil
{
  public static Bitmap a(Window paramWindow, Bitmap paramBitmap)
  {
    try
    {
      if ((ImmersiveUtils.isSupporImmersive() == 1) && ((paramWindow.getAttributes().flags & 0x400) != 1024))
      {
        int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getContext());
        return Bitmap.createBitmap(paramBitmap, 0, i, paramBitmap.getWidth(), paramBitmap.getHeight() - i, null, false);
      }
      paramWindow = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), null, false);
      return paramWindow;
    }
    catch (Exception paramWindow)
    {
      paramWindow.printStackTrace();
    }
    catch (OutOfMemoryError paramWindow)
    {
      paramWindow.printStackTrace();
    }
    return null;
  }
  
  public static Pair<String, Bitmap> a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateScreenShotImageWithQRCode->begin time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("ScreenShotImageUtil", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        localResources = BaseApplicationImpl.getContext().getResources();
        paramString1 = BitmapFactory.decodeFile(paramString1);
        i = paramString1.getWidth();
        j = paramString1.getHeight();
        n = AIOUtils.b(0.5F, localResources);
        m = AIOUtils.b(90.0F, localResources);
        k = Math.max(paramInt, i);
        n += j;
        m += n;
        localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        localCanvas = new Canvas(localBitmap);
        localPaint = new Paint();
        if (paramInt <= i) {
          continue;
        }
      }
      catch (OutOfMemoryError|Exception paramString1)
      {
        Resources localResources;
        int i;
        int j;
        int n;
        int m;
        int k;
        Bitmap localBitmap;
        Canvas localCanvas;
        Paint localPaint;
        float f1;
        float f2;
        float f3;
        String str;
        boolean bool;
        continue;
        continue;
        paramString2 = paramString1;
        if (paramString1 != null) {
          continue;
        }
        paramString2 = "";
        continue;
        localObject = paramString1;
        if (paramString1 != null) {
          continue;
        }
        localObject = "";
        continue;
      }
      try
      {
        localPaint.setColor(Color.parseColor("#f7f7f9"));
        localCanvas.drawRect(0.0F, 0.0F, paramInt, j, localPaint);
        if (i >= paramInt) {
          localCanvas.drawBitmap(paramString1, 0.0F, 0.0F, localPaint);
        } else {
          localCanvas.drawBitmap(paramString1, new Rect(0, 0, i, j), new Rect((paramInt - i) / 2, 0, (paramInt + i) / 2, j), localPaint);
        }
        localPaint.setColor(Color.parseColor("#DEDFE0"));
        f1 = j;
        f2 = k;
        f3 = n;
        localCanvas.drawRect(0.0F, f1, f2, f3, localPaint);
        localPaint.setColor(-1);
        localCanvas.drawRect(0.0F, f3, f2, m, localPaint);
        localCanvas.drawBitmap(BitmapFactory.decodeResource(localResources, 2130842646), AIOUtils.b(13.0F, localResources), AIOUtils.b(25.0F, localResources) + n, localPaint);
        localPaint.setColor(-16777216);
        localPaint.setTextSize(AIOUtils.a(2, 18, localResources));
        localCanvas.drawText("QQ看点", AIOUtils.b(60.0F, localResources), AIOUtils.b(42.0F, localResources) + n, localPaint);
        localPaint.setColor(Color.parseColor("#777777"));
        localPaint.setTextSize(AIOUtils.a(2, 14, localResources));
        localCanvas.drawText(localResources.getString(2131892977), AIOUtils.b(60.0F, localResources), AIOUtils.b(61.0F, localResources) + n, localPaint);
        paramString1 = new StringBuilder();
        paramString1.append("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=");
        paramString1.append(URLEncoder.encode(paramString2, "UTF-8"));
        paramString1 = paramString1.toString();
        localObject = new HashMap();
        ((HashMap)localObject).put("url", paramString1);
        str = (String)HttpUtil.shortenUrlBatch((HashMap)localObject).get("url");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("generateScreenShotImageWithQRCode->shortenUrl:");
          ((StringBuilder)localObject).append(str);
          QLog.d("ScreenShotImageUtil", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new HashMap();
        bool = TextUtils.isEmpty(str);
        if ((!bool) && (str.length() < paramString1.length()))
        {
          ((HashMap)localObject).put("param_errorCode", "0");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", true, 0L, 0L, (HashMap)localObject, "");
          paramString1 = Uri.parse(paramString2);
          try
          {
            paramString1 = paramString1.getQueryParameter("_wv");
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = "";
          }
          paramString1 = Uri.parse(str);
          try
          {
            paramString1 = paramString1.getQueryParameter("_wv");
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = "";
          }
          paramString1 = str;
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = str;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              if (str.contains("?"))
              {
                paramString1 = new StringBuilder();
                paramString1.append(str);
                paramString1.append("&_wv=");
                paramString1.append(paramString2);
                paramString1 = paramString1.toString();
              }
              else
              {
                paramString1 = new StringBuilder();
                paramString1.append(str);
                paramString1.append("?_wv=");
                paramString1.append(paramString2);
                paramString1 = paramString1.toString();
              }
            }
          }
          paramString2 = paramString1;
          if (paramString1.startsWith("http://")) {
            paramString2 = paramString1.replaceFirst("http://", "https://");
          }
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("generateScreenShotImageWithQRCode->use new qrCode:");
            paramString1.append(paramString2);
            QLog.d("ScreenShotImageUtil", 2, paramString1.toString());
          }
          paramString1 = TroopShareUtility.a(paramString2, localResources, AIOUtils.b(80.0F, localResources), 0, false);
        }
        else
        {
          if (TextUtils.isEmpty(str)) {
            ((HashMap)localObject).put("param_errorCode", "1");
          } else if (str.equals(paramString1)) {
            ((HashMap)localObject).put("param_errorCode", "2");
          } else if (str.length() >= paramString1.length()) {
            ((HashMap)localObject).put("param_errorCode", "3");
          }
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", false, 0L, 0L, (HashMap)localObject, "");
          paramString1 = null;
        }
        paramString2 = paramString1;
        if (paramString1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->use old kandian qrCode!");
          }
          paramString2 = BitmapFactory.decodeResource(localResources, 2130842653);
        }
        localCanvas.drawBitmap(paramString2, k - AIOUtils.b(5.0F, localResources) - paramString2.getWidth(), n + AIOUtils.b(5.0F, localResources), localPaint);
        paramString1 = localBitmap;
        paramString2 = a(paramString1, paramString3);
      }
      catch (OutOfMemoryError|Exception paramString1) {}
    }
    paramString2 = "";
    paramString1 = null;
    if (QLog.isDevelopLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("generateScreenShotImageWithQRCode->end time:");
      paramString3.append(System.currentTimeMillis());
      QLog.d("ScreenShotImageUtil", 2, paramString3.toString());
    }
    return new Pair(paramString2, paramString1);
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: ldc_w 273
    //   3: astore_3
    //   4: new 345	java/io/File
    //   7: dup
    //   8: getstatic 351	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS	Ljava/lang/String;
    //   11: invokestatic 356	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 362	java/io/File:exists	()Z
    //   24: ifne +9 -> 33
    //   27: aload 4
    //   29: invokevirtual 365	java/io/File:mkdirs	()Z
    //   32: pop
    //   33: new 367	java/text/SimpleDateFormat
    //   36: dup
    //   37: ldc_w 369
    //   40: invokespecial 370	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   43: new 372	java/util/Date
    //   46: dup
    //   47: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   50: invokespecial 375	java/util/Date:<init>	(J)V
    //   53: invokevirtual 379	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   56: astore 4
    //   58: new 68	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   65: astore 5
    //   67: aload 5
    //   69: getstatic 351	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS	Ljava/lang/String;
    //   72: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 5
    //   78: aload_1
    //   79: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 5
    //   85: aload 4
    //   87: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 5
    //   93: ldc_w 381
    //   96: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 5
    //   102: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 356	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 6
    //   110: new 345	java/io/File
    //   113: dup
    //   114: aload 6
    //   116: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: astore 4
    //   121: aload 4
    //   123: invokevirtual 362	java/io/File:exists	()Z
    //   126: ifne +95 -> 221
    //   129: aconst_null
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_1
    //   134: new 383	java/io/FileOutputStream
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 386	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: astore 4
    //   145: aload_0
    //   146: getstatic 392	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   149: bipush 100
    //   151: aload 4
    //   153: invokevirtual 396	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   156: istore_2
    //   157: aload_3
    //   158: astore_0
    //   159: iload_2
    //   160: ifeq +6 -> 166
    //   163: aload 6
    //   165: astore_0
    //   166: aload 4
    //   168: invokestatic 402	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   171: goto +42 -> 213
    //   174: astore_0
    //   175: aload 4
    //   177: astore_1
    //   178: goto +37 -> 215
    //   181: astore_1
    //   182: aload 4
    //   184: astore_0
    //   185: aload_1
    //   186: astore 4
    //   188: goto +12 -> 200
    //   191: astore_0
    //   192: goto +23 -> 215
    //   195: astore 4
    //   197: aload 5
    //   199: astore_0
    //   200: aload_0
    //   201: astore_1
    //   202: aload 4
    //   204: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   207: aload_0
    //   208: invokestatic 402	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   211: aload_3
    //   212: astore_0
    //   213: aload_0
    //   214: areturn
    //   215: aload_1
    //   216: invokestatic 402	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   219: aload_0
    //   220: athrow
    //   221: aload 6
    //   223: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramBitmap	Bitmap
    //   0	224	1	paramString	String
    //   156	4	2	bool	boolean
    //   3	209	3	str1	String
    //   17	170	4	localObject	Object
    //   195	8	4	localException	Exception
    //   65	133	5	localStringBuilder	StringBuilder
    //   108	114	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   145	157	174	finally
    //   145	157	181	java/lang/Exception
    //   134	145	191	finally
    //   202	207	191	finally
    //   134	145	195	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotImageUtil
 * JD-Core Version:    0.7.0.1
 */