import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.2;
import org.jetbrains.annotations.NotNull;

public final class ohj
  extends ohl
  implements oho
{
  private int jdField_a_of_type_Int;
  private final ohl[] jdField_a_of_type_ArrayOfOhl;
  
  public ohj(@NotNull ohk paramohk, @NotNull ohl[] paramArrayOfohl)
  {
    super(paramohk, false, "AsyncSteps");
    this.jdField_a_of_type_ArrayOfOhl = paramArrayOfohl;
    paramohk = this.jdField_a_of_type_ArrayOfOhl;
    int j = paramohk.length;
    while (i < j)
    {
      paramohk[i].a(this);
      i += 1;
    }
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
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    a("AsyncSteps onEnd: mFinishCount = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfOhl.length) {
      d();
    }
  }
  
  public boolean b()
  {
    ohl[] arrayOfohl = this.jdField_a_of_type_ArrayOfOhl;
    int j = arrayOfohl.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfohl[i];
      AsyncSteps.1 local1;
      if (((ohl)localObject).a())
      {
        local1 = new AsyncSteps.1(this, (ohl)localObject);
        if (((ohl)localObject).c()) {
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
          ((ohn)localObject).a(local1);
        }
        else
        {
          new Thread(local1).start();
          continue;
          a().b(new AsyncSteps.2(this, (ohl)localObject));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohj
 * JD-Core Version:    0.7.0.1
 */