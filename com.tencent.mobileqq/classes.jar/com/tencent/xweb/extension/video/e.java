package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.media.AudioManager;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.util.h;
import java.util.Timer;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public class e
  implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, b, r
{
  private final int A = 1;
  private final int B = 2;
  private final int C = 3;
  private int D = 0;
  private int E = -3;
  private int F;
  private boolean G = false;
  private s H;
  private AudioManager I;
  private int J = 0;
  private double K = 0.0D;
  private float L = 0.0F;
  private float M = 0.0F;
  private a N;
  private float O = 1.0F;
  private Window P;
  private WindowManager.LayoutParams Q;
  private String R;
  private Timer S;
  private boolean T;
  private int U = 0;
  private double V;
  private int W = 200;
  private Drawable X;
  private boolean Y;
  private boolean Z;
  private Activity a;
  private boolean aa = false;
  private int ab;
  private WebView b;
  private ViewGroup c;
  private FrameLayout d;
  private SurfaceView e;
  private View f;
  private ViewGroup g;
  private VideoStatusLayout h;
  private ProgressBar i;
  private TextView j;
  private TextView k;
  private ClickableFrameLayout l;
  private LinearLayout m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private c q;
  private WebChromeClient.CustomViewCallback r;
  private GestureDetector s;
  private ScaleGestureDetector t;
  private boolean u;
  private long v;
  private double w;
  private double x;
  private double y;
  private final int z = 0;
  
  private Activity a(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext != paramContext) {
        return a(localContext);
      }
    }
    return null;
  }
  
  private SurfaceView a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return (SurfaceView)paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      while (i1 < paramView.getChildCount())
      {
        SurfaceView localSurfaceView = a(paramView.getChildAt(i1));
        if (localSurfaceView != null) {
          return localSurfaceView;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  private String a(double paramDouble1, double paramDouble2)
  {
    String str1 = String.format("%02d", new Object[] { Integer.valueOf((int)(paramDouble1 / 3600.0D)) });
    int i1 = (int)(paramDouble1 % 3600.0D);
    String str2 = String.format("%02d", new Object[] { Integer.valueOf(i1 / 60) });
    String str3 = String.format("%02d", new Object[] { Integer.valueOf(i1 % 60) });
    if (paramDouble2 > 3600.0D) {
      return String.format("%s:%s:%s", new Object[] { str1, str2, str3 });
    }
    return String.format("%s:%s", new Object[] { str2, str3 });
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = this.f;
    if (localView != null) {
      localView.setLayoutParams(c(paramInt1, paramInt2, paramInt3));
    }
  }
  
  private void a(Activity paramActivity, int paramInt)
  {
    s locals = this.H;
    if ((locals != null) && (locals.a(paramInt)))
    {
      Log.i("XWebNativeInterface", "setRequestedOrientation by wechat client");
      return;
    }
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(paramInt);
    }
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 233	com/tencent/luggage/wxa/su/h:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/su/g;
    //   5: astore_1
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 7
    //   15: aload_1
    //   16: ifnull +109 -> 125
    //   19: aload_1
    //   20: invokevirtual 237	com/tencent/luggage/wxa/su/g:e	()I
    //   23: iconst_m1
    //   24: if_icmpeq +101 -> 125
    //   27: aload_1
    //   28: invokevirtual 237	com/tencent/luggage/wxa/su/g:e	()I
    //   31: istore_0
    //   32: new 239	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: aload_1
    //   38: invokevirtual 237	com/tencent/luggage/wxa/su/g:e	()I
    //   41: iconst_0
    //   42: invokevirtual 242	com/tencent/luggage/wxa/su/g:a	(IZ)Ljava/lang/String;
    //   45: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 249	java/io/File:isFile	()Z
    //   53: ifeq +60 -> 113
    //   56: aload_2
    //   57: invokevirtual 252	java/io/File:exists	()Z
    //   60: ifeq +53 -> 113
    //   63: new 254	java/io/FileInputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 257	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_3
    //   72: goto +57 -> 129
    //   75: astore_1
    //   76: new 259	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   83: astore_2
    //   84: aload_2
    //   85: ldc_w 262
    //   88: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: aload_1
    //   94: invokevirtual 269	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 202
    //   103: aload_2
    //   104: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 274	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto +10 -> 120
    //   113: aload_1
    //   114: iconst_m1
    //   115: iconst_1
    //   116: invokevirtual 277	com/tencent/luggage/wxa/su/g:b	(IZ)Z
    //   119: pop
    //   120: aconst_null
    //   121: astore_3
    //   122: goto +7 -> 129
    //   125: aconst_null
    //   126: astore_3
    //   127: iconst_m1
    //   128: istore_0
    //   129: aload 8
    //   131: astore_2
    //   132: aload_3
    //   133: ifnull +335 -> 468
    //   136: new 279	java/io/InputStreamReader
    //   139: dup
    //   140: aload_3
    //   141: ldc_w 281
    //   144: invokespecial 284	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   147: astore_1
    //   148: new 286	java/io/BufferedReader
    //   151: dup
    //   152: aload_1
    //   153: invokespecial 289	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   156: astore 6
    //   158: aload_1
    //   159: astore_2
    //   160: aload 6
    //   162: astore 4
    //   164: new 291	java/lang/StringBuffer
    //   167: dup
    //   168: ldc_w 293
    //   171: invokespecial 294	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   174: astore 5
    //   176: aload_1
    //   177: astore_2
    //   178: aload 6
    //   180: astore 4
    //   182: aload 6
    //   184: invokevirtual 297	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   187: astore 10
    //   189: aload 10
    //   191: ifnull +35 -> 226
    //   194: aload_1
    //   195: astore_2
    //   196: aload 6
    //   198: astore 4
    //   200: aload 5
    //   202: aload 10
    //   204: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   207: pop
    //   208: aload_1
    //   209: astore_2
    //   210: aload 6
    //   212: astore 4
    //   214: aload 5
    //   216: ldc_w 302
    //   219: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   222: pop
    //   223: goto -47 -> 176
    //   226: aload_1
    //   227: astore_2
    //   228: aload 6
    //   230: astore 4
    //   232: aload 5
    //   234: invokevirtual 303	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   237: astore 5
    //   239: aload 5
    //   241: astore_2
    //   242: aload_1
    //   243: invokevirtual 306	java/io/InputStreamReader:close	()V
    //   246: aload 5
    //   248: astore_2
    //   249: aload 6
    //   251: invokevirtual 307	java/io/BufferedReader:close	()V
    //   254: aload 5
    //   256: astore_2
    //   257: aload_3
    //   258: ifnull +210 -> 468
    //   261: aload 5
    //   263: astore_1
    //   264: aload_1
    //   265: astore_2
    //   266: aload_3
    //   267: invokevirtual 310	java/io/InputStream:close	()V
    //   270: aload_1
    //   271: astore_2
    //   272: goto +196 -> 468
    //   275: goto +193 -> 468
    //   278: astore_2
    //   279: aload_1
    //   280: astore 5
    //   282: aload 6
    //   284: astore_1
    //   285: aload_2
    //   286: astore 6
    //   288: goto +41 -> 329
    //   291: astore 4
    //   293: aconst_null
    //   294: astore 5
    //   296: goto +143 -> 439
    //   299: astore 6
    //   301: aconst_null
    //   302: astore_2
    //   303: aload_1
    //   304: astore 5
    //   306: aload_2
    //   307: astore_1
    //   308: goto +21 -> 329
    //   311: astore 4
    //   313: aconst_null
    //   314: astore_1
    //   315: aload_1
    //   316: astore 5
    //   318: goto +121 -> 439
    //   321: astore 6
    //   323: aconst_null
    //   324: astore 5
    //   326: aload 5
    //   328: astore_1
    //   329: aload 5
    //   331: astore_2
    //   332: aload_1
    //   333: astore 4
    //   335: new 259	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   342: astore 10
    //   344: aload 5
    //   346: astore_2
    //   347: aload_1
    //   348: astore 4
    //   350: aload 10
    //   352: ldc_w 312
    //   355: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 5
    //   361: astore_2
    //   362: aload_1
    //   363: astore 4
    //   365: aload 10
    //   367: aload 6
    //   369: invokevirtual 313	java/io/IOException:getMessage	()Ljava/lang/String;
    //   372: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 5
    //   378: astore_2
    //   379: aload_1
    //   380: astore 4
    //   382: ldc 202
    //   384: aload 10
    //   386: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 274	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 5
    //   394: ifnull +11 -> 405
    //   397: aload 9
    //   399: astore_2
    //   400: aload 5
    //   402: invokevirtual 306	java/io/InputStreamReader:close	()V
    //   405: aload_1
    //   406: ifnull +10 -> 416
    //   409: aload 9
    //   411: astore_2
    //   412: aload_1
    //   413: invokevirtual 307	java/io/BufferedReader:close	()V
    //   416: aload 8
    //   418: astore_2
    //   419: aload_3
    //   420: ifnull +48 -> 468
    //   423: aload 7
    //   425: astore_1
    //   426: goto -162 -> 264
    //   429: astore_1
    //   430: aload 4
    //   432: astore 5
    //   434: aload_1
    //   435: astore 4
    //   437: aload_2
    //   438: astore_1
    //   439: aload_1
    //   440: ifnull +7 -> 447
    //   443: aload_1
    //   444: invokevirtual 306	java/io/InputStreamReader:close	()V
    //   447: aload 5
    //   449: ifnull +8 -> 457
    //   452: aload 5
    //   454: invokevirtual 307	java/io/BufferedReader:close	()V
    //   457: aload_3
    //   458: ifnull +7 -> 465
    //   461: aload_3
    //   462: invokevirtual 310	java/io/InputStream:close	()V
    //   465: aload 4
    //   467: athrow
    //   468: aload_2
    //   469: ifnull +49 -> 518
    //   472: aload_2
    //   473: invokevirtual 316	java/lang/String:isEmpty	()Z
    //   476: ifeq +6 -> 482
    //   479: goto +39 -> 518
    //   482: new 259	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   489: astore_1
    //   490: aload_1
    //   491: ldc_w 318
    //   494: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_1
    //   499: iload_0
    //   500: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: ldc 202
    //   506: aload_1
    //   507: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 209	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: invokestatic 325	com/tencent/xweb/util/h:K	()V
    //   516: aload_2
    //   517: areturn
    //   518: ldc 202
    //   520: ldc_w 327
    //   523: invokestatic 209	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: invokestatic 329	com/tencent/xweb/util/h:L	()V
    //   529: ldc_w 331
    //   532: areturn
    //   533: astore_1
    //   534: goto -259 -> 275
    //   537: astore_1
    //   538: goto -73 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	469	0	i1	int
    //   5	33	1	localg	com.tencent.luggage.wxa.su.g
    //   75	39	1	localFileNotFoundException	java.io.FileNotFoundException
    //   147	279	1	localObject1	Object
    //   429	6	1	localObject2	Object
    //   438	69	1	localObject3	Object
    //   533	1	1	localException1	java.lang.Exception
    //   537	1	1	localException2	java.lang.Exception
    //   48	224	2	localObject4	Object
    //   278	8	2	localIOException1	java.io.IOException
    //   302	215	2	localObject5	Object
    //   71	391	3	localFileInputStream	java.io.FileInputStream
    //   162	69	4	localObject6	Object
    //   291	1	4	localObject7	Object
    //   311	1	4	localObject8	Object
    //   333	133	4	localObject9	Object
    //   174	279	5	localObject10	Object
    //   156	131	6	localObject11	Object
    //   299	1	6	localIOException2	java.io.IOException
    //   321	47	6	localIOException3	java.io.IOException
    //   13	411	7	localObject12	Object
    //   7	410	8	localObject13	Object
    //   10	400	9	localObject14	Object
    //   187	198	10	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   63	72	75	java/io/FileNotFoundException
    //   164	176	278	java/io/IOException
    //   182	189	278	java/io/IOException
    //   200	208	278	java/io/IOException
    //   214	223	278	java/io/IOException
    //   232	239	278	java/io/IOException
    //   148	158	291	finally
    //   148	158	299	java/io/IOException
    //   136	148	311	finally
    //   136	148	321	java/io/IOException
    //   164	176	429	finally
    //   182	189	429	finally
    //   200	208	429	finally
    //   214	223	429	finally
    //   232	239	429	finally
    //   335	344	429	finally
    //   350	359	429	finally
    //   365	376	429	finally
    //   382	392	429	finally
    //   242	246	533	java/lang/Exception
    //   249	254	533	java/lang/Exception
    //   266	270	533	java/lang/Exception
    //   400	405	533	java/lang/Exception
    //   412	416	533	java/lang/Exception
    //   443	447	537	java/lang/Exception
    //   452	457	537	java/lang/Exception
    //   461	465	537	java/lang/Exception
  }
  
  private String b(double paramDouble)
  {
    return a(paramDouble, this.w);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    localLayoutParams.width = paramInt2;
    localLayoutParams.height = paramInt3;
    View localView = this.f;
    if (localView != null) {
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private FrameLayout.LayoutParams c(int paramInt1, int paramInt2, int paramInt3)
  {
    Display localDisplay = ((WindowManager)l().getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point(0, 0);
    localDisplay.getSize(localPoint);
    int i1;
    if (paramInt1 == 0)
    {
      i1 = Math.max(localPoint.x, localPoint.y);
      paramInt1 = Math.min(localPoint.x, localPoint.y);
    }
    else
    {
      paramInt1 = Math.max(localPoint.x, localPoint.y);
      i1 = Math.min(localPoint.x, localPoint.y);
    }
    double d1 = paramInt2;
    Double.isNaN(d1);
    double d2 = paramInt3;
    Double.isNaN(d2);
    d2 = d1 * 1.0D / d2;
    d1 = i1;
    Double.isNaN(d1);
    double d3 = paramInt1;
    Double.isNaN(d3);
    if (d2 >= d1 * 1.0D / d3)
    {
      d2 = 1.0D / d2;
      Double.isNaN(d1);
      paramInt1 = (int)(d1 * d2);
    }
    else
    {
      Double.isNaN(d3);
      i1 = (int)(d3 * d2);
    }
    return new FrameLayout.LayoutParams(i1, paramInt1, 17);
  }
  
  private String c(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramDouble, this.w));
    localStringBuilder.append("/");
    paramDouble = this.w;
    localStringBuilder.append(a(paramDouble, paramDouble));
    return localStringBuilder.toString();
  }
  
  private Context l()
  {
    return this.b.getContext();
  }
  
  private Activity m()
  {
    Activity localActivity = this.a;
    if (localActivity != null) {
      return localActivity;
    }
    localActivity = a(this.b.getContext());
    if (localActivity != null)
    {
      this.a = localActivity;
      return localActivity;
    }
    Log.e("XWebNativeInterface", "royle:tryGetActivity but no Activity");
    return localActivity;
  }
  
  private String n()
  {
    double d1 = this.w;
    return a(d1, d1);
  }
  
  public void a()
  {
    WebChromeClient.CustomViewCallback localCustomViewCallback = this.r;
    if (localCustomViewCallback != null) {
      localCustomViewCallback.onCustomViewHidden();
    }
    j();
  }
  
  public void a(double paramDouble)
  {
    this.V = paramDouble;
  }
  
  public void a(double paramDouble, boolean paramBoolean)
  {
    a(new e.3(this, paramBoolean, paramDouble));
  }
  
  public void a(double paramDouble, double[] paramArrayOfDouble)
  {
    a(new e.4(this, paramDouble, paramArrayOfDouble));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Activity localActivity = m();
    if (localActivity == null) {
      return;
    }
    if ((this.E == -3) && (localActivity != null)) {
      this.E = localActivity.getRequestedOrientation();
    }
    int i1 = 1;
    if (paramInt1 <= paramInt2)
    {
      a(localActivity, 1);
    }
    else
    {
      a(localActivity, 0);
      i1 = 0;
    }
    this.F = i1;
    a(i1, paramInt1, paramInt2);
  }
  
  public void a(Activity paramActivity, View paramView1, View paramView2, Context paramContext, String paramString)
  {
    this.a = paramActivity;
    this.b = ((WebView)paramView1);
    this.R = paramString;
    this.d = new FrameLayout(l());
    this.d.setBackgroundColor(-16777216);
    if (this.b.isXWalkKernel())
    {
      this.e = new SurfaceView(l());
      this.e.getHolder().setFormat(-3);
      this.e.getHolder().addCallback(new e.1(this));
      this.e.setZOrderOnTop(false);
      this.e.setZOrderMediaOverlay(false);
      this.d.addView(this.e);
    }
    this.s = new GestureDetector(l(), this);
    this.t = new ScaleGestureDetector(l(), this);
    this.s.setIsLongpressEnabled(false);
    this.g = ((ViewGroup)LayoutInflater.from(l()).inflate(2131629630, null));
    this.g.setVisibility(8);
    this.q = new c((FrameLayout)this.g.findViewById(2131440417), new e.7(this));
    this.i = ((ProgressBar)this.g.findViewById(2131440733));
    this.j = ((TextView)this.g.findViewById(2131448365));
    this.k = ((TextView)this.g.findViewById(2131448830));
    this.n = ((ImageView)this.g.findViewById(2131435374));
    this.h = ((VideoStatusLayout)this.g.findViewById(2131436865));
    this.l = ((ClickableFrameLayout)this.g.findViewById(2131436860));
    this.l.setGestureDetector(this.s);
    this.l.setOnTouchListener(new e.14(this));
    this.o = ((ImageView)this.g.findViewById(2131435373));
    this.o.setOnClickListener(new e.15(this));
    this.m = ((LinearLayout)this.g.findViewById(2131436868));
    this.m.setVisibility(4);
    this.p = ((ImageView)this.g.findViewById(2131435378));
    this.p.setOnClickListener(new e.16(this));
  }
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    Log.i("XWebNativeInterface", "onShowCustomView");
    this.f = paramView;
    this.r = paramCustomViewCallback;
    if ((this.f != null) || (this.b.isXWalkKernel()))
    {
      if (this.b.isXWalkKernel()) {
        h.l();
      } else if (this.b.isSysKernel()) {
        h.p();
      }
      i();
    }
    this.b.requestFocus();
  }
  
  public void a(Object paramObject)
  {
    new ReflectMethod(paramObject, "addJavascriptInterface", new Class[] { Object.class, String.class }).invoke(new Object[] { this, "xwebToNative" });
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.G) {
      return;
    }
    Activity localActivity = m();
    if (localActivity != null)
    {
      localActivity.runOnUiThread(paramRunnable);
      return;
    }
    this.b.getView().post(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("disableJsCallback:");
    localStringBuilder.append(paramBoolean);
    Log.i("XWebNativeInterface", localStringBuilder.toString());
    this.G = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.b != null) && (paramBoolean2) && (this.R != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("evaluteJavascript:");
      ((StringBuilder)localObject).append(paramBoolean1);
      Log.i("XWebNativeInterface", ((StringBuilder)localObject).toString());
      String str = this.R;
      localObject = str;
      if (paramBoolean1) {
        localObject = d.a(str);
      }
      this.b.evaluateJavascript((String)localObject, new e.17(this));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(new e.2(this, paramBoolean));
  }
  
  public boolean b(Object paramObject)
  {
    this.H = ((s)paramObject);
    return true;
  }
  
  public void c()
  {
    if (this.I == null) {
      this.I = ((AudioManager)l().getSystemService("audio"));
    }
    this.J = this.I.getStreamMaxVolume(3);
    this.K = this.I.getStreamVolume(3);
    if (this.N == null) {
      this.N = new a(l());
    }
    if (this.P == null)
    {
      localObject = m();
      if (localObject != null) {
        this.P = ((Activity)localObject).getWindow();
      }
    }
    Object localObject = this.P;
    if ((localObject != null) && (this.Q == null)) {
      this.Q = ((Window)localObject).getAttributes();
    }
    localObject = this.Q;
    if (localObject != null)
    {
      this.O = ((WindowManager.LayoutParams)localObject).screenBrightness;
      if (this.O == -1.0F) {
        try
        {
          int i1 = Settings.System.getInt(l().getContentResolver(), "screen_brightness");
          double d1 = i1;
          Double.isNaN(d1);
          float f1 = (float)(d1 / 256.0D);
          this.O = f1;
          return;
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("brightness get error:");
          localStringBuilder.append(localSettingNotFoundException.getMessage());
          Log.e("XWebNativeInterface", localStringBuilder.toString());
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Activity localActivity = m();
    if (localActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      if ((localActivity.getWindow().getAttributes().flags & 0x800) != 0)
      {
        this.Z = true;
        localActivity.getWindow().clearFlags(2048);
      }
      else
      {
        this.Z = false;
      }
      if (!this.aa)
      {
        if ((localActivity.getWindow().getAttributes().flags & 0x400) != 0)
        {
          this.Y = true;
        }
        else
        {
          this.Y = false;
          localActivity.getWindow().addFlags(1024);
        }
        this.aa = true;
      }
    }
    else
    {
      if (this.Z) {
        localActivity.getWindow().addFlags(2048);
      }
      if (!this.Y) {
        localActivity.getWindow().clearFlags(1024);
      }
      this.ab = 0;
      this.aa = false;
      this.u = false;
    }
  }
  
  public void d()
  {
    Timer localTimer = this.S;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.S.purge();
      this.S = null;
    }
    this.S = new Timer();
    this.S.schedule(new e.18(this), 4000L);
  }
  
  public void e()
  {
    Timer localTimer = this.S;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.S.purge();
      this.S = null;
    }
  }
  
  public void f()
  {
    if (this.T)
    {
      h();
      return;
    }
    g();
  }
  
  public void g()
  {
    a(new e.19(this));
  }
  
  public void h()
  {
    a(new e.20(this));
  }
  
  public void i()
  {
    Log.i("XWebNativeInterface", "attach");
    if (k())
    {
      Log.i("XWebNativeInterface", "attach has entered fullscreen");
      return;
    }
    Object localObject1 = m();
    if (localObject1 == null) {
      return;
    }
    c();
    c(true);
    localObject1 = (FrameLayout)((Activity)localObject1).getWindow().getDecorView();
    Object localObject2;
    if ((this.b.isXWalkKernel()) && (this.d.getParent() == localObject1))
    {
      localObject2 = this.f;
      if (localObject2 != null)
      {
        this.d.addView((View)localObject2, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        return;
      }
    }
    if (this.d.getParent() == localObject1) {
      return;
    }
    ((FrameLayout)localObject1).addView(this.d, new FrameLayout.LayoutParams(-1, -1, 17));
    localObject1 = this.f;
    if (localObject1 != null)
    {
      localObject2 = this.d;
      ((FrameLayout)localObject2).addView((View)localObject1, ((FrameLayout)localObject2).getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
      if (this.b.isSysKernel()) {
        this.f.setVisibility(4);
      }
    }
    if (this.b.isSysKernel())
    {
      localObject1 = a(this.f);
      if (localObject1 != null) {
        ((SurfaceView)localObject1).setZOrderMediaOverlay(true);
      }
    }
    if (this.b.isXWalkKernel())
    {
      this.c = ((ViewGroup)this.b.getParent());
      this.c.removeView(this.b);
      localObject1 = this.d;
      ((FrameLayout)localObject1).addView(this.b, ((FrameLayout)localObject1).getChildCount());
    }
    localObject1 = this.d;
    ((FrameLayout)localObject1).addView(this.g, ((FrameLayout)localObject1).getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
    this.X = this.b.getView().getBackground();
    localObject1 = this.X;
    if (localObject1 != null) {
      this.X = ((Drawable)localObject1).getConstantState().newDrawable().mutate();
    }
    this.b.getView().setBackground(new ColorDrawable(-16777216));
    if (this.b.isSysKernel()) {
      this.d.postDelayed(new e.13(this), this.W);
    }
  }
  
  public void j()
  {
    Log.i("XWebNativeInterface", "detach");
    if (!k())
    {
      Log.i("XWebNativeInterface", "detach has exited fullscreen");
      return;
    }
    Activity localActivity = m();
    if (localActivity == null) {
      return;
    }
    if (this.X != null)
    {
      this.b.getView().setBackground(this.X);
      this.X = null;
    }
    else
    {
      this.b.getView().setBackground(new ColorDrawable(0));
    }
    Object localObject = (ViewGroup)localActivity.getWindow().getDecorView();
    if (this.d.getParent() == localObject)
    {
      if (this.b.isXWalkKernel())
      {
        this.d.removeView(this.b);
        this.c.addView(this.b, 0);
      }
      localObject = this.f;
      if (localObject != null) {
        this.d.removeView((View)localObject);
      }
      this.d.removeView(this.g);
      this.g.setVisibility(8);
      int i1 = this.E;
      if (i1 != -3)
      {
        a(localActivity, i1);
        this.E = -3;
      }
      c(false);
      if ((this.d.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.d.getParent()).removeView(this.d);
      }
    }
  }
  
  public boolean k()
  {
    return this.aa;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.U = 0;
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.D == 1) && (this.f != null))
    {
      float f1 = paramScaleGestureDetector.getScaleFactor();
      this.f.getLeft();
      this.f.getTop();
      this.f.getBottom();
      this.f.getRight();
      b(this.F, (int)(this.f.getWidth() * f1), (int)(this.f.getHeight() * f1));
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return true;
      }
      paramFloat2 = paramMotionEvent2.getX();
      float f2 = paramMotionEvent1.getX();
      float f1 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      if (this.g.getHeight() > this.g.getWidth())
      {
        paramFloat1 = this.g.getWidth();
        i1 = this.g.getHeight();
      }
      else
      {
        paramFloat1 = this.g.getHeight();
        i1 = this.g.getWidth();
      }
      float f3 = i1;
      int i1 = this.U;
      if (i1 != 0)
      {
        paramFloat2 = 0.0F;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return true;
            }
            paramFloat1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
            this.M = this.q.a();
            if (paramFloat1 > 0.0F)
            {
              this.L = ((int)(this.M + paramFloat1 / f3 * 100.0F));
              if (this.L > 100.0F) {
                this.L = 100.0F;
              }
            }
            else
            {
              this.L = ((int)(this.M + paramFloat1 / f3 * 100.0F));
              if (this.L < 0.0F) {
                this.L = 0.0F;
              }
            }
            d1 = this.w;
            d2 = this.L;
            Double.isNaN(d2);
            d1 = d1 * d2 / 100.0D;
            this.h.setVideoTimeProgress(c(d1));
            this.h.a();
            a(d1);
            return true;
          }
          paramFloat1 = f1 * -1.0F / paramFloat1;
          paramFloat1 = this.O + paramFloat1 * 1.2F;
          if (paramFloat1 < 0.0F) {
            paramFloat1 = paramFloat2;
          } else if (paramFloat1 > 1.0F) {
            paramFloat1 = 1.0F;
          }
          paramMotionEvent1 = this.Q;
          paramMotionEvent1.screenBrightness = paramFloat1;
          this.P.setAttributes(paramMotionEvent1);
          this.h.setBrightProgress((int)(paramFloat1 * 100.0F));
          this.h.a();
          return true;
        }
        paramFloat2 = f1 * -1.0F;
        d1 = this.J * paramFloat2 / paramFloat1 * 1.2F;
        int i2 = (int)d1;
        i1 = i2;
        if (i2 == 0)
        {
          i1 = i2;
          if (Math.abs(d1) > 0.2000000029802322D) {
            if (paramFloat2 > 0.0F)
            {
              i1 = 1;
            }
            else
            {
              i1 = i2;
              if (paramFloat2 < 0.0F) {
                i1 = -1;
              }
            }
          }
        }
        d1 = this.K;
        d2 = i1;
        Double.isNaN(d2);
        d2 = d1 + d2;
        i1 = this.J;
        if (d2 > i1)
        {
          d1 = i1;
        }
        else
        {
          d1 = d2;
          if (d2 < 0.0D) {
            d1 = 0.0D;
          }
        }
        this.I.setStreamVolume(3, (int)d1, 4);
        d2 = Float.valueOf(this.J).floatValue();
        Double.isNaN(d2);
        i1 = (int)(d1 / d2 * 100.0D);
        this.h.setVolumnProgress(i1);
        this.h.a();
        return true;
      }
      if (Math.abs(paramFloat2 - f2) - Math.abs(f1) > 1.0F)
      {
        this.U = 3;
        return true;
      }
      c();
      double d1 = Math.ceil(this.b.getContext().getResources().getDisplayMetrics().density * 25.0F);
      double d2 = paramMotionEvent1.getY();
      d1 *= 2.0D;
      if (d2 >= d1)
      {
        d2 = paramMotionEvent1.getY();
        double d3 = this.g.getHeight();
        Double.isNaN(d3);
        if (d2 <= d3 - d1)
        {
          if (paramMotionEvent1.getX() < this.g.getWidth() / 2.0F)
          {
            this.U = 2;
            return true;
          }
          this.U = 1;
          return true;
        }
      }
      this.U = 0;
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    e();
    f();
    return true;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onSpecialVideoEnterFullscreen(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSpecialVideoEnterFullscreen:");
    localStringBuilder.append(paramInt);
    Log.i("XWebNativeInterface", localStringBuilder.toString());
    h.a(paramInt, this.b.isXWalkKernel());
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onSpecialVideoHook(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSpecialVideoHook:");
    localStringBuilder.append(paramInt);
    Log.i("XWebNativeInterface", localStringBuilder.toString());
    h.b(paramInt, this.b.isXWalkKernel());
  }
  
  @android.webkit.JavascriptInterface
  public boolean onVideoEmptied()
  {
    Log.i("XWebNativeInterface", "onVideoEmptied");
    s locals = this.H;
    if (locals != null)
    {
      locals.h();
      return true;
    }
    return false;
  }
  
  @android.webkit.JavascriptInterface
  public void onVideoEnded()
  {
    Log.i("XWebNativeInterface", "onVideoEnded");
    s locals = this.H;
    if (locals != null) {
      locals.g();
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onVideoEnterFullscreen:isVideoTag:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(",width:");
    ((StringBuilder)localObject).append(paramDouble1);
    ((StringBuilder)localObject).append(",height:");
    ((StringBuilder)localObject).append(paramDouble2);
    ((StringBuilder)localObject).append(",pause:");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(",seeking:");
    ((StringBuilder)localObject).append(paramBoolean3);
    ((StringBuilder)localObject).append(",currentTime:");
    ((StringBuilder)localObject).append(paramDouble3);
    ((StringBuilder)localObject).append(",duration:");
    ((StringBuilder)localObject).append(paramDouble4);
    Log.i("XWebNativeInterface", ((StringBuilder)localObject).toString());
    localObject = this.H;
    if (localObject != null) {
      ((s)localObject).a(paramBoolean1, paramLong, paramDouble1, paramDouble2, paramBoolean2, paramBoolean3, paramDouble3, paramDouble4, paramArrayOfDouble);
    }
    if (this.b.isXWalkKernel()) {
      h.m();
    } else if (this.b.isSysKernel()) {
      h.q();
    }
    if (paramBoolean1)
    {
      if (this.b.isXWalkKernel()) {
        h.n();
      } else if (this.b.isSysKernel()) {
        h.r();
      }
      this.u = true;
    }
    this.v = paramLong;
    this.w = paramDouble4;
    this.x = paramDouble1;
    this.y = paramDouble2;
    if (paramBoolean3) {
      onVideoSeeking();
    } else {
      onVideoSeeked();
    }
    a(new e.10(this, paramBoolean1, paramDouble1, paramDouble2));
    onVideoTimeUpdate(paramDouble3, paramDouble4, paramArrayOfDouble);
    b(paramBoolean2);
  }
  
  @android.webkit.JavascriptInterface
  public void onVideoError(int paramInt, String paramString)
  {
    Log.i("XWebNativeInterface", "onVideoError");
    s locals = this.H;
    if (locals != null) {
      locals.a(paramInt, paramString);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoExitFullscreen()
  {
    Log.i("XWebNativeInterface", "onVideoExitFullscreen");
    s locals = this.H;
    if (locals != null) {
      locals.i();
    }
    this.u = false;
    a(new e.11(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoGetFrame(long paramLong, double paramDouble, String paramString)
  {
    if ((paramLong == this.v) && (this.V == paramDouble) && (paramString != null) && (paramString.startsWith("data:image/png;base64,")))
    {
      paramString = Base64.decode(paramString.substring(22), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      this.n.setImageBitmap(paramString);
      this.n.setVisibility(0);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoPause()
  {
    Log.i("XWebNativeInterface", "onVideoPause");
    s locals = this.H;
    if (locals != null) {
      locals.f();
    }
    b(true);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoPlay()
  {
    Log.i("XWebNativeInterface", "onVideoPlay");
    s locals = this.H;
    if (locals != null) {
      locals.e();
    }
    b(false);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoPlaying()
  {
    Log.i("XWebNativeInterface", "onVideoPlaying");
    s locals = this.H;
    if (locals != null) {
      locals.a();
    }
    a(new e.5(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoSeeked()
  {
    Log.i("XWebNativeInterface", "onVideoSeeked");
    s locals = this.H;
    if (locals != null) {
      locals.d();
    }
    a(new e.9(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoSeeking()
  {
    Log.i("XWebNativeInterface", "onVideoSeeking");
    s locals = this.H;
    if (locals != null) {
      locals.c();
    }
    a(new e.8(this));
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
  {
    Object localObject = this.H;
    if (localObject != null) {
      ((s)localObject).a(paramDouble1, paramDouble2);
    }
    if ((this.y != paramDouble2) || (this.x != paramDouble1))
    {
      this.x = paramDouble1;
      this.y = paramDouble2;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVideoSizeUpdate width:");
      ((StringBuilder)localObject).append(paramDouble1);
      ((StringBuilder)localObject).append(", height:");
      ((StringBuilder)localObject).append(paramDouble2);
      Log.i("XWebNativeInterface", ((StringBuilder)localObject).toString());
      a(new e.12(this, paramDouble1, paramDouble2));
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoTimeUpdate(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
  {
    s locals = this.H;
    if (locals != null) {
      locals.a(paramDouble1, paramDouble2, paramArrayOfDouble);
    }
    this.w = paramDouble2;
    a(paramDouble1, true);
    a(paramDouble2, paramArrayOfDouble);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public void onVideoWaiting()
  {
    Log.i("XWebNativeInterface", "onVideoWaiting");
    s locals = this.H;
    if (locals != null) {
      locals.b();
    }
    a(new e.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e
 * JD-Core Version:    0.7.0.1
 */