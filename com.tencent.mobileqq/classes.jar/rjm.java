import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class rjm
  implements amkq
{
  public rjm(FastWebActivity paramFastWebActivity) {}
  
  public void a()
  {
    FastWebActivity.b(this.a, true);
    QLog.d(FastWebActivity.a(this.a), 1, "onPageSwipeClose");
  }
  
  public void b()
  {
    if (FastWebActivity.a(this.a) == 0L)
    {
      FastWebActivity.a(this.a, NetConnInfoCenter.getServerTime());
      QLog.d(FastWebActivity.a(this.a), 1, "onPageSwipeNotClose time :" + FastWebActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjm
 * JD-Core Version:    0.7.0.1
 */