import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lit
  extends lgp
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<mdf> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile mbh jdField_a_of_type_Mbh;
  private WeakReference<mbe> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile mbh jdField_b_of_type_Mbh;
  
  public lit(VideoAppInterface paramVideoAppInterface)
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
  
  private boolean b(mbh parammbh)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammbh != null)
    {
      localObject1 = Integer.valueOf(parammbh.b());
      a(localObject1);
      localObject1 = a();
      if ((parammbh != null) && (localObject1 != null) && (((mbe)localObject1).b())) {
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
        bool1 = mbh.a((mbh)localObject2, parammbh);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((mbe)localObject1).b(parammbh))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(parammbh);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mbh)localObject2).a());
    if (parammbh.a())
    {
      this.jdField_b_of_type_Mbh = null;
      return true;
    }
    this.jdField_b_of_type_Mbh = ((mbh)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(mbh parammbh)
  {
    if (parammbh == null) {}
    do
    {
      return;
      if (parammbh.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + parammbh.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!parammbh.equals(this.jdField_a_of_type_Mbh));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + parammbh.b());
    this.jdField_a_of_type_Mbh = null;
  }
  
  private boolean c(mbh parammbh)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammbh != null)
    {
      localObject1 = Integer.valueOf(parammbh.b());
      a(localObject1);
      localObject1 = a();
      if ((parammbh != null) && (localObject1 != null) && (((mbe)localObject1).a())) {
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
        bool1 = mbh.a((mbh)localObject2, parammbh);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((mbe)localObject1).a(parammbh)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(parammbh);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mbh)localObject2).a());
    if (parammbh.a())
    {
      this.jdField_a_of_type_Mbh = null;
      return true;
    }
    this.jdField_a_of_type_Mbh = ((mbh)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((mbh)localObject2).b());
    label210:
    return false;
  }
  
  private void d(mbh parammbh)
  {
    if (parammbh == null) {}
    do
    {
      return;
      if (parammbh.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + parammbh.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!parammbh.equals(this.jdField_b_of_type_Mbh));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + parammbh.b());
    this.jdField_b_of_type_Mbh = null;
  }
  
  private void e()
  {
    mbe localmbe = a();
    a("hiddenMainTipsReal");
    if ((localmbe == null) || (!localmbe.a())) {
      return;
    }
    localmbe.a();
  }
  
  private void f()
  {
    mbe localmbe = a();
    a("hiddenSubTipsReal");
    if ((localmbe == null) || (!localmbe.b())) {
      return;
    }
    localmbe.b();
  }
  
  public mbe a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (mbe)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    mbh localmbh = mbg.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmbh == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localmbh.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localmbh.d());
      return;
    case 1: 
      d(localmbh);
      return;
    }
    c(localmbh);
  }
  
  public void a(mbe parammbe)
  {
    if (parammbe == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + parammbe.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parammbe);
  }
  
  public void a(mbh parammbh)
  {
    if (parammbh == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + parammbh.b());
    if ((parammbh.a()) || (this.jdField_a_of_type_Mbh == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Mbh);
  }
  
  public void a(mdf parammdf)
  {
    if (parammdf == null) {
      return;
    }
    a("setDeviceTipsController is " + parammdf.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammdf);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((mdf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mbg.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((mdf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, false);
      return true;
    }
    return false;
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
        ((mdf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, paramBoolean);
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
    return a(mbg.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mbg.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (mdf localmdf = null; localmdf != null; localmdf = (mdf)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      localmdf.a(paramString, paramLong, paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(mbh parammbh)
  {
    if (parammbh == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (parammbh.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + parammbh.d());
      return false;
    case 1: 
      return b(parammbh);
    }
    return c(parammbh);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Mbh = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_Mbh = null;
  }
  
  public void b(mbh parammbh)
  {
    if (parammbh == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + parammbh.b());
    if ((parammbh.a()) || (this.jdField_b_of_type_Mbh == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_Mbh);
  }
  
  public void c()
  {
    mbe localmbe = a();
    a("HiddenViewContainer");
    if ((localmbe == null) || (!localmbe.b())) {
      return;
    }
    localmbe.c();
  }
  
  public void d()
  {
    mbe localmbe = a();
    a("ShowViewContainer");
    if ((localmbe == null) || (!localmbe.b())) {
      return;
    }
    localmbe.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lit
 * JD-Core Version:    0.7.0.1
 */