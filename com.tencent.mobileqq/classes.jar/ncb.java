import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.gamelist.GameListView;

public class ncb
  implements View.OnTouchListener
{
  public ncb(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      paramView = nhs.a("avgame_start_game_owner_hl@3x.png");
      if (paramView != null)
      {
        GameListView.a(this.a).setImageBitmap(paramView);
        continue;
        paramView = nhs.a("avgame_start_game_owner_normal@3x.png");
        if (paramView != null) {
          GameListView.a(this.a).setImageBitmap(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncb
 * JD-Core Version:    0.7.0.1
 */