import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class nqh
{
  @Nullable
  private nqi a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView)
  {
    if ((npl.a().a() == 1) && (npl.c()))
    {
      str = npl.a().a();
      i = npl.a().b();
      if (apdh.a(str))
      {
        this.a = new nqi(paramActivity, paramListView, str);
        this.a.a(i);
        paramActivity = npl.a().a();
        if (paramActivity != null) {
          nof.b(paramActivity, true, "no error");
        }
        npl.a().a = this;
        npl.a().a();
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        String str;
        int i;
        return;
        npl.a().a(3);
        paramActivity = npl.a().a();
        if (paramActivity != null) {
          nof.b(paramActivity, false, "apng not exit");
        }
      }
    }
    QLog.i("KandianAdPandentMask", 2, "status: " + npl.a().a() + " Aladdin: " + npl.c());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.a != null) && (nqi.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqh
 * JD-Core Version:    0.7.0.1
 */