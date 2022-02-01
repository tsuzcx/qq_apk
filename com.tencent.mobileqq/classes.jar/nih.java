import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gameroom.GameRoomFragment.9;

public class nih
  implements DialogInterface.OnClickListener
{
  public nih(GameRoomFragment.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.a != null) {
      this.a.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nih
 * JD-Core Version:    0.7.0.1
 */