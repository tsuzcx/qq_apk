import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.1;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.2;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.3;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.4;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.5;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import mqq.os.MqqHandler;

public class tep
  implements teo
{
  private List<ten> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private teq jdField_a_of_type_Teq;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (ten)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull ten paramten, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramten.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramten.a(paramConcurrentHashMap);
    if (!paramten.a())
    {
      if (this.jdField_a_of_type_Teq != null) {
        this.jdField_a_of_type_Teq.b();
      }
      a();
      return;
    }
    if (paramten.jdField_a_of_type_Boolean)
    {
      paramten.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramten));
  }
  
  public tep a(@NonNull ten paramten)
  {
    paramten.jdField_a_of_type_Teo = this;
    this.jdField_a_of_type_JavaUtilList.add(paramten);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Teq = null;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public void a(@NonNull teq paramteq)
  {
    this.jdField_a_of_type_Teq = paramteq;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Teq != null) {
        this.jdField_a_of_type_Teq.c();
      }
      a();
      return;
    }
    ten localten = (ten)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localten.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localten.a(localten.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localten));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localten));
      return;
    }
    if (this.jdField_a_of_type_Teq != null) {
      this.jdField_a_of_type_Teq.b();
    }
    localten.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Teq != null) {
        this.jdField_a_of_type_Teq.c();
      }
      a();
    }
    ten localten;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localten = (ten)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Teq != null) {
        this.jdField_a_of_type_Teq.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localten));
    return;
    label108:
    if (this.jdField_a_of_type_Teq != null) {
      this.jdField_a_of_type_Teq.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tep
 * JD-Core Version:    0.7.0.1
 */