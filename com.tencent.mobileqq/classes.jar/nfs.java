import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nfs
  implements Handler.Callback
{
  int jdField_a_of_type_Int = -2147483648;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  nfh jdField_a_of_type_Nfh;
  ngx jdField_a_of_type_Ngx;
  ngz jdField_a_of_type_Ngz;
  nha<nfv> jdField_a_of_type_Nha;
  nhb jdField_a_of_type_Nhb;
  volatile boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = -2147483648;
  boolean jdField_b_of_type_Boolean;
  int c = 0;
  
  public nfs(AVGameAppInterface paramAVGameAppInterface, ngz paramngz, nhb paramnhb, ngx paramngx, nha<nfv> paramnha)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Ngx = paramngx;
    this.jdField_a_of_type_Nha = paramnha;
    this.jdField_a_of_type_Ngz = paramngz;
    this.jdField_a_of_type_Nhb = paramnhb;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getUIHandler().getLooper(), this);
  }
  
  private void a(nfv paramnfv)
  {
    if (this.jdField_b_of_type_Boolean) {}
    nfh localnfh;
    do
    {
      return;
      localnfh = paramnfv.a();
    } while ((localnfh == null) || (localnfh.a(this.jdField_a_of_type_Nfh)));
    this.jdField_a_of_type_Nfh = localnfh;
    if (this.jdField_a_of_type_Int == -2147483648) {}
    for (int i = 1;; i = this.jdField_a_of_type_Int + 1)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_b_of_type_Int != -2147483648) {
        break;
      }
      this.jdField_b_of_type_Int = paramnfv.g();
      this.c = paramnfv.d();
      return;
    }
  }
  
  private void a(nfv paramnfv, int paramInt)
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
  
  private void b(nfv paramnfv, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.StatusMonitor", 2, "handleTopicCountReport status=" + paramnfv.a());
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    switch (paramnfv.a())
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
      a(paramnfv);
      return;
    case 2: 
    case 3: 
    case 4: 
      a(paramnfv);
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
    long l1 = this.jdField_a_of_type_Ngz.b();
    long l2 = this.jdField_a_of_type_Ngz.a();
    long l3 = SystemClock.elapsedRealtime();
    long l4 = this.jdField_a_of_type_Nhb.a();
    if ((l3 - l1 < 10000L) && (l2 == l4))
    {
      QLog.d("avgame_logic.StatusMonitor", 1, String.format("handleStatusTimeout exit!!! [heartBeatSeq,localSeq]=[%d,%d] [heartBeatTs,curTs]=[%d,%d]", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l3) }));
      this.jdField_a_of_type_Ngx.a(9, BaseApplicationImpl.getApplication().getString(2131690333), (nfv)this.jdField_a_of_type_Nha.a());
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Nfh = null;
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
    nfk.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - this.jdField_a_of_type_Int, this.c);
  }
  
  public void a()
  {
    c();
    b();
    e();
  }
  
  public void a(nfv paramnfv, boolean paramBoolean)
  {
    boolean bool = paramnfv.c();
    int j = paramnfv.a();
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
      b(paramnfv, paramBoolean);
      return;
      c();
      if (bool)
      {
        b();
        int m = paramnfv.a().a.d * 1000;
        int k = paramnfv.a().a.c;
        int n = paramnfv.a().d();
        int i = 0;
        if (m > n) {
          i = m - n;
        }
        a(paramnfv, i + k * 1000);
        continue;
        c();
        if (bool)
        {
          b();
          a(paramnfv, paramnfv.a().a.c * 1000 - paramnfv.a().e());
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
 * Qualified Name:     nfs
 * JD-Core Version:    0.7.0.1
 */