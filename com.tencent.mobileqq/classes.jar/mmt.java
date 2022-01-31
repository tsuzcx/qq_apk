import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class mmt
  implements Runnable
{
  public mmt(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    FastWebActivity.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d(FastWebActivity.a(this.a), 2, "reset mIsWaitingForFavoriteResult = false, not to block request too long.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmt
 * JD-Core Version:    0.7.0.1
 */