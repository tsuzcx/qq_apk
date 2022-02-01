import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.2;
import org.jetbrains.annotations.NotNull;

public final class ony
  extends ooa
  implements ood
{
  private int jdField_a_of_type_Int;
  private final ooa[] jdField_a_of_type_ArrayOfOoa;
  
  public ony(@NotNull onz paramonz, @NotNull ooa[] paramArrayOfooa)
  {
    super(paramonz, false, "AsyncSteps");
    this.jdField_a_of_type_ArrayOfOoa = paramArrayOfooa;
    paramonz = this.jdField_a_of_type_ArrayOfOoa;
    int j = paramonz.length;
    while (i < j)
    {
      paramonz[i].a(this);
      i += 1;
    }
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
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    a("AsyncSteps onEnd: mFinishCount = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfOoa.length) {
      d();
    }
  }
  
  public boolean b()
  {
    ooa[] arrayOfooa = this.jdField_a_of_type_ArrayOfOoa;
    int j = arrayOfooa.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfooa[i];
      AsyncSteps.1 local1;
      if (((ooa)localObject).a())
      {
        local1 = new AsyncSteps.1(this, (ooa)localObject);
        if (((ooa)localObject).c()) {
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
          ((ooc)localObject).a(local1);
        }
        else
        {
          new Thread(local1).start();
          continue;
          a().b(new AsyncSteps.2(this, (ooa)localObject));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ony
 * JD-Core Version:    0.7.0.1
 */