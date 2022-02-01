import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.2;
import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class oug
  extends ouc
  implements ouf
{
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final ouc[] jdField_a_of_type_ArrayOfOuc;
  
  public oug(@NotNull oub paramoub, @NotNull ouc[] paramArrayOfouc)
  {
    super(paramoub, false, "SyncSteps");
    this.jdField_a_of_type_ArrayOfOuc = paramArrayOfouc;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    int j = paramArrayOfouc.length;
    j = paramArrayOfouc.length;
    while (i < j)
    {
      paramArrayOfouc[i].a(this);
      i += 1;
    }
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, paramArrayOfouc);
  }
  
  public void a()
  {
    super.a();
    ouc[] arrayOfouc = this.jdField_a_of_type_ArrayOfOuc;
    int j = arrayOfouc.length;
    int i = 0;
    while (i < j)
    {
      arrayOfouc[i].a();
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ArrayOfOuc);
    return true;
  }
  
  public final void b()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject = (ouc)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ouc)localObject).a())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (ouc)localObject);
        if (((ouc)localObject).c())
        {
          local1.run();
          return;
        }
        localObject = a().a();
        if (localObject != null)
        {
          ((oue)localObject).a(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      a().b(new SyncSteps.2(this, (ouc)localObject));
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
 * Qualified Name:     oug
 * JD-Core Version:    0.7.0.1
 */