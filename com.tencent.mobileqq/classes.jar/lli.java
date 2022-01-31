import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lli
  extends ljg
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<mfb> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile mdf jdField_a_of_type_Mdf;
  private WeakReference<mdc> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile mdf jdField_b_of_type_Mdf;
  
  public lli(VideoAppInterface paramVideoAppInterface)
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
  
  private boolean b(mdf parammdf)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammdf != null)
    {
      localObject1 = Integer.valueOf(parammdf.b());
      a(localObject1);
      localObject1 = a();
      if ((parammdf != null) && (localObject1 != null) && (((mdc)localObject1).b())) {
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
        bool1 = mdf.a((mdf)localObject2, parammdf);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((mdc)localObject1).b(parammdf))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(parammdf);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mdf)localObject2).a());
    if (parammdf.a())
    {
      this.jdField_b_of_type_Mdf = null;
      return true;
    }
    this.jdField_b_of_type_Mdf = ((mdf)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(mdf parammdf)
  {
    if (parammdf == null) {}
    do
    {
      return;
      if (parammdf.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + parammdf.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!parammdf.equals(this.jdField_a_of_type_Mdf));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + parammdf.b());
    this.jdField_a_of_type_Mdf = null;
  }
  
  private boolean c(mdf parammdf)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammdf != null)
    {
      localObject1 = Integer.valueOf(parammdf.b());
      a(localObject1);
      localObject1 = a();
      if ((parammdf != null) && (localObject1 != null) && (((mdc)localObject1).a())) {
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
        bool1 = mdf.a((mdf)localObject2, parammdf);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((mdc)localObject1).a(parammdf)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(parammdf);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mdf)localObject2).a());
    if (parammdf.a())
    {
      this.jdField_a_of_type_Mdf = null;
      return true;
    }
    this.jdField_a_of_type_Mdf = ((mdf)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((mdf)localObject2).b());
    label210:
    return false;
  }
  
  private void d(mdf parammdf)
  {
    if (parammdf == null) {}
    do
    {
      return;
      if (parammdf.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + parammdf.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!parammdf.equals(this.jdField_b_of_type_Mdf));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + parammdf.b());
    this.jdField_b_of_type_Mdf = null;
  }
  
  private void e()
  {
    mdc localmdc = a();
    a("hiddenMainTipsReal");
    if ((localmdc == null) || (!localmdc.a())) {
      return;
    }
    localmdc.a();
  }
  
  private void f()
  {
    mdc localmdc = a();
    a("hiddenSubTipsReal");
    if ((localmdc == null) || (!localmdc.b())) {
      return;
    }
    localmdc.b();
  }
  
  public mdc a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (mdc)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    mdf localmdf = mde.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmdf == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localmdf.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localmdf.d());
      return;
    case 1: 
      d(localmdf);
      return;
    }
    c(localmdf);
  }
  
  public void a(mdc parammdc)
  {
    if (parammdc == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + parammdc.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parammdc);
  }
  
  public void a(mdf parammdf)
  {
    if (parammdf == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + parammdf.b());
    if ((parammdf.a()) || (this.jdField_a_of_type_Mdf == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Mdf);
  }
  
  public void a(mfb parammfb)
  {
    if (parammfb == null) {
      return;
    }
    a("setDeviceTipsController is " + parammfb.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammfb);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((mfb)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mde.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
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
        ((mfb)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong);
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
        ((mfb)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, paramBoolean);
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
    return a(mde.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mde.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(mdf parammdf)
  {
    if (parammdf == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (parammdf.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + parammdf.d());
      return false;
    case 1: 
      return b(parammdf);
    }
    return c(parammdf);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Mdf = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_Mdf = null;
  }
  
  public void b(mdf parammdf)
  {
    if (parammdf == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + parammdf.b());
    if ((parammdf.a()) || (this.jdField_b_of_type_Mdf == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_Mdf);
  }
  
  public void c()
  {
    mdc localmdc = a();
    a("HiddenViewContainer");
    if ((localmdc == null) || (!localmdc.b())) {
      return;
    }
    localmdc.c();
  }
  
  public void d()
  {
    mdc localmdc = a();
    a("ShowViewContainer");
    if ((localmdc == null) || (!localmdc.b())) {
      return;
    }
    localmdc.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lli
 * JD-Core Version:    0.7.0.1
 */