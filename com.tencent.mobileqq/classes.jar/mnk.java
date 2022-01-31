import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;

public class mnk
  implements View.OnTouchListener
{
  public mnk(QavRecordButtonView paramQavRecordButtonView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QavRecordButtonView.a(this.a) != 1) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(0.5F);
      continue;
      paramView.setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mnk
 * JD-Core Version:    0.7.0.1
 */