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

public class oub
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<ouc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<ouc> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  @Nullable
  private oud jdField_a_of_type_Oud;
  @Nullable
  private oue jdField_a_of_type_Oue;
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      localObject = (ouc)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ouc)localObject).a())
      {
        local4 = new Automator.4(this, (ouc)localObject);
        if (((ouc)localObject).c()) {
          local4.run();
        }
      }
    }
    while (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      Automator.4 local4;
      return;
      Object localObject = this.jdField_a_of_type_Oue;
      if (localObject != null)
      {
        ((oue)localObject).a(local4);
        return;
      }
      new Thread(local4).start();
      return;
      b(new Automator.5(this, (ouc)localObject));
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  @Nullable
  public final oud a()
  {
    return this.jdField_a_of_type_Oud;
  }
  
  @Nullable
  public final oue a()
  {
    return this.jdField_a_of_type_Oue;
  }
  
  public final void a()
  {
    b(new Automator.3(this));
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public final void a(@NotNull ouc paramouc)
  {
    b(new Automator.6(this, paramouc));
  }
  
  public final void a(@Nullable oud paramoud)
  {
    this.jdField_a_of_type_Oud = paramoud;
  }
  
  public final void a(@Nullable oue paramoue)
  {
    this.jdField_a_of_type_Oue = paramoue;
  }
  
  public final void a(@NotNull ouc[] paramArrayOfouc, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfouc, paramBoolean));
  }
  
  public final void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ouc)localIterator.next()).a();
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
 * Qualified Name:     oub
 * JD-Core Version:    0.7.0.1
 */