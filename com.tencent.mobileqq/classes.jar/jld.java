import android.os.Bundle;
import com.tencent.av.redpacket.AVRedPacketHandler;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.GameStateInfo;
import com.tencent.av.redpacket.AVRedPacketManager.ResPreLoadObserver;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.qphone.base.util.QLog;

public class jld
  implements AVRedPacketManager.ResPreLoadObserver
{
  public jld(AVRedPacketManager paramAVRedPacketManager) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onLoadFinish, isSucc=" + paramBoolean + ",type=" + paramInt);
    }
    if (!AVRedPacketManager.a(this.a, true)) {}
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      if ((this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1) && (this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 1))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("key", this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key);
        localBundle.putInt("gameState", 1);
        localBundle.putInt("fromWho", 1);
        localBundle.putInt("musicId", this.a.g);
        localBundle.putInt("enterType", this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.enterType);
        this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketHandler.b();
        this.a.a(1, localBundle);
        this.a.a(false, 1011, AVRedPacketManager.jdField_a_of_type_Long, null);
        this.a.a(false, 1021, AVRedPacketManager.c, null);
        return;
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 2) || (this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 1));
    long l = Math.abs(System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.mRedPacketComeStartTime);
    paramBoolean = RedBagUtil.b(AVRedPacketManager.a(this.a));
    if (l >= AVRedPacketManager.f)
    {
      if (paramBoolean)
      {
        this.a.d();
        return;
      }
      this.a.f();
      return;
    }
    if (paramBoolean)
    {
      this.a.a(false, 1028, AVRedPacketManager.f - l, null);
      return;
    }
    this.a.a(false, 1026, AVRedPacketManager.f - l, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jld
 * JD-Core Version:    0.7.0.1
 */