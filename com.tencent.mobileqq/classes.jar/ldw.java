import android.os.Handler;
import android.os.Looper;
import com.tencent.av.VideoProcessExitMonitor.1;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class ldw
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public ldw(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 0;
    if (mnm.a().l == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      QLog.d("VideoProcessExitMonitor", 1, String.format("VideoProcessExitMonitor mExitProcessEnable=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
      return;
    }
  }
  
  private void a(long paramLong)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("startMsfRespTimeoutCheck timeout=%s", new Object[] { Long.valueOf(paramLong) }));
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_JavaLangRunnable = new VideoProcessExitMonitor.1(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  private void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusTimeout mCurStatus=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Int = 2;
      }
      c(this.jdField_a_of_type_Int);
      return;
    }
  }
  
  private void b(int paramInt)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("sendSetMsfConnStatusReq status=%s", new Object[] { Integer.valueOf(paramInt) }));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldz.class);
    localNewIntent.putExtra("reqType", 10);
    localNewIntent.putExtra("status", paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(localNewIntent);
  }
  
  private void c()
  {
    QLog.d("VideoProcessExitMonitor", 1, "exitProcess");
    long l = System.currentTimeMillis();
    QLog.flushLog(true);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().otherProcessExit(true);
    QLog.d("VideoProcessExitMonitor", 1, String.format("exitProcess time cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    try
    {
      Thread.sleep(300L);
      label66:
      System.exit(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label66;
    }
  }
  
  private void c(int paramInt)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("checkExitProcess status=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_Int == 2) {
      c();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("processActive mCurStatus=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      if (this.jdField_a_of_type_Int != 0)
      {
        b(2);
        this.jdField_a_of_type_Int = 0;
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusAck mCurStatus=%s status=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt) }));
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_JavaLangRunnable = null;
      }
      if ((paramInt == 1) && (this.jdField_a_of_type_Int == 1)) {
        this.jdField_a_of_type_Int = 2;
      }
      c(this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        QLog.d("VideoProcessExitMonitor", 1, String.format("processDeactive mCurStatus=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
        if (this.jdField_a_of_type_Int == 0)
        {
          b(1);
          a(2000L);
          this.jdField_a_of_type_Int = 1;
          c(this.jdField_a_of_type_Int);
          return;
        }
      }
      int i = this.jdField_a_of_type_Int;
      if (i != 1) {}
    }
  }
  
  public boolean a()
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("canExitProcess mAcceptMultiIncomingCall=%s mSwitch2MultiActive=%s mSwitch2MultiPassive=%s mSwitch2DoubleMeeting=%s mSwitch2OtherTerminal=%s mAllTerminalOffline=%s", new Object[] { Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g) }));
    return (!this.b) && (!this.c) && (!this.d) && (!this.e) && (!this.f) && (!this.g);
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setAcceptMultiIncomingCall acceptMultiIncomingCall=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiActive switch2MultiActive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiPassive switch2MultiPassive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.d = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2DoubleMeeting switch2DoubleMeeting=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.e = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2OtherTerminal switch2OtherTerminal=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.f = paramBoolean;
  }
  
  public void g(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setAllTerminalOffline allTerminalOffline=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ldw
 * JD-Core Version:    0.7.0.1
 */