import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.avgame.gameroom.gamelist.GameListView;

public class ncd
  implements View.OnTouchListener
{
  public ncd(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      this.a.setCancelPreparePressImage();
      continue;
      this.a.setCancelPrepareNorImage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncd
 * JD-Core Version:    0.7.0.1
 */