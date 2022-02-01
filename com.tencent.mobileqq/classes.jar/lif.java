import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lif
  extends lgb
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<mcf> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile mah jdField_a_of_type_Mah;
  private WeakReference<mae> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile mah jdField_b_of_type_Mah;
  
  public lif(VideoAppInterface paramVideoAppInterface)
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
  
  private boolean b(mah parammah)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammah != null)
    {
      localObject1 = Integer.valueOf(parammah.b());
      a(localObject1);
      localObject1 = a();
      if ((parammah != null) && (localObject1 != null) && (((mae)localObject1).b())) {
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
        bool1 = mah.a((mah)localObject2, parammah);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((mae)localObject1).b(parammah))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(parammah);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mah)localObject2).a());
    if (parammah.a())
    {
      this.jdField_b_of_type_Mah = null;
      return true;
    }
    this.jdField_b_of_type_Mah = ((mah)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(mah parammah)
  {
    if (parammah == null) {}
    do
    {
      return;
      if (parammah.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + parammah.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!parammah.equals(this.jdField_a_of_type_Mah));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + parammah.b());
    this.jdField_a_of_type_Mah = null;
  }
  
  private boolean c(mah parammah)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammah != null)
    {
      localObject1 = Integer.valueOf(parammah.b());
      a(localObject1);
      localObject1 = a();
      if ((parammah != null) && (localObject1 != null) && (((mae)localObject1).a())) {
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
        bool1 = mah.a((mah)localObject2, parammah);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((mae)localObject1).a(parammah)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(parammah);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mah)localObject2).a());
    if (parammah.a())
    {
      this.jdField_a_of_type_Mah = null;
      return true;
    }
    this.jdField_a_of_type_Mah = ((mah)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((mah)localObject2).b());
    label210:
    return false;
  }
  
  private void d(mah parammah)
  {
    if (parammah == null) {}
    do
    {
      return;
      if (parammah.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + parammah.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!parammah.equals(this.jdField_b_of_type_Mah));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + parammah.b());
    this.jdField_b_of_type_Mah = null;
  }
  
  private void e()
  {
    mae localmae = a();
    a("hiddenMainTipsReal");
    if ((localmae == null) || (!localmae.a())) {
      return;
    }
    localmae.a();
  }
  
  private void f()
  {
    mae localmae = a();
    a("hiddenSubTipsReal");
    if ((localmae == null) || (!localmae.b())) {
      return;
    }
    localmae.b();
  }
  
  public mae a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (mae)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    mah localmah = mag.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmah == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localmah.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localmah.d());
      return;
    case 1: 
      d(localmah);
      return;
    }
    c(localmah);
  }
  
  public void a(mae parammae)
  {
    if (parammae == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + parammae.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parammae);
  }
  
  public void a(mah parammah)
  {
    if (parammah == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + parammah.b());
    if ((parammah.a()) || (this.jdField_a_of_type_Mah == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Mah);
  }
  
  public void a(mcf parammcf)
  {
    if (parammcf == null) {
      return;
    }
    a("setDeviceTipsController is " + parammcf.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammcf);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((mcf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mag.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
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
        ((mcf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ((mcf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, paramBoolean);
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
    return a(mag.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mag.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(mah parammah)
  {
    if (parammah == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (parammah.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + parammah.d());
      return false;
    case 1: 
      return b(parammah);
    }
    return c(parammah);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Mah = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_Mah = null;
  }
  
  public void b(mah parammah)
  {
    if (parammah == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + parammah.b());
    if ((parammah.a()) || (this.jdField_b_of_type_Mah == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_Mah);
  }
  
  public void c()
  {
    mae localmae = a();
    a("HiddenViewContainer");
    if ((localmae == null) || (!localmae.b())) {
      return;
    }
    localmae.c();
  }
  
  public void d()
  {
    mae localmae = a();
    a("ShowViewContainer");
    if ((localmae == null) || (!localmae.b())) {
      return;
    }
    localmae.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lif
 * JD-Core Version:    0.7.0.1
 */