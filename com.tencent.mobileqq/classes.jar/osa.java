import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class osa
{
  @Nullable
  private osb a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView)
  {
    if ((oqr.a().a() == 1) && (oqr.e()))
    {
      str = oqr.a().a();
      i = oqr.a().b();
      if (!oqr.a(i)) {}
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      return;
      if (atwl.a(str))
      {
        this.a = new osb(paramActivity, paramListView, str);
        this.a.a(i);
        paramActivity = oqr.a().a();
        if (paramActivity != null) {
          oon.b(paramActivity, true, "no error");
        }
        oqr.a().a = this;
      }
      for (;;)
      {
        QLog.d("ReadInJoySuperMaskAd", 1, "preview mode value = " + oqr.a().f());
        oqr.a().a();
        return;
        oqr.a().b(3);
        paramActivity = oqr.a().a();
        if (paramActivity != null) {
          oon.b(paramActivity, false, "apng not exit");
        }
      }
    }
    QLog.i("KandianAdPandentMask", 2, "status: " + oqr.a().a() + " Aladdin: " + oqr.e());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (osb.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osa
 * JD-Core Version:    0.7.0.1
 */