import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.2;
import org.jetbrains.annotations.NotNull;

public final class oua
  extends ouc
  implements ouf
{
  private int jdField_a_of_type_Int;
  private final ouc[] jdField_a_of_type_ArrayOfOuc;
  
  public oua(@NotNull oub paramoub, @NotNull ouc[] paramArrayOfouc)
  {
    super(paramoub, false, "AsyncSteps");
    this.jdField_a_of_type_ArrayOfOuc = paramArrayOfouc;
    paramoub = this.jdField_a_of_type_ArrayOfOuc;
    int j = paramoub.length;
    while (i < j)
    {
      paramoub[i].a(this);
      i += 1;
    }
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
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    a("AsyncSteps onEnd: mFinishCount = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfOuc.length) {
      d();
    }
  }
  
  public boolean b()
  {
    ouc[] arrayOfouc = this.jdField_a_of_type_ArrayOfOuc;
    int j = arrayOfouc.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfouc[i];
      AsyncSteps.1 local1;
      if (((ouc)localObject).a())
      {
        local1 = new AsyncSteps.1(this, (ouc)localObject);
        if (((ouc)localObject).c()) {
          local1.run();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = a().a();
        if (localObject != null)
        {
          ((oue)localObject).a(local1);
        }
        else
        {
          new Thread(local1).start();
          continue;
          a().b(new AsyncSteps.2(this, (ouc)localObject));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oua
 * JD-Core Version:    0.7.0.1
 */