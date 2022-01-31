import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.2;
import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class ohp
  extends ohl
  implements oho
{
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final ohl[] jdField_a_of_type_ArrayOfOhl;
  
  public ohp(@NotNull ohk paramohk, @NotNull ohl[] paramArrayOfohl)
  {
    super(paramohk, false, "SyncSteps");
    this.jdField_a_of_type_ArrayOfOhl = paramArrayOfohl;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    int j = paramArrayOfohl.length;
    j = paramArrayOfohl.length;
    while (i < j)
    {
      paramArrayOfohl[i].a(this);
      i += 1;
    }
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, paramArrayOfohl);
  }
  
  public void a()
  {
    super.a();
    ohl[] arrayOfohl = this.jdField_a_of_type_ArrayOfOhl;
    int j = arrayOfohl.length;
    int i = 0;
    while (i < j)
    {
      arrayOfohl[i].a();
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ArrayOfOhl);
    return true;
  }
  
  public final void b()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject = (ohl)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ohl)localObject).a())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (ohl)localObject);
        if (((ohl)localObject).c())
        {
          local1.run();
          return;
        }
        localObject = a().a();
        if (localObject != null)
        {
          ((ohn)localObject).a(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      a().b(new SyncSteps.2(this, (ohl)localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohp
 * JD-Core Version:    0.7.0.1
 */