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

public class onz
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<ooa> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<ooa> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  @Nullable
  private oob jdField_a_of_type_Oob;
  @Nullable
  private ooc jdField_a_of_type_Ooc;
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      localObject = (ooa)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ooa)localObject).a())
      {
        local4 = new Automator.4(this, (ooa)localObject);
        if (((ooa)localObject).c()) {
          local4.run();
        }
      }
    }
    while (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      Automator.4 local4;
      return;
      Object localObject = this.jdField_a_of_type_Ooc;
      if (localObject != null)
      {
        ((ooc)localObject).a(local4);
        return;
      }
      new Thread(local4).start();
      return;
      b(new Automator.5(this, (ooa)localObject));
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  @Nullable
  public final oob a()
  {
    return this.jdField_a_of_type_Oob;
  }
  
  @Nullable
  public final ooc a()
  {
    return this.jdField_a_of_type_Ooc;
  }
  
  public final void a()
  {
    b(new Automator.3(this));
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public final void a(@NotNull ooa paramooa)
  {
    b(new Automator.6(this, paramooa));
  }
  
  public final void a(@Nullable oob paramoob)
  {
    this.jdField_a_of_type_Oob = paramoob;
  }
  
  public final void a(@Nullable ooc paramooc)
  {
    this.jdField_a_of_type_Ooc = paramooc;
  }
  
  public final void a(@NotNull ooa[] paramArrayOfooa, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfooa, paramBoolean));
  }
  
  public final void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ooa)localIterator.next()).a();
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
 * Qualified Name:     onz
 * JD-Core Version:    0.7.0.1
 */