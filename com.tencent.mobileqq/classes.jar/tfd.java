import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class tfd
{
  private static Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  public bbms a;
  public String a;
  public WeakReference<Activity> a;
  public List<int[]> a;
  private tfc jdField_a_of_type_Tfc;
  public boolean a;
  public boolean b = true;
  
  public tfd(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - jdField_a_of_type_JavaLangLong.longValue();
    if ((l2 > 0L) && (l2 < 800L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isFastDoubleClick", 2, "time:" + l1 + ", mLastClickTIme:" + jdField_a_of_type_JavaLangLong + ", timeDiff:" + l2);
      }
      return true;
    }
    jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
    return false;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    if (a()) {
      return;
    }
    b();
    this.jdField_a_of_type_Tfc.a(b(paramInt));
  }
  
  public void a(tfc paramtfc)
  {
    this.jdField_a_of_type_Tfc = paramtfc;
  }
  
  public abstract int b(int paramInt);
  
  public void b()
  {
    if (!this.b) {}
    do
    {
      Activity localActivity;
      do
      {
        return;
        if (this.jdField_a_of_type_Bbms != null) {
          break;
        }
        localActivity = a();
      } while (localActivity == null);
      int i = localActivity.getResources().getDimensionPixelSize(2131167766);
      this.jdField_a_of_type_Bbms = new bbms(localActivity);
      this.jdField_a_of_type_Bbms.a(ajjy.a(2131648183));
      this.jdField_a_of_type_Bbms.b(i);
    } while (this.jdField_a_of_type_Bbms.isShowing());
    this.jdField_a_of_type_Bbms.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  public void d()
  {
    a();
    if (this.jdField_a_of_type_Tfc != null) {
      this.jdField_a_of_type_Tfc.a();
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Tfc != null) {
      this.jdField_a_of_type_Tfc.b();
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_Tfc != null) {
      this.jdField_a_of_type_Tfc.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfd
 * JD-Core Version:    0.7.0.1
 */