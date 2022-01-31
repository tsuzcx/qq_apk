import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.widget.XListView;

public class cr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public cr(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.a.getBottom() - LiteActivity.a(this.a).getTop();
    if ((LiteActivity.a(this.a).getVisibility() == 0) && (this.a.a.getPaddingBottom() != i)) {
      this.a.a.setPadding(this.a.a.getPaddingLeft(), this.a.a.getPaddingTop(), this.a.a.getPaddingRight(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cr
 * JD-Core Version:    0.7.0.1
 */