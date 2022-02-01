import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lih
  extends lgd
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<mck> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile mam jdField_a_of_type_Mam;
  private WeakReference<maj> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile mam jdField_b_of_type_Mam;
  
  public lih(VideoAppInterface paramVideoAppInterface)
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
  
  private boolean b(mam parammam)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammam != null)
    {
      localObject1 = Integer.valueOf(parammam.b());
      a(localObject1);
      localObject1 = a();
      if ((parammam != null) && (localObject1 != null) && (((maj)localObject1).b())) {
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
        bool1 = mam.a((mam)localObject2, parammam);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((maj)localObject1).b(parammam))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(parammam);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mam)localObject2).a());
    if (parammam.a())
    {
      this.jdField_b_of_type_Mam = null;
      return true;
    }
    this.jdField_b_of_type_Mam = ((mam)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(mam parammam)
  {
    if (parammam == null) {}
    do
    {
      return;
      if (parammam.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + parammam.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!parammam.equals(this.jdField_a_of_type_Mam));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + parammam.b());
    this.jdField_a_of_type_Mam = null;
  }
  
  private boolean c(mam parammam)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammam != null)
    {
      localObject1 = Integer.valueOf(parammam.b());
      a(localObject1);
      localObject1 = a();
      if ((parammam != null) && (localObject1 != null) && (((maj)localObject1).a())) {
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
        bool1 = mam.a((mam)localObject2, parammam);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((maj)localObject1).a(parammam)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(parammam);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mam)localObject2).a());
    if (parammam.a())
    {
      this.jdField_a_of_type_Mam = null;
      return true;
    }
    this.jdField_a_of_type_Mam = ((mam)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((mam)localObject2).b());
    label210:
    return false;
  }
  
  private void d(mam parammam)
  {
    if (parammam == null) {}
    do
    {
      return;
      if (parammam.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + parammam.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!parammam.equals(this.jdField_b_of_type_Mam));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + parammam.b());
    this.jdField_b_of_type_Mam = null;
  }
  
  private void e()
  {
    maj localmaj = a();
    a("hiddenMainTipsReal");
    if ((localmaj == null) || (!localmaj.a())) {
      return;
    }
    localmaj.a();
  }
  
  private void f()
  {
    maj localmaj = a();
    a("hiddenSubTipsReal");
    if ((localmaj == null) || (!localmaj.b())) {
      return;
    }
    localmaj.b();
  }
  
  public maj a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (maj)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    mam localmam = mal.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmam == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localmam.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localmam.d());
      return;
    case 1: 
      d(localmam);
      return;
    }
    c(localmam);
  }
  
  public void a(maj parammaj)
  {
    if (parammaj == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + parammaj.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parammaj);
  }
  
  public void a(mam parammam)
  {
    if (parammam == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + parammam.b());
    if ((parammam.a()) || (this.jdField_a_of_type_Mam == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Mam);
  }
  
  public void a(mck parammck)
  {
    if (parammck == null) {
      return;
    }
    a("setDeviceTipsController is " + parammck.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammck);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((mck)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mal.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
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
        ((mck)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong);
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
        ((mck)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, paramBoolean);
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
    return a(mal.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mal.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(mam parammam)
  {
    if (parammam == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (parammam.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + parammam.d());
      return false;
    case 1: 
      return b(parammam);
    }
    return c(parammam);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Mam = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_Mam = null;
  }
  
  public void b(mam parammam)
  {
    if (parammam == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + parammam.b());
    if ((parammam.a()) || (this.jdField_b_of_type_Mam == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_Mam);
  }
  
  public void c()
  {
    maj localmaj = a();
    a("HiddenViewContainer");
    if ((localmaj == null) || (!localmaj.b())) {
      return;
    }
    localmaj.c();
  }
  
  public void d()
  {
    maj localmaj = a();
    a("ShowViewContainer");
    if ((localmaj == null) || (!localmaj.b())) {
      return;
    }
    localmaj.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lih
 * JD-Core Version:    0.7.0.1
 */