import android.os.Handler;
import com.tencent.avgame.gamelogic.GameEngine.2.1;
import com.tencent.qphone.base.util.QLog;

public class myl
  extends mxw
{
  myl(myk parammyk) {}
  
  public void a(int paramInt)
  {
    QLog.i("avgame_logic.GameEngine", 1, "onEnterRoomError errorType = " + paramInt + " engineData = " + myk.a(this.a));
    if ((paramInt == 4) || (paramInt == 3)) {
      ngk.a().b().post(new GameEngine.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myl
 * JD-Core Version:    0.7.0.1
 */