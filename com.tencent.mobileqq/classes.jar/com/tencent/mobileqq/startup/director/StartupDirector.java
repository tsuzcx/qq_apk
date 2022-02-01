package com.tencent.mobileqq.startup.director;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.debug.DebugActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashControlManager;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class StartupDirector
  implements Handler.Callback
{
  private static final int[] A;
  private static final int[] B;
  private static final int[] C;
  private static final int[] D;
  private static final int[] E;
  private static long P = 0L;
  public static final int[] a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static int f;
  public static int h;
  public static long k;
  public static long l;
  public static int m = 0;
  private static final int[] o = { 1, 6, 9, 15 };
  private static final int[] p = { 5, 7 };
  private static final int[] q = { 11, 12, 18, 19 };
  private static final int[] r = { 13, 11, 12, 18 };
  private static final int[] s = { 7, 20 };
  private static final int[] t = { 13, 11, 18 };
  private static final int[] u = s;
  private static final int[] v = { 32, 5, 10 };
  private static final int[] w = { 14, 5, 11, 10 };
  private static final int[] x;
  private static final int[] y;
  private static final int[] z;
  private int F = -1;
  private ArrayList<WeakReference<AppActivity>> G;
  private Handler H;
  private Handler I;
  private long J = 0L;
  private CheckPermission K;
  private boolean L;
  private int M = 0;
  private int N;
  private long O;
  private int Q = -1;
  private ConcurrentHashMap<Integer, Long> R = new ConcurrentHashMap(8);
  public AppActivity e;
  public long g;
  public long i = 0L;
  public long j = 0L;
  StartupDirector.SplashCallBack n;
  
  static
  {
    a = new int[] { 14, 5, 11, 10 };
    x = new int[] { 14 };
    y = new int[] { 5, 10, 8, 21 };
    z = new int[] { 13, 5 };
    A = new int[] { 13, 5, 14, 12, 10 };
    B = new int[] { 13, 5, 14, 12, 22 };
    C = new int[] { 13, 5, 14, 12 };
    D = new int[] { 30, 33 };
    E = new int[] { 5, 14, 8, 12, 10 };
    b = false;
    c = false;
    d = false;
    f = 0;
    h = 0;
    k = -1L;
    l = -1L;
  }
  
  /* Error */
  private final int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 148	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 154	android/content/Context:getFilesDir	()Ljava/io/File;
    //   8: ldc 156
    //   10: invokespecial 159	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore 11
    //   15: aload 11
    //   17: invokevirtual 163	java/io/File:exists	()Z
    //   20: istore 6
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore 9
    //   28: aconst_null
    //   29: astore 8
    //   31: iconst_0
    //   32: istore 5
    //   34: iconst_0
    //   35: istore 4
    //   37: iconst_0
    //   38: istore_3
    //   39: iload 4
    //   41: istore_2
    //   42: iload 6
    //   44: ifeq +138 -> 182
    //   47: new 165	java/io/BufferedInputStream
    //   50: dup
    //   51: new 167	java/io/FileInputStream
    //   54: dup
    //   55: aload 11
    //   57: invokespecial 170	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 173	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore 7
    //   65: aload 7
    //   67: astore_1
    //   68: aload 7
    //   70: invokevirtual 177	java/io/BufferedInputStream:read	()I
    //   73: istore_2
    //   74: iload_2
    //   75: iconst_m1
    //   76: if_icmpne +8 -> 84
    //   79: iload_3
    //   80: istore_2
    //   81: goto +3 -> 84
    //   84: iload_2
    //   85: istore_3
    //   86: aload 7
    //   88: invokevirtual 180	java/io/BufferedInputStream:close	()V
    //   91: goto +91 -> 182
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   99: iload_3
    //   100: istore_2
    //   101: goto +81 -> 182
    //   104: astore 8
    //   106: goto +16 -> 122
    //   109: astore_1
    //   110: aload 8
    //   112: astore 7
    //   114: goto +46 -> 160
    //   117: astore 8
    //   119: aconst_null
    //   120: astore 7
    //   122: aload 7
    //   124: astore_1
    //   125: aload 8
    //   127: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   130: iload 4
    //   132: istore_2
    //   133: aload 7
    //   135: ifnull +47 -> 182
    //   138: iload 5
    //   140: istore_3
    //   141: aload 7
    //   143: invokevirtual 180	java/io/BufferedInputStream:close	()V
    //   146: iload 4
    //   148: istore_2
    //   149: goto +33 -> 182
    //   152: astore 8
    //   154: aload_1
    //   155: astore 7
    //   157: aload 8
    //   159: astore_1
    //   160: aload 7
    //   162: ifnull +18 -> 180
    //   165: aload 7
    //   167: invokevirtual 180	java/io/BufferedInputStream:close	()V
    //   170: goto +10 -> 180
    //   173: astore 7
    //   175: aload 7
    //   177: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   180: aload_1
    //   181: athrow
    //   182: iload_2
    //   183: iconst_1
    //   184: iadd
    //   185: istore_2
    //   186: aload 10
    //   188: astore_1
    //   189: new 186	java/io/FileOutputStream
    //   192: dup
    //   193: aload 11
    //   195: invokespecial 187	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   198: astore 7
    //   200: aload 7
    //   202: iload_2
    //   203: invokevirtual 190	java/io/FileOutputStream:write	(I)V
    //   206: aload 7
    //   208: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   211: iload_2
    //   212: ireturn
    //   213: astore 8
    //   215: aload 7
    //   217: astore_1
    //   218: aload 8
    //   220: astore 7
    //   222: goto +46 -> 268
    //   225: astore 8
    //   227: goto +14 -> 241
    //   230: astore 7
    //   232: goto +36 -> 268
    //   235: astore 8
    //   237: aload 9
    //   239: astore 7
    //   241: aload 7
    //   243: astore_1
    //   244: aload 8
    //   246: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   249: aload 7
    //   251: ifnull +15 -> 266
    //   254: aload 7
    //   256: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   259: iload_2
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   266: iload_2
    //   267: ireturn
    //   268: aload_1
    //   269: ifnull +15 -> 284
    //   272: aload_1
    //   273: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   276: goto +8 -> 284
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   284: aload 7
    //   286: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	StartupDirector
    //   0	287	1	paramContext	android.content.Context
    //   41	226	2	i1	int
    //   38	103	3	i2	int
    //   35	112	4	i3	int
    //   32	107	5	i4	int
    //   20	23	6	bool	boolean
    //   63	103	7	localObject1	Object
    //   173	3	7	localIOException1	java.io.IOException
    //   198	23	7	localObject2	Object
    //   230	1	7	localObject3	Object
    //   239	46	7	localObject4	Object
    //   29	1	8	localObject5	Object
    //   104	7	8	localException1	Exception
    //   117	9	8	localException2	Exception
    //   152	6	8	localObject6	Object
    //   213	6	8	localObject7	Object
    //   225	1	8	localIOException2	java.io.IOException
    //   235	10	8	localIOException3	java.io.IOException
    //   26	212	9	localObject8	Object
    //   23	164	10	localObject9	Object
    //   13	181	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   86	91	94	java/io/IOException
    //   141	146	94	java/io/IOException
    //   68	74	104	java/lang/Exception
    //   47	65	109	finally
    //   47	65	117	java/lang/Exception
    //   68	74	152	finally
    //   125	130	152	finally
    //   165	170	173	java/io/IOException
    //   200	206	213	finally
    //   200	206	225	java/io/IOException
    //   189	200	230	finally
    //   244	249	230	finally
    //   189	200	235	java/io/IOException
    //   206	211	261	java/io/IOException
    //   254	259	261	java/io/IOException
    //   272	276	279	java/io/IOException
  }
  
  public static StartupDirector a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onApplicationCreate ");
    }
    StartupDirector localStartupDirector = new StartupDirector();
    localStartupDirector.a(0);
    Step.AmStepFactory.b(0, localStartupDirector, o).step();
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      DebugActivity.startNetworkPolicy();
    }
    catch (Throwable localThrowable2)
    {
      label53:
      break label53;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localStartupDirector.a(1);
      Step.AmStepFactory.b(49, localStartupDirector, null).step();
      d = true;
      return localStartupDirector;
    }
    if (BaseApplicationImpl.sProcessId == 6)
    {
      b = false;
      return localStartupDirector;
    }
    b = false;
    Step.AmStepFactory.b(13, localStartupDirector, null).step();
    if (BaseApplicationImpl.sProcessId == 2)
    {
      Step.AmStepFactory.b(11, localStartupDirector, null).step();
      Step.AmStepFactory.b(39, localStartupDirector, null).step();
      ThreadManager.post(Step.AmStepFactory.b(0, localStartupDirector, y), 10, null, false);
      Step.AmStepFactory.b(0, localStartupDirector, x).step();
      return null;
    }
    if (BaseApplicationImpl.sProcessId == 10)
    {
      Step.AmStepFactory.b(0, localStartupDirector, E).step();
      return null;
    }
    if ((BaseApplicationImpl.sProcessId != 5) && (BaseApplicationImpl.sProcessId != 7))
    {
      if (BaseApplicationImpl.processName.endsWith(":secmsg"))
      {
        Step.AmStepFactory.b(12, localStartupDirector, null).step();
        return null;
      }
      if (BaseApplicationImpl.processName.endsWith(":qqfav")) {
        return null;
      }
      if (BaseApplicationImpl.processName.endsWith(":peak"))
      {
        ThreadManager.excute(Step.AmStepFactory.b(0, localStartupDirector, a), 16, null, false);
        Step.AmStepFactory.b(49, localStartupDirector, null).step();
        return null;
      }
      if (BaseApplicationImpl.processName.endsWith(":picture"))
      {
        Step.AmStepFactory.b(11, localStartupDirector, null).step();
        return null;
      }
      if (BaseApplicationImpl.processName.endsWith(":plugins"))
      {
        Step.AmStepFactory.b(14, localStartupDirector, null).step();
        Step.AmStepFactory.b(51, localStartupDirector, null).step();
        return null;
      }
      if ((!BaseApplicationImpl.processName.contains(":wxa_container")) && (!BaseApplicationImpl.processName.contains("com.tencent.ilink.ServiceProcess")))
      {
        if (BaseApplicationImpl.processName.endsWith(":troopbar"))
        {
          Step.AmStepFactory.b(12, localStartupDirector, null).step();
          Step.AmStepFactory.b(11, localStartupDirector, null).step();
          Step.AmStepFactory.b(14, localStartupDirector, null).step();
        }
        else
        {
          Step.AmStepFactory.b(0, localStartupDirector, w).step();
        }
        if (BaseApplicationImpl.processName.endsWith(":troophomework")) {
          Step.AmStepFactory.b(38, localStartupDirector, null).step();
        }
        if (!BaseApplicationImpl.processName.endsWith(":live")) {
          break label612;
        }
        Step.AmStepFactory.b(47, localStartupDirector, null).step();
        return null;
      }
      try
      {
        ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).attachBaseContext(BaseApplicationImpl.sApplication);
        return null;
      }
      catch (Throwable localThrowable1)
      {
        Log.e("StartupDirector", "attach wxMini failed !!", localThrowable1);
        return null;
      }
    }
    Step.AmStepFactory.b(11, localThrowable1, null).step();
    Step.AmStepFactory.b(8, localThrowable1, null).step();
    Step.AmStepFactory.b(0, localThrowable1, v).step();
    Step.AmStepFactory.b(12, localThrowable1, null).step();
    Step.AmStepFactory.b(46, localThrowable1, null).step();
    if (BaseApplicationImpl.sProcessId == 7)
    {
      Step.AmStepFactory.b(48, localThrowable1, null).step();
      Step.AmStepFactory.b(50, localThrowable1, null).step();
      Step.AmStepFactory.b(49, localThrowable1, null).step();
    }
    label612:
    return null;
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nextState ");
    localStringBuilder.append(this.F);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt);
    QLog.i("AutoMonitor", 1, localStringBuilder.toString());
    if ((b) || (BaseApplicationImpl.sProcessId == 1))
    {
      long l1;
      if (this.F != -1)
      {
        long l2 = SystemClock.uptimeMillis();
        if (b)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("STATE_");
          localStringBuilder.append(this.F);
          localStringBuilder.append(", cost=");
          localStringBuilder.append(l2 - P);
          localStringBuilder.append(" then ");
          localStringBuilder.append(paramInt);
          Log.i("AutoMonitor", localStringBuilder.toString());
        }
        l1 = l2;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          this.R.put(Integer.valueOf(this.F), Long.valueOf(l2 - P));
          l1 = l2;
        }
      }
      else
      {
        l1 = 0L;
      }
      if (paramInt != 1000)
      {
        if (this.F == -1) {
          l1 = SystemClock.uptimeMillis();
        }
        if (l1 != 0L) {
          P = l1;
        }
      }
    }
    this.F = paramInt;
    paramInt = this.F;
    if ((paramInt == 2) || (paramInt == 1000))
    {
      paramInt = this.F;
      if (paramInt == 2)
      {
        this.Q = ThreadManager.getSubThread().getPriority();
        ThreadManager.getSubThread().setPriority(10);
        ThreadManager.getRecentThread().setPriority(10);
        return;
      }
      if ((paramInt == 1000) && (this.Q != -1))
      {
        ThreadManager.getSubThread().setPriority(this.Q);
        ThreadManager.getRecentThread().setPriority(this.Q);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEndStep with ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", when ");
      ((StringBuilder)localObject).append(this.F);
      QLog.i("AutoMonitor", 2, ((StringBuilder)localObject).toString());
    }
    BaseApplicationImpl.isInActionS = false;
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().postAtFrontOfQueue(Step.AmStepFactory.b(10, this, null));
      if (f == 1) {
        ThreadManager.getSubThreadHandler().post(Step.AmStepFactory.b(23, this, null));
      }
    }
    this.H = null;
    Object localObject = this.I;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    a(1000);
    if (paramBoolean)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.i;
      long l3 = BaseApplicationImpl.sShowTime;
      long l4 = l1 - BaseApplicationImpl.sShowTime;
      l = l1;
      if ((BaseApplicationImpl.sShowTime > 0L) && (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.sApplication))) {
        BaseApplicationImpl.sShowTime = -l1;
      } else {
        BaseApplicationImpl.sShowTime = 0L;
      }
      long l5 = this.g;
      long l6 = this.j;
      if ((l3 > 0L) && (l4 < 30000L))
      {
        k = l4;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ActionLoginS, cost=");
        ((StringBuilder)localObject).append(l4);
        QLog.d("AutoMonitor", 1, ((StringBuilder)localObject).toString());
      }
      new StartupDirector.1(this).run();
      ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.2(this, l6, l5, l2, l1 - l2, l3, l4), 10000L);
      ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.3(this), 3000L);
      if (this.n != null)
      {
        localObject = SplashADView.a(null, null);
        if (localObject != null) {
          ThreadManager.getSubThreadHandler().postDelayed(new StartupDirector.4(this, (SplashADView)localObject), 4000L);
        }
      }
      else {}
    }
    BaseApplicationImpl.sDirector = null;
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    this.M = 1;
    paramArrayOfInt1 = Step.AmStepFactory.b(0, this, paramArrayOfInt1);
    if (paramArrayOfInt2 != null)
    {
      this.M = 2;
      this.N = paramInt;
      paramArrayOfInt1.setResultListener(this.I, 10);
      paramArrayOfInt2 = Step.AmStepFactory.b(0, this, paramArrayOfInt2);
      paramArrayOfInt2.setResultListener(this.I, 10);
      new Handler(ThreadManager.getRecentThreadLooper()).post(paramArrayOfInt2);
    }
    else
    {
      paramArrayOfInt1.setResultListener(this.I, paramInt);
    }
    paramArrayOfInt1.step();
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.H == null) {
      this.H = new Handler(ThreadManager.getSubThreadLooper(), this);
    }
    this.H.removeMessages(paramInt1);
    Message localMessage = this.I.obtainMessage(paramInt1, paramInt2, 0);
    this.H.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void b(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (paramAppActivity == null) {
      return;
    }
    TextView localTextView = new TextView(paramAppActivity);
    paramAppActivity.getWindow().setBackgroundDrawableResource(17170446);
    localTextView.setGravity(17);
    localTextView.setBackgroundColor(-16777216);
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (!paramBoolean) {
      localTextView.setText(2131890944);
    } else {
      localTextView.setText(HardCodeUtil.a(2131911684));
    }
    paramAppActivity.setContentView(localTextView);
    QLog.flushLog();
    this.I.postDelayed(new StartupDirector.5(this, paramAppActivity), 8000L);
  }
  
  private void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realCreateActivity ");
    ((StringBuilder)localObject).append(this.F);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.G);
    QLog.i("AutoMonitor", 1, ((StringBuilder)localObject).toString());
    if (this.F == 3) {
      a(4);
    }
    localObject = this.G;
    if (localObject != null)
    {
      int i1 = ((ArrayList)localObject).size() - 1;
      while (i1 >= 0)
      {
        localObject = (WeakReference)this.G.get(i1);
        if (localObject != null) {
          localObject = (AppActivity)((WeakReference)localObject).get();
        } else {
          localObject = null;
        }
        if (localObject != null) {
          ((AppActivity)localObject).realOnCreate();
        }
        i1 -= 1;
      }
    }
    if (BaseApplicationImpl.sLaunchTime > 0L)
    {
      long l1 = SystemClock.uptimeMillis();
      this.j = (l1 - BaseApplicationImpl.sLaunchTime);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ActionLoginA, cost=");
      ((StringBuilder)localObject).append(this.j);
      Log.d("AutoMonitor", ((StringBuilder)localObject).toString());
      if (NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication)) {
        BaseApplicationImpl.sLaunchTime = -l1;
      } else {
        BaseApplicationImpl.sLaunchTime = 0L;
      }
    }
    a(5);
    a(2, 0, 3000L);
    if (BaseApplicationImpl.sProcessId == 1) {
      b(12, 0, 10000L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.I == null) {
      this.I = new Handler(Looper.getMainLooper(), this);
    }
    this.I.removeMessages(paramInt1);
    Message localMessage = this.I.obtainMessage(paramInt1, paramInt2, 0);
    this.I.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(StartupDirector.SplashCallBack paramSplashCallBack)
  {
    this.n = paramSplashCallBack;
  }
  
  public void a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityFocusChanged when ");
    localStringBuilder.append(this.F);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramAppActivity);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramBoolean);
    QLog.i("AutoMonitor", 1, localStringBuilder.toString());
    if (!paramBoolean) {
      return;
    }
    this.I.removeMessages(2);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.K == null) {
        this.K = ((CheckPermission)Step.AmStepFactory.b(3, this, null));
      }
      if (!this.K.checkPermission(paramAppActivity))
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        return;
      }
    }
    QQDeviceInfo.initHuaweiOaid();
    int i1 = this.F;
    if (i1 == 2)
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        ThreadManager.getFileThreadHandler().postDelayed(Step.AmStepFactory.b(14, this, null), 1000L);
      }
      a(11, 1, 5L);
      a(3);
    }
    else if (i1 == 101)
    {
      a(11, 7, 5L);
      a(3);
    }
    else if (i1 == 201)
    {
      a(11, 8, 5L);
      a(3);
    }
    else if ((i1 == 5) || (i1 == 6))
    {
      a(true);
    }
    paramAppActivity = SplashADView.a(null, null);
    if ((paramAppActivity != null) && (paramAppActivity.k) && (paramAppActivity.l))
    {
      QLog.i("SplashAD", 1, "adView resume Video");
      paramAppActivity.c();
    }
  }
  
  public boolean a(Object paramObject, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onActivityCreate");
    ((StringBuilder)localObject).append(paramObject);
    QLog.i("AutoMonitor", 1, ((StringBuilder)localObject).toString());
    if ((paramObject instanceof AppActivity)) {
      paramObject = (AppActivity)paramObject;
    } else {
      paramObject = null;
    }
    long l1 = SystemClock.uptimeMillis();
    if ((this.F == 1) && (Math.abs(l1 - BaseApplicationImpl.appStartTime) > 4000L))
    {
      BaseApplicationImpl.sShowTime = 0L;
      BaseApplicationImpl.sLaunchTime = 0L;
      BaseApplicationImpl.appStartTime = 0L;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramObject == null)
    {
      i1 = this.F;
      if (i1 == 1)
      {
        BaseApplicationImpl.sIsBgStartup = true;
        BaseApplicationImpl.sShowTime = 0L;
        BaseApplicationImpl.sLaunchTime = 0L;
        if (paramIntent != null) {
          f = paramIntent.getIntExtra("k_start_mode", 0);
        }
        paramObject = new StringBuilder();
        paramObject.append("onActivityCreate");
        paramObject.append(this.F);
        paramObject.append(", ");
        paramObject.append(f);
        QLog.i("AutoMonitor", 1, paramObject.toString());
        paramObject = A;
        i1 = f;
        if (i1 == 1)
        {
          paramObject = B;
        }
        else if (i1 == 2)
        {
          paramObject = C;
          BaseApplicationImpl.appStartTime = 0L;
        }
        Step.AmStepFactory.b(0, this, paramObject).step();
        QQCrashControlManager.f();
        if (GuardManager.sInstance != null) {
          GuardManager.sInstance.updateStateOnPreStartEvent(f);
        }
        a(201);
        return false;
      }
      if (i1 == 2)
      {
        Step.AmStepFactory.b(0, this, z).step();
        a(101);
        return false;
      }
      if ((i1 == 201) && (f == 2) && (paramIntent != null))
      {
        i1 = paramIntent.getIntExtra("k_start_mode", 0);
        paramObject = new StringBuilder();
        paramObject.append("onActivityCreate");
        paramObject.append(this.F);
        paramObject.append(", ");
        paramObject.append(i1);
        QLog.i("AutoMonitor", 1, paramObject.toString());
        if ((i1 == 3) || (i1 == 0) || (i1 == 1)) {
          Step.AmStepFactory.b(10, this, null).step();
        }
      }
      return false;
    }
    int i1 = this.F;
    if ((i1 != 1) && (i1 != 2) && (i1 != 101) && (i1 != 201))
    {
      if ((i1 != 5) && (i1 != 6))
      {
        bool2 = true;
      }
      else
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        this.e = paramObject;
        a(6);
        a(2, 0, 1000L);
      }
    }
    else
    {
      if ((Build.VERSION.SDK_INT < 21) && (!"Success".equals(BaseApplicationImpl.sInjectResult)) && (!(paramObject instanceof InstallActivity)))
      {
        paramIntent = new Intent(paramObject, InstallActivity.class);
        paramIntent.addFlags(603979776);
        localObject = paramObject.getIntent();
        ((Intent)localObject).addFlags(67108864);
        paramIntent.putExtra("NT_AY", (Parcelable)localObject);
        try
        {
          paramObject.superStartActivityForResult(paramIntent, -1, null);
        }
        catch (Exception paramIntent)
        {
          QLog.e("AutoMonitor", 1, "", paramIntent);
        }
        try
        {
          paramObject.superFinish();
        }
        catch (Exception paramObject)
        {
          QLog.e("AutoMonitor", 1, "", paramObject);
        }
        h = a(BaseApplicationImpl.sApplication);
        if (h <= 3) {
          System.exit(-1);
        }
        return true;
      }
      this.e = paramObject;
      if ((paramObject instanceof InstallActivity)) {
        try
        {
          new File(this.e.getFilesDir(), "suicide_count").delete();
        }
        catch (Throwable paramIntent)
        {
          QLog.e("AutoMonitor", 1, "", paramIntent);
        }
      }
      if (!(paramObject instanceof SplashActivity))
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
      }
      paramIntent = (SetSplash)Step.AmStepFactory.b(2, this, null);
      paramIntent.step();
      if (paramIntent.a)
      {
        a(2, 0, 1000L);
        bool1 = true;
      }
      else
      {
        Step.AmStepFactory.b(7, this, null).step();
        a(2, 0, 0L);
      }
      i1 = this.F;
      if ((i1 == 201) || ((i1 == 1) && (f == 2))) {
        this.i = l1;
      }
      bool2 = bool1;
      if (this.F == 1)
      {
        a(2);
        bool2 = bool1;
      }
    }
    if (bool2)
    {
      if (this.G == null) {
        this.G = new ArrayList(2);
      }
      this.G.add(new WeakReference(paramObject));
    }
    return bool2;
  }
  
  public boolean b()
  {
    return this.L;
  }
  
  public void c()
  {
    a(2, 0, 0L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector
 * JD-Core Version:    0.7.0.1
 */