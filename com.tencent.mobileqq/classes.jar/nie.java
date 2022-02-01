import android.graphics.RectF;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.avgame.gameroom.seat.SeatView;

public class nie
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  
  public nie(GameRoomFragment paramGameRoomFragment) {}
  
  public void onGlobalLayout()
  {
    RectF localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
    if (localRectF == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.b)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_Nio.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.getString(2131690346), localRectF, 146);
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.b = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF = localRectF;
      return;
      if ((this.jdField_a_of_type_AndroidGraphicsRectF != null) && ((this.jdField_a_of_type_AndroidGraphicsRectF.left != localRectF.left) || (this.jdField_a_of_type_AndroidGraphicsRectF.top != localRectF.top))) {
        this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_Nio.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.getString(2131690346), localRectF, 146);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nie
 * JD-Core Version:    0.7.0.1
 */