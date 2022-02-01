import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.2;
import org.jetbrains.annotations.NotNull;

public final class ovv
  extends ovx
  implements owa
{
  private int jdField_a_of_type_Int;
  private final ovx[] jdField_a_of_type_ArrayOfOvx;
  
  public ovv(@NotNull ovw paramovw, @NotNull ovx[] paramArrayOfovx)
  {
    super(paramovw, false, "AsyncSteps");
    this.jdField_a_of_type_ArrayOfOvx = paramArrayOfovx;
    paramovw = this.jdField_a_of_type_ArrayOfOvx;
    int j = paramovw.length;
    while (i < j)
    {
      paramovw[i].a(this);
      i += 1;
    }
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
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    a("AsyncSteps onEnd: mFinishCount = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfOvx.length) {
      d();
    }
  }
  
  public boolean b()
  {
    ovx[] arrayOfovx = this.jdField_a_of_type_ArrayOfOvx;
    int j = arrayOfovx.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfovx[i];
      AsyncSteps.1 local1;
      if (((ovx)localObject).a())
      {
        local1 = new AsyncSteps.1(this, (ovx)localObject);
        if (((ovx)localObject).c()) {
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
          ((ovz)localObject).a(local1);
        }
        else
        {
          new Thread(local1).start();
          continue;
          a().b(new AsyncSteps.2(this, (ovx)localObject));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovv
 * JD-Core Version:    0.7.0.1
 */