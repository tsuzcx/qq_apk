import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gameroom.GameRoomFragment.9;

public class nck
  implements DialogInterface.OnClickListener
{
  public nck(GameRoomFragment.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.a != null) {
      this.a.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nck
 * JD-Core Version:    0.7.0.1
 */