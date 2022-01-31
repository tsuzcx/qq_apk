import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class obs
{
  @Nullable
  private obt a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView)
  {
    if ((oaw.a().a() == 1) && (oaw.c()))
    {
      str = oaw.a().a();
      i = oaw.a().b();
      if (i != 1) {}
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      return;
      if (apvb.a(str))
      {
        this.a = new obt(paramActivity, paramListView, str);
        this.a.a(i);
        paramActivity = oaw.a().a();
        if (paramActivity != null) {
          nzq.b(paramActivity, true, "no error");
        }
        oaw.a().a = this;
      }
      for (;;)
      {
        QLog.d("ReadInJoySuperMaskAd", 1, "preview mode value = " + oaw.a().d());
        oaw.a().a();
        return;
        oaw.a().a(3);
        paramActivity = oaw.a().a();
        if (paramActivity != null) {
          nzq.b(paramActivity, false, "apng not exit");
        }
      }
    }
    QLog.i("KandianAdPandentMask", 2, "status: " + oaw.a().a() + " Aladdin: " + oaw.c());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (obt.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */