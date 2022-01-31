import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kyu
  extends kwt
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private WeakReference<lqa> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile lqd jdField_a_of_type_Lqd;
  private volatile lqd b;
  
  public kyu(VideoAppInterface paramVideoAppInterface)
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
  
  private boolean b(lqd paramlqd)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (paramlqd != null)
    {
      localObject1 = Integer.valueOf(paramlqd.b());
      a(localObject1);
      localObject1 = a();
      if ((paramlqd != null) && (localObject1 != null) && (((lqa)localObject1).b())) {
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
        bool1 = lqd.a((lqd)localObject2, paramlqd);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((lqa)localObject1).b(paramlqd))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(paramlqd);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((lqd)localObject2).a());
    if (paramlqd.a())
    {
      this.b = null;
      return true;
    }
    this.b = ((lqd)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(lqd paramlqd)
  {
    if (paramlqd == null) {}
    do
    {
      return;
      if (paramlqd.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + paramlqd.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!paramlqd.equals(this.jdField_a_of_type_Lqd));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + paramlqd.b());
    this.jdField_a_of_type_Lqd = null;
  }
  
  private boolean c(lqd paramlqd)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (paramlqd != null)
    {
      localObject1 = Integer.valueOf(paramlqd.b());
      a(localObject1);
      localObject1 = a();
      if ((paramlqd != null) && (localObject1 != null) && (((lqa)localObject1).a())) {
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
        bool1 = lqd.a((lqd)localObject2, paramlqd);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((lqa)localObject1).a(paramlqd)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(paramlqd);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((lqd)localObject2).a());
    if (paramlqd.a())
    {
      this.jdField_a_of_type_Lqd = null;
      return true;
    }
    this.jdField_a_of_type_Lqd = ((lqd)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((lqd)localObject2).b());
    label210:
    return false;
  }
  
  private void d(lqd paramlqd)
  {
    if (paramlqd == null) {}
    do
    {
      return;
      if (paramlqd.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + paramlqd.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!paramlqd.equals(this.b));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + paramlqd.b());
    this.b = null;
  }
  
  private void e()
  {
    lqa locallqa = a();
    a("hiddenMainTipsReal");
    if ((locallqa == null) || (!locallqa.a())) {
      return;
    }
    locallqa.a();
  }
  
  private void f()
  {
    lqa locallqa = a();
    a("hiddenSubTipsReal");
    if ((locallqa == null) || (!locallqa.b())) {
      return;
    }
    locallqa.b();
  }
  
  public lqa a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (lqa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    lqd locallqd = lqc.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallqd == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    switch (locallqd.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + locallqd.d());
      return;
    case 1: 
      d(locallqd);
      return;
    }
    c(locallqd);
  }
  
  public void a(lqa paramlqa)
  {
    if (paramlqa == null) {
      return;
    }
    a("setAvTipsView avTipsView is " + paramlqa.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramlqa);
  }
  
  public void a(lqd paramlqd)
  {
    if (paramlqd == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + paramlqd.b());
    if ((paramlqd.a()) || (this.jdField_a_of_type_Lqd == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_Lqd);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(lqc.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(lqc.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(lqc.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(lqd paramlqd)
  {
    if (paramlqd == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    switch (paramlqd.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + paramlqd.d());
      return false;
    case 1: 
      return b(paramlqd);
    }
    return c(paramlqd);
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_Lqd = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.b = null;
  }
  
  public void b(lqd paramlqd)
  {
    if (paramlqd == null) {
      return;
    }
    a("NotifyHiddenSubTipsByRunner item" + paramlqd.b());
    if ((paramlqd.a()) || (this.b == null))
    {
      f();
      return;
    }
    b(this.b);
  }
  
  public void c()
  {
    lqa locallqa = a();
    a("HiddenViewContainer");
    if ((locallqa == null) || (!locallqa.b())) {
      return;
    }
    locallqa.c();
  }
  
  public void d()
  {
    lqa locallqa = a();
    a("ShowViewContainer");
    if ((locallqa == null) || (!locallqa.b())) {
      return;
    }
    locallqa.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kyu
 * JD-Core Version:    0.7.0.1
 */