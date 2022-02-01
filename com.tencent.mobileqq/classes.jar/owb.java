import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.2;
import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class owb
  extends ovx
  implements owa
{
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final ovx[] jdField_a_of_type_ArrayOfOvx;
  
  public owb(@NotNull ovw paramovw, @NotNull ovx[] paramArrayOfovx)
  {
    super(paramovw, false, "SyncSteps");
    this.jdField_a_of_type_ArrayOfOvx = paramArrayOfovx;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    int j = paramArrayOfovx.length;
    j = paramArrayOfovx.length;
    while (i < j)
    {
      paramArrayOfovx[i].a(this);
      i += 1;
    }
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, paramArrayOfovx);
  }
  
  public void a()
  {
    super.a();
    ovx[] arrayOfovx = this.jdField_a_of_type_ArrayOfOvx;
    int j = arrayOfovx.length;
    int i = 0;
    while (i < j)
    {
      arrayOfovx[i].a();
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    Collections.addAll(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_ArrayOfOvx);
    return true;
  }
  
  public final void b()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject = (ovx)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((ovx)localObject).a())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (ovx)localObject);
        if (((ovx)localObject).c())
        {
          local1.run();
          return;
        }
        localObject = a().a();
        if (localObject != null)
        {
          ((ovz)localObject).a(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      a().b(new SyncSteps.2(this, (ovx)localObject));
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
 * Qualified Name:     owb
 * JD-Core Version:    0.7.0.1
 */