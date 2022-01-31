import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class sdz
  implements View.OnSystemUiVisibilityChangeListener
{
  sdz(sdw paramsdw) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (paramInt = 5894;; paramInt = 1799)
    {
      sds.a(this.a.a).getWindow().getDecorView().setSystemUiVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdz
 * JD-Core Version:    0.7.0.1
 */