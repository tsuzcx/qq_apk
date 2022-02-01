import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lin
  extends lgj
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<mdb> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile mbd jdField_a_of_type_Mbd;
  private WeakReference<mba> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile mbd jdField_b_of_type_Mbd;
  
  public lin(VideoAppInterface paramVideoAppInterface)
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
  
  private boolean b(mbd parammbd)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammbd != null)
    {
      localObject1 = Integer.valueOf(parammbd.b());
      a(localObject1);
      localObject1 = a();
      if ((parammbd != null) && (localObject1 != null) && (((mba)localObject1).b())) {
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
        bool1 = mbd.a((mbd)localObject2, parammbd);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((mba)localObject1).b(parammbd))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(parammbd);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mbd)localObject2).a());
    if (parammbd.a())
    {
      this.jdField_b_of_type_Mbd = null;
      return true;
    }
    this.jdField_b_of_type_Mbd = ((mbd)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(mbd parammbd)
  {
    if (parammbd == null) {}
    do
    {
      return;
      if (parammbd.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + parammbd.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!parammbd.equals(this.jdField_a_of_type_Mbd));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + parammbd.b());
    this.jdField_a_of_type_Mbd = null;
  }
  
  private boolean c(mbd parammbd)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (parammbd != null)
    {
      localObject1 = Integer.valueOf(parammbd.b());
      a(localObject1);
      localObject1 = a();
      if ((parammbd != null) && (localObject1 != null) && (((mba)localObject1).a())) {
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
        bool1 = mbd.a((mbd)localObject2, parammbd);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((mba)localObject1).a(parammbd)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(parammbd);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((mbd)localObject2).a());
    if (parammbd.a())
    {
      this.jdField_a_of_type_Mbd = null;
      return true;
    }
    this.jdField_a_of_type_Mbd = ((mbd)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((mbd)localObject2).b());
    label210:
    return false;
  }
  
  private void d(mbd parammbd)
  {
    if (parammbd == null) {}
    do
    {
      return;
      if (parammbd.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + parammbd.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!parammbd.equals(this.jdField_b_of_type_Mbd));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + parammbd.b());
    this.jdField_b_of_type_Mbd = null;
  }
  
  private void e()
  {
    mba localmba = a();
    a("hiddenMainTipsReal");
    if ((localmba == null) || (!localmba.a())) {
      return;
    }
    localmba.a();
  }
  
  private void f()
  {
    mba localmba = a();
    a("hiddenSubTipsReal");
    if ((localmba == null) || (!localmba.b())) {
      return;
    }
    localmba.b();
  }
  
  public mba a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (mba)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    mbd localmbd = mbc.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localmbd == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localmbd.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localmbd.d());
      return;
    case 1: 
      d(localmbd);
      return;
    }
    c(localmbd);
  }
  
  public void a(mba parammba)
  {
    if (parammba == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + parammba.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parammba);
  }
  
  public void a(mbd parammbd)
  {
    if (parammbd == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + parammbd.b());
    if ((parammbd.a()) || (this.jdField_a_of_type_Mbd == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Mbd);
  }
  
  public void a(mdb parammdb)
  {
    if (parammdb == null) {
      return;
    }
    a("setDeviceTipsController is " + parammdb.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammdb);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((mdb)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mbc.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
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
        ((mdb)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong);
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
        ((mdb)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, paramBoolean);
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
    return a(mbc.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(mbc.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(mbd parammbd)
  {
    if (parammbd == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (parammbd.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + parammbd.d());
      return false;
    case 1: 
      return b(parammbd);
    }
    return c(parammbd);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Mbd = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_Mbd = null;
  }
  
  public void b(mbd parammbd)
  {
    if (parammbd == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + parammbd.b());
    if ((parammbd.a()) || (this.jdField_b_of_type_Mbd == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_Mbd);
  }
  
  public void c()
  {
    mba localmba = a();
    a("HiddenViewContainer");
    if ((localmba == null) || (!localmba.b())) {
      return;
    }
    localmba.c();
  }
  
  public void d()
  {
    mba localmba = a();
    a("ShowViewContainer");
    if ((localmba == null) || (!localmba.b())) {
      return;
    }
    localmba.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lin
 * JD-Core Version:    0.7.0.1
 */