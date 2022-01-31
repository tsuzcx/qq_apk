import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class oyh
  extends oyf
  implements oel
{
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private ofh jdField_a_of_type_Ofh;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public oyh(@NotNull oyg paramoyg, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramoyg, "RIJADSuperMaskPopupStep");
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
  }
  
  private void i()
  {
    this.jdField_a_of_type_Boolean = false;
    if (oek.a().a() == 1)
    {
      j();
      return;
    }
    if (oek.a().e())
    {
      a(false);
      return;
    }
    if (this.b)
    {
      a(false);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void j()
  {
    if (oek.a().jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Ofh == null) {
        this.jdField_a_of_type_Ofh = new ofh();
      }
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      this.jdField_a_of_type_Ofh.a(localActivity, oek.a().a());
      a(true);
    }
    for (;;)
    {
      oek.a().jdField_a_of_type_Boolean = false;
      return;
      a(false);
    }
  }
  
  public void a()
  {
    super.a();
    oek.a().a(this);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if ((paramInt != 0) || (oek.a().a() != 1)) {
        break label42;
      }
      j();
    }
    for (;;)
    {
      if (paramInt == 0) {
        oek.a().jdField_a_of_type_Boolean = false;
      }
      return;
      label42:
      a(false);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      if (paramBoolean) {
        break label35;
      }
    }
    label35:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.b = paramBoolean;
      if ((this.b) && (this.jdField_a_of_type_Boolean)) {
        a(false);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_Ofh != null) && (this.jdField_a_of_type_Ofh.a())) {
      this.jdField_a_of_type_Ofh.a();
    }
  }
  
  public boolean b()
  {
    return super.b();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
  }
  
  public void e()
  {
    super.e();
  }
  
  public void f()
  {
    super.f();
  }
  
  protected void g()
  {
    i();
  }
  
  protected void h()
  {
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oyh
 * JD-Core Version:    0.7.0.1
 */