import android.graphics.RectF;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.avgame.gameroom.seat.SeatView;

public class nbg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  
  public nbg(GameRoomFragment paramGameRoomFragment) {}
  
  public void onGlobalLayout()
  {
    RectF localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
    if (localRectF == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.b)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_Nbp.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.getString(2131690282), localRectF, 146);
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.b = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF = localRectF;
      return;
      if ((this.jdField_a_of_type_AndroidGraphicsRectF != null) && ((this.jdField_a_of_type_AndroidGraphicsRectF.left != localRectF.left) || (this.jdField_a_of_type_AndroidGraphicsRectF.top != localRectF.top))) {
        this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_Nbp.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.getString(2131690282), localRectF, 146);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbg
 * JD-Core Version:    0.7.0.1
 */