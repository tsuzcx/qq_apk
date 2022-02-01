import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameJoinRoomFragment;

public class nhu
  extends mya
{
  public nhu(AVGameJoinRoomFragment paramAVGameJoinRoomFragment) {}
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    super.b(paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhu
 * JD-Core Version:    0.7.0.1
 */