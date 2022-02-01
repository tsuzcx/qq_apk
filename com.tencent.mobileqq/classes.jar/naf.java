import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gameroom.GameRoomFragment.9;

public class naf
  implements DialogInterface.OnClickListener
{
  public naf(GameRoomFragment.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.a != null) {
      this.a.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     naf
 * JD-Core Version:    0.7.0.1
 */