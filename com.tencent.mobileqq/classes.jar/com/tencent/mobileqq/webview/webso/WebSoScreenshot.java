package com.tencent.mobileqq.webview.webso;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import java.io.File;

public class WebSoScreenshot
{
  private static String a = "";
  
  static Drawable a(String paramString)
  {
    String str = WebSoUtils.b(paramString);
    if (!TextUtils.isEmpty(str))
    {
      if (!new File(str).exists()) {
        return null;
      }
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseMemoryCache = false;
        try
        {
          paramString = new BitmapFactory.Options();
          paramString.inSampleSize = 4;
          paramString = BitmapFactory.decodeFile(str, paramString);
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          paramString = null;
        }
        if (paramString == null) {
          paramString = URLDrawableHelperConstants.a;
        } else {
          paramString = new BitmapDrawable(paramString);
        }
        localURLDrawableOptions.mLoadingDrawable = paramString;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        paramString = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
        return paramString;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (QVipSDKProcessor.c().c <= 0) {
      return;
    }
    paramString = a(paramString);
    if (paramString != null)
    {
      paramActivity = paramActivity.findViewById(2131370699);
      if (paramActivity != null)
      {
        Drawable localDrawable = paramActivity.getBackground();
        paramActivity.setBackgroundDrawable(paramString);
        paramActivity.setAlpha(1.0F);
        paramActivity.setVisibility(0);
        paramActivity.postDelayed(new WebSoScreenshot.1(paramActivity, localDrawable), 2000L);
      }
    }
  }
  
  /* Error */
  public static void a(View paramView, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 5
    //   11: astore_3
    //   12: aload 6
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 145	android/view/View:getMeasuredWidth	()I
    //   20: aload_0
    //   21: invokevirtual 148	android/view/View:getHeight	()I
    //   24: getstatic 154	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   27: invokestatic 160	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   30: astore 8
    //   32: aload 5
    //   34: astore_3
    //   35: aload 6
    //   37: astore 4
    //   39: aload_0
    //   40: new 162	android/graphics/Canvas
    //   43: dup
    //   44: aload 8
    //   46: invokespecial 163	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   49: invokevirtual 167	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   52: aload 5
    //   54: astore_3
    //   55: aload 6
    //   57: astore 4
    //   59: ldc 169
    //   61: invokestatic 175	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   64: checkcast 169	com/tencent/qzonehub/api/IGifAntishakeApi
    //   67: aload 8
    //   69: invokeinterface 179 2 0
    //   74: astore 9
    //   76: aload 5
    //   78: astore_3
    //   79: aload 6
    //   81: astore 4
    //   83: ldc 169
    //   85: invokestatic 175	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   88: checkcast 169	com/tencent/qzonehub/api/IGifAntishakeApi
    //   91: aload 9
    //   93: getstatic 181	com/tencent/mobileqq/webview/webso/WebSoScreenshot:a	Ljava/lang/String;
    //   96: invokeinterface 185 3 0
    //   101: istore_2
    //   102: aload 5
    //   104: astore_3
    //   105: aload 6
    //   107: astore 4
    //   109: new 187	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   116: astore_0
    //   117: aload 5
    //   119: astore_3
    //   120: aload 6
    //   122: astore 4
    //   124: aload_0
    //   125: ldc 190
    //   127: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 5
    //   133: astore_3
    //   134: aload 6
    //   136: astore 4
    //   138: aload_0
    //   139: aload 9
    //   141: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 5
    //   147: astore_3
    //   148: aload 6
    //   150: astore 4
    //   152: aload_0
    //   153: ldc 196
    //   155: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 5
    //   161: astore_3
    //   162: aload 6
    //   164: astore 4
    //   166: aload_0
    //   167: getstatic 181	com/tencent/mobileqq/webview/webso/WebSoScreenshot:a	Ljava/lang/String;
    //   170: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 5
    //   176: astore_3
    //   177: aload 6
    //   179: astore 4
    //   181: aload_0
    //   182: ldc 198
    //   184: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 5
    //   190: astore_3
    //   191: aload 6
    //   193: astore 4
    //   195: aload_0
    //   196: iload_2
    //   197: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 5
    //   203: astore_3
    //   204: aload 6
    //   206: astore 4
    //   208: aload_0
    //   209: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 207	com/tencent/mobileqq/webview/webso/WebSoUtils:a	(Ljava/lang/String;)V
    //   215: aload 7
    //   217: astore_0
    //   218: aload 5
    //   220: astore_3
    //   221: aload 6
    //   223: astore 4
    //   225: aload 9
    //   227: ldc 209
    //   229: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifne +65 -> 297
    //   235: aload 5
    //   237: astore_3
    //   238: aload 6
    //   240: astore 4
    //   242: aload 9
    //   244: putstatic 181	com/tencent/mobileqq/webview/webso/WebSoScreenshot:a	Ljava/lang/String;
    //   247: aload 5
    //   249: astore_3
    //   250: aload 6
    //   252: astore 4
    //   254: new 217	java/io/FileOutputStream
    //   257: dup
    //   258: aload_1
    //   259: invokestatic 23	com/tencent/mobileqq/webview/webso/WebSoUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   265: astore_0
    //   266: aload 8
    //   268: getstatic 224	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   271: bipush 70
    //   273: aload_0
    //   274: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   277: pop
    //   278: aload_0
    //   279: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   282: goto +15 -> 297
    //   285: astore_1
    //   286: aload_0
    //   287: astore_3
    //   288: aload_1
    //   289: astore_0
    //   290: goto +64 -> 354
    //   293: astore_1
    //   294: goto +40 -> 334
    //   297: aload_0
    //   298: astore_3
    //   299: aload_0
    //   300: astore 4
    //   302: aload 8
    //   304: invokevirtual 234	android/graphics/Bitmap:recycle	()V
    //   307: aload_0
    //   308: astore_3
    //   309: aload_0
    //   310: astore 4
    //   312: ldc 236
    //   314: invokestatic 207	com/tencent/mobileqq/webview/webso/WebSoUtils:a	(Ljava/lang/String;)V
    //   317: aload_0
    //   318: ifnull +35 -> 353
    //   321: aload_0
    //   322: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   325: return
    //   326: astore_0
    //   327: goto +27 -> 354
    //   330: astore_1
    //   331: aload 4
    //   333: astore_0
    //   334: aload_0
    //   335: astore_3
    //   336: ldc 238
    //   338: iconst_1
    //   339: aload_1
    //   340: invokevirtual 241	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   343: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_0
    //   347: ifnull +6 -> 353
    //   350: goto -29 -> 321
    //   353: return
    //   354: aload_3
    //   355: ifnull +7 -> 362
    //   358: aload_3
    //   359: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   362: goto +5 -> 367
    //   365: aload_0
    //   366: athrow
    //   367: goto -2 -> 365
    //   370: astore_0
    //   371: return
    //   372: astore_1
    //   373: goto -11 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramView	View
    //   0	376	1	paramString	String
    //   101	96	2	i	int
    //   11	348	3	localObject1	Object
    //   14	318	4	localObject2	Object
    //   1	247	5	localObject3	Object
    //   4	247	6	localObject4	Object
    //   7	209	7	localObject5	Object
    //   30	273	8	localBitmap	android.graphics.Bitmap
    //   74	169	9	str	String
    // Exception table:
    //   from	to	target	type
    //   266	282	285	finally
    //   266	282	293	java/lang/Throwable
    //   16	32	326	finally
    //   39	52	326	finally
    //   59	76	326	finally
    //   83	102	326	finally
    //   109	117	326	finally
    //   124	131	326	finally
    //   138	145	326	finally
    //   152	159	326	finally
    //   166	174	326	finally
    //   181	188	326	finally
    //   195	201	326	finally
    //   208	215	326	finally
    //   225	235	326	finally
    //   242	247	326	finally
    //   254	266	326	finally
    //   302	307	326	finally
    //   312	317	326	finally
    //   336	346	326	finally
    //   16	32	330	java/lang/Throwable
    //   39	52	330	java/lang/Throwable
    //   59	76	330	java/lang/Throwable
    //   83	102	330	java/lang/Throwable
    //   109	117	330	java/lang/Throwable
    //   124	131	330	java/lang/Throwable
    //   138	145	330	java/lang/Throwable
    //   152	159	330	java/lang/Throwable
    //   166	174	330	java/lang/Throwable
    //   181	188	330	java/lang/Throwable
    //   195	201	330	java/lang/Throwable
    //   208	215	330	java/lang/Throwable
    //   225	235	330	java/lang/Throwable
    //   242	247	330	java/lang/Throwable
    //   254	266	330	java/lang/Throwable
    //   302	307	330	java/lang/Throwable
    //   312	317	330	java/lang/Throwable
    //   321	325	370	java/io/IOException
    //   358	362	372	java/io/IOException
  }
  
  public static void a(CustomWebView paramCustomWebView)
  {
    if (QVipSDKProcessor.c().c <= 0) {
      return;
    }
    paramCustomWebView.post(new WebSoScreenshot.2(paramCustomWebView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoScreenshot
 * JD-Core Version:    0.7.0.1
 */