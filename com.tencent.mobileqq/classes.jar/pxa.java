import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public class pxa
  extends pwy
  implements ukz
{
  private SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean;
  
  public pxa(@NotNull pwz parampwz, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(parampwz, "RIJADSuperMaskPopupStep");
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramActivity);
  }
  
  private boolean b()
  {
    boolean bool = false;
    pwz localpwz = a();
    if (localpwz != null) {
      bool = localpwz.a();
    }
    return bool;
  }
  
  private void i()
  {
    ujj.a.a(new pxb(this));
  }
  
  public void a()
  {
    super.a();
    uky.a().a(this);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (!plm.c(paramInt))) {
      return;
    }
    int i = -1;
    if (paramInt == 0) {
      i = ujd.a.c().getAndAdd(1);
    }
    while (i != 0)
    {
      a(false);
      ujj.a.a(4);
      return;
      if (plm.c(paramInt)) {
        i = ujd.a.d().getAndAdd(1);
      }
    }
    if (!(uje.a.a() instanceof AdvertisementInfo))
    {
      a(false);
      ujj.a.a(4);
      return;
    }
    if (ujj.a.b())
    {
      ujg.a.a("beginShowMask", "");
      if (b())
      {
        ujj.a.a(4);
        ujg.a.a("alertManagerShowAfter", "");
        ujg.a.a(uje.a.a(), false, "has high level float", null, "resource_use_key");
        a(false);
        return;
      }
      ujg.a.a("alertManagerShowNow", "");
      i();
      return;
    }
    ujj.a.a(4);
    ukq.a("ReadInJoySuperMaskAd", "superMask not show, refreshNum = " + i);
    a(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (ujj.a.c()) {
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
    uky.a().a();
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
 * Qualified Name:     pxa
 * JD-Core Version:    0.7.0.1
 */