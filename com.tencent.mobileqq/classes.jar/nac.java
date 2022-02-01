import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nac
  implements Handler.Callback
{
  int jdField_a_of_type_Int = -2147483648;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  mzq jdField_a_of_type_Mzq;
  nbh jdField_a_of_type_Nbh;
  nbj jdField_a_of_type_Nbj;
  nbk<naf> jdField_a_of_type_Nbk;
  nbl jdField_a_of_type_Nbl;
  volatile boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = -2147483648;
  boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public nac(AVGameAppInterface paramAVGameAppInterface, nbj paramnbj, nbl paramnbl, nbh paramnbh, nbk<naf> paramnbk)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Nbh = paramnbh;
    this.jdField_a_of_type_Nbk = paramnbk;
    this.jdField_a_of_type_Nbj = paramnbj;
    this.jdField_a_of_type_Nbl = paramnbl;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getUIHandler().getLooper(), this);
  }
  
  private void a(naf paramnaf)
  {
    if (this.jdField_b_of_type_Boolean) {}
    mzq localmzq;
    do
    {
      return;
      localmzq = paramnaf.a();
    } while ((localmzq == null) || (localmzq.a(this.jdField_a_of_type_Mzq)));
    this.jdField_a_of_type_Mzq = localmzq;
    if (this.jdField_a_of_type_Int == -2147483648) {}
    for (int i = 1;; i = this.jdField_a_of_type_Int + 1)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_b_of_type_Int != -2147483648) {
        break;
      }
      this.jdField_b_of_type_Int = paramnaf.g();
      this.c = paramnaf.d();
      return;
    }
  }
  
  private void a(naf paramnaf, int paramInt)
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
  
  private void b(naf paramnaf, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, "handleTopicCountReport status=" + paramnaf.a());
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    switch (paramnaf.a())
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
      a(paramnaf);
      return;
    case 2: 
    case 3: 
    case 4: 
      a(paramnaf);
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
    long l1 = this.jdField_a_of_type_Nbj.b();
    long l2 = this.jdField_a_of_type_Nbj.a();
    long l3 = SystemClock.elapsedRealtime();
    long l4 = this.jdField_a_of_type_Nbl.a();
    if ((l3 - l1 < 10000L) && (l2 == l4))
    {
      QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleStatusTimeout exit!!! [heartBeatSeq,localSeq]=[%d,%d] [heartBeatTs,curTs]=[%d,%d]", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l3) }));
      this.jdField_a_of_type_Nbh.a(9, BaseApplicationImpl.getApplication().getString(2131690295), (naf)this.jdField_a_of_type_Nbk.a());
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Mzq = null;
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
    mzt.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - this.jdField_a_of_type_Int, this.c);
  }
  
  public void a()
  {
    c();
    b();
    e();
  }
  
  public void a(naf paramnaf, boolean paramBoolean)
  {
    boolean bool = paramnaf.c();
    int j = paramnaf.a();
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
      b(paramnaf, paramBoolean);
      return;
      c();
      if (bool)
      {
        b();
        int m = paramnaf.a().a.d * 1000;
        int k = paramnaf.a().a.c;
        int n = paramnaf.a().d();
        int i = 0;
        if (m > n) {
          i = m - n;
        }
        a(paramnaf, i + k * 1000);
        continue;
        c();
        if (bool)
        {
          b();
          a(paramnaf, paramnaf.a().a.c * 1000 - paramnaf.a().e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nac
 * JD-Core Version:    0.7.0.1
 */