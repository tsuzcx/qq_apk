import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class obp
{
  @Nullable
  private obq a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView)
  {
    if ((oat.a().a() == 1) && (oat.c()))
    {
      str = oat.a().a();
      i = oat.a().b();
      if (i != 1) {}
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      return;
      if (apvd.a(str))
      {
        this.a = new obq(paramActivity, paramListView, str);
        this.a.a(i);
        paramActivity = oat.a().a();
        if (paramActivity != null) {
          nzn.b(paramActivity, true, "no error");
        }
        oat.a().a = this;
      }
      for (;;)
      {
        QLog.d("ReadInJoySuperMaskAd", 1, "preview mode value = " + oat.a().d());
        oat.a().a();
        return;
        oat.a().a(3);
        paramActivity = oat.a().a();
        if (paramActivity != null) {
          nzn.b(paramActivity, false, "apng not exit");
        }
      }
    }
    QLog.i("KandianAdPandentMask", 2, "status: " + oat.a().a() + " Aladdin: " + oat.c());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (obq.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obp
 * JD-Core Version:    0.7.0.1
 */