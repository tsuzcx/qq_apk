import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.gamelist.GameListView;

public class ndf
  implements View.OnTouchListener
{
  public ndf(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      paramView = njh.a("avgame_start_game_owner_hl@3x.png");
      if (paramView != null)
      {
        this.a.a.a().setImageBitmap(paramView);
        continue;
        paramView = njh.a("avgame_start_game_owner_normal@3x.png");
        if (paramView != null) {
          this.a.a.a().setImageBitmap(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndf
 * JD-Core Version:    0.7.0.1
 */