import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.1;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.3;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.4;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.5;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class omo
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<omp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<omp> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  @Nullable
  private omq jdField_a_of_type_Omq;
  @Nullable
  private omr jdField_a_of_type_Omr;
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      localObject = (omp)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((omp)localObject).a())
      {
        local4 = new Automator.4(this, (omp)localObject);
        if (((omp)localObject).c()) {
          local4.run();
        }
      }
    }
    while (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      Automator.4 local4;
      return;
      Object localObject = this.jdField_a_of_type_Omr;
      if (localObject != null)
      {
        ((omr)localObject).a(local4);
        return;
      }
      new Thread(local4).start();
      return;
      b(new Automator.5(this, (omp)localObject));
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  @Nullable
  public final omq a()
  {
    return this.jdField_a_of_type_Omq;
  }
  
  @Nullable
  public final omr a()
  {
    return this.jdField_a_of_type_Omr;
  }
  
  public final void a()
  {
    b(new Automator.3(this));
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public final void a(@NotNull omp paramomp)
  {
    b(new Automator.6(this, paramomp));
  }
  
  public final void a(@Nullable omq paramomq)
  {
    this.jdField_a_of_type_Omq = paramomq;
  }
  
  public final void a(@Nullable omr paramomr)
  {
    this.jdField_a_of_type_Omr = paramomr;
  }
  
  public final void a(@NotNull omp[] paramArrayOfomp, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfomp, paramBoolean));
  }
  
  public final void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((omp)localIterator.next()).a();
    }
  }
  
  public void b(@NotNull Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omo
 * JD-Core Version:    0.7.0.1
 */