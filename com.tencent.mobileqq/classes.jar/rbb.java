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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class rbb
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
        int n = aciy.a(0.5F, localResources);
        int i = aciy.a(90.0F, localResources);
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
          localCanvas.drawBitmap(BitmapFactory.decodeResource(localResources, 2130841143), aciy.a(13.0F, localResources), aciy.a(25.0F, localResources) + paramInt, localPaint);
          localPaint.setColor(-16777216);
          localPaint.setTextSize(aciy.a(2, 18, localResources));
          localCanvas.drawText("QQ看点", aciy.a(60.0F, localResources), aciy.a(42.0F, localResources) + paramInt, localPaint);
          localPaint.setColor(Color.parseColor("#777777"));
          localPaint.setTextSize(aciy.a(2, 14, localResources));
          localCanvas.drawText(localResources.getString(2131629911), aciy.a(60.0F, localResources), aciy.a(61.0F, localResources) + paramInt, localPaint);
          paramString1 = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=" + URLEncoder.encode(paramString2, "UTF-8");
          localObject = new HashMap();
          ((HashMap)localObject).put("url", paramString1);
          str = (String)mpl.a((HashMap)localObject).get("url");
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->shortenUrl:" + str);
          }
          localObject = new HashMap();
          if ((TextUtils.isEmpty(str)) || (str.length() >= paramString1.length())) {
            continue;
          }
          ((HashMap)localObject).put("param_errorCode", "0");
          awrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", true, 0L, 0L, (HashMap)localObject, "");
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
          paramString1 = azsq.a(paramString2, localResources, aciy.a(80.0F, localResources), 0, false);
          paramString2 = paramString1;
          if (paramString1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->use old kandian qrCode!");
            }
            paramString2 = BitmapFactory.decodeResource(localResources, 2130841149);
          }
          localCanvas.drawBitmap(paramString2, j - aciy.a(5.0F, localResources) - paramString2.getWidth(), aciy.a(5.0F, localResources) + paramInt, localPaint);
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
        awrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", false, 0L, 0L, (HashMap)localObject, "");
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
    //   0: new 340	java/io/File
    //   3: dup
    //   4: getstatic 346	ajed:cx	Ljava/lang/String;
    //   7: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 352	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_3
    //   19: invokevirtual 355	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: new 357	java/text/SimpleDateFormat
    //   26: dup
    //   27: ldc_w 359
    //   30: invokespecial 360	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   33: new 362	java/util/Date
    //   36: dup
    //   37: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   40: invokespecial 365	java/util/Date:<init>	(J)V
    //   43: invokevirtual 369	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   46: astore_3
    //   47: new 67	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   54: getstatic 346	ajed:cx	Ljava/lang/String;
    //   57: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_3
    //   65: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc_w 371
    //   71: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 4
    //   79: new 340	java/io/File
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_3
    //   89: aload 4
    //   91: astore_1
    //   92: aload_3
    //   93: invokevirtual 352	java/io/File:exists	()Z
    //   96: ifne +38 -> 134
    //   99: new 373	java/io/FileOutputStream
    //   102: dup
    //   103: aload_3
    //   104: invokespecial 376	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   107: astore_3
    //   108: aload_3
    //   109: astore_1
    //   110: aload_0
    //   111: getstatic 382	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   114: bipush 100
    //   116: aload_3
    //   117: invokevirtual 386	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   120: istore_2
    //   121: iload_2
    //   122: ifeq +53 -> 175
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: invokestatic 392	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   132: aload_0
    //   133: astore_1
    //   134: aload_1
    //   135: areturn
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: astore_1
    //   142: aload 4
    //   144: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   147: aload_0
    //   148: invokestatic 392	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   151: ldc_w 261
    //   154: areturn
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: invokestatic 392	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   162: aload_0
    //   163: athrow
    //   164: astore_0
    //   165: goto -7 -> 158
    //   168: astore 4
    //   170: aload_3
    //   171: astore_0
    //   172: goto -32 -> 140
    //   175: ldc_w 261
    //   178: astore_0
    //   179: goto -51 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramBitmap	Bitmap
    //   0	182	1	paramString	String
    //   120	2	2	bool	boolean
    //   10	161	3	localObject	Object
    //   77	49	4	str	String
    //   136	7	4	localException1	Exception
    //   168	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   99	108	136	java/lang/Exception
    //   99	108	155	finally
    //   110	121	164	finally
    //   142	147	164	finally
    //   110	121	168	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rbb
 * JD-Core Version:    0.7.0.1
 */