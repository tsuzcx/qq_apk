import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class nab
  extends myf
{
  nab(naa paramnaa) {}
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      naf localnaf = (naf)naa.a(this.a).a();
      localnaf.a(paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when onUserNickUpdated %s", new Object[] { Arrays.toString(localnaf.a().players.toArray()) }));
      }
      naa.a(this.a).a(paramHashMap);
      naa.a(this.a, paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nab
 * JD-Core Version:    0.7.0.1
 */