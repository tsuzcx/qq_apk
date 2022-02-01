import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.qphone.base.util.QLog;

public class ncj
  extends CountDownTimer
{
  public ncj(GameRoomFragment paramGameRoomFragment, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish() {}
  
  public void onTick(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    this.a.d.setText(i + "s");
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "CountDownTimer remainSeconds = " + i);
    }
    if ((i <= 10) && (i > 0)) {
      this.a.a();
    }
    if (i == 0) {
      GameRoomFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncj
 * JD-Core Version:    0.7.0.1
 */