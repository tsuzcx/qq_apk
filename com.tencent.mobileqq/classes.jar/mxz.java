import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class mxz
  implements Handler.Callback
{
  int jdField_a_of_type_Int = -2147483648;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  mxq jdField_a_of_type_Mxq;
  mzd jdField_a_of_type_Mzd;
  mzf jdField_a_of_type_Mzf;
  mzg<myc> jdField_a_of_type_Mzg;
  mzh jdField_a_of_type_Mzh;
  volatile boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = -2147483648;
  boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public mxz(AVGameAppInterface paramAVGameAppInterface, mzf parammzf, mzh parammzh, mzd parammzd, mzg<myc> parammzg)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mzd = parammzd;
    this.jdField_a_of_type_Mzg = parammzg;
    this.jdField_a_of_type_Mzf = parammzf;
    this.jdField_a_of_type_Mzh = parammzh;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getUIHandler().getLooper(), this);
  }
  
  private void a(myc parammyc)
  {
    if (this.jdField_b_of_type_Boolean) {}
    mxq localmxq;
    do
    {
      return;
      localmxq = parammyc.a();
    } while ((localmxq == null) || (localmxq.a(this.jdField_a_of_type_Mxq)));
    this.jdField_a_of_type_Mxq = localmxq;
    if (this.jdField_a_of_type_Int == -2147483648) {}
    for (int i = 1;; i = this.jdField_a_of_type_Int + 1)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_b_of_type_Int != -2147483648) {
        break;
      }
      this.jdField_b_of_type_Int = parammyc.g();
      this.c = parammyc.d();
      return;
    }
  }
  
  private void a(myc parammyc, int paramInt)
  {
    paramInt += 10000;
    if (paramInt <= 0)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramInt);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  private void b(myc parammyc, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, "handleTopicCountReport status=" + parammyc.a());
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    switch (parammyc.a())
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return;
    case 1: 
      f();
      e();
      a(parammyc);
      return;
    case 2: 
    case 3: 
    case 4: 
      a(parammyc);
      return;
    }
    f();
    e();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void d()
  {
    long l1 = this.jdField_a_of_type_Mzf.b();
    long l2 = this.jdField_a_of_type_Mzf.a();
    long l3 = SystemClock.elapsedRealtime();
    long l4 = this.jdField_a_of_type_Mzh.a();
    if ((l3 - l1 < 10000L) && (l2 == l4))
    {
      QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleStatusTimeout exit!!! [heartBeatSeq,localSeq]=[%d,%d] [heartBeatTs,curTs]=[%d,%d]", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l3) }));
      this.jdField_a_of_type_Mzd.a(9, BaseApplicationImpl.getApplication().getString(2131690264), (myc)this.jdField_a_of_type_Mzg.a());
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Mxq = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
    this.c = 0;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, String.format("doReportTopicCountIfNeed [inSnapshotRound=%b count=%d expectCount=%d gType=%d]", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c) }));
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == -2147483648) || (this.jdField_b_of_type_Int == -2147483648)) {}
    while (this.jdField_b_of_type_Int <= this.jdField_a_of_type_Int) {
      return;
    }
    mxt.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - this.jdField_a_of_type_Int, this.c);
  }
  
  public void a()
  {
    c();
    b();
    e();
  }
  
  public void a(myc parammyc, boolean paramBoolean)
  {
    boolean bool = parammyc.c();
    int j = parammyc.a();
    switch (j)
    {
    default: 
      b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.StatusMonitor", 2, "onStatusChanged " + j);
      }
      b(parammyc, paramBoolean);
      return;
      c();
      if (bool)
      {
        b();
        int m = parammyc.a().a.d * 1000;
        int k = parammyc.a().a.c;
        int n = parammyc.a().d();
        int i = 0;
        if (m > n) {
          i = m - n;
        }
        a(parammyc, i + k * 1000);
        continue;
        c();
        if (bool)
        {
          b();
          a(parammyc, parammyc.a().a.c * 1000 - parammyc.a().e());
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxz
 * JD-Core Version:    0.7.0.1
 */