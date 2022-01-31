import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class tbf<V extends tat, P extends taw<V>>
  implements tav
{
  private tau<V, P> a;
  
  public tbf(tau<V, P> paramtau)
  {
    if (paramtau == null) {
      throw new NullPointerException("IWSDelegateCallback is null!");
    }
    this.a = paramtau;
  }
  
  private V a()
  {
    tat localtat = this.a.a();
    if (localtat == null) {
      throw new NullPointerException("View returned from getMvpView() is null");
    }
    return localtat;
  }
  
  private P a()
  {
    taw localtaw = this.a.b();
    if (localtaw == null) {
      throw new NullPointerException("Presenter returned from getPresenter() is null");
    }
    return localtaw;
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(Bundle paramBundle)
  {
    taw localtaw = this.a.b();
    paramBundle = localtaw;
    if (localtaw == null) {
      paramBundle = this.a.a();
    }
    this.a.a(paramBundle);
  }
  
  public void a(View paramView, @Nullable Bundle paramBundle)
  {
    a().a(a());
  }
  
  public void b()
  {
    a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbf
 * JD-Core Version:    0.7.0.1
 */