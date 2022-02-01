import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class rlq
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private rll jdField_a_of_type_Rll;
  private rlm jdField_a_of_type_Rlm;
  
  private rlq(@NotNull rll paramrll)
  {
    this.jdField_a_of_type_Rll = paramrll;
  }
  
  private int a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Long > 0L) {
      l = NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long;
    }
    return (int)Math.max(l, 33L);
  }
  
  private Runnable a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    return new RIJRewardTaskTimingPresenter.1(this, paramInt1, paramString, paramInt2);
  }
  
  public static rlq a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return new rlq(new rln());
    }
    return new rlq(new rlp());
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 > 600000L)
    {
      bool1 = bool2;
      if (prj.a())
      {
        prj.b(paramInt1);
        bool1 = true;
      }
    }
    if ((paramInt1 > paramInt2) && (rjy.a()))
    {
      b();
      return true;
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean, RIJRewardTask paramRIJRewardTask, int paramInt)
  {
    boolean bool2 = false;
    int i = paramRIJRewardTask.c();
    boolean bool1 = bool2;
    if (i > prj.a())
    {
      bool1 = bool2;
      if (prj.a()) {
        bool1 = true;
      }
    }
    if (!paramBoolean)
    {
      paramBoolean = bool1;
      if (i <= paramInt) {}
    }
    else
    {
      paramBoolean = bool1;
      if (rjy.a()) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    RIJRewardTask localRIJRewardTask = this.jdField_a_of_type_Rll.a();
    if (localRIJRewardTask == null) {
      return;
    }
    QLog.i("RIJRewardTaskTimingPresenter", 1, "stop timing --> curTask: " + localRIJRewardTask.toString());
    this.jdField_a_of_type_Rll.a(localRIJRewardTask.a());
    this.jdField_a_of_type_Rll.b(localRIJRewardTask);
    this.jdField_a_of_type_Rll.a(null);
  }
  
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    int j = 0;
    RIJRewardTask localRIJRewardTask3 = this.jdField_a_of_type_Rll.b();
    RIJRewardTask localRIJRewardTask2 = this.jdField_a_of_type_Rll.a();
    RIJRewardTask localRIJRewardTask1 = localRIJRewardTask2;
    if (localRIJRewardTask2 == null)
    {
      localRIJRewardTask2 = new RIJRewardTask(paramString, paramInt2, paramInt1, 0);
      localRIJRewardTask1 = localRIJRewardTask2;
      if (localRIJRewardTask3 != null)
      {
        localRIJRewardTask1 = localRIJRewardTask2;
        if (localRIJRewardTask3.a().equals(localRIJRewardTask2.a()))
        {
          localRIJRewardTask2.a(localRIJRewardTask2.c() + localRIJRewardTask3.c());
          localRIJRewardTask1 = localRIJRewardTask2;
        }
      }
    }
    int i = j;
    if (this.jdField_a_of_type_Rll.a(paramString))
    {
      i = j;
      if (localRIJRewardTask3 != null)
      {
        i = j;
        if (!localRIJRewardTask3.a().equals(paramString)) {
          i = 1;
        }
      }
    }
    if (i != 0) {
      return;
    }
    this.jdField_a_of_type_Rll.a(localRIJRewardTask1);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaLangRunnable = a(paramString, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(rlm paramrlm)
  {
    this.jdField_a_of_type_Rlm = paramrlm;
  }
  
  public void b()
  {
    RIJRewardTask localRIJRewardTask = this.jdField_a_of_type_Rll.a();
    if (localRIJRewardTask == null) {
      return;
    }
    QLog.i("RIJRewardTaskTimingPresenter", 1, "report task progress --> task: " + localRIJRewardTask.toString());
    this.jdField_a_of_type_Rll.a(localRIJRewardTask.a(), localRIJRewardTask.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlq
 * JD-Core Version:    0.7.0.1
 */