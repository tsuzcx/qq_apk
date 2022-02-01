import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;

public class nyh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nyh(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i = this.a.getWindow().getDecorView().getBottom();
    int j = this.a.getWindow().getDecorView().getTop();
    LebaSearchPluginManagerActivity.a(this.a, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyh
 * JD-Core Version:    0.7.0.1
 */