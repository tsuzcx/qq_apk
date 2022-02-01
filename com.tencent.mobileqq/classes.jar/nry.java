import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;

public class nry
  implements View.OnKeyListener
{
  public nry(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      paramView = ((TextView)paramView).getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        this.a.a(paramView);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nry
 * JD-Core Version:    0.7.0.1
 */