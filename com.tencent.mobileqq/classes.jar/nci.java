import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.avgame.gameroom.seat.SeatView;

public class nci
  implements View.OnTouchListener
{
  public nci(GameRoomFragment paramGameRoomFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = paramView.findViewById(2131363164);
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        GameRoomFragment.a(this.a).setVisibility(8);
        this.a.a.a();
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nci
 * JD-Core Version:    0.7.0.1
 */