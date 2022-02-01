import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.2;
import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class omt
  extends omp
  implements oms
{
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final omp[] jdField_a_of_type_ArrayOfOmp;
  
  public omt(@NotNull omo paramomo, @NotNull omp[] paramArrayOfomp)
  {
    super(paramomo, false, "SyncSteps");
    this.jdField_a_of_type_ArrayOfOmp = paramArrayOfomp;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    int j = paramArrayOfomp.length;
    j = paramArrayOfomp.length;
    while (i < j)
    {
      paramArrayOfomp[i].a(this);
      i += 1;
    }
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, paramArrayOfomp);
  }
  
  public void a()
  {
    super.a();
    omp[] arrayOfomp = this.jdField_a_of_type_ArrayOfOmp;
    int j = arrayOfomp.length;
    int i = 0;
    while (i < j)
    {
      arrayOfomp[i].a();
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ArrayOfOmp);
    return true;
  }
  
  public final void b()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject = (omp)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((omp)localObject).a())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (omp)localObject);
        if (((omp)localObject).c())
        {
          local1.run();
          return;
        }
        localObject = a().a();
        if (localObject != null)
        {
          ((omr)localObject).a(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      a().b(new SyncSteps.2(this, (omp)localObject));
      return;
    }
    d();
  }
  
  public boolean b()
  {
    b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omt
 * JD-Core Version:    0.7.0.1
 */