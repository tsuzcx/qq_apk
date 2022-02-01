import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView;

public class qjz
  implements View.OnTouchListener
{
  public qjz(NativeShareView paramNativeShareView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjz
 * JD-Core Version:    0.7.0.1
 */