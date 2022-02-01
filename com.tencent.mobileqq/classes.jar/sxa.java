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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class sxa
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
    catch (OutOfMemoryError paramWindow)
    {
      paramWindow.printStackTrace();
      return null;
    }
    catch (Exception paramWindow)
    {
      for (;;)
      {
        paramWindow.printStackTrace();
      }
    }
  }
  
  public static Pair<String, Bitmap> a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->begin time:" + System.currentTimeMillis());
    }
    for (;;)
    {
      try
      {
        localResources = BaseApplicationImpl.getContext().getResources();
        paramString1 = BitmapFactory.decodeFile(paramString1);
        k = paramString1.getWidth();
        m = paramString1.getHeight();
        int n = AIOUtils.dp2px(0.5F, localResources);
        int i = AIOUtils.dp2px(90.0F, localResources);
        j = Math.max(paramInt, k);
        localBitmap = Bitmap.createBitmap(j, m + n + i, Bitmap.Config.ARGB_8888);
        localCanvas = new Canvas(localBitmap);
        localPaint = new Paint();
        if (paramInt > k)
        {
          localPaint.setColor(Color.parseColor("#f7f7f9"));
          localCanvas.drawRect(0.0F, 0.0F, paramInt, m, localPaint);
        }
        if (k >= paramInt)
        {
          localCanvas.drawBitmap(paramString1, 0.0F, 0.0F, localPaint);
          localPaint.setColor(Color.parseColor("#DEDFE0"));
          localCanvas.drawRect(0.0F, m, j, m + n, localPaint);
          paramInt = m + n;
          localPaint.setColor(-1);
          localCanvas.drawRect(0.0F, paramInt, j, paramInt + i, localPaint);
          localCanvas.drawBitmap(BitmapFactory.decodeResource(localResources, 2130841689), AIOUtils.dp2px(13.0F, localResources), AIOUtils.dp2px(25.0F, localResources) + paramInt, localPaint);
          localPaint.setColor(-16777216);
          localPaint.setTextSize(AIOUtils.sp2TextSize(2, 18, localResources));
          localCanvas.drawText("QQ看点", AIOUtils.dp2px(60.0F, localResources), AIOUtils.dp2px(42.0F, localResources) + paramInt, localPaint);
          localPaint.setColor(Color.parseColor("#777777"));
          localPaint.setTextSize(AIOUtils.sp2TextSize(2, 14, localResources));
          localCanvas.drawText(localResources.getString(2131694800), AIOUtils.dp2px(60.0F, localResources), AIOUtils.dp2px(61.0F, localResources) + paramInt, localPaint);
          paramString1 = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=" + URLEncoder.encode(paramString2, "UTF-8");
          localObject = new HashMap();
          ((HashMap)localObject).put("url", paramString1);
          str = (String)HttpUtil.shortenUrlBatch((HashMap)localObject).get("url");
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->shortenUrl:" + str);
          }
          localObject = new HashMap();
          if ((TextUtils.isEmpty(str)) || (str.length() >= paramString1.length())) {
            continue;
          }
          ((HashMap)localObject).put("param_errorCode", "0");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", true, 0L, 0L, (HashMap)localObject, "");
          paramString1 = Uri.parse(paramString2);
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        Resources localResources;
        int k;
        int m;
        int j;
        Bitmap localBitmap;
        Canvas localCanvas;
        Paint localPaint;
        Object localObject;
        String str;
        paramString1 = null;
        paramString2 = "";
        continue;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        paramString2 = "";
        continue;
      }
      try
      {
        paramString1 = paramString1.getQueryParameter("_wv");
        if (paramString1 != null) {
          continue;
        }
        paramString2 = "";
        paramString1 = Uri.parse(str);
      }
      catch (Exception paramString1)
      {
        try
        {
          paramString1 = paramString1.getQueryParameter("_wv");
          localObject = paramString1;
          if (paramString1 == null) {
            localObject = "";
          }
          paramString1 = str;
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = str;
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              if (!str.contains("?")) {
                continue;
              }
              paramString1 = str + "&_wv=" + paramString2;
            }
          }
          paramString2 = paramString1;
          if (paramString1.startsWith("http://")) {
            paramString2 = paramString1.replaceFirst("http://", "https://");
          }
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->use new qrCode:" + paramString2);
          }
          paramString1 = bflj.a(paramString2, localResources, AIOUtils.dp2px(80.0F, localResources), 0, false);
          paramString2 = paramString1;
          if (paramString1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->use old kandian qrCode!");
            }
            paramString2 = BitmapFactory.decodeResource(localResources, 2130841695);
          }
          localCanvas.drawBitmap(paramString2, j - AIOUtils.dp2px(5.0F, localResources) - paramString2.getWidth(), AIOUtils.dp2px(5.0F, localResources) + paramInt, localPaint);
          paramString2 = a(localBitmap, paramString3);
          paramString1 = localBitmap;
          if (QLog.isDevelopLevel()) {
            QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->end time:" + System.currentTimeMillis());
          }
          return new Pair(paramString2, paramString1);
          localCanvas.drawBitmap(paramString1, new Rect(0, 0, k, m), new Rect((paramInt - k) / 2, 0, (k + paramInt) / 2, m), localPaint);
          continue;
          paramString1 = paramString1;
          paramString1.printStackTrace();
          paramString1 = "";
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          paramString1 = "";
          continue;
          paramString1 = str + "?_wv=" + paramString2;
          continue;
        }
      }
      if (TextUtils.isEmpty(str))
      {
        ((HashMap)localObject).put("param_errorCode", "1");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", false, 0L, 0L, (HashMap)localObject, "");
        paramString1 = null;
      }
      else if (str.equals(paramString1))
      {
        ((HashMap)localObject).put("param_errorCode", "2");
      }
      else if (str.length() >= paramString1.length())
      {
        ((HashMap)localObject).put("param_errorCode", "3");
        continue;
        paramString2 = paramString1;
      }
    }
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 345	java/io/File
    //   3: dup
    //   4: getstatic 351	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS	Ljava/lang/String;
    //   7: invokestatic 356	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 362	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 365	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 367	java/text/SimpleDateFormat
    //   29: dup
    //   30: ldc_w 369
    //   33: invokespecial 370	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   36: new 372	java/util/Date
    //   39: dup
    //   40: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   43: invokespecial 375	java/util/Date:<init>	(J)V
    //   46: invokevirtual 379	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   49: astore_3
    //   50: new 67	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   57: getstatic 351	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS	Ljava/lang/String;
    //   60: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 381
    //   74: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 356	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 4
    //   85: new 345	java/io/File
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore_3
    //   95: aload 4
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 362	java/io/File:exists	()Z
    //   102: ifne +38 -> 140
    //   105: new 383	java/io/FileOutputStream
    //   108: dup
    //   109: aload_3
    //   110: invokespecial 386	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: astore_3
    //   114: aload_3
    //   115: astore_1
    //   116: aload_0
    //   117: getstatic 392	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   120: bipush 100
    //   122: aload_3
    //   123: invokevirtual 396	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   126: istore_2
    //   127: iload_2
    //   128: ifeq +53 -> 181
    //   131: aload 4
    //   133: astore_0
    //   134: aload_3
    //   135: invokestatic 402	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   138: aload_0
    //   139: astore_1
    //   140: aload_1
    //   141: areturn
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: astore_1
    //   148: aload 4
    //   150: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   153: aload_0
    //   154: invokestatic 402	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   157: ldc_w 265
    //   160: areturn
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: invokestatic 402	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   168: aload_0
    //   169: athrow
    //   170: astore_0
    //   171: goto -7 -> 164
    //   174: astore 4
    //   176: aload_3
    //   177: astore_0
    //   178: goto -32 -> 146
    //   181: ldc_w 265
    //   184: astore_0
    //   185: goto -51 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramBitmap	Bitmap
    //   0	188	1	paramString	String
    //   126	2	2	bool	boolean
    //   13	164	3	localObject	Object
    //   83	49	4	str	String
    //   142	7	4	localException1	Exception
    //   174	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   105	114	142	java/lang/Exception
    //   105	114	161	finally
    //   116	127	170	finally
    //   148	153	170	finally
    //   116	127	174	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxa
 * JD-Core Version:    0.7.0.1
 */