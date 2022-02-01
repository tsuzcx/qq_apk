package com.tencent.qqmini.sdk.plugins;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.List;

public class ScreenJsPlugin$ScreenShotListenManager
{
  private static final String[] KEYWORDS = { "screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap" };
  private static final String[] MEDIA_PROJECTIONS = { "_data", "datetaken" };
  private static final String[] MEDIA_PROJECTIONS_API_16 = { "_data", "datetaken", "width", "height" };
  private static final String TAG = "ScreenShotListenManager";
  private static Point sScreenRealSize;
  private Context mContext;
  private ScreenJsPlugin.ScreenShotListenManager.MediaContentObserver mExternalObserver;
  private ScreenJsPlugin.ScreenShotListenManager.MediaContentObserver mInternalObserver;
  private ScreenJsPlugin.ScreenShotListenManager.OnScreenShotListener mListener;
  private long mStartListenTime;
  private final Handler mUiHandler = new Handler(Looper.getMainLooper());
  private final List<String> sHasCallbackPaths = new ArrayList();
  
  private ScreenJsPlugin$ScreenShotListenManager(Context paramContext)
  {
    if (paramContext != null)
    {
      this.mContext = paramContext;
      if (sScreenRealSize == null)
      {
        sScreenRealSize = getRealScreenSize();
        if (sScreenRealSize != null)
        {
          paramContext = new StringBuilder();
          paramContext.append("Screen Real Size: ");
          paramContext.append(sScreenRealSize.x);
          paramContext.append(" * ");
          paramContext.append(sScreenRealSize.y);
          QMLog.d("ScreenShotListenManager", paramContext.toString());
          return;
        }
        QMLog.w("ScreenShotListenManager", "Get screen real size failed.");
      }
      return;
    }
    throw new IllegalArgumentException("The context must not be null.");
  }
  
  public static void assertInMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      StringBuilder localStringBuilder = null;
      Object localObject = localStringBuilder;
      if (arrayOfStackTraceElement != null)
      {
        localObject = localStringBuilder;
        if (arrayOfStackTraceElement.length >= 4) {
          localObject = arrayOfStackTraceElement[3].toString();
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Call the method must be in main thread: ");
      localStringBuilder.append((String)localObject);
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  private boolean checkCallback(String paramString)
  {
    if (this.sHasCallbackPaths.contains(paramString)) {
      return true;
    }
    if (this.sHasCallbackPaths.size() >= 20)
    {
      int i = 0;
      while (i < 5)
      {
        this.sHasCallbackPaths.remove(0);
        i += 1;
      }
    }
    this.sHasCallbackPaths.add(paramString);
    return false;
  }
  
  private boolean checkScreenShot(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong >= this.mStartListenTime)
    {
      if (System.currentTimeMillis() - paramLong > 10000L) {
        return false;
      }
      Object localObject = sScreenRealSize;
      if ((localObject != null) && ((paramInt1 > ((Point)localObject).x) || (paramInt2 > sScreenRealSize.y)) && ((paramInt2 > sScreenRealSize.x) || (paramInt1 > sScreenRealSize.y))) {
        return false;
      }
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramString = paramString.toLowerCase();
      localObject = KEYWORDS;
      paramInt2 = localObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        if (paramString.contains(localObject[paramInt1])) {
          return true;
        }
        paramInt1 += 1;
      }
    }
    return false;
  }
  
  private Point getImageSize(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Point(localOptions.outWidth, localOptions.outHeight);
  }
  
  /* Error */
  private Point getRealScreenSize()
  {
    // Byte code:
    //   0: new 112	android/graphics/Point
    //   3: dup
    //   4: invokespecial 243	android/graphics/Point:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 95	com/tencent/qqmini/sdk/plugins/ScreenJsPlugin$ScreenShotListenManager:mContext	Landroid/content/Context;
    //   12: ldc 245
    //   14: invokevirtual 251	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 253	android/view/WindowManager
    //   20: invokeinterface 257 1 0
    //   25: astore_1
    //   26: getstatic 262	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 17
    //   31: if_icmplt +10 -> 41
    //   34: aload_1
    //   35: aload_2
    //   36: invokevirtual 268	android/view/Display:getRealSize	(Landroid/graphics/Point;)V
    //   39: aload_2
    //   40: areturn
    //   41: ldc_w 264
    //   44: ldc_w 270
    //   47: iconst_0
    //   48: anewarray 272	java/lang/Class
    //   51: invokevirtual 276	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   54: astore_3
    //   55: ldc_w 264
    //   58: ldc_w 278
    //   61: iconst_0
    //   62: anewarray 272	java/lang/Class
    //   65: invokevirtual 276	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   68: astore 4
    //   70: aload_2
    //   71: aload_3
    //   72: aload_1
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokevirtual 284	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 286	java/lang/Integer
    //   83: invokevirtual 289	java/lang/Integer:intValue	()I
    //   86: aload 4
    //   88: aload_1
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokevirtual 284	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 286	java/lang/Integer
    //   99: invokevirtual 289	java/lang/Integer:intValue	()I
    //   102: invokevirtual 292	android/graphics/Point:set	(II)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 295	android/view/Display:getWidth	()I
    //   113: aload_1
    //   114: invokevirtual 298	android/view/Display:getHeight	()I
    //   117: invokevirtual 292	android/graphics/Point:set	(II)V
    //   120: aload_3
    //   121: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   124: aload_2
    //   125: areturn
    //   126: astore_1
    //   127: goto +6 -> 133
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_1
    //   134: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   137: aload_2
    //   138: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	ScreenShotListenManager
    //   25	89	1	localDisplay	android.view.Display
    //   126	1	1	localException1	Exception
    //   130	4	1	localException2	Exception
    //   7	131	2	localPoint	Point
    //   54	18	3	localMethod1	java.lang.reflect.Method
    //   107	14	3	localException3	Exception
    //   68	19	4	localMethod2	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   41	105	107	java/lang/Exception
    //   8	39	126	java/lang/Exception
    //   108	124	126	java/lang/Exception
    //   0	8	130	java/lang/Exception
  }
  
  /* Error */
  private void handleMediaContentChange(android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: aload 11
    //   8: astore 9
    //   10: aload 12
    //   12: astore 8
    //   14: aload_0
    //   15: getfield 95	com/tencent/qqmini/sdk/plugins/ScreenJsPlugin$ScreenShotListenManager:mContext	Landroid/content/Context;
    //   18: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore 13
    //   23: aload 11
    //   25: astore 9
    //   27: aload 12
    //   29: astore 8
    //   31: getstatic 262	android/os/Build$VERSION:SDK_INT	I
    //   34: bipush 16
    //   36: if_icmpge +19 -> 55
    //   39: aload 11
    //   41: astore 9
    //   43: aload 12
    //   45: astore 8
    //   47: getstatic 38	com/tencent/qqmini/sdk/plugins/ScreenJsPlugin$ScreenShotListenManager:MEDIA_PROJECTIONS	[Ljava/lang/String;
    //   50: astore 10
    //   52: goto +16 -> 68
    //   55: aload 11
    //   57: astore 9
    //   59: aload 12
    //   61: astore 8
    //   63: getstatic 44	com/tencent/qqmini/sdk/plugins/ScreenJsPlugin$ScreenShotListenManager:MEDIA_PROJECTIONS_API_16	[Ljava/lang/String;
    //   66: astore 10
    //   68: aload 11
    //   70: astore 9
    //   72: aload 12
    //   74: astore 8
    //   76: aload 13
    //   78: aload_1
    //   79: aload 10
    //   81: aconst_null
    //   82: aconst_null
    //   83: ldc_w 307
    //   86: invokevirtual 313	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnonnull +37 -> 128
    //   94: aload_1
    //   95: astore 9
    //   97: aload_1
    //   98: astore 8
    //   100: ldc 12
    //   102: ldc_w 315
    //   105: invokestatic 318	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: ifnull +18 -> 127
    //   112: aload_1
    //   113: invokeinterface 324 1 0
    //   118: ifne +9 -> 127
    //   121: aload_1
    //   122: invokeinterface 327 1 0
    //   127: return
    //   128: aload_1
    //   129: astore 9
    //   131: aload_1
    //   132: astore 8
    //   134: aload_1
    //   135: invokeinterface 330 1 0
    //   140: ifne +37 -> 177
    //   143: aload_1
    //   144: astore 9
    //   146: aload_1
    //   147: astore 8
    //   149: ldc 12
    //   151: ldc_w 332
    //   154: invokestatic 134	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_1
    //   158: ifnull +18 -> 176
    //   161: aload_1
    //   162: invokeinterface 324 1 0
    //   167: ifne +9 -> 176
    //   170: aload_1
    //   171: invokeinterface 327 1 0
    //   176: return
    //   177: aload_1
    //   178: astore 9
    //   180: aload_1
    //   181: astore 8
    //   183: aload_1
    //   184: ldc 34
    //   186: invokeinterface 336 2 0
    //   191: istore 4
    //   193: aload_1
    //   194: astore 9
    //   196: aload_1
    //   197: astore 8
    //   199: aload_1
    //   200: ldc 36
    //   202: invokeinterface 336 2 0
    //   207: istore 5
    //   209: aload_1
    //   210: astore 9
    //   212: aload_1
    //   213: astore 8
    //   215: getstatic 262	android/os/Build$VERSION:SDK_INT	I
    //   218: istore_2
    //   219: iconst_m1
    //   220: istore_3
    //   221: iload_2
    //   222: bipush 16
    //   224: if_icmplt +245 -> 469
    //   227: aload_1
    //   228: astore 9
    //   230: aload_1
    //   231: astore 8
    //   233: aload_1
    //   234: ldc 40
    //   236: invokeinterface 336 2 0
    //   241: istore_3
    //   242: aload_1
    //   243: astore 9
    //   245: aload_1
    //   246: astore 8
    //   248: aload_1
    //   249: ldc 42
    //   251: invokeinterface 336 2 0
    //   256: istore_2
    //   257: goto +3 -> 260
    //   260: aload_1
    //   261: astore 9
    //   263: aload_1
    //   264: astore 8
    //   266: aload_1
    //   267: iload 4
    //   269: invokeinterface 340 2 0
    //   274: astore 10
    //   276: aload_1
    //   277: astore 9
    //   279: aload_1
    //   280: astore 8
    //   282: aload_1
    //   283: iload 5
    //   285: invokeinterface 344 2 0
    //   290: lstore 6
    //   292: iload_3
    //   293: iflt +44 -> 337
    //   296: iload_2
    //   297: iflt +40 -> 337
    //   300: aload_1
    //   301: astore 9
    //   303: aload_1
    //   304: astore 8
    //   306: aload_1
    //   307: iload_3
    //   308: invokeinterface 348 2 0
    //   313: istore_3
    //   314: aload_1
    //   315: astore 9
    //   317: aload_1
    //   318: astore 8
    //   320: aload_1
    //   321: iload_2
    //   322: invokeinterface 348 2 0
    //   327: istore 4
    //   329: iload_3
    //   330: istore_2
    //   331: iload 4
    //   333: istore_3
    //   334: goto +41 -> 375
    //   337: aload_1
    //   338: astore 9
    //   340: aload_1
    //   341: astore 8
    //   343: aload_0
    //   344: aload 10
    //   346: invokespecial 350	com/tencent/qqmini/sdk/plugins/ScreenJsPlugin$ScreenShotListenManager:getImageSize	(Ljava/lang/String;)Landroid/graphics/Point;
    //   349: astore 11
    //   351: aload_1
    //   352: astore 9
    //   354: aload_1
    //   355: astore 8
    //   357: aload 11
    //   359: getfield 116	android/graphics/Point:x	I
    //   362: istore_2
    //   363: aload_1
    //   364: astore 9
    //   366: aload_1
    //   367: astore 8
    //   369: aload 11
    //   371: getfield 124	android/graphics/Point:y	I
    //   374: istore_3
    //   375: aload_1
    //   376: astore 9
    //   378: aload_1
    //   379: astore 8
    //   381: aload_0
    //   382: aload 10
    //   384: lload 6
    //   386: iload_2
    //   387: iload_3
    //   388: invokespecial 354	com/tencent/qqmini/sdk/plugins/ScreenJsPlugin$ScreenShotListenManager:handleMediaRowData	(Ljava/lang/String;JII)V
    //   391: aload_1
    //   392: ifnull +52 -> 444
    //   395: aload_1
    //   396: invokeinterface 324 1 0
    //   401: ifne +43 -> 444
    //   404: goto +34 -> 438
    //   407: astore_1
    //   408: goto +37 -> 445
    //   411: astore_1
    //   412: aload 8
    //   414: astore 9
    //   416: aload_1
    //   417: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   420: aload 8
    //   422: ifnull +22 -> 444
    //   425: aload 8
    //   427: invokeinterface 324 1 0
    //   432: ifne +12 -> 444
    //   435: aload 8
    //   437: astore_1
    //   438: aload_1
    //   439: invokeinterface 327 1 0
    //   444: return
    //   445: aload 9
    //   447: ifnull +20 -> 467
    //   450: aload 9
    //   452: invokeinterface 324 1 0
    //   457: ifne +10 -> 467
    //   460: aload 9
    //   462: invokeinterface 327 1 0
    //   467: aload_1
    //   468: athrow
    //   469: iconst_m1
    //   470: istore_2
    //   471: goto -211 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	this	ScreenShotListenManager
    //   0	474	1	paramUri	android.net.Uri
    //   218	253	2	i	int
    //   220	168	3	j	int
    //   191	141	4	k	int
    //   207	77	5	m	int
    //   290	95	6	l	long
    //   12	424	8	localObject1	Object
    //   8	453	9	localObject2	Object
    //   50	333	10	localObject3	Object
    //   4	366	11	localPoint	Point
    //   1	72	12	localObject4	Object
    //   21	56	13	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   14	23	407	finally
    //   31	39	407	finally
    //   47	52	407	finally
    //   63	68	407	finally
    //   76	90	407	finally
    //   100	108	407	finally
    //   134	143	407	finally
    //   149	157	407	finally
    //   183	193	407	finally
    //   199	209	407	finally
    //   215	219	407	finally
    //   233	242	407	finally
    //   248	257	407	finally
    //   266	276	407	finally
    //   282	292	407	finally
    //   306	314	407	finally
    //   320	329	407	finally
    //   343	351	407	finally
    //   357	363	407	finally
    //   369	375	407	finally
    //   381	391	407	finally
    //   416	420	407	finally
    //   14	23	411	java/lang/Exception
    //   31	39	411	java/lang/Exception
    //   47	52	411	java/lang/Exception
    //   63	68	411	java/lang/Exception
    //   76	90	411	java/lang/Exception
    //   100	108	411	java/lang/Exception
    //   134	143	411	java/lang/Exception
    //   149	157	411	java/lang/Exception
    //   183	193	411	java/lang/Exception
    //   199	209	411	java/lang/Exception
    //   215	219	411	java/lang/Exception
    //   233	242	411	java/lang/Exception
    //   248	257	411	java/lang/Exception
    //   266	276	411	java/lang/Exception
    //   282	292	411	java/lang/Exception
    //   306	314	411	java/lang/Exception
    //   320	329	411	java/lang/Exception
    //   343	351	411	java/lang/Exception
    //   357	363	411	java/lang/Exception
    //   369	375	411	java/lang/Exception
    //   381	391	411	java/lang/Exception
  }
  
  private void handleMediaRowData(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (checkScreenShot(paramString, paramLong, paramInt1, paramInt2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ScreenShot: path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("; size = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" * ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("; date = ");
      localStringBuilder.append(paramLong);
      QMLog.d("ScreenShotListenManager", localStringBuilder.toString());
      if ((this.mListener != null) && (!checkCallback(paramString))) {
        this.mListener.onShot(paramString);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Media content changed, but not screenshot: path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("; size = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" * ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("; date = ");
      localStringBuilder.append(paramLong);
      QMLog.w("ScreenShotListenManager", localStringBuilder.toString());
    }
  }
  
  public static ScreenShotListenManager newInstance(Context paramContext)
  {
    assertInMainThread();
    return new ScreenShotListenManager(paramContext);
  }
  
  public void setListener(ScreenJsPlugin.ScreenShotListenManager.OnScreenShotListener paramOnScreenShotListener)
  {
    this.mListener = paramOnScreenShotListener;
  }
  
  public void startListen()
  {
    assertInMainThread();
    this.sHasCallbackPaths.clear();
    this.mStartListenTime = System.currentTimeMillis();
    this.mInternalObserver = new ScreenJsPlugin.ScreenShotListenManager.MediaContentObserver(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mUiHandler);
    this.mExternalObserver = new ScreenJsPlugin.ScreenShotListenManager.MediaContentObserver(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mUiHandler);
    this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.mInternalObserver);
    this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.mExternalObserver);
  }
  
  public void stopListen()
  {
    
    if (this.mInternalObserver != null)
    {
      try
      {
        this.mContext.getContentResolver().unregisterContentObserver(this.mInternalObserver);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      this.mInternalObserver = null;
    }
    if (this.mExternalObserver != null)
    {
      try
      {
        this.mContext.getContentResolver().unregisterContentObserver(this.mExternalObserver);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      this.mExternalObserver = null;
    }
    this.mStartListenTime = 0L;
    this.sHasCallbackPaths.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin.ScreenShotListenManager
 * JD-Core Version:    0.7.0.1
 */