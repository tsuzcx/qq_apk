import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.2;
import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class ooe
  extends ooa
  implements ood
{
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final ooa[] jdField_a_of_type_ArrayOfOoa;
  
  public ooe(@NotNull onz paramonz, @NotNull ooa[] paramArrayOfooa)
  {
    super(paramonz, false, "SyncSteps");
    this.jdField_a_of_type_ArrayOfOoa = paramArrayOfooa;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    int j = paramArrayOfooa.length;
    j = paramArrayOfooa.length;
    while (i < j)
    {
      paramArrayOfooa[i].a(this);
      i += 1;
    }
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, paramArrayOfooa);
  }
  
  public void a()
  {
    super.a();
    ooa[] arrayOfooa = this.jdField_a_of_type_ArrayOfOoa;
    int j = arrayOfooa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfooa[i].a();
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ArrayOfOoa);
    return true;
  }
  
  public final void b()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject = (ooa)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ooa)localObject).a())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (ooa)localObject);
        if (((ooa)localObject).c())
        {
          local1.run();
          return;
        }
        localObject = a().a();
        if (localObject != null)
        {
          ((ooc)localObject).a(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      a().b(new SyncSteps.2(this, (ooa)localObject));
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
 * Qualified Name:     ooe
 * JD-Core Version:    0.7.0.1
 */