import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public class pmd
  extends pmb
  implements twy
{
  private SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean;
  
  public pmd(@NotNull pmc parampmc, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(parampmc, "RIJADSuperMaskPopupStep");
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramActivity);
  }
  
  private boolean b()
  {
    boolean bool = false;
    pmc localpmc = a();
    if (localpmc != null) {
      bool = localpmc.a();
    }
    return bool;
  }
  
  private void i()
  {
    tvi.a.a(new pme(this));
  }
  
  public void a()
  {
    super.a();
    twx.a().a(this);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (!pcl.c(paramInt))) {
      return;
    }
    int i = -1;
    if (paramInt == 0) {
      i = tvd.a.c().getAndAdd(1);
    }
    while (i != 0)
    {
      a(false);
      return;
      if (pcl.c(paramInt)) {
        i = tvd.a.d().getAndAdd(1);
      }
    }
    if (!(tve.a.a() instanceof AdvertisementInfo))
    {
      a(false);
      return;
    }
    if (tvi.a.b())
    {
      tvg.a.a("beginShowMask");
      if (b())
      {
        tvi.a.a(tuz.a.d());
        tvg.a.a("alertManagerShowAfter");
        tvg.a.a(tve.a.a(), false, "has high level float", null, "resource_use_key");
        a(false);
        return;
      }
      tvg.a.a("alertManagerShowNow");
      i();
      return;
    }
    tvi.a.a(tuz.a.d());
    twp.a("ReadInJoySuperMaskAd", "superMask not show, refreshNum = " + i);
    a(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (tvi.a.c()) {
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
    twx.a().a();
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
 * Qualified Name:     pmd
 * JD-Core Version:    0.7.0.1
 */