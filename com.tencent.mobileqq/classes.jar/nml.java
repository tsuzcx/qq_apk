import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.2;
import com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.3;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;

public class nml
{
  public int a;
  protected long a;
  public Handler a;
  private SplitedProgressBar jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar;
  public WeakReference<vrr> a;
  public Timer a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  public boolean a;
  public long b;
  public long c;
  
  public nml(SplitedProgressBar paramSplitedProgressBar)
  {
    this.jdField_a_of_type_AndroidOsHandler = new nmm(this, Looper.getMainLooper());
    if (paramSplitedProgressBar == null) {
      throw new InvalidParameterException("ProgressControler: progressBar is null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = paramSplitedProgressBar;
  }
  
  private void d()
  {
    Timer localTimer = new Timer();
    ProgressControler.3 local3 = new ProgressControler.3(this);
    localTimer.scheduleAtFixedRate(local3, 0L, 50L);
    this.jdField_a_of_type_JavaUtilTimer = localTimer;
    this.jdField_a_of_type_JavaUtilTimerTask = local3;
  }
  
  protected void a()
  {
    ProgressControler.2 local2 = new ProgressControler.2(this);
    this.jdField_a_of_type_AndroidOsHandler.post(local2);
  }
  
  protected void a(int paramInt, long paramLong)
  {
    int j = 100;
    int i = 0;
    if (this.b > 0L)
    {
      int k = (int)paramLong * 100 / (int)this.b;
      i = k;
      if (k > 100) {
        i = j;
      }
    }
    for (;;)
    {
      if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.b))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ProgressControler", 2, "setProgressNow index < 0 || index >= mProgressBar.mTotalCount, index = " + paramInt + ", mTotalCount = " + this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.b);
        }
        if (this.jdField_a_of_type_JavaUtilTimer != null) {
          this.jdField_a_of_type_JavaUtilTimer.cancel();
        }
        if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
          this.jdField_a_of_type_JavaUtilTimerTask.cancel();
        }
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(paramInt, i);
      return;
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, vrr paramvrr)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.c = this.jdField_a_of_type_Long;
    this.b = paramLong2;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramLong2 <= 0L)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvrr);
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    d();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nml
 * JD-Core Version:    0.7.0.1
 */