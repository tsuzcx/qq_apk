import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class pgr
  extends pgp
  implements tqj
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private trs jdField_a_of_type_Trs;
  private boolean jdField_a_of_type_Boolean;
  
  public pgr(@NotNull pgq parampgq, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(parampgq, "RIJADSuperMaskPopupStep");
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
  }
  
  private void i()
  {
    if ((tqi.a().a() == 1) && (tqi.f()))
    {
      if (this.jdField_a_of_type_Trs == null) {
        this.jdField_a_of_type_Trs = new trs();
      }
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      this.jdField_a_of_type_Trs.a(localActivity, tqi.a().a());
      a(true);
      return;
    }
    a(false);
  }
  
  public void a()
  {
    super.a();
    tqi.a().a(this);
  }
  
  public void a(int paramInt)
  {
    pgq localpgq = a();
    if (localpgq != null) {}
    for (boolean bool = localpgq.a();; bool = false)
    {
      tpx.a("ReadInJoySuperMaskAd", "refreshNum is " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " autoRefresh is " + pfs.a().a.jdField_a_of_type_Boolean + " showStatus is " + tqi.a().a() + " automatorFinished is " + bool);
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (pfs.a().a.jdField_a_of_type_Boolean) && (tqi.a().d()) && (tqi.a().a() == 1) && (bool)) {
        tqk.a.a(tqi.a().a(), false, "has high level float");
      }
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1) == 0) && (pfs.a().a.jdField_a_of_type_Boolean) && (!bool))
      {
        if ((tqi.a().d()) && (tqi.a().a() == 1)) {
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
    if (tqi.a().d()) {
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
    if ((this.jdField_a_of_type_Trs != null) && (this.jdField_a_of_type_Trs.a())) {
      this.jdField_a_of_type_Trs.a();
    }
    tqi.a().d();
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
 * Qualified Name:     pgr
 * JD-Core Version:    0.7.0.1
 */