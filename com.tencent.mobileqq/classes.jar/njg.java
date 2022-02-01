import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.gamelist.GameListView;

public class njg
  implements View.OnTouchListener
{
  public njg(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = nfc.a().e();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      if (bool) {}
      for (paramView = "avgame_match_stop_press@2x.png";; paramView = "avgame_match_start_press@2x.png")
      {
        paramView = nqf.a(paramView);
        if (paramView == null) {
          break;
        }
        GameListView.a(this.a).setImageBitmap(paramView);
        break;
      }
    }
    if (bool) {}
    for (paramView = "avgame_match_stop_normal@2x.png";; paramView = "avgame_match_start_normal@2x.png")
    {
      paramView = nqf.a(paramView);
      if (paramView == null) {
        break;
      }
      GameListView.a(this.a).setImageBitmap(paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njg
 * JD-Core Version:    0.7.0.1
 */