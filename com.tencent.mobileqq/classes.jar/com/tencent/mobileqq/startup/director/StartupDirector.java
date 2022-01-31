package com.tencent.mobileqq.startup.director;

import ahqk;
import ahql;
import ahqm;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class StartupDirector
  implements Handler.Callback
{
  public static int a;
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static int b;
  public static boolean b;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static final int jdField_c_of_type_Int;
  private static final int[] jdField_c_of_type_ArrayOfInt;
  private static final int[] jdField_d_of_type_ArrayOfInt;
  private static final int[] jdField_e_of_type_ArrayOfInt;
  private static long jdField_f_of_type_Long;
  private static final int[] jdField_f_of_type_ArrayOfInt;
  private static final int[] g;
  private static final int[] h;
  private static final int[] i;
  private static final int[] j;
  private static final int[] k;
  private static final int[] l;
  private static final int[] m;
  private static final int[] n;
  private static final int[] o;
  private static final int[] p;
  private static final int[] q;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public AppActivity a;
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public long c;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private int jdField_f_of_type_Int;
  
  static
  {
    if (Build.MODEL.toLowerCase().startsWith("coolpad 80")) {}
    for (int i1 = 1;; i1 = 3)
    {
      jdField_c_of_type_Int = i1;
      jdField_a_of_type_ArrayOfInt = new int[] { 1, 7, 13 };
      jdField_b_of_type_ArrayOfInt = new int[] { 4, 5, 17 };
      jdField_c_of_type_ArrayOfInt = new int[] { 10 };
      jdField_d_of_type_ArrayOfInt = new int[] { 9, 10, 15, 16 };
      jdField_e_of_type_ArrayOfInt = new int[] { 11, 9, 10, 15 };
      jdField_f_of_type_ArrayOfInt = new int[] { 5, 17 };
      g = new int[] { 11, 9, 15 };
      h = jdField_f_of_type_ArrayOfInt;
      i = new int[] { 30, 4, 8 };
      j = new int[] { 12, 4, 9, 8 };
      k = new int[] { 12 };
      l = new int[] { 6, 4, 8, 18 };
      m = new int[] { 11, 4 };
      n = new int[] { 11, 4, 12, 10, 8 };
      o = new int[] { 11, 4, 12, 10, 19 };
      p = new int[] { 11, 4, 12, 10 };
      q = new int[] { 28, 31 };
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  /* Error */
  private final int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: new 103	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 109	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc 111
    //   24: invokespecial 114	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 9
    //   29: iload 4
    //   31: istore_3
    //   32: aload 9
    //   34: invokevirtual 118	java/io/File:exists	()Z
    //   37: ifeq +49 -> 86
    //   40: new 120	java/io/BufferedInputStream
    //   43: dup
    //   44: new 122	java/io/FileInputStream
    //   47: dup
    //   48: aload 9
    //   50: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 128	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 5
    //   58: aload 5
    //   60: astore_1
    //   61: aload 5
    //   63: invokevirtual 132	java/io/BufferedInputStream:read	()I
    //   66: istore_3
    //   67: iload_3
    //   68: iconst_m1
    //   69: if_icmpne +228 -> 297
    //   72: iload_2
    //   73: istore_3
    //   74: aload 5
    //   76: ifnull +10 -> 86
    //   79: aload 5
    //   81: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   84: iload_2
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: aload 8
    //   92: astore_1
    //   93: new 137	java/io/FileOutputStream
    //   96: dup
    //   97: aload 9
    //   99: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore 5
    //   104: aload 5
    //   106: iload_2
    //   107: invokevirtual 142	java/io/FileOutputStream:write	(I)V
    //   110: aload 5
    //   112: ifnull +8 -> 120
    //   115: aload 5
    //   117: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   127: iload_2
    //   128: istore_3
    //   129: goto -43 -> 86
    //   132: astore 6
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: astore_1
    //   140: aload 6
    //   142: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   145: iload 4
    //   147: istore_3
    //   148: aload 5
    //   150: ifnull -64 -> 86
    //   153: aload 5
    //   155: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   158: iload 4
    //   160: istore_3
    //   161: goto -75 -> 86
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   169: iload 4
    //   171: istore_3
    //   172: goto -86 -> 86
    //   175: astore_1
    //   176: aload 6
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore 5
    //   194: aload 5
    //   196: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   199: goto -9 -> 190
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   207: iload_2
    //   208: ireturn
    //   209: astore 6
    //   211: aload 7
    //   213: astore 5
    //   215: aload 5
    //   217: astore_1
    //   218: aload 6
    //   220: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   223: aload 5
    //   225: ifnull -105 -> 120
    //   228: aload 5
    //   230: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   233: iload_2
    //   234: ireturn
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   240: iload_2
    //   241: ireturn
    //   242: astore 6
    //   244: aload_1
    //   245: astore 5
    //   247: aload 6
    //   249: astore_1
    //   250: aload 5
    //   252: ifnull +8 -> 260
    //   255: aload 5
    //   257: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   260: aload_1
    //   261: athrow
    //   262: astore 5
    //   264: aload 5
    //   266: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   269: goto -9 -> 260
    //   272: astore_1
    //   273: goto -23 -> 250
    //   276: astore 6
    //   278: goto -63 -> 215
    //   281: astore 6
    //   283: aload_1
    //   284: astore 5
    //   286: aload 6
    //   288: astore_1
    //   289: goto -109 -> 180
    //   292: astore 6
    //   294: goto -157 -> 137
    //   297: iload_3
    //   298: istore_2
    //   299: goto -227 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	StartupDirector
    //   0	302	1	paramContext	android.content.Context
    //   13	286	2	i1	int
    //   31	267	3	i2	int
    //   10	160	4	i3	int
    //   56	130	5	localObject1	Object
    //   192	3	5	localIOException1	java.io.IOException
    //   213	43	5	localObject2	Object
    //   262	3	5	localIOException2	java.io.IOException
    //   284	1	5	localContext	android.content.Context
    //   7	1	6	localObject3	Object
    //   132	45	6	localException1	Exception
    //   209	10	6	localIOException3	java.io.IOException
    //   242	6	6	localObject4	Object
    //   276	1	6	localIOException4	java.io.IOException
    //   281	6	6	localObject5	Object
    //   292	1	6	localException2	Exception
    //   1	211	7	localObject6	Object
    //   4	87	8	localObject7	Object
    //   27	71	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   79	84	122	java/io/IOException
    //   40	58	132	java/lang/Exception
    //   153	158	164	java/io/IOException
    //   40	58	175	finally
    //   185	190	192	java/io/IOException
    //   115	120	202	java/io/IOException
    //   93	104	209	java/io/IOException
    //   228	233	235	java/io/IOException
    //   93	104	242	finally
    //   218	223	242	finally
    //   255	260	262	java/io/IOException
    //   104	110	272	finally
    //   104	110	276	java/io/IOException
    //   61	67	281	finally
    //   140	145	281	finally
    //   61	67	292	java/lang/Exception
  }
  
  public static StartupDirector a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onApplicationCreate ");
    }
    StartupDirector localStartupDirector = new StartupDirector();
    localStartupDirector.a(0);
    Step.AmStepFactory.b(0, localStartupDirector, jdField_a_of_type_ArrayOfInt).c();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localStartupDirector.a(1);
      return localStartupDirector;
    }
    if (BaseApplicationImpl.sProcessId == 6)
    {
      jdField_a_of_type_Boolean = false;
      return localStartupDirector;
    }
    jdField_a_of_type_Boolean = false;
    Step.AmStepFactory.b(11, localStartupDirector, null).c();
    if (BaseApplicationImpl.sProcessId == 2)
    {
      Step.AmStepFactory.b(37, localStartupDirector, null).c();
      ThreadManager.post(Step.AmStepFactory.b(0, localStartupDirector, l), 10, null, false);
      Step.AmStepFactory.b(0, localStartupDirector, k).c();
    }
    do
    {
      for (;;)
      {
        return null;
        if ((BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7))
        {
          Step.AmStepFactory.b(9, localStartupDirector, null).c();
          Step.AmStepFactory.b(6, localStartupDirector, null).c();
          Step.AmStepFactory.b(0, localStartupDirector, i).c();
          Step.AmStepFactory.b(10, localStartupDirector, null).c();
        }
        else
        {
          if (!BaseApplicationImpl.processName.endsWith(":secmsg")) {
            break;
          }
          Step.AmStepFactory.b(10, localStartupDirector, null).c();
        }
      }
    } while (BaseApplicationImpl.processName.endsWith(":qqfav"));
    if (BaseApplicationImpl.processName.endsWith(":troopbar"))
    {
      Step.AmStepFactory.b(10, localStartupDirector, null).c();
      Step.AmStepFactory.b(9, localStartupDirector, null).c();
      Step.AmStepFactory.b(12, localStartupDirector, null).c();
    }
    for (;;)
    {
      if ((!BaseApplicationImpl.processName.endsWith(":picture")) && (!BaseApplicationImpl.processName.endsWith(":qzonevideo"))) {
        ThreadManager.post(Step.AmStepFactory.b(0, localStartupDirector, q), 8, null, false);
      }
      if (!BaseApplicationImpl.processName.endsWith(":troophomework")) {
        break;
      }
      Step.AmStepFactory.b(35, localStartupDirector, null).c();
      break;
      Step.AmStepFactory.b(0, localStartupDirector, j).c();
    }
  }
  
  private void a()
  {
    QLog.i("AutoMonitor", 1, "realCreateActivity " + this.jdField_d_of_type_Int + ", " + this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("AutoMonitor", 2, "realCreateActivity time=" + System.currentTimeMillis());
    }
    if (this.jdField_d_of_type_Int == 3) {
      a(4);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localObject != null) {}
        for (localObject = (AppActivity)((WeakReference)localObject).get();; localObject = null)
        {
          if (localObject != null) {
            ((AppActivity)localObject).realOnCreate();
          }
          i1 -= 1;
          break;
        }
      }
    }
    long l1;
    if (BaseApplicationImpl.sLaunchTime > 0L)
    {
      l1 = SystemClock.uptimeMillis();
      this.jdField_c_of_type_Long = (l1 - BaseApplicationImpl.sLaunchTime);
      Log.d("AutoMonitor", "ActionLoginA, cost=" + this.jdField_c_of_type_Long);
      if (!NetworkUtil.d(BaseApplicationImpl.sApplication)) {
        break label254;
      }
    }
    label254:
    for (BaseApplicationImpl.sLaunchTime = -l1;; BaseApplicationImpl.sLaunchTime = 0L)
    {
      a(5);
      a(2, 0, 3000L);
      if (BaseApplicationImpl.sProcessId == 1) {
        b(12, 0, 10000L);
      }
      return;
    }
  }
  
  private void a(int paramInt)
  {
    QLog.i("AutoMonitor", 1, "nextState " + this.jdField_d_of_type_Int + ", " + paramInt);
    long l1;
    if (jdField_a_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Int == -1) {
        break label144;
      }
      l1 = SystemClock.uptimeMillis();
      Log.i("AutoMonitor", "STATE_" + this.jdField_d_of_type_Int + ", cost=" + (l1 - jdField_f_of_type_Long) + " then " + paramInt);
    }
    for (;;)
    {
      if (paramInt != 1000)
      {
        if (this.jdField_d_of_type_Int == -1) {
          l1 = SystemClock.uptimeMillis();
        }
        if (l1 != 0L) {
          jdField_f_of_type_Long = l1;
        }
      }
      this.jdField_d_of_type_Int = paramInt;
      return;
      label144:
      l1 = 0L;
    }
  }
  
  private void a(AppActivity paramAppActivity, boolean paramBoolean1, boolean paramBoolean2)
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
    if (!paramBoolean1) {
      if (InjectUtils.sSpaceNoEnough) {
        localTextView.setText(2131433065);
      }
    }
    for (;;)
    {
      paramAppActivity.setContentView(localTextView);
      QLog.flushLog();
      InjectUtils.uploadInjectFailure(paramAppActivity, "SuicideFailed", Integer.toString(jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ahqm(this, paramAppActivity), 8000L);
      return;
      localTextView.setText(2131433064);
      continue;
      localTextView.setText("程序启动失败，请稍候重试.");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onEndStep with " + paramBoolean + ", when " + this.jdField_d_of_type_Int);
    }
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().post(Step.AmStepFactory.b(8, this, null));
      if (jdField_a_of_type_Int == 1) {
        ThreadManager.getSubThreadHandler().post(Step.AmStepFactory.b(20, this, null));
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    a(1000);
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    if (paramBoolean)
    {
      l1 = SystemClock.uptimeMillis();
      l2 = this.jdField_b_of_type_Long;
      l3 = this.jdField_b_of_type_Long;
      l4 = BaseApplicationImpl.sShowTime;
      l5 = BaseApplicationImpl.sShowTime;
      if ((BaseApplicationImpl.sShowTime <= 0L) || (!NetworkUtil.g(BaseApplicationImpl.sApplication))) {
        break label249;
      }
    }
    label249:
    for (BaseApplicationImpl.sShowTime = -l1;; BaseApplicationImpl.sShowTime = 0L)
    {
      long l6 = this.jdField_a_of_type_Long;
      long l7 = this.jdField_c_of_type_Long;
      ThreadManager.getSubThreadHandler().postDelayed(new ahqk(this, l7, l6, l2, l1 - l3, l4, l1 - l5), 10000L);
      ThreadManager.getSubThreadHandler().postDelayed(new ahql(this), 3000L);
      ThreadManager.getSubThreadHandler().postDelayed(Step.AmStepFactory.b(28, this, null), 5000L);
      BaseApplicationImpl.sDirector = null;
      return;
    }
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    this.jdField_e_of_type_Int = 1;
    paramArrayOfInt1 = Step.AmStepFactory.b(0, this, paramArrayOfInt1);
    if (paramArrayOfInt2 != null)
    {
      this.jdField_e_of_type_Int = 2;
      this.jdField_f_of_type_Int = paramInt;
      paramArrayOfInt1.a(this.jdField_b_of_type_AndroidOsHandler, 10);
      paramArrayOfInt2 = Step.AmStepFactory.b(0, this, paramArrayOfInt2);
      paramArrayOfInt2.a(this.jdField_b_of_type_AndroidOsHandler, 10);
      new Handler(ThreadManager.getRecentThreadLooper()).post(paramArrayOfInt2);
    }
    for (;;)
    {
      paramArrayOfInt1.c();
      return;
      paramArrayOfInt1.a(this.jdField_b_of_type_AndroidOsHandler, paramInt);
    }
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    QLog.i("AutoMonitor", 1, "onActivityFocusChanged when " + this.jdField_d_of_type_Int + ", " + paramAppActivity + ", " + paramBoolean);
    if (!paramBoolean) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
      if (this.jdField_d_of_type_Int == 2)
      {
        a(11, 1, 5L);
        a(3);
        return;
      }
      if (this.jdField_d_of_type_Int == 101)
      {
        a(11, 7, 5L);
        a(3);
        return;
      }
      if (this.jdField_d_of_type_Int == 201)
      {
        a(11, 8, 5L);
        a(3);
        return;
      }
      if ((this.jdField_d_of_type_Int == 5) || (this.jdField_d_of_type_Int == 6))
      {
        a(true);
        return;
      }
    } while (this.jdField_d_of_type_Int == 3);
  }
  
  public boolean a(Object paramObject, Intent paramIntent)
  {
    QLog.i("AutoMonitor", 1, "onActivityCreate" + paramObject);
    if ((paramObject instanceof AppActivity)) {}
    for (paramObject = (AppActivity)paramObject;; paramObject = null)
    {
      long l1 = SystemClock.uptimeMillis();
      if ((this.jdField_d_of_type_Int == 1) && (Math.abs(l1 - BaseApplicationImpl.appStartTime) > 4000L))
      {
        BaseApplicationImpl.sShowTime = 0L;
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.appStartTime = 0L;
      }
      label202:
      boolean bool2;
      if (paramObject == null)
      {
        int i1;
        if (this.jdField_d_of_type_Int == 1)
        {
          BaseApplicationImpl.sIsBgStartup = true;
          BaseApplicationImpl.sShowTime = 0L;
          BaseApplicationImpl.sLaunchTime = 0L;
          if (paramIntent != null) {
            jdField_a_of_type_Int = paramIntent.getIntExtra("k_start_mode", 0);
          }
          QLog.i("AutoMonitor", 1, "onActivityCreate" + this.jdField_d_of_type_Int + ", " + jdField_a_of_type_Int);
          paramObject = n;
          if (jdField_a_of_type_Int == 1)
          {
            paramObject = o;
            Step.AmStepFactory.b(0, this, paramObject).c();
            if (GuardManager.a != null)
            {
              paramObject = GuardManager.a;
              if (jdField_a_of_type_Int != 2) {
                break label252;
              }
              i1 = 1;
              paramObject.a(i1, null);
            }
            a(201);
          }
        }
        for (;;)
        {
          bool2 = false;
          return bool2;
          if (jdField_a_of_type_Int == 2)
          {
            paramObject = p;
            BaseApplicationImpl.appStartTime = 0L;
            break;
          }
          if (jdField_a_of_type_Int != 0) {
            break;
          }
          paramObject = n;
          break;
          label252:
          i1 = 6;
          break label202;
          if (this.jdField_d_of_type_Int == 2)
          {
            Step.AmStepFactory.b(0, this, m).c();
            a(101);
          }
          else if ((this.jdField_d_of_type_Int == 201) && (jdField_a_of_type_Int == 2) && (paramIntent != null))
          {
            i1 = paramIntent.getIntExtra("k_start_mode", 2);
            QLog.i("AutoMonitor", 1, "onActivityCreate" + this.jdField_d_of_type_Int + ", " + i1);
            if ((i1 == 3) || (i1 == 0) || (i1 == 1)) {
              Step.AmStepFactory.b(8, this, null).c();
            }
          }
        }
      }
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 101) || (this.jdField_d_of_type_Int == 201))
      {
        if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) && (!(paramObject instanceof InstallActivity)))
        {
          paramIntent = new Intent(paramObject, InstallActivity.class);
          paramIntent.addFlags(603979776);
          Intent localIntent = paramObject.getIntent();
          localIntent.addFlags(67108864);
          paramIntent.putExtra("NT_AY", localIntent);
          try
          {
            paramObject.superStartActivityForResult(paramIntent, -1, null);
          }
          catch (Exception paramIntent)
          {
            try
            {
              for (;;)
              {
                paramObject.superFinish();
                jdField_b_of_type_Int = a(BaseApplicationImpl.sApplication);
                if (jdField_b_of_type_Int <= jdField_c_of_type_Int) {
                  System.exit(-1);
                }
                return true;
                paramIntent = paramIntent;
                QLog.e("AutoMonitor", 1, "", paramIntent);
              }
            }
            catch (Exception paramObject)
            {
              for (;;)
              {
                QLog.e("AutoMonitor", 1, "", paramObject);
              }
            }
          }
        }
        this.jdField_a_of_type_MqqAppAppActivity = paramObject;
        if (!(paramObject instanceof InstallActivity)) {}
      }
      for (;;)
      {
        boolean bool1;
        try
        {
          new File(this.jdField_a_of_type_MqqAppAppActivity.getFilesDir(), "suicide_count").delete();
          if (!(paramObject instanceof SplashActivity))
          {
            BaseApplicationImpl.sLaunchTime = 0L;
            BaseApplicationImpl.sShowTime = 0L;
          }
          Step.AmStepFactory.b(2, this, null).c();
          a(2, 0, 1000L);
          bool2 = true;
          if ((this.jdField_d_of_type_Int == 201) || ((this.jdField_d_of_type_Int == 1) && (jdField_a_of_type_Int == 2))) {
            this.jdField_b_of_type_Long = l1;
          }
          bool1 = bool2;
          if (this.jdField_d_of_type_Int == 1)
          {
            a(2);
            bool1 = bool2;
          }
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramObject));
          return bool1;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("AutoMonitor", 1, "", paramIntent);
          continue;
        }
        if ((this.jdField_d_of_type_Int == 5) || (this.jdField_d_of_type_Int == 6))
        {
          BaseApplicationImpl.sLaunchTime = 0L;
          BaseApplicationImpl.sShowTime = 0L;
          this.jdField_a_of_type_MqqAppAppActivity = paramObject;
          a(6);
          a(2, 0, 1000L);
          bool1 = false;
        }
        else if (this.jdField_d_of_type_Int == 3)
        {
          bool1 = true;
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i1 = 0;
    QLog.i("AutoMonitor", 1, "handleMessage when " + this.jdField_d_of_type_Int + ", what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 7: 
    case 8: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        return true;
        a(4, 0, 300L);
        bool1 = Step.AmStepFactory.b(11, this, null).c();
        if ((bool1) && (jdField_b_of_type_Int <= jdField_c_of_type_Int))
        {
          a(5, 0, 0L);
          a(jdField_b_of_type_ArrayOfInt, jdField_d_of_type_ArrayOfInt, 6);
          b(9, 0, 300L);
          return true;
        }
        if (bool1) {
          i1 = 1;
        }
        a(3, i1, 0L);
        return true;
        b(9, 0, 300L);
        a(jdField_e_of_type_ArrayOfInt, jdField_f_of_type_ArrayOfInt, 6);
        return true;
        a(g, h, 6);
        return true;
        a(this.jdField_a_of_type_MqqAppAppActivity, true);
        return true;
        if (this.jdField_a_of_type_MqqAppAppActivity != null)
        {
          AppActivity localAppActivity = this.jdField_a_of_type_MqqAppAppActivity;
          if (paramMessage.arg1 > 0) {}
          for (bool1 = true;; bool1 = false)
          {
            if (jdField_b_of_type_Int < jdField_c_of_type_Int) {
              bool2 = true;
            }
            a(localAppActivity, bool1, bool2);
            return true;
          }
          if (this.jdField_a_of_type_MqqAppAppActivity != null)
          {
            ShortcutUtils.a(this.jdField_a_of_type_MqqAppAppActivity, "com.tencent.mobileqq.activity.MainActivity");
            ShortcutUtils.a(this.jdField_a_of_type_MqqAppAppActivity, SplashActivity.class.getName());
            return true;
            if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(4)) {
              ShortcutUtils.a(this.jdField_a_of_type_MqqAppAppActivity.getApplicationContext(), SplashActivity.class.getName());
            }
            this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
            return true;
            if (paramMessage.arg1 == 0)
            {
              if (this.jdField_a_of_type_Long > 0L) {
                this.jdField_d_of_type_Long = (this.jdField_e_of_type_Long + this.jdField_a_of_type_Long - SystemClock.uptimeMillis());
              }
              if (BaseApplicationImpl.isCurrentVersionFirstLaunch)
              {
                System.gc();
                System.runFinalization();
                this.jdField_d_of_type_Long = 2000L;
              }
              if ((this.jdField_d_of_type_Long > 0L) && (this.jdField_d_of_type_Long < 6000L))
              {
                a(6, 1, this.jdField_d_of_type_Long);
                return true;
              }
              a();
              return true;
            }
            a();
            return true;
            Step.AmStepFactory.b(12, this, null).c();
            if (BaseApplicationImpl.sProcessId == 7)
            {
              a(13, 0, 0L);
              return true;
              i1 = this.jdField_e_of_type_Int - 1;
              this.jdField_e_of_type_Int = i1;
              if (i1 == 0)
              {
                a(this.jdField_f_of_type_Int, 0, 0L);
                return true;
                if (this.jdField_a_of_type_Long > 0L) {
                  this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
                }
                b(paramMessage.arg1, 0, 0L);
                return true;
                try
                {
                  if (GuardManager.a != null)
                  {
                    paramMessage = GuardManager.a;
                    if (jdField_a_of_type_Int == 2) {
                      bool1 = true;
                    }
                    paramMessage.d(bool1);
                    return true;
                  }
                }
                catch (Throwable paramMessage)
                {
                  return true;
                }
              }
            }
          }
        }
      }
    }
    Step.AmStepFactory.b(27, this, null).c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector
 * JD-Core Version:    0.7.0.1
 */