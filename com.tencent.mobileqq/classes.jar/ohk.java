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

public class ohk
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<ohl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<ohl> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  @Nullable
  private ohm jdField_a_of_type_Ohm;
  @Nullable
  private ohn jdField_a_of_type_Ohn;
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      localObject = (ohl)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ohl)localObject).a())
      {
        local4 = new Automator.4(this, (ohl)localObject);
        if (((ohl)localObject).c()) {
          local4.run();
        }
      }
    }
    while (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      Automator.4 local4;
      return;
      Object localObject = this.jdField_a_of_type_Ohn;
      if (localObject != null)
      {
        ((ohn)localObject).a(local4);
        return;
      }
      new Thread(local4).start();
      return;
      b(new Automator.5(this, (ohl)localObject));
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  @Nullable
  public final ohm a()
  {
    return this.jdField_a_of_type_Ohm;
  }
  
  @Nullable
  public final ohn a()
  {
    return this.jdField_a_of_type_Ohn;
  }
  
  public final void a()
  {
    b(new Automator.3(this));
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public final void a(@NotNull ohl paramohl)
  {
    b(new Automator.6(this, paramohl));
  }
  
  public final void a(@Nullable ohm paramohm)
  {
    this.jdField_a_of_type_Ohm = paramohm;
  }
  
  public final void a(@Nullable ohn paramohn)
  {
    this.jdField_a_of_type_Ohn = paramohn;
  }
  
  public final void a(@NotNull ohl[] paramArrayOfohl, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfohl, paramBoolean));
  }
  
  public final void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ohl)localIterator.next()).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohk
 * JD-Core Version:    0.7.0.1
 */