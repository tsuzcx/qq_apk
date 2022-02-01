import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class mxy
  extends mwv
{
  mxy(mxx parammxx) {}
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      myc localmyc = (myc)mxx.a(this.a).a();
      localmyc.a(paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when onUserNickUpdated %s", new Object[] { Arrays.toString(localmyc.a().players.toArray()) }));
      }
      mxx.a(this.a).a(paramHashMap);
      mxx.a(this.a, paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxy
 * JD-Core Version:    0.7.0.1
 */