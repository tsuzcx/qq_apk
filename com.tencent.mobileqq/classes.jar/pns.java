import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class pns
  extends pnq
  implements oqs
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private osa jdField_a_of_type_Osa;
  private boolean jdField_a_of_type_Boolean;
  
  public pns(@NotNull pnr parampnr, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(parampnr, "RIJADSuperMaskPopupStep");
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
  }
  
  private void i()
  {
    if ((oqr.a().a() == 1) && (oqr.e()))
    {
      if (this.jdField_a_of_type_Osa == null) {
        this.jdField_a_of_type_Osa = new osa();
      }
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      this.jdField_a_of_type_Osa.a(localActivity, oqr.a().a());
      a(true);
      return;
    }
    a(false);
  }
  
  public void a()
  {
    super.a();
    oqr.a().a(this);
  }
  
  public void a(int paramInt)
  {
    pnr localpnr = a();
    if (localpnr != null) {}
    for (boolean bool = localpnr.a();; bool = false)
    {
      oqh.a("ReadInJoySuperMaskAd", "refreshNum is " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " autoRefresh is " + pmy.a().a.jdField_a_of_type_Boolean + " showStatus is " + oqr.a().a() + " automatorFinished is " + bool);
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1) == 0) && (pmy.a().a.jdField_a_of_type_Boolean) && (!bool))
      {
        if ((oqr.a().c()) && (oqr.a().a() == 1)) {
          i();
        }
      }
      else {
        return;
      }
      a(false);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (oqr.a().c()) {
      if (paramBoolean) {
        break label33;
      }
    }
    label33:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Boolean) {
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
    if ((this.jdField_a_of_type_Osa != null) && (this.jdField_a_of_type_Osa.a())) {
      this.jdField_a_of_type_Osa.a();
    }
    oqr.a().d();
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
  
  protected void g() {}
  
  protected void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pns
 * JD-Core Version:    0.7.0.1
 */