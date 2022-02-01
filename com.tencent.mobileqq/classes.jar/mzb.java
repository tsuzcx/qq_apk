import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class mzb
  implements Handler.Callback
{
  int jdField_a_of_type_Int = -2147483648;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  myp jdField_a_of_type_Myp;
  nag jdField_a_of_type_Nag;
  nai jdField_a_of_type_Nai;
  naj<mze> jdField_a_of_type_Naj;
  nak jdField_a_of_type_Nak;
  volatile boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = -2147483648;
  boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public mzb(AVGameAppInterface paramAVGameAppInterface, nai paramnai, nak paramnak, nag paramnag, naj<mze> paramnaj)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Nag = paramnag;
    this.jdField_a_of_type_Naj = paramnaj;
    this.jdField_a_of_type_Nai = paramnai;
    this.jdField_a_of_type_Nak = paramnak;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getUIHandler().getLooper(), this);
  }
  
  private void a(mze parammze)
  {
    if (this.jdField_b_of_type_Boolean) {}
    myp localmyp;
    do
    {
      return;
      localmyp = parammze.a();
    } while ((localmyp == null) || (localmyp.a(this.jdField_a_of_type_Myp)));
    this.jdField_a_of_type_Myp = localmyp;
    if (this.jdField_a_of_type_Int == -2147483648) {}
    for (int i = 1;; i = this.jdField_a_of_type_Int + 1)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_b_of_type_Int != -2147483648) {
        break;
      }
      this.jdField_b_of_type_Int = parammze.g();
      this.c = parammze.d();
      return;
    }
  }
  
  private void a(mze parammze, int paramInt)
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
  
  private void b(mze parammze, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, "handleTopicCountReport status=" + parammze.a());
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    switch (parammze.a())
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
      a(parammze);
      return;
    case 2: 
    case 3: 
    case 4: 
      a(parammze);
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
    long l1 = this.jdField_a_of_type_Nai.b();
    long l2 = this.jdField_a_of_type_Nai.a();
    long l3 = SystemClock.elapsedRealtime();
    long l4 = this.jdField_a_of_type_Nak.a();
    if ((l3 - l1 < 10000L) && (l2 == l4))
    {
      QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleStatusTimeout exit!!! [heartBeatSeq,localSeq]=[%d,%d] [heartBeatTs,curTs]=[%d,%d]", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l3) }));
      this.jdField_a_of_type_Nag.a(9, BaseApplicationImpl.getApplication().getString(2131690270), (mze)this.jdField_a_of_type_Naj.a());
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Myp = null;
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
    mys.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - this.jdField_a_of_type_Int, this.c);
  }
  
  public void a()
  {
    c();
    b();
    e();
  }
  
  public void a(mze parammze, boolean paramBoolean)
  {
    boolean bool = parammze.c();
    int j = parammze.a();
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
      b(parammze, paramBoolean);
      return;
      c();
      if (bool)
      {
        b();
        int m = parammze.a().a.d * 1000;
        int k = parammze.a().a.c;
        int n = parammze.a().d();
        int i = 0;
        if (m > n) {
          i = m - n;
        }
        a(parammze, i + k * 1000);
        continue;
        c();
        if (bool)
        {
          b();
          a(parammze, parammze.a().a.c * 1000 - parammze.a().e());
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
 * Qualified Name:     mzb
 * JD-Core Version:    0.7.0.1
 */