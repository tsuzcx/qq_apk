import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class mza
  extends mxu
{
  mza(myz parammyz) {}
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      mze localmze = (mze)myz.a(this.a).a();
      localmze.a(paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when onUserNickUpdated %s", new Object[] { Arrays.toString(localmze.a().players.toArray()) }));
      }
      myz.a(this.a).a(paramHashMap);
      myz.a(this.a, paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mza
 * JD-Core Version:    0.7.0.1
 */