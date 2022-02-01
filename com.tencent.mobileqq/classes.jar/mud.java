import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager.WakeLock;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class mud
{
  static int jdField_b_of_type_Int = -1;
  int jdField_a_of_type_Int = 0;
  Sensor jdField_a_of_type_AndroidHardwareSensor = null;
  SensorManager jdField_a_of_type_AndroidHardwareSensorManager = null;
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  String jdField_a_of_type_JavaLangString = "SensorHelper";
  WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference = null;
  mue jdField_a_of_type_Mue = null;
  muf jdField_a_of_type_Muf = null;
  mug jdField_a_of_type_Mug = null;
  muh jdField_a_of_type_Muh = new muh();
  mur jdField_a_of_type_Mur;
  boolean jdField_a_of_type_Boolean = false;
  Sensor jdField_b_of_type_AndroidHardwareSensor = null;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  private boolean e = true;
  private boolean f;
  private boolean g = true;
  private boolean h = true;
  private boolean i;
  private boolean j = true;
  
  private mud(Activity paramActivity, VideoController paramVideoController, mur parammur)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_Mur = parammur;
    b();
  }
  
  public static mud a(mud parammud, Activity paramActivity, VideoController paramVideoController, mur parammur)
  {
    if (parammud != null) {
      parammud.a(false);
    }
    return new mud(paramActivity, paramVideoController, parammur);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Muh.a(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startSensor " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Mue == null) || (this.jdField_a_of_type_Muf == null) || (this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "startSensor error, start[" + paramBoolean);
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_Muh.a();
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Mue, this.jdField_a_of_type_AndroidHardwareSensor, 3);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Muf, this.jdField_b_of_type_AndroidHardwareSensor, 3);
    if (this.jdField_a_of_type_Mug == null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_Mug = new mug(this);
      ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).registerReceiver(this.jdField_a_of_type_Mug, localIntentFilter);
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "startSensor error, mSreenActionReceive had exist");
    return;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Mue);
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Muf);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "toggleProximityWakeLock[false], when[StopSensor]");
      a(false, true);
      b(false);
      c(false);
      if (this.jdField_a_of_type_Mug != null)
      {
        ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_Mug);
        this.jdField_a_of_type_Mug = null;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Muh.b();
  }
  
  /* Error */
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 197	mud:a	()Z
    //   6: istore_3
    //   7: aload_0
    //   8: getfield 76	mud:d	Z
    //   11: iload_1
    //   12: if_icmpeq +17 -> 29
    //   15: aload_0
    //   16: getfield 103	mud:f	Z
    //   19: ifne +324 -> 343
    //   22: iload_1
    //   23: ifne +6 -> 29
    //   26: goto +317 -> 343
    //   29: aload_0
    //   30: getfield 41	mud:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: iconst_1
    //   34: ldc 199
    //   36: iconst_4
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: iload_1
    //   43: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: getfield 76	mud:d	Z
    //   53: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload_0
    //   60: getfield 103	mud:f	Z
    //   63: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: iload_3
    //   70: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: invokestatic 211	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   87: ifnonnull +51 -> 138
    //   90: aload_0
    //   91: getfield 68	mud:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   94: invokevirtual 135	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   97: checkcast 169	android/content/Context
    //   100: ldc 213
    //   102: invokevirtual 217	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   105: checkcast 219	android/os/PowerManager
    //   108: astore 4
    //   110: aload_0
    //   111: aload 4
    //   113: bipush 32
    //   115: ldc 221
    //   117: invokevirtual 225	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   120: putfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   123: aload_0
    //   124: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   127: ifnull +11 -> 138
    //   130: aload_0
    //   131: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   134: iconst_0
    //   135: invokevirtual 230	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   138: aload_0
    //   139: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   142: ifnonnull +46 -> 188
    //   145: aload_0
    //   146: getfield 41	mud:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: iconst_1
    //   150: ldc 232
    //   152: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: goto -75 -> 80
    //   158: astore 4
    //   160: aload_0
    //   161: monitorexit
    //   162: aload 4
    //   164: athrow
    //   165: astore 4
    //   167: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq -32 -> 138
    //   173: aload_0
    //   174: getfield 41	mud:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   177: iconst_2
    //   178: ldc 234
    //   180: aload 4
    //   182: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: goto -47 -> 138
    //   188: aload_0
    //   189: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   192: ifnull -112 -> 80
    //   195: aload_0
    //   196: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   199: invokevirtual 240	android/os/PowerManager$WakeLock:isHeld	()Z
    //   202: istore_3
    //   203: aload_0
    //   204: getfield 41	mud:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: iconst_1
    //   208: ldc 242
    //   210: iconst_2
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: iload_1
    //   217: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: iload_3
    //   224: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   227: aastore
    //   228: invokestatic 211	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload_1
    //   235: ifeq +57 -> 292
    //   238: iload_3
    //   239: ifne +53 -> 292
    //   242: aload_0
    //   243: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   246: invokevirtual 245	android/os/PowerManager$WakeLock:acquire	()V
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 76	mud:d	Z
    //   254: aload_0
    //   255: getfield 62	mud:jdField_a_of_type_Muh	Lmuh;
    //   258: invokevirtual 247	muh:c	()V
    //   261: aload_0
    //   262: iload_1
    //   263: putfield 76	mud:d	Z
    //   266: goto -186 -> 80
    //   269: astore 4
    //   271: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -194 -> 80
    //   277: aload_0
    //   278: getfield 41	mud:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   281: iconst_2
    //   282: ldc 249
    //   284: aload 4
    //   286: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -209 -> 80
    //   292: iload_1
    //   293: ifne -32 -> 261
    //   296: iload_3
    //   297: ifeq -36 -> 261
    //   300: aload_0
    //   301: getfield 74	mud:jdField_a_of_type_AndroidOsPowerManager$WakeLock	Landroid/os/PowerManager$WakeLock;
    //   304: invokevirtual 252	android/os/PowerManager$WakeLock:release	()V
    //   307: aload_0
    //   308: iconst_0
    //   309: putfield 76	mud:d	Z
    //   312: aload_0
    //   313: getfield 62	mud:jdField_a_of_type_Muh	Lmuh;
    //   316: aload_0
    //   317: getfield 82	mud:j	Z
    //   320: aload_0
    //   321: getfield 103	mud:f	Z
    //   324: aload_0
    //   325: getfield 80	mud:h	Z
    //   328: aload_0
    //   329: getfield 64	mud:jdField_a_of_type_Int	I
    //   332: iload_2
    //   333: aload_0
    //   334: getfield 66	mud:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   337: invokevirtual 255	muh:a	(ZZZIZLcom/tencent/av/VideoController;)V
    //   340: goto -79 -> 261
    //   343: iload_3
    //   344: ifeq -261 -> 83
    //   347: goto -318 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	mud
    //   0	350	1	paramBoolean1	boolean
    //   0	350	2	paramBoolean2	boolean
    //   6	338	3	bool	boolean
    //   108	4	4	localPowerManager	android.os.PowerManager
    //   158	5	4	localObject	Object
    //   165	16	4	localException1	java.lang.Exception
    //   269	16	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	22	158	finally
    //   29	80	158	finally
    //   83	110	158	finally
    //   110	138	158	finally
    //   138	155	158	finally
    //   167	185	158	finally
    //   188	234	158	finally
    //   242	261	158	finally
    //   261	266	158	finally
    //   271	289	158	finally
    //   300	340	158	finally
    //   110	138	165	java/lang/Exception
    //   188	234	269	java/lang/Exception
    //   242	261	269	java/lang/Exception
    //   261	266	269	java/lang/Exception
    //   300	340	269	java/lang/Exception
  }
  
  boolean a()
  {
    if (jdField_b_of_type_Int == -1)
    {
      String str = Build.MODEL;
      if (!Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
        break label73;
      }
      if ((!str.equalsIgnoreCase("GT-I9200")) && (!str.equalsIgnoreCase("GT-I8262D")) && (!str.equalsIgnoreCase("SM-N9008"))) {
        break label66;
      }
      jdField_b_of_type_Int = 1;
    }
    while (jdField_b_of_type_Int == 1)
    {
      return true;
      label66:
      jdField_b_of_type_Int = 0;
      continue;
      label73:
      jdField_b_of_type_Int = 0;
    }
    return false;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      Context localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((localContext != null) && (this.jdField_a_of_type_AndroidHardwareSensorManager == null)) {
        this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localContext.getSystemService("sensor"));
      }
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
        this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      }
      if (this.jdField_b_of_type_AndroidHardwareSensor == null) {
        this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
      }
    }
    if (this.jdField_a_of_type_Mue == null) {
      this.jdField_a_of_type_Mue = new mue(this);
    }
    if (this.jdField_a_of_type_Muf == null) {
      this.jdField_a_of_type_Muf = new muf(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mud
 * JD-Core Version:    0.7.0.1
 */