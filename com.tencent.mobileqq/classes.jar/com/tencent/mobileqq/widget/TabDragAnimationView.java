package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.qqcontext.R.styleable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TabDragAnimationView
  extends View
{
  private static boolean C;
  private static boolean D;
  private static boolean E;
  public static final int a = ViewUtils.dpToPx(27.0F);
  public static final int b = ViewUtils.dpToPx(42.0F);
  public static HashMap<String, String> q;
  private static final int u = ViewUtils.dpToPx(2.0F);
  private LottieDrawable A;
  private LottieDrawable B;
  private String F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private boolean M;
  private boolean N;
  private boolean O;
  private final TabDragAnimationView.StopAnimUpdateListener P;
  private final TabDragAnimationView.ScrollAnimUpdateListener Q;
  private final TabDragAnimationView.ScaleAnimUpdateListener R;
  private float S;
  private final boolean T;
  private Paint U;
  private Rect V;
  private boolean W;
  private Canvas Z;
  private Bitmap aa;
  private int ab;
  private boolean ac;
  private final Handler ad;
  private GestureDetector ae;
  private GestureDetector.OnDoubleTapListener af;
  private TabDragAnimationView.OnDragListener ag;
  private View.OnLongClickListener ah;
  private HashMap<String, String> ai;
  private HashMap<Integer, Integer> aj;
  private HashMap<Integer, Integer> ak;
  protected int c;
  protected int d;
  protected int e;
  float f;
  float g;
  float h;
  float i;
  int j;
  public boolean k;
  protected boolean l;
  ValueAnimator m;
  ValueAnimator n;
  int o;
  int p;
  public URLDrawable r;
  public boolean s;
  private String t;
  private Drawable v;
  private Drawable w;
  private Drawable x;
  private Drawable y;
  private Drawable z;
  
  public TabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TabDragAnimationView@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.t = ((StringBuilder)localObject).toString();
    this.I = -1;
    boolean bool = false;
    this.J = 0;
    this.K = 0;
    this.f = 0.0F;
    this.g = 0.0F;
    this.h = 0.0F;
    this.i = 0.0F;
    this.j = 1;
    this.L = -1;
    this.k = false;
    this.M = false;
    this.l = true;
    this.N = false;
    this.O = false;
    this.S = 0.0F;
    this.U = new Paint(1);
    this.V = new Rect();
    this.W = false;
    this.Z = new Canvas();
    this.ab = 10000;
    this.ac = true;
    this.ad = new Handler(Looper.getMainLooper());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bF, paramInt, 0);
    try
    {
      this.c = paramAttributeSet.getInt(R.styleable.bG, 0);
      this.G = paramAttributeSet.getDimensionPixelSize(R.styleable.bI, 0);
      this.H = paramAttributeSet.getDimensionPixelSize(R.styleable.bH, 0);
      if (QLog.isColorLevel())
      {
        localObject = this.t;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load xml attr, expected logo width=");
        localStringBuilder.append(this.G);
        localStringBuilder.append(", expected logo height=");
        localStringBuilder.append(this.H);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      paramAttributeSet.recycle();
      this.P = new TabDragAnimationView.StopAnimUpdateListener(this);
      this.Q = new TabDragAnimationView.ScrollAnimUpdateListener(this);
      this.R = new TabDragAnimationView.ScaleAnimUpdateListener(this);
      this.s = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).isNowThemeIsAnimate();
      if ((Build.MODEL.contains("vivo")) || (Build.MANUFACTURER.contains("vivo"))) {
        bool = true;
      }
      this.T = bool;
      this.ae = new GestureDetector(paramContext, new TabDragAnimationView.1(this), this.ad);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  public static int a(Resources paramResources)
  {
    if (paramResources == null)
    {
      QLog.e("TabDragAnimationView", 1, "getTabTextViewColor called error: resources == null");
      return Color.parseColor("#000000");
    }
    String str = QQTheme.getCurrentThemeId();
    if (!g()) {
      return paramResources.getColor(2131167993);
    }
    if (TextUtils.isEmpty(str)) {
      return paramResources.getColor(2131168196);
    }
    if (q == null)
    {
      q = new HashMap();
      q.put("2971", "#0099FF");
      q.put("2921", "#0099FF");
      q.put("3491", "#19497D");
      q.put("3063", "#12D6BC");
      q.put("3064", "#FFE454");
      q.put("3066", "#FF779A");
      q.put("3065", "#6532D7");
      q.put("3067", "#FF6772");
      q.put("2920", "#0066CC");
    }
    str = (String)q.get(str);
    if (!TextUtils.isEmpty(str)) {
      return Color.parseColor(str);
    }
    return paramResources.getColor(2131168196);
  }
  
  private String a(int paramInt)
  {
    Object localObject1 = QQTheme.getCurrentThemeId();
    this.ai = new HashMap();
    if ((C) && (paramInt != 18))
    {
      this.ai.put("2971", "black");
      this.ai.put("3491", "black");
      this.ai.put("3063", "black");
      this.ai.put("3064", "black");
      this.ai.put("3066", "black");
      this.ai.put("3065", "black");
      this.ai.put("3067", "black");
      this.ai.put("2921", "black");
      this.ai.put("2920", "black");
    }
    else
    {
      if ((C) && (paramInt == 18)) {
        this.ai.put("2971", "black");
      } else {
        this.ai.put("2971", "white");
      }
      this.ai.put("3491", "blue");
      this.ai.put("3063", "green");
      this.ai.put("3064", "yellow");
      this.ai.put("3066", "pink");
      this.ai.put("3065", "purple");
      this.ai.put("3067", "red");
      this.ai.put("2921", "gray");
      this.ai.put("2920", "black");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = (String)this.ai.get(localObject1);
    } else {
      localObject1 = "white";
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "white";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("tablottie");
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append((String)localObject2);
    String str2 = ((StringBuilder)localObject1).toString();
    String str1;
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    case 13: 
    case 15: 
    default: 
      return null;
    case 18: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("flashshow_newui.json");
      str1 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (!new File(str1).exists())
      {
        localObject1 = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tab");
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".zip");
        a((Context)localObject1, localStringBuilder.toString(), str2, true);
        return str1;
      }
      break;
    case 17: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("qcircle_newui.json");
      str1 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (!new File(str1).exists())
      {
        localObject1 = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tab");
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".zip");
        a((Context)localObject1, localStringBuilder.toString(), str2, true);
        return str1;
      }
      break;
    case 16: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("kandian_newui.json");
      str1 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (!new File(str1).exists())
      {
        localObject1 = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tab");
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".zip");
        a((Context)localObject1, localStringBuilder.toString(), str2, true);
        return str1;
      }
      break;
    case 14: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("leba_newui.json");
      str1 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (!new File(str1).exists())
      {
        localObject1 = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tab");
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".zip");
        a((Context)localObject1, localStringBuilder.toString(), str2, true);
        return str1;
      }
      break;
    case 12: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("contact_newui.json");
      str1 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (!new File(str1).exists())
      {
        localObject1 = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tab");
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".zip");
        a((Context)localObject1, localStringBuilder.toString(), str2, true);
        return str1;
      }
      break;
    case 11: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("conversation_newui.json");
      str1 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (!new File(str1).exists())
      {
        localObject1 = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tab");
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".zip");
        a((Context)localObject1, localStringBuilder.toString(), str2, true);
        localObject1 = str1;
      }
      break;
    }
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    int i2 = this.G;
    paramInt1 = i1;
    if (i1 > i2) {
      paramInt1 = i2;
    }
    this.d = paramInt1;
    paramInt1 = this.H;
    if (paramInt2 <= paramInt1) {
      paramInt1 = paramInt2;
    }
    this.e = paramInt1;
    paramInt1 = this.I;
    if (paramInt1 == -1) {
      paramInt1 = this.d / 10;
    }
    paramInt2 = this.I;
    if (paramInt2 == -1) {
      paramInt2 = this.e / 10;
    }
    this.K = ((int)Math.sqrt(Math.pow(paramInt1, 2.0D) + Math.pow(paramInt2, 2.0D)));
    this.J = ((int)Math.sqrt(Math.pow(this.d / 2 + paramInt1, 2.0D) + Math.pow(this.e / 2 + paramInt2, 2.0D)));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString1.substring(paramString1.lastIndexOf(File.separator));
    paramContext = paramContext.getAssets();
    try
    {
      FileUtils.delete(paramString2, false);
      File localFile = new File(paramString2);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramContext = paramContext.open(paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(File.separator);
      paramString1.append(str);
      paramString1 = paramString1.toString();
      a(paramString1, paramContext);
      if (paramBoolean)
      {
        paramContext = new File(paramString1);
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append(File.separator);
        ZipUtils.unZipFile(paramContext, paramString1.toString());
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("copyFilesFromAssets called error: ");
      paramString1.append(paramContext);
      QLog.e("TabDragAnimationView", 1, paramString1.toString());
      return;
    }
    catch (IOException paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("copyFilesFromAssets called error: ");
      paramString1.append(paramContext);
      QLog.e("TabDragAnimationView", 1, paramString1.toString());
    }
  }
  
  /* Error */
  public static void a(String paramString, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 437	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 450	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore_3
    //   21: aload 6
    //   23: astore_0
    //   24: aload 7
    //   26: invokevirtual 546	java/io/File:delete	()Z
    //   29: pop
    //   30: aload 6
    //   32: astore_0
    //   33: aload 7
    //   35: invokevirtual 453	java/io/File:exists	()Z
    //   38: ifne +71 -> 109
    //   41: aload 6
    //   43: astore_0
    //   44: new 548	java/io/FileOutputStream
    //   47: dup
    //   48: aload 7
    //   50: invokespecial 551	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: astore_3
    //   54: aload_1
    //   55: invokevirtual 556	java/io/InputStream:available	()I
    //   58: newarray byte
    //   60: astore_0
    //   61: aload_1
    //   62: aload_0
    //   63: invokevirtual 560	java/io/InputStream:read	([B)I
    //   66: istore_2
    //   67: iload_2
    //   68: iconst_m1
    //   69: if_icmpeq +13 -> 82
    //   72: aload_3
    //   73: aload_0
    //   74: iconst_0
    //   75: iload_2
    //   76: invokevirtual 564	java/io/FileOutputStream:write	([BII)V
    //   79: goto -18 -> 61
    //   82: aload_3
    //   83: invokevirtual 567	java/io/FileOutputStream:flush	()V
    //   86: goto +23 -> 109
    //   89: astore 4
    //   91: aload_3
    //   92: astore_0
    //   93: aload 4
    //   95: astore_3
    //   96: goto +343 -> 439
    //   99: astore 4
    //   101: goto +108 -> 209
    //   104: astore 4
    //   106: goto +220 -> 326
    //   109: aload_3
    //   110: ifnull +44 -> 154
    //   113: aload_3
    //   114: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   117: goto +37 -> 154
    //   120: astore_0
    //   121: new 113	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   128: astore_3
    //   129: aload_3
    //   130: ldc_w 572
    //   133: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_3
    //   138: aload_0
    //   139: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc_w 321
    //   146: iconst_1
    //   147: aload_3
    //   148: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_1
    //   155: ifnull +283 -> 438
    //   158: aload_1
    //   159: invokevirtual 573	java/io/InputStream:close	()V
    //   162: return
    //   163: astore_1
    //   164: new 113	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   171: astore_0
    //   172: aload_0
    //   173: ldc_w 572
    //   176: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc_w 321
    //   189: iconst_1
    //   190: aload_0
    //   191: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: return
    //   198: astore_3
    //   199: goto +240 -> 439
    //   202: astore_0
    //   203: aload 4
    //   205: astore_3
    //   206: aload_0
    //   207: astore 4
    //   209: aload_3
    //   210: astore_0
    //   211: new 113	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   218: astore 5
    //   220: aload_3
    //   221: astore_0
    //   222: aload 5
    //   224: ldc_w 572
    //   227: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_3
    //   232: astore_0
    //   233: aload 5
    //   235: aload 4
    //   237: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_3
    //   242: astore_0
    //   243: ldc_w 321
    //   246: iconst_1
    //   247: aload 5
    //   249: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_3
    //   256: ifnull +44 -> 300
    //   259: aload_3
    //   260: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   263: goto +37 -> 300
    //   266: astore_0
    //   267: new 113	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   274: astore_3
    //   275: aload_3
    //   276: ldc_w 572
    //   279: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_3
    //   284: aload_0
    //   285: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: ldc_w 321
    //   292: iconst_1
    //   293: aload_3
    //   294: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_1
    //   301: ifnull +137 -> 438
    //   304: aload_1
    //   305: invokevirtual 573	java/io/InputStream:close	()V
    //   308: return
    //   309: astore_1
    //   310: new 113	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   317: astore_0
    //   318: goto -146 -> 172
    //   321: astore 4
    //   323: aload 5
    //   325: astore_3
    //   326: aload_3
    //   327: astore_0
    //   328: new 113	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   335: astore 5
    //   337: aload_3
    //   338: astore_0
    //   339: aload 5
    //   341: ldc_w 572
    //   344: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_3
    //   349: astore_0
    //   350: aload 5
    //   352: aload 4
    //   354: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_3
    //   359: astore_0
    //   360: ldc_w 321
    //   363: iconst_1
    //   364: aload 5
    //   366: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload_3
    //   373: ifnull +44 -> 417
    //   376: aload_3
    //   377: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   380: goto +37 -> 417
    //   383: astore_0
    //   384: new 113	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   391: astore_3
    //   392: aload_3
    //   393: ldc_w 572
    //   396: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_3
    //   401: aload_0
    //   402: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc_w 321
    //   409: iconst_1
    //   410: aload_3
    //   411: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_1
    //   418: ifnull +20 -> 438
    //   421: aload_1
    //   422: invokevirtual 573	java/io/InputStream:close	()V
    //   425: return
    //   426: astore_1
    //   427: new 113	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   434: astore_0
    //   435: goto -263 -> 172
    //   438: return
    //   439: aload_0
    //   440: ifnull +48 -> 488
    //   443: aload_0
    //   444: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   447: goto +41 -> 488
    //   450: astore_0
    //   451: new 113	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   458: astore 4
    //   460: aload 4
    //   462: ldc_w 572
    //   465: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 4
    //   471: aload_0
    //   472: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: ldc_w 321
    //   479: iconst_1
    //   480: aload 4
    //   482: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload_1
    //   489: ifnull +44 -> 533
    //   492: aload_1
    //   493: invokevirtual 573	java/io/InputStream:close	()V
    //   496: goto +37 -> 533
    //   499: astore_0
    //   500: new 113	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   507: astore_1
    //   508: aload_1
    //   509: ldc_w 572
    //   512: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_1
    //   517: aload_0
    //   518: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: ldc_w 321
    //   525: iconst_1
    //   526: aload_1
    //   527: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: goto +5 -> 538
    //   536: aload_3
    //   537: athrow
    //   538: goto -2 -> 536
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	paramString	String
    //   0	541	1	paramInputStream	java.io.InputStream
    //   66	10	2	i1	int
    //   20	128	3	localObject1	Object
    //   198	1	3	localObject2	Object
    //   205	332	3	localObject3	Object
    //   14	1	4	localObject4	Object
    //   89	5	4	localObject5	Object
    //   99	1	4	localIOException	IOException
    //   104	100	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   207	29	4	str	String
    //   321	32	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   458	23	4	localStringBuilder1	StringBuilder
    //   17	348	5	localStringBuilder2	StringBuilder
    //   11	31	6	localObject6	Object
    //   8	41	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   54	61	89	finally
    //   61	67	89	finally
    //   72	79	89	finally
    //   82	86	89	finally
    //   54	61	99	java/io/IOException
    //   61	67	99	java/io/IOException
    //   72	79	99	java/io/IOException
    //   82	86	99	java/io/IOException
    //   54	61	104	java/io/FileNotFoundException
    //   61	67	104	java/io/FileNotFoundException
    //   72	79	104	java/io/FileNotFoundException
    //   82	86	104	java/io/FileNotFoundException
    //   113	117	120	java/io/IOException
    //   158	162	163	java/io/IOException
    //   24	30	198	finally
    //   33	41	198	finally
    //   44	54	198	finally
    //   211	220	198	finally
    //   222	231	198	finally
    //   233	241	198	finally
    //   243	255	198	finally
    //   328	337	198	finally
    //   339	348	198	finally
    //   350	358	198	finally
    //   360	372	198	finally
    //   24	30	202	java/io/IOException
    //   33	41	202	java/io/IOException
    //   44	54	202	java/io/IOException
    //   259	263	266	java/io/IOException
    //   304	308	309	java/io/IOException
    //   24	30	321	java/io/FileNotFoundException
    //   33	41	321	java/io/FileNotFoundException
    //   44	54	321	java/io/FileNotFoundException
    //   376	380	383	java/io/IOException
    //   421	425	426	java/io/IOException
    //   443	447	450	java/io/IOException
    //   492	496	499	java/io/IOException
  }
  
  private boolean a()
  {
    return this.z != null;
  }
  
  public static int b(Resources paramResources)
  {
    if (paramResources == null)
    {
      QLog.e("TabDragAnimationView", 1, "getTabTextViewUnselectedColor called error: resources == null");
      return Color.parseColor("#000000");
    }
    String str = QQTheme.getCurrentThemeId();
    if (!g()) {
      return paramResources.getColor(2131168118);
    }
    if (TextUtils.isEmpty(str)) {
      return paramResources.getColor(2131168195);
    }
    if (C) {
      return paramResources.getColor(2131168118);
    }
    if ("2920".equals(str)) {
      return Color.parseColor("#999999");
    }
    return paramResources.getColor(2131168195);
  }
  
  public static boolean g()
  {
    return (QQTheme.isNowSimpleUI()) && (!D) && (!E);
  }
  
  public static boolean h()
  {
    return false;
  }
  
  private boolean j()
  {
    String str = QQTheme.getCurrentThemeId();
    if ((!TextUtils.isEmpty(this.F)) && ((TextUtils.isEmpty(str)) || (str.equals(this.F)))) {
      return false;
    }
    this.F = str;
    return true;
  }
  
  private LottieDrawable k()
  {
    try
    {
      LottieComposition localLottieComposition = LottieComposition.Factory.fromInputStreamSync(new BufferedInputStream(new FileInputStream(a(this.o))));
      localObject = new LottieDrawable();
      ((LottieDrawable)localObject).setComposition(localLottieComposition);
      ((LottieDrawable)localObject).loop(false);
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateLottieDrawable() called error: ");
      localStringBuilder.append(localException);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public static void setIsKDImmersiveMode(boolean paramBoolean)
  {
    E = paramBoolean;
  }
  
  public static void setIsQCircleLayerMode(boolean paramBoolean)
  {
    D = paramBoolean;
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.l)
    {
      this.k = true;
      this.j = 8;
      this.h = paramFloat1;
      this.i = paramFloat2;
      this.N = paramBoolean;
      invalidate();
    }
  }
  
  /* Error */
  public void a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 548	java/io/FileOutputStream
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 637	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_1
    //   15: getstatic 643	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   18: bipush 90
    //   20: aload_2
    //   21: invokevirtual 649	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   24: pop
    //   25: aload_2
    //   26: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   29: return
    //   30: astore_1
    //   31: aload_2
    //   32: astore_3
    //   33: goto +40 -> 73
    //   36: astore_3
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: astore_2
    //   41: goto +11 -> 52
    //   44: astore_1
    //   45: goto +28 -> 73
    //   48: astore_2
    //   49: aload 4
    //   51: astore_1
    //   52: aload_1
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 652	java/lang/Exception:printStackTrace	()V
    //   58: aload_1
    //   59: ifnull +13 -> 72
    //   62: aload_1
    //   63: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   66: return
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 653	java/io/IOException:printStackTrace	()V
    //   72: return
    //   73: aload_3
    //   74: ifnull +15 -> 89
    //   77: aload_3
    //   78: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   81: goto +8 -> 89
    //   84: astore_2
    //   85: aload_2
    //   86: invokevirtual 653	java/io/IOException:printStackTrace	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	TabDragAnimationView
    //   0	91	1	paramBitmap	Bitmap
    //   0	91	2	paramString	String
    //   4	29	3	str	String
    //   36	4	3	localException	Exception
    //   53	25	3	localBitmap	Bitmap
    //   1	49	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	25	30	finally
    //   14	25	36	java/lang/Exception
    //   5	14	44	finally
    //   54	58	44	finally
    //   5	14	48	java/lang/Exception
    //   25	29	67	java/io/IOException
    //   62	66	67	java/io/IOException
    //   77	81	84	java/io/IOException
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.t);
    localStringBuilder.append(paramString);
    this.t = localStringBuilder.toString();
  }
  
  public void b()
  {
    if (this.l)
    {
      this.P.a();
      f();
      this.m.start();
      return;
    }
    c();
  }
  
  public void c()
  {
    this.h = 0.0F;
    this.i = 0.0F;
    this.k = false;
    invalidate();
  }
  
  void d()
  {
    ValueAnimator localValueAnimator = this.n;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.n.removeUpdateListener(this.R);
    }
    this.j = 1;
    this.n = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    this.n.setDuration(200L);
    this.n.setInterpolator(new LinearInterpolator());
    this.n.addUpdateListener(this.R);
    this.n.start();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.W)
    {
      if (this.aa == null) {
        this.aa = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      }
      this.aa.eraseColor(-1);
      this.Z.setBitmap(this.aa);
      super.draw(this.Z);
      paramCanvas = new StringBuilder();
      paramCanvas.append(Environment.getExternalStorageDirectory());
      paramCanvas.append("/aaaa/");
      paramCanvas = paramCanvas.toString();
      new File(paramCanvas).mkdirs();
      Bitmap localBitmap = this.aa;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCanvas);
      int i1 = this.ab;
      this.ab = (i1 + 1);
      localStringBuilder.append(i1);
      localStringBuilder.append(".png");
      a(localBitmap, localStringBuilder.toString());
    }
  }
  
  void e()
  {
    ValueAnimator localValueAnimator = this.n;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.n.removeUpdateListener(this.R);
      this.R.a();
      this.n = null;
    }
  }
  
  void f()
  {
    ValueAnimator localValueAnimator = this.m;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.m.removeUpdateListener(this.P);
    }
    this.m = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.m.setDuration(300L);
    this.m.setInterpolator(new DecelerateInterpolator());
    this.m.addUpdateListener(this.P);
  }
  
  Drawable getBgDrawable()
  {
    Object localObject;
    if ((g()) && (h()))
    {
      if (C)
      {
        if ((this.B != null) && (!j())) {
          return this.B;
        }
        this.B = k();
        localObject = this.B;
        if (localObject != null)
        {
          ((LottieDrawable)localObject).setCallback(this);
          return this.B;
        }
      }
      else
      {
        if ((this.A != null) && (!j())) {
          return this.A;
        }
        if ((this.o == 18) && (!j())) {
          this.B = null;
        }
        this.A = k();
        localObject = this.A;
        if (localObject != null)
        {
          ((LottieDrawable)localObject).setCallback(this);
          return this.A;
        }
      }
    }
    else if (g())
    {
      if (this.aj == null)
      {
        this.aj = new HashMap();
        this.aj.put(Integer.valueOf(11), Integer.valueOf(2130852559));
        this.aj.put(Integer.valueOf(12), Integer.valueOf(2130852555));
        this.aj.put(Integer.valueOf(14), Integer.valueOf(2130852571));
        this.aj.put(Integer.valueOf(17), Integer.valueOf(2130852579));
        this.aj.put(Integer.valueOf(16), Integer.valueOf(2130852575));
        this.aj.put(Integer.valueOf(19), Integer.valueOf(2130852564));
      }
      localObject = getResources().getDrawable(((Integer)this.aj.get(Integer.valueOf(this.o))).intValue());
      if (localObject != null) {
        return localObject;
      }
    }
    else if (i())
    {
      if ((this.A != null) && (!j())) {
        return this.A;
      }
      if ((this.o == 18) && (!j())) {
        this.B = null;
      }
      this.A = k();
      localObject = this.A;
      if (localObject != null)
      {
        ((LottieDrawable)localObject).setCallback(this);
        return this.A;
      }
    }
    return this.v;
  }
  
  Drawable getBgPressedDrawable()
  {
    if (this.s)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.t, 2, "getBgPressedDrawable() called ");
      }
      localObject1 = this.r;
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).getAnimatePathByTag(this.o);
      Drawable localDrawable = this.x;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_width", this.d);
      localBundle.putInt("key_height", this.e);
      localBundle.putInt("key_loop", 1);
      int i1 = this.p;
      IVasApngUtilApi localIVasApngUtilApi = (IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class);
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("- tab-");
      ((StringBuilder)localObject2).append(this.o);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("- tab-");
      ((StringBuilder)localObject3).append(this.o);
      localObject3 = ((StringBuilder)localObject3).toString();
      this.r = localIVasApngUtilApi.getApngDrawable(localAppRuntime, (String)localObject1, (String)localObject2, localDrawable, new int[] { i1 }, (String)localObject3, localBundle);
      localObject1 = this.r;
      if (localObject1 != null)
      {
        ((URLDrawable)localObject1).setCallback(this);
        return this.r;
      }
    }
    else if ((g()) && (h()))
    {
      if (C)
      {
        if ((this.B != null) && (!j())) {
          return this.B;
        }
        this.B = k();
        localObject1 = this.B;
        if (localObject1 != null)
        {
          ((LottieDrawable)localObject1).setCallback(this);
          return this.B;
        }
      }
      else
      {
        if ((this.A != null) && (!j())) {
          return this.A;
        }
        this.A = k();
        localObject1 = this.A;
        if (localObject1 != null)
        {
          ((LottieDrawable)localObject1).setCallback(this);
          return this.A;
        }
      }
    }
    else if (g())
    {
      if (this.ak == null)
      {
        this.ak = new HashMap();
        this.ak.put(Integer.valueOf(11), Integer.valueOf(2130852561));
        this.ak.put(Integer.valueOf(12), Integer.valueOf(2130852557));
        this.ak.put(Integer.valueOf(14), Integer.valueOf(2130852573));
        this.ak.put(Integer.valueOf(17), Integer.valueOf(2130852581));
        this.ak.put(Integer.valueOf(16), Integer.valueOf(2130852577));
        this.ak.put(Integer.valueOf(19), Integer.valueOf(2130852567));
      }
      localObject1 = getResources().getDrawable(((Integer)this.ak.get(Integer.valueOf(this.o))).intValue());
      if (localObject1 != null) {
        return localObject1;
      }
    }
    else if (i())
    {
      if ((this.A != null) && (!j())) {
        return this.A;
      }
      this.A = k();
      localObject1 = this.A;
      if (localObject1 != null)
      {
        ((LottieDrawable)localObject1).setCallback(this);
        return this.A;
      }
    }
    Object localObject1 = this.r;
    if (localObject1 != null)
    {
      ((URLDrawable)localObject1).setCallback(null);
      this.r = null;
    }
    return this.x;
  }
  
  public Drawable getClickAnimationDrawable()
  {
    return this.z;
  }
  
  public Rect getLastDrawDgBounds()
  {
    return this.V;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i4 = getPaddingLeft();
    int i2 = getRight() - getLeft() - getPaddingRight();
    int i1 = getPaddingTop();
    int i3 = getBottom() - getTop() - getPaddingBottom();
    int i5 = this.c;
    int i6;
    int i7;
    label292:
    int i8;
    if (i5 != 1)
    {
      if (i5 != 2)
      {
        if (i5 != 3) {
          if (i5 != 4)
          {
            i5 = (i4 + i2) / 2;
            i2 = (i1 + i3) / 2;
            i1 = this.d;
            i4 = i1 / 2;
            i6 = i1 / 2 + i5;
            i3 = this.e;
            i1 = i3 / 2;
            i3 = i3 / 2 + i2;
            i1 = i2 - i1;
            i4 = i5 - i4;
          }
        }
        for (;;)
        {
          i7 = i1;
          i1 = i6;
          i6 = i2;
          i2 = i7;
          break;
          i4 = this.d;
          i5 = i2 - i4 / 2;
          i1 = (i1 + i3) / 2;
          i4 = i2 - i4 / 2;
          i3 = this.e;
          i7 = i1 - i3 / 2;
          i6 = i3 / 2;
          i3 = i5;
          i5 = i7;
          break label292;
          i5 = this.d;
          i2 = i5 / 2 + i4;
          i1 = (i1 + i3) / 2;
          i7 = i5 + i4;
          i3 = this.e;
          i5 = i1 - i3 / 2;
          i6 = i3 / 2;
          i3 = i2;
          i2 = i7;
          i7 = i5;
          i8 = i6 + i1;
          i5 = i3;
          i6 = i2;
          i2 = i1;
          i3 = i8;
          i1 = i7;
        }
      }
      i5 = (i4 + i2) / 2;
      i1 = this.e;
      i6 = i3 - i1 / 2;
      i2 = this.d;
      i4 = i5 - i2 / 2;
      i7 = i2 / 2;
      i2 = i3 - i1;
      i1 = i7 + i5;
    }
    else
    {
      i5 = (i4 + i2) / 2;
      i2 = this.e;
      i6 = i2 / 2;
      i3 = this.d;
      i4 = i5 - i3 / 2;
      i7 = i3 / 2;
      i3 = i2 + i1;
      i7 += i5;
      i2 = i1;
      i6 += i1;
      i1 = i7;
    }
    this.U.setStyle(Paint.Style.STROKE);
    this.U.setStrokeWidth(1.0F);
    Drawable localDrawable2;
    Drawable localDrawable1;
    Drawable localDrawable3;
    if ((this.j == 1) && (!this.k))
    {
      if (((this.R.a) || (!this.R.b)) && (this.M)) {
        localDrawable2 = this.y;
      } else {
        localDrawable2 = this.w;
      }
      if (((this.R.a) || (!this.R.b)) && (this.M)) {
        localDrawable1 = getBgPressedDrawable();
      } else {
        localDrawable1 = getBgDrawable();
      }
      if (this.R.c != 1.0F) {
        paramCanvas.scale(this.R.c, this.R.c, i5, i6);
      }
      if (localDrawable1 != null)
      {
        if (((g()) && (h())) || ((!g()) && (i()) && ((localDrawable1 == this.A) || (localDrawable1 == this.B))))
        {
          paramCanvas.save();
          paramCanvas.translate(i4, i2);
          localDrawable1.setBounds(i4, i2, i1, i3);
          if (!a()) {
            localDrawable1.draw(paramCanvas);
          }
          paramCanvas.restore();
        }
        else
        {
          localDrawable1.setBounds(i4, i2, i1, i3);
          if (!a()) {
            localDrawable1.draw(paramCanvas);
          }
        }
        this.U.setColor(-65536);
        this.V.set(localDrawable1.getBounds());
      }
      if ((localDrawable2 != null) && (this.l))
      {
        localDrawable2.setBounds(i4, i2, i1, i3);
        if (!a()) {
          localDrawable2.draw(paramCanvas);
        }
        this.U.setColor(-16776961);
      }
      localDrawable3 = localDrawable1;
    }
    else
    {
      if (this.M) {
        localDrawable2 = this.y;
      } else {
        localDrawable2 = this.w;
      }
      if (this.M) {
        localDrawable1 = getBgPressedDrawable();
      } else {
        localDrawable1 = getBgDrawable();
      }
      if ((int)Math.sqrt(Math.pow(this.d / 2 + Math.abs(this.h), 2.0D) + Math.pow(this.e / 2 + Math.abs(this.i), 2.0D)) > this.J)
      {
        float f1 = this.h;
        double d3 = 0.0D;
        double d1;
        if (f1 != 0.0F)
        {
          f1 = this.i;
          if (f1 != 0.0F)
          {
            d1 = Math.pow(f1, 2.0D) / Math.pow(this.h, 2.0D);
            d2 = this.K;
            d3 = d1 + 1.0D;
            double d4 = 1.0D / Math.sqrt(d3);
            Double.isNaN(d2);
            d2 *= d4;
            d4 = this.K;
            d1 = Math.sqrt(d1 / d3);
            Double.isNaN(d4);
            d1 *= d4;
            break label1047;
          }
        }
        if (this.h != 0.0F)
        {
          d2 = this.K;
          d1 = d3;
          label1047:
          d3 = d2;
        }
        else if (this.i != 0.0F)
        {
          d1 = this.K;
        }
        else
        {
          d1 = 0.0D;
        }
        if (this.h > 0.0F) {
          i5 = 1;
        } else {
          i5 = -1;
        }
        double d2 = i5;
        Double.isNaN(d2);
        i8 = (int)(d3 * d2);
        if (this.i > 0.0F) {
          i5 = 1;
        } else {
          i5 = -1;
        }
        d2 = i5;
        Double.isNaN(d2);
        i5 = (int)(d1 * d2);
      }
      else
      {
        i8 = (int)this.h;
        i5 = (int)this.i;
      }
      int i9 = i8 * 2;
      int i10 = i5 * 2;
      if (localDrawable1 != null)
      {
        if (this.N) {
          i6 = i4;
        } else {
          i6 = i4 - i8;
        }
        if (this.N) {
          i7 = i2;
        } else {
          i7 = i2 - i5;
        }
        if (this.N) {
          i8 = i1;
        } else {
          i8 = i1 - i8;
        }
        if (this.N) {
          i5 = i3;
        } else {
          i5 = i3 - i5;
        }
        localDrawable1.setBounds(i6, i7, i8, i5);
        if (!a()) {
          localDrawable1.draw(paramCanvas);
        }
        this.U.setColor(-65536);
        this.V.set(localDrawable1.getBounds());
      }
      localDrawable3 = localDrawable1;
      if (localDrawable2 != null)
      {
        localDrawable3 = localDrawable1;
        if (this.l)
        {
          paramCanvas.save();
          localDrawable2.setBounds(i4 - i9, i2 - i10, i1 - i9, i3 - i10);
          if (!a())
          {
            boolean bool = this.M;
            localDrawable2.draw(paramCanvas);
          }
          this.U.setColor(-16776961);
          paramCanvas.restore();
          localDrawable3 = localDrawable1;
        }
      }
    }
    if ((a()) && (localDrawable3 != null))
    {
      this.z.setBounds(localDrawable3.getBounds());
      this.z.draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    int i6 = this.G;
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = this.H;
    paramInt1 = resolveSizeAndState(i4 + i5 + i6, paramInt1, 0);
    paramInt2 = resolveSizeAndState(i1 + i2 + i3, paramInt2, 0);
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    a(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.af != null) {
      this.ae.onTouchEvent(paramMotionEvent);
    }
    Object localObject = this.z;
    if ((localObject != null) && ((localObject instanceof Animatable)) && (!((Animatable)localObject).isRunning())) {
      setClickAnimationDrawable(null);
    }
    int i1 = getPaddingLeft();
    int i6 = getRight();
    int i7 = getLeft();
    int i8 = getPaddingRight();
    int i2 = getPaddingTop();
    int i3 = getBottom();
    int i4 = getTop();
    int i5 = getPaddingBottom();
    i1 = (i1 + (i6 - i7 - i8)) / 2;
    i6 = (i2 + (i3 - i4 - i5)) / 2;
    double d1 = this.d;
    Double.isNaN(d1);
    d1 = Math.pow(d1 / 2.0D, 2.0D);
    double d2 = this.e;
    Double.isNaN(d2);
    i2 = (int)Math.sqrt(d1 + Math.pow(d2 / 2.0D, 2.0D));
    i3 = getWidth();
    i4 = getHeight();
    i5 = paramMotionEvent.getActionMasked();
    if (i5 != 0)
    {
      float f2 = 0.0F;
      if (i5 != 1) {
        if (i5 != 2)
        {
          if (i5 != 3) {
            return false;
          }
          if (this.T)
          {
            i7 = (int)(DeviceInfoUtil.E() - ViewUtils.dip2px(14.0F));
            if (this.S > i7)
            {
              this.f = 0.0F;
              this.g = 0.0F;
              this.S = 0.0F;
              this.L = -1;
              this.O = false;
              if (this.k) {
                b();
              }
              return false;
            }
          }
        }
        else
        {
          if (this.l)
          {
            i2 = paramMotionEvent.findPointerIndex(this.L);
            if (i2 == -1)
            {
              this.O = false;
              return false;
            }
            f3 = paramMotionEvent.getX(i2);
            f1 = paramMotionEvent.getY(i2);
            if (((int)Math.sqrt(Math.pow(f3 - i1, 2.0D) + Math.pow(f1 - i6, 2.0D)) <= this.J) && ((f3 != this.f) || (f1 != this.g)))
            {
              f2 = this.f - f3;
              f1 = this.g - f1;
              this.O = true;
            }
            else if (this.O)
            {
              f2 = this.f - f3;
              f1 = this.g - f1;
            }
            else
            {
              f1 = 0.0F;
            }
            if (this.O)
            {
              e();
              a(f2, f1, false);
            }
            return this.O;
          }
          return false;
        }
      }
      this.L = -1;
      this.O = false;
      if (this.k) {
        b();
      }
      f2 = this.f;
      float f1 = i1;
      d1 = Math.pow(f2 - f1, 2.0D);
      f2 = this.g;
      float f4 = i6;
      i6 = (int)Math.sqrt(d1 + Math.pow(f2 - f4, 2.0D)) + u;
      f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      i7 = (int)Math.sqrt(Math.pow(f2 - f1, 2.0D) + Math.pow(f3 - f4, 2.0D));
      if (((i6 >= i2) || (i7 <= i2)) && (f2 > 0.0F) && (f2 < i3) && (f3 > 0.0F) && (f3 < i4)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        localObject = this.ag;
        if (localObject != null) {
          ((TabDragAnimationView.OnDragListener)localObject).a();
        }
      }
      if ((this.af == null) && (getParent() != null) && (i1 != 0))
      {
        ((ViewGroup)getParent()).performClick();
        if (QLog.isColorLevel())
        {
          f1 = paramMotionEvent.getRawX();
          f4 = paramMotionEvent.getRawY();
          paramMotionEvent = this.t;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("TabDragView perform click, action=");
          ((StringBuilder)localObject).append(i5);
          ((StringBuilder)localObject).append(", ux=");
          ((StringBuilder)localObject).append(f2);
          ((StringBuilder)localObject).append(", uy=");
          ((StringBuilder)localObject).append(f3);
          ((StringBuilder)localObject).append(", urx=");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(", ury=");
          ((StringBuilder)localObject).append(f4);
          ((StringBuilder)localObject).append(", w=");
          ((StringBuilder)localObject).append(i3);
          ((StringBuilder)localObject).append(", vh=");
          ((StringBuilder)localObject).append(i4);
          ((StringBuilder)localObject).append(", radius=");
          ((StringBuilder)localObject).append(i6);
          ((StringBuilder)localObject).append(", innerRadius=");
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append(", upRidus=");
          ((StringBuilder)localObject).append(i7);
          QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        }
      }
      return true;
    }
    this.f = paramMotionEvent.getX();
    this.g = paramMotionEvent.getY();
    this.S = paramMotionEvent.getRawY();
    this.L = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
    if ((int)Math.sqrt(Math.pow(this.f - i1, 2.0D) + Math.pow(this.g - i6, 2.0D)) <= i2) {
      if (this.M) {
        c();
      } else if (this.ac) {
        d();
      }
    }
    return true;
  }
  
  public void setAnimEnable(boolean paramBoolean)
  {
    this.l = paramBoolean;
    invalidate();
  }
  
  public void setBgDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBgDrawable() called with: bgId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1)
    {
      this.v = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setBgPressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBgPressedDrawable() called with: bgPressId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1)
    {
      this.x = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setClickAnimationDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setClickAnimationDrawable() called with: drawable = [");
      localStringBuilder.append(paramDrawable);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.z;
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    this.z = paramDrawable;
    paramDrawable = this.z;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    invalidate();
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  public void setEmotionDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Resources localResources = getResources();
    this.o = paramInt5;
    this.p = paramInt6;
    if (paramInt1 != -1) {
      this.w = localResources.getDrawable(paramInt1);
    }
    if (paramInt2 != -1) {
      this.v = localResources.getDrawable(paramInt2);
    }
    if (paramInt3 != -1) {
      this.y = localResources.getDrawable(paramInt3);
    }
    if (paramInt4 != -1) {
      this.x = localResources.getDrawable(paramInt4);
    }
  }
  
  public void setEmotionDrawable(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    this.w = paramDrawable1;
    this.v = paramDrawable2;
    this.y = paramDrawable3;
    this.x = paramDrawable4;
  }
  
  public void setEnableClickScaleAnimation(boolean paramBoolean)
  {
    this.ac = paramBoolean;
  }
  
  public void setExpectedLogoMoveDistance(int paramInt)
  {
    this.I = paramInt;
    if (paramInt != -1) {
      this.K = ((int)Math.sqrt(Math.pow(this.I, 2.0D) * 2.0D));
    }
  }
  
  public void setFaceDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFaceDrawable() called with: faceId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1) {
      this.w = getResources().getDrawable(paramInt);
    } else {
      this.w = null;
    }
    invalidate();
  }
  
  public void setFacePressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFacePressedDrawable() called with: facePressId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1) {
      this.y = getResources().getDrawable(paramInt);
    } else {
      this.y = null;
    }
    invalidate();
  }
  
  public void setIconGravity(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3) && (paramInt != 4) && (paramInt != 1) && (paramInt != 2))
    {
      if (QLog.isColorLevel())
      {
        String str = this.t;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unsupported gravity=");
        localStringBuilder.append(paramInt);
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.c = paramInt;
      invalidate();
    }
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (((this.R.a) || (!this.R.b)) && (this.M)) {
      localObject = this.x;
    } else {
      localObject = this.v;
    }
    if (paramInt2 >= 0) {
      this.H = paramInt2;
    } else if (localObject != null) {
      this.H = Math.min(b, Math.max(((Drawable)localObject).getIntrinsicHeight(), a));
    }
    if (paramInt1 >= 0) {
      this.G = paramInt1;
    } else if (localObject != null) {
      this.G = Math.min(b, Math.max(((Drawable)localObject).getIntrinsicWidth(), a));
    }
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIconSize, mExpectedLogoWidth=");
      localStringBuilder.append(this.G);
      localStringBuilder.append(", mExpectedLogoHeight=");
      localStringBuilder.append(this.H);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    requestLayout();
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.af = paramOnDoubleTapListener;
  }
  
  public void setOnDragListener(TabDragAnimationView.OnDragListener paramOnDragListener)
  {
    this.ag = paramOnDragListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    super.setOnLongClickListener(paramOnLongClickListener);
    this.ah = paramOnLongClickListener;
  }
  
  public void setPressChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPressChanged() called with: enable = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.M = paramBoolean;
    Object localObject = this.r;
    if ((localObject != null) && (localObject == getBgPressedDrawable()))
    {
      localObject = this.r.getCurrDrawable();
      if ((localObject instanceof ApngDrawable)) {
        ((ApngDrawable)localObject).repaly();
      }
    }
    if (C)
    {
      if ((g()) && (h())) {
        if (paramBoolean)
        {
          localObject = this.B;
          if (localObject != null)
          {
            ((LottieDrawable)localObject).playAnimation();
          }
          else
          {
            this.B = k();
            localObject = this.B;
            if (localObject != null)
            {
              ((LottieDrawable)localObject).setCallback(this);
              this.B.playAnimation();
            }
          }
        }
        else
        {
          localObject = this.B;
          if (localObject != null)
          {
            ((LottieDrawable)localObject).pauseAnimation();
            this.B.setProgress(0.0F);
          }
        }
      }
    }
    else if ((g()) && (h()))
    {
      if (paramBoolean)
      {
        localObject = this.A;
        if (localObject != null)
        {
          ((LottieDrawable)localObject).playAnimation();
        }
        else
        {
          this.A = k();
          localObject = this.A;
          if (localObject != null)
          {
            ((LottieDrawable)localObject).setCallback(this);
            this.A.playAnimation();
          }
        }
      }
      else
      {
        localObject = this.A;
        if (localObject != null)
        {
          ((LottieDrawable)localObject).pauseAnimation();
          this.A.setProgress(0.0F);
        }
      }
    }
    else if (i()) {
      if (paramBoolean)
      {
        localObject = this.A;
        if (localObject != null)
        {
          ((LottieDrawable)localObject).playAnimation();
        }
        else
        {
          this.A = k();
          localObject = this.A;
          if (localObject != null)
          {
            ((LottieDrawable)localObject).setCallback(this);
            this.A.playAnimation();
          }
        }
      }
      else
      {
        localObject = this.A;
        if (localObject != null)
        {
          ((LottieDrawable)localObject).pauseAnimation();
          this.A.setProgress(0.0F);
        }
      }
    }
    invalidate();
  }
  
  public void setShouldFixFlashShow(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.M = paramBoolean1;
    C = paramBoolean2;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */