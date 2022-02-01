import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.seat.SeatView;

public class ndy
  implements DialogInterface.OnClickListener
{
  public ndy(SeatView paramSeatView, Player paramPlayer) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndy
 * JD-Core Version:    0.7.0.1
 */