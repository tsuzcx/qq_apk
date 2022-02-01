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

public class ovw
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<ovx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<ovx> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  @Nullable
  private ovy jdField_a_of_type_Ovy;
  @Nullable
  private ovz jdField_a_of_type_Ovz;
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      localObject = (ovx)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ovx)localObject).a())
      {
        local4 = new Automator.4(this, (ovx)localObject);
        if (((ovx)localObject).c()) {
          local4.run();
        }
      }
    }
    while (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      Automator.4 local4;
      return;
      Object localObject = this.jdField_a_of_type_Ovz;
      if (localObject != null)
      {
        ((ovz)localObject).a(local4);
        return;
      }
      new Thread(local4).start();
      return;
      b(new Automator.5(this, (ovx)localObject));
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  @Nullable
  public final ovy a()
  {
    return this.jdField_a_of_type_Ovy;
  }
  
  @Nullable
  public final ovz a()
  {
    return this.jdField_a_of_type_Ovz;
  }
  
  public final void a()
  {
    b(new Automator.3(this));
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public final void a(@NotNull ovx paramovx)
  {
    b(new Automator.6(this, paramovx));
  }
  
  public final void a(@Nullable ovy paramovy)
  {
    this.jdField_a_of_type_Ovy = paramovy;
  }
  
  public final void a(@Nullable ovz paramovz)
  {
    this.jdField_a_of_type_Ovz = paramovz;
  }
  
  public final void a(@NotNull ovx[] paramArrayOfovx, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfovx, paramBoolean));
  }
  
  public final void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ovx)localIterator.next()).a();
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
 * Qualified Name:     ovw
 * JD-Core Version:    0.7.0.1
 */