import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.avgame.gamelogic.GameEngine.2.1;
import com.tencent.qphone.base.util.QLog;

public class nfd
  extends ndt
{
  nfd(nfc paramnfc) {}
  
  public void a()
  {
    QLog.i("avgame_logic.GameEngine", 1, "onEnterRoomSucess.");
    if (Build.VERSION.SDK_INT >= 16) {
      lfm.a().a(this.a);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.i("avgame_logic.GameEngine", 1, "onEnterRoomError errorType = " + paramInt + " engineData = " + nfc.a(this.a));
    if ((paramInt == 4) || (paramInt == 3)) {
      nom.a().b().post(new GameEngine.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfd
 * JD-Core Version:    0.7.0.1
 */