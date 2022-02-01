package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.IScreenShotShareHandler;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ScreenShotDetector
  extends IScreenShotShareHandler
{
  private static final String[] b = { "_data", "datetaken" };
  private static final String[] c = { "_data", "datetaken", "width", "height" };
  private static final String[] d = { "screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap" };
  private static final String[] e = { "三星F9000", "三星A8S", "三星S8+", "华为MHA-AL00", "华为P30", "vivoX27", "小米9", "OPPOA59S", "魅族Pro7-H", HardCodeUtil.a(2131911058), HardCodeUtil.a(2131911059) };
  private static Point f;
  private static String i = "";
  private static ScreenShotDetector m = new ScreenShotDetector();
  private static SharedPreferences o = BaseApplicationImpl.getApplication().getSharedPreferences("screenshots_quick_share_switch", 4);
  private static boolean p = true;
  private WeakReference<Context> g;
  private long h;
  private ScreenShotDetector.MediaContentObserver j;
  private ScreenShotDetector.MediaContentObserver k;
  private final Handler l = new Handler(Looper.getMainLooper());
  private ScreenShotDetector.ScreenShotListener n;
  
  private Point a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Point(localOptions.outWidth, localOptions.outHeight);
  }
  
  private static void a(Context paramContext, ScreenShotDetector.MediaContentObserver paramMediaContentObserver)
  {
    if (paramMediaContentObserver == null) {
      return;
    }
    try
    {
      paramContext.getContentResolver().unregisterContentObserver(paramMediaContentObserver);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotDetector", 1, "unregisterContentObserver", paramContext);
    }
  }
  
  /* Error */
  private void a(android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 169	com/tencent/mobileqq/screendetect/ScreenShotDetector:g	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 202	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 174	android/content/Context
    //   10: astore 10
    //   12: aload 10
    //   14: ifnonnull +12 -> 26
    //   17: ldc 186
    //   19: iconst_2
    //   20: ldc 204
    //   22: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: return
    //   26: aconst_null
    //   27: astore 12
    //   29: aconst_null
    //   30: astore 11
    //   32: aload 11
    //   34: astore 9
    //   36: aload 12
    //   38: astore 8
    //   40: aload 10
    //   42: invokevirtual 178	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   45: astore 13
    //   47: aload 11
    //   49: astore 9
    //   51: aload 12
    //   53: astore 8
    //   55: getstatic 212	android/os/Build$VERSION:SDK_INT	I
    //   58: bipush 16
    //   60: if_icmpge +19 -> 79
    //   63: aload 11
    //   65: astore 9
    //   67: aload 12
    //   69: astore 8
    //   71: getstatic 41	com/tencent/mobileqq/screendetect/ScreenShotDetector:b	[Ljava/lang/String;
    //   74: astore 10
    //   76: goto +16 -> 92
    //   79: aload 11
    //   81: astore 9
    //   83: aload 12
    //   85: astore 8
    //   87: getstatic 47	com/tencent/mobileqq/screendetect/ScreenShotDetector:c	[Ljava/lang/String;
    //   90: astore 10
    //   92: aload 11
    //   94: astore 9
    //   96: aload 12
    //   98: astore 8
    //   100: aload 13
    //   102: aload_1
    //   103: aload 10
    //   105: aconst_null
    //   106: aconst_null
    //   107: ldc 214
    //   109: invokevirtual 218	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore_1
    //   113: aload_1
    //   114: ifnonnull +37 -> 151
    //   117: aload_1
    //   118: astore 9
    //   120: aload_1
    //   121: astore 8
    //   123: ldc 186
    //   125: iconst_2
    //   126: ldc 220
    //   128: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_1
    //   132: ifnull +18 -> 150
    //   135: aload_1
    //   136: invokeinterface 226 1 0
    //   141: ifne +9 -> 150
    //   144: aload_1
    //   145: invokeinterface 229 1 0
    //   150: return
    //   151: aload_1
    //   152: astore 9
    //   154: aload_1
    //   155: astore 8
    //   157: aload_1
    //   158: invokeinterface 232 1 0
    //   163: ifne +49 -> 212
    //   166: aload_1
    //   167: astore 9
    //   169: aload_1
    //   170: astore 8
    //   172: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +17 -> 192
    //   178: aload_1
    //   179: astore 9
    //   181: aload_1
    //   182: astore 8
    //   184: ldc 186
    //   186: iconst_2
    //   187: ldc 237
    //   189: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_1
    //   193: ifnull +18 -> 211
    //   196: aload_1
    //   197: invokeinterface 226 1 0
    //   202: ifne +9 -> 211
    //   205: aload_1
    //   206: invokeinterface 229 1 0
    //   211: return
    //   212: aload_1
    //   213: astore 9
    //   215: aload_1
    //   216: astore 8
    //   218: aload_1
    //   219: ldc 37
    //   221: invokeinterface 243 2 0
    //   226: istore 4
    //   228: aload_1
    //   229: astore 9
    //   231: aload_1
    //   232: astore 8
    //   234: aload_1
    //   235: ldc 39
    //   237: invokeinterface 243 2 0
    //   242: istore 5
    //   244: aload_1
    //   245: astore 9
    //   247: aload_1
    //   248: astore 8
    //   250: getstatic 212	android/os/Build$VERSION:SDK_INT	I
    //   253: istore_2
    //   254: iconst_m1
    //   255: istore_3
    //   256: iload_2
    //   257: bipush 16
    //   259: if_icmplt +245 -> 504
    //   262: aload_1
    //   263: astore 9
    //   265: aload_1
    //   266: astore 8
    //   268: aload_1
    //   269: ldc 43
    //   271: invokeinterface 243 2 0
    //   276: istore_3
    //   277: aload_1
    //   278: astore 9
    //   280: aload_1
    //   281: astore 8
    //   283: aload_1
    //   284: ldc 45
    //   286: invokeinterface 243 2 0
    //   291: istore_2
    //   292: goto +3 -> 295
    //   295: aload_1
    //   296: astore 9
    //   298: aload_1
    //   299: astore 8
    //   301: aload_1
    //   302: iload 4
    //   304: invokeinterface 246 2 0
    //   309: astore 10
    //   311: aload_1
    //   312: astore 9
    //   314: aload_1
    //   315: astore 8
    //   317: aload_1
    //   318: iload 5
    //   320: invokeinterface 250 2 0
    //   325: lstore 6
    //   327: iload_3
    //   328: iflt +44 -> 372
    //   331: iload_2
    //   332: iflt +40 -> 372
    //   335: aload_1
    //   336: astore 9
    //   338: aload_1
    //   339: astore 8
    //   341: aload_1
    //   342: iload_3
    //   343: invokeinterface 254 2 0
    //   348: istore_3
    //   349: aload_1
    //   350: astore 9
    //   352: aload_1
    //   353: astore 8
    //   355: aload_1
    //   356: iload_2
    //   357: invokeinterface 254 2 0
    //   362: istore 4
    //   364: iload_3
    //   365: istore_2
    //   366: iload 4
    //   368: istore_3
    //   369: goto +41 -> 410
    //   372: aload_1
    //   373: astore 9
    //   375: aload_1
    //   376: astore 8
    //   378: aload_0
    //   379: aload 10
    //   381: invokespecial 256	com/tencent/mobileqq/screendetect/ScreenShotDetector:a	(Ljava/lang/String;)Landroid/graphics/Point;
    //   384: astore 11
    //   386: aload_1
    //   387: astore 9
    //   389: aload_1
    //   390: astore 8
    //   392: aload 11
    //   394: getfield 259	android/graphics/Point:x	I
    //   397: istore_2
    //   398: aload_1
    //   399: astore 9
    //   401: aload_1
    //   402: astore 8
    //   404: aload 11
    //   406: getfield 262	android/graphics/Point:y	I
    //   409: istore_3
    //   410: aload_1
    //   411: astore 9
    //   413: aload_1
    //   414: astore 8
    //   416: aload_0
    //   417: aload 10
    //   419: lload 6
    //   421: iload_2
    //   422: iload_3
    //   423: invokespecial 265	com/tencent/mobileqq/screendetect/ScreenShotDetector:a	(Ljava/lang/String;JII)V
    //   426: aload_1
    //   427: ifnull +52 -> 479
    //   430: aload_1
    //   431: invokeinterface 226 1 0
    //   436: ifne +43 -> 479
    //   439: goto +34 -> 473
    //   442: astore_1
    //   443: goto +37 -> 480
    //   446: astore_1
    //   447: aload 8
    //   449: astore 9
    //   451: aload_1
    //   452: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   455: aload 8
    //   457: ifnull +22 -> 479
    //   460: aload 8
    //   462: invokeinterface 226 1 0
    //   467: ifne +12 -> 479
    //   470: aload 8
    //   472: astore_1
    //   473: aload_1
    //   474: invokeinterface 229 1 0
    //   479: return
    //   480: aload 9
    //   482: ifnull +20 -> 502
    //   485: aload 9
    //   487: invokeinterface 226 1 0
    //   492: ifne +10 -> 502
    //   495: aload 9
    //   497: invokeinterface 229 1 0
    //   502: aload_1
    //   503: athrow
    //   504: iconst_m1
    //   505: istore_2
    //   506: goto -211 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	ScreenShotDetector
    //   0	509	1	paramUri	android.net.Uri
    //   253	253	2	i1	int
    //   255	168	3	i2	int
    //   226	141	4	i3	int
    //   242	77	5	i4	int
    //   325	95	6	l1	long
    //   38	433	8	localObject1	Object
    //   34	462	9	localObject2	Object
    //   10	408	10	localObject3	Object
    //   30	375	11	localPoint	Point
    //   27	70	12	localObject4	Object
    //   45	56	13	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   40	47	442	finally
    //   55	63	442	finally
    //   71	76	442	finally
    //   87	92	442	finally
    //   100	113	442	finally
    //   123	131	442	finally
    //   157	166	442	finally
    //   172	178	442	finally
    //   184	192	442	finally
    //   218	228	442	finally
    //   234	244	442	finally
    //   250	254	442	finally
    //   268	277	442	finally
    //   283	292	442	finally
    //   301	311	442	finally
    //   317	327	442	finally
    //   341	349	442	finally
    //   355	364	442	finally
    //   378	386	442	finally
    //   392	398	442	finally
    //   404	410	442	finally
    //   416	426	442	finally
    //   451	455	442	finally
    //   40	47	446	java/lang/Exception
    //   55	63	446	java/lang/Exception
    //   71	76	446	java/lang/Exception
    //   87	92	446	java/lang/Exception
    //   100	113	446	java/lang/Exception
    //   123	131	446	java/lang/Exception
    //   157	166	446	java/lang/Exception
    //   172	178	446	java/lang/Exception
    //   184	192	446	java/lang/Exception
    //   218	228	446	java/lang/Exception
    //   234	244	446	java/lang/Exception
    //   250	254	446	java/lang/Exception
    //   268	277	446	java/lang/Exception
    //   283	292	446	java/lang/Exception
    //   301	311	446	java/lang/Exception
    //   317	327	446	java/lang/Exception
    //   341	349	446	java/lang/Exception
    //   355	364	446	java/lang/Exception
    //   378	386	446	java/lang/Exception
    //   392	398	446	java/lang/Exception
    //   404	410	446	java/lang/Exception
    //   416	426	446	java/lang/Exception
  }
  
  private void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (b(paramString, paramLong, paramInt1, paramInt2))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ScreenShot: path = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("; size = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" * ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("; date = ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("; diffTime = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - paramLong);
        QLog.d("ScreenShotDetector", 2, ((StringBuilder)localObject).toString());
      }
      if (!b(paramString))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ScreenShot 机型：");
          ((StringBuilder)localObject).append(Build.MANUFACTURER);
          ((StringBuilder)localObject).append(Build.MODEL);
          QLog.d("ScreenShotDetector", 2, ((StringBuilder)localObject).toString());
        }
        ScreenShotHelper.a("0X8009FED", 0);
        localObject = this.n;
        if (localObject != null) {
          ((ScreenShotDetector.ScreenShotListener)localObject).a();
        }
        this.l.removeCallbacksAndMessages(null);
        this.l.post(new ScreenShotDetector.1(this, paramString));
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Media content changed, but not screenshot: path = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("; size = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" * ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("; date = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("ScreenShotDetector", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    String str = c().getAccount();
    p = paramBoolean;
    if (str == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotDetector", 2, new Object[] { "getAccount in updateSwitchStatus: ", Boolean.valueOf(paramBoolean) });
    }
    o.edit().putBoolean(str, paramBoolean).apply();
  }
  
  private boolean b(String paramString)
  {
    if ((i.length() > 0) && (TextUtils.equals(i, paramString)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ScreenShot: imgPath has done; imagePath = ");
        localStringBuilder.append(paramString);
        QLog.d("ScreenShotDetector", 2, localStringBuilder.toString());
      }
      return true;
    }
    i = paramString;
    return false;
  }
  
  private boolean b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ScreenShotDetector called with checkScreenShot  当前时间与图片获取时间差 : ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - paramLong);
      QLog.d("ScreenShotDetector", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong >= this.h)
    {
      if (System.currentTimeMillis() - paramLong > 4000L) {
        return false;
      }
      if (f == null)
      {
        f = ScreenShotHelper.a((Context)this.g.get());
        if (f != null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Screen Real Size: ");
            ((StringBuilder)localObject).append(f.x);
            ((StringBuilder)localObject).append(" * ");
            ((StringBuilder)localObject).append(f.y);
            QLog.d("ScreenShotDetector", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("ScreenShotDetector", 2, "Get screen real size failed.");
        }
      }
      localObject = f;
      if ((localObject != null) && ((paramInt1 > ((Point)localObject).x) || (paramInt2 > f.y)) && ((paramInt2 > f.x) || (paramInt1 > f.y))) {
        return false;
      }
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramString = paramString.toLowerCase();
      localObject = d;
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
  
  public static AppRuntime c()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private static void c(Context paramContext, ScreenShotDetector.MediaContentObserver paramMediaContentObserver1, ScreenShotDetector.MediaContentObserver paramMediaContentObserver2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnRegisterObservers() called with: context = [");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], internalObserver = [");
      localStringBuilder.append(paramMediaContentObserver1);
      localStringBuilder.append("], externalObserver = [");
      localStringBuilder.append(paramMediaContentObserver2);
      localStringBuilder.append("]");
      QLog.d("ScreenShotDetector", 2, localStringBuilder.toString());
    }
    try
    {
      paramContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, paramMediaContentObserver1);
      paramContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, paramMediaContentObserver2);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnRegisterObservers error", paramContext);
    }
  }
  
  private static void d(Context paramContext, ScreenShotDetector.MediaContentObserver paramMediaContentObserver1, ScreenShotDetector.MediaContentObserver paramMediaContentObserver2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnUnRegisterObservers() called with: context = [");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], internalObserver = [");
      localStringBuilder.append(paramMediaContentObserver1);
      localStringBuilder.append("], externalObserver = [");
      localStringBuilder.append(paramMediaContentObserver2);
      localStringBuilder.append("]");
      QLog.d("ScreenShotDetector", 2, localStringBuilder.toString());
    }
    try
    {
      a(paramContext, paramMediaContentObserver1);
      a(paramContext, paramMediaContentObserver2);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnUnRegisterObservers error", paramContext);
    }
  }
  
  public static boolean d()
  {
    String str = c().getAccount();
    if (str == null) {
      return p;
    }
    boolean bool = o.getBoolean(str, true);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotDetector", 2, new Object[] { "getAccount in getSwitchStatus: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static ScreenShotDetector getInstance()
  {
    return m;
  }
  
  public void a(ScreenShotDetector.ScreenShotListener paramScreenShotListener)
  {
    this.n = paramScreenShotListener;
  }
  
  protected boolean b()
  {
    if (!ScreenShotHelper.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: onChange screen switch is closed!");
      }
      return true;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).mAutomator.g())) {
      return true;
    }
    if ((localAppRuntime != null) && (!localAppRuntime.isBackgroundPause)) {
      return localAppRuntime.isBackgroundStop;
    }
    return true;
  }
  
  public void c(Context paramContext)
  {
    if ((paramContext instanceof QQLSActivity))
    {
      QLog.e("ScreenShotDetector", 1, "ScreenShot: startListen error, context is QQLSActivity!");
      return;
    }
    this.g = new WeakReference(paramContext);
    this.h = 0L;
    this.h = System.currentTimeMillis();
    if (this.j == null) {
      this.j = new ScreenShotDetector.MediaContentObserver(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.l);
    }
    if (this.k == null) {
      this.k = new ScreenShotDetector.MediaContentObserver(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.l);
    }
    ThreadManager.executeOnSubThread(new ScreenShotDetector.2(this, paramContext.getApplicationContext()), false);
  }
  
  public void d(Context paramContext)
  {
    this.l.removeCallbacksAndMessages(null);
    ThreadManager.executeOnSubThread(new ScreenShotDetector.3(this, paramContext.getApplicationContext()), false);
  }
  
  public void disaptchTouchEventCallback(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    ScreenShotHelper.a(paramActivity, paramMotionEvent);
  }
  
  public void onWindowFocusChanged(Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ScreenShot: onWindowFocusChanged ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ScreenShotHelper-ScreenShotDetector", 2, localStringBuilder.toString());
    }
    this.l.removeCallbacksAndMessages(null);
    if (paramBoolean)
    {
      ScreenShotHelper.a(paramActivity, this.l);
      return;
    }
    if ("XIAOMI".equalsIgnoreCase(Build.MANUFACTURER)) {
      ScreenShotHelper.b(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotDetector
 * JD-Core Version:    0.7.0.1
 */