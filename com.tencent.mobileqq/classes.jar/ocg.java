import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class ocg
  implements View.OnSystemUiVisibilityChangeListener
{
  ocg(ocf paramocf) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (paramInt = 4866;; paramInt = 771)
    {
      this.a.getWindow().getDecorView().setSystemUiVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocg
 * JD-Core Version:    0.7.0.1
 */