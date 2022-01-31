import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ljk
  extends lhi
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<mcr> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile mav jdField_a_of_type_Mav;
  private WeakReference<mas> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile mav jdField_b_of_type_Mav;
  
  public ljk(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable = new TipsViewTimerRunnable(paramVideoAppInterface);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("NewTipsManager", 2, paramString);
  }
  
  private boolean b(mav parammav)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammav != null)
    {
      localObject1 = Integer.valueOf(parammav.b());
      a(localObject1);
      localObject1 = a();
      if ((parammav != null) && (localObject1 != null) && (((mas)localObject1).b())) {
        break label76;
      }
      bool1 = false;
    }
    label76:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "null";
        break;
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        bool1 = mav.a((mav)localObject2, parammav);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((mas)localObject1).b(parammav))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(parammav);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mav)localObject2).a());
    if (parammav.a())
    {
      this.jdField_b_of_type_Mav = null;
      return true;
    }
    this.jdField_b_of_type_Mav = ((mav)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(mav parammav)
  {
    if (parammav == null) {}
    do
    {
      return;
      if (parammav.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + parammav.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!parammav.equals(this.jdField_a_of_type_Mav));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + parammav.b());
    this.jdField_a_of_type_Mav = null;
  }
  
  private boolean c(mav parammav)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammav != null)
    {
      localObject1 = Integer.valueOf(parammav.b());
      a(localObject1);
      localObject1 = a();
      if ((parammav != null) && (localObject1 != null) && (((mas)localObject1).a())) {
        break label76;
      }
      bool1 = false;
    }
    label76:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "null";
        break;
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        bool1 = mav.a((mav)localObject2, parammav);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((mas)localObject1).a(parammav)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(parammav);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mav)localObject2).a());
    if (parammav.a())
    {
      this.jdField_a_of_type_Mav = null;
      return true;
    }
    this.jdField_a_of_type_Mav = ((mav)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((mav)localObject2).b());
    label210:
    return false;
  }
  
  private void d(mav parammav)
  {
    if (parammav == null) {}
    do
    {
      return;
      if (parammav.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + parammav.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!parammav.equals(this.jdField_b_of_type_Mav));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + parammav.b());
    this.jdField_b_of_type_Mav = null;
  }
  
  private void e()
  {
    mas localmas = a();
    a("hiddenMainTipsReal");
    if ((localmas == null) || (!localmas.a())) {
      return;
    }
    localmas.a();
  }
  
  private void f()
  {
    mas localmas = a();
    a("hiddenSubTipsReal");
    if ((localmas == null) || (!localmas.b())) {
      return;
    }
    localmas.b();
  }
  
  public mas a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (mas)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    mav localmav = mau.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmav == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localmav.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localmav.d());
      return;
    case 1: 
      d(localmav);
      return;
    }
    c(localmav);
  }
  
  public void a(mas parammas)
  {
    if (parammas == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + parammas.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parammas);
  }
  
  public void a(mav parammav)
  {
    if (parammav == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + parammav.b());
    if ((parammav.a()) || (this.jdField_a_of_type_Mav == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Mav);
  }
  
  public void a(mcr parammcr)
  {
    if (parammcr == null) {
      return;
    }
    a("setDeviceTipsController is " + parammcr.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammcr);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mau.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ((mcr)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mau.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mau.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(mav parammav)
  {
    if (parammav == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (parammav.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + parammav.d());
      return false;
    case 1: 
      return b(parammav);
    }
    return c(parammav);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Mav = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_Mav = null;
  }
  
  public void b(mav parammav)
  {
    if (parammav == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + parammav.b());
    if ((parammav.a()) || (this.jdField_b_of_type_Mav == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_Mav);
  }
  
  public void c()
  {
    mas localmas = a();
    a("HiddenViewContainer");
    if ((localmas == null) || (!localmas.b())) {
      return;
    }
    localmas.c();
  }
  
  public void d()
  {
    mas localmas = a();
    a("ShowViewContainer");
    if ((localmas == null) || (!localmas.b())) {
      return;
    }
    localmas.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljk
 * JD-Core Version:    0.7.0.1
 */