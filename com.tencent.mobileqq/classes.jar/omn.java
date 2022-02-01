import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.2;
import org.jetbrains.annotations.NotNull;

public final class omn
  extends omp
  implements oms
{
  private int jdField_a_of_type_Int;
  private final omp[] jdField_a_of_type_ArrayOfOmp;
  
  public omn(@NotNull omo paramomo, @NotNull omp[] paramArrayOfomp)
  {
    super(paramomo, false, "AsyncSteps");
    this.jdField_a_of_type_ArrayOfOmp = paramArrayOfomp;
    paramomo = this.jdField_a_of_type_ArrayOfOmp;
    int j = paramomo.length;
    while (i < j)
    {
      paramomo[i].a(this);
      i += 1;
    }
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
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    a("AsyncSteps onEnd: mFinishCount = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfOmp.length) {
      d();
    }
  }
  
  public boolean b()
  {
    omp[] arrayOfomp = this.jdField_a_of_type_ArrayOfOmp;
    int j = arrayOfomp.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfomp[i];
      AsyncSteps.1 local1;
      if (((omp)localObject).a())
      {
        local1 = new AsyncSteps.1(this, (omp)localObject);
        if (((omp)localObject).c()) {
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
          ((omr)localObject).a(local1);
        }
        else
        {
          new Thread(local1).start();
          continue;
          a().b(new AsyncSteps.2(this, (omp)localObject));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omn
 * JD-Core Version:    0.7.0.1
 */