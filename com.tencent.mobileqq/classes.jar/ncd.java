import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.gameroom.GameRoomFragment;

public class ncd
  implements DialogInterface.OnClickListener
{
  public ncd(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    while (paramInt != 1) {
      return;
    }
    this.a.a.a(false, 1);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncd
 * JD-Core Version:    0.7.0.1
 */