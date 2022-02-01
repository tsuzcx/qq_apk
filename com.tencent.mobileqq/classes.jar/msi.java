import android.content.Context;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import com.tencent.av.utils.PhoneStatusMonitor.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class msi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private msj jdField_a_of_type_Msj;
  private msk jdField_a_of_type_Msk;
  private boolean jdField_a_of_type_Boolean;
  private final AtomicBoolean b;
  
  /* Error */
  public msi(Context paramContext, msj parammsj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 29	java/util/concurrent/atomic/AtomicBoolean
    //   8: dup
    //   9: invokespecial 30	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   12: putfield 32	msi:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: aload_0
    //   16: new 29	java/util/concurrent/atomic/AtomicBoolean
    //   19: dup
    //   20: invokespecial 30	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   23: putfield 34	msi:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   26: aload_0
    //   27: new 36	com/tencent/av/utils/PhoneStatusMonitor$3
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 39	com/tencent/av/utils/PhoneStatusMonitor$3:<init>	(Lmsi;)V
    //   35: putfield 41	msi:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   38: invokestatic 47	android/os/SystemClock:elapsedRealtime	()J
    //   41: lstore_3
    //   42: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 55
    //   50: iconst_2
    //   51: ldc 57
    //   53: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 63	msi:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   61: aload_0
    //   62: aload_2
    //   63: putfield 65	msi:jdField_a_of_type_Msj	Lmsj;
    //   66: aload_0
    //   67: new 67	msl
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 68	msl:<init>	(Lmsi;)V
    //   75: putfield 70	msi:jdField_a_of_type_AndroidTelephonyPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   78: aload_0
    //   79: new 72	msk
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 73	msk:<init>	(Lmsi;)V
    //   87: putfield 75	msi:jdField_a_of_type_Msk	Lmsk;
    //   90: new 77	com/tencent/av/utils/PhoneStatusMonitor$1
    //   93: dup
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial 80	com/tencent/av/utils/PhoneStatusMonitor$1:<init>	(Lmsi;Landroid/content/Context;)V
    //   99: bipush 16
    //   101: aconst_null
    //   102: iconst_0
    //   103: invokestatic 86	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   106: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +37 -> 146
    //   112: ldc 55
    //   114: iconst_2
    //   115: new 88	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   122: ldc 91
    //   124: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokestatic 47	android/os/SystemClock:elapsedRealtime	()J
    //   130: lload_3
    //   131: lsub
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: ldc 100
    //   137: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: new 106	android/content/IntentFilter
    //   149: dup
    //   150: invokespecial 107	android/content/IntentFilter:<init>	()V
    //   153: astore_2
    //   154: aload_2
    //   155: ldc 109
    //   157: invokevirtual 113	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   160: aload_2
    //   161: ldc 115
    //   163: invokevirtual 113	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   166: aload_2
    //   167: ldc 117
    //   169: invokevirtual 113	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   172: aload_2
    //   173: ldc 119
    //   175: invokevirtual 113	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   178: aload_2
    //   179: ldc 121
    //   181: invokevirtual 113	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: aload_0
    //   186: getfield 75	msi:jdField_a_of_type_Msk	Lmsk;
    //   189: aload_2
    //   190: invokevirtual 127	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   193: pop
    //   194: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +37 -> 234
    //   200: ldc 55
    //   202: iconst_2
    //   203: new 88	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   210: ldc 129
    //   212: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokestatic 47	android/os/SystemClock:elapsedRealtime	()J
    //   218: lload_3
    //   219: lsub
    //   220: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: ldc 100
    //   225: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: new 131	android/os/Handler
    //   238: dup
    //   239: invokestatic 137	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   242: invokespecial 140	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   245: putfield 142	msi:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   248: return
    //   249: astore_2
    //   250: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -175 -> 78
    //   256: ldc 55
    //   258: iconst_2
    //   259: new 88	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   266: ldc 144
    //   268: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_2
    //   272: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: goto -203 -> 78
    //   284: astore_2
    //   285: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -182 -> 106
    //   291: ldc 55
    //   293: iconst_2
    //   294: new 88	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   301: ldc 152
    //   303: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_2
    //   307: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: goto -210 -> 106
    //   319: astore_2
    //   320: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq -217 -> 106
    //   326: ldc 55
    //   328: iconst_2
    //   329: new 88	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   336: ldc 154
    //   338: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_2
    //   342: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: goto -245 -> 106
    //   354: astore_1
    //   355: ldc 55
    //   357: iconst_1
    //   358: ldc 155
    //   360: aload_1
    //   361: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: goto -170 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	msi
    //   0	367	1	paramContext	Context
    //   0	367	2	parammsj	msj
    //   41	178	3	l	long
    // Exception table:
    //   from	to	target	type
    //   66	78	249	java/lang/Exception
    //   90	106	284	java/lang/InternalError
    //   90	106	319	java/lang/IncompatibleClassChangeError
    //   184	194	354	java/lang/Throwable
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("PhoneStatusMonitor", 2, "updateCallingState, pre[" + this.jdField_a_of_type_Boolean + "], cur[" + paramBoolean + "]");
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Msj != null) {
        this.jdField_a_of_type_Msj.a(this.jdField_a_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Boolean);
    d();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidTelephonyPhoneStateListener == null)) {
      return;
    }
    d();
    msm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    QLog.d("PhoneStatusMonitor", 1, "PhoneStatusMonitor.unregisterReceiver()");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Msk);
      this.jdField_a_of_type_Msj = null;
      this.jdField_a_of_type_Msk = null;
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PhoneStatusMonitor", 1, "unregisterReceiver", localThrowable);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    a();
  }
  
  public void c()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "checkCalling, begin, isCalling[" + this.jdField_a_of_type_Boolean + "], isChecking[" + bool + "]");
    }
    if (bool) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.excute(new PhoneStatusMonitor.2(this), 16, null, false);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "clearTillEnd, calling[" + this.jdField_a_of_type_Boolean + "], tillEnd[" + this.b.get() + "]");
    }
    this.b.set(false);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "checkEndOfCall, calling[" + this.jdField_a_of_type_Boolean + "]");
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.b.set(true);
    c();
  }
  
  protected void finalize()
  {
    try
    {
      a();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msi
 * JD-Core Version:    0.7.0.1
 */