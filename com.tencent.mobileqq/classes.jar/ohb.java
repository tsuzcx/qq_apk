import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity;

public class ohb
  implements View.OnSystemUiVisibilityChangeListener
{
  public ohb(DanceMachineQQBrowserActivity paramDanceMachineQQBrowserActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (paramInt = 4870;; paramInt = 775)
    {
      this.a.getWindow().getDecorView().setSystemUiVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohb
 * JD-Core Version:    0.7.0.1
 */