import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ljf
  extends lhd
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<mcm> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile maq jdField_a_of_type_Maq;
  private WeakReference<man> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile maq jdField_b_of_type_Maq;
  
  public ljf(VideoAppInterface paramVideoAppInterface)
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
  
  private boolean b(maq parammaq)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammaq != null)
    {
      localObject1 = Integer.valueOf(parammaq.b());
      a(localObject1);
      localObject1 = a();
      if ((parammaq != null) && (localObject1 != null) && (((man)localObject1).b())) {
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
        bool1 = maq.a((maq)localObject2, parammaq);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((man)localObject1).b(parammaq))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(parammaq);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((maq)localObject2).a());
    if (parammaq.a())
    {
      this.jdField_b_of_type_Maq = null;
      return true;
    }
    this.jdField_b_of_type_Maq = ((maq)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(maq parammaq)
  {
    if (parammaq == null) {}
    do
    {
      return;
      if (parammaq.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + parammaq.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!parammaq.equals(this.jdField_a_of_type_Maq));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + parammaq.b());
    this.jdField_a_of_type_Maq = null;
  }
  
  private boolean c(maq parammaq)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammaq != null)
    {
      localObject1 = Integer.valueOf(parammaq.b());
      a(localObject1);
      localObject1 = a();
      if ((parammaq != null) && (localObject1 != null) && (((man)localObject1).a())) {
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
        bool1 = maq.a((maq)localObject2, parammaq);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((man)localObject1).a(parammaq)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(parammaq);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((maq)localObject2).a());
    if (parammaq.a())
    {
      this.jdField_a_of_type_Maq = null;
      return true;
    }
    this.jdField_a_of_type_Maq = ((maq)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((maq)localObject2).b());
    label210:
    return false;
  }
  
  private void d(maq parammaq)
  {
    if (parammaq == null) {}
    do
    {
      return;
      if (parammaq.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + parammaq.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!parammaq.equals(this.jdField_b_of_type_Maq));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + parammaq.b());
    this.jdField_b_of_type_Maq = null;
  }
  
  private void e()
  {
    man localman = a();
    a("hiddenMainTipsReal");
    if ((localman == null) || (!localman.a())) {
      return;
    }
    localman.a();
  }
  
  private void f()
  {
    man localman = a();
    a("hiddenSubTipsReal");
    if ((localman == null) || (!localman.b())) {
      return;
    }
    localman.b();
  }
  
  public man a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (man)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    maq localmaq = map.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmaq == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localmaq.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localmaq.d());
      return;
    case 1: 
      d(localmaq);
      return;
    }
    c(localmaq);
  }
  
  public void a(man paramman)
  {
    if (paramman == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + paramman.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramman);
  }
  
  public void a(maq parammaq)
  {
    if (parammaq == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + parammaq.b());
    if ((parammaq.a()) || (this.jdField_a_of_type_Maq == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Maq);
  }
  
  public void a(mcm parammcm)
  {
    if (parammcm == null) {
      return;
    }
    a("setDeviceTipsController is " + parammcm.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammcm);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(map.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
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
        ((mcm)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong);
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
    return a(map.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(map.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(maq parammaq)
  {
    if (parammaq == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (parammaq.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + parammaq.d());
      return false;
    case 1: 
      return b(parammaq);
    }
    return c(parammaq);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Maq = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_Maq = null;
  }
  
  public void b(maq parammaq)
  {
    if (parammaq == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + parammaq.b());
    if ((parammaq.a()) || (this.jdField_b_of_type_Maq == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_Maq);
  }
  
  public void c()
  {
    man localman = a();
    a("HiddenViewContainer");
    if ((localman == null) || (!localman.b())) {
      return;
    }
    localman.c();
  }
  
  public void d()
  {
    man localman = a();
    a("ShowViewContainer");
    if ((localman == null) || (!localman.b())) {
      return;
    }
    localman.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljf
 * JD-Core Version:    0.7.0.1
 */