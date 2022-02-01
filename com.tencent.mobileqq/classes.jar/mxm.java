import android.os.Handler;
import com.tencent.avgame.gamelogic.GameEngine.2.1;
import com.tencent.qphone.base.util.QLog;

public class mxm
  extends mwx
{
  mxm(mxl parammxl) {}
  
  public void a(int paramInt)
  {
    QLog.i("avgame_logic.GameEngine", 1, "onEnterRoomError errorType = " + paramInt + " engineData = " + mxl.a(this.a));
    if ((paramInt == 4) || (paramInt == 3)) {
      neq.a().b().post(new GameEngine.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxm
 * JD-Core Version:    0.7.0.1
 */