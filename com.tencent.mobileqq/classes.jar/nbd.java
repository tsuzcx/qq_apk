import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nbd
  implements View.OnClickListener
{
  public nbd(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(View paramView)
  {
    String str = String.format(this.a.getString(2131690248), new Object[] { this.a.b.getText().toString().replace("-", " ") });
    GameRoomFragment.a(this.a, str);
    this.a.a(2, this.a.getString(2131690249));
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    bdll.b(null, "dc00898", "", "", "0X800B020", "0X800B020", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbd
 * JD-Core Version:    0.7.0.1
 */