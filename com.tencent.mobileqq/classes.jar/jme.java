import android.graphics.Bitmap;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketGameEmojiAnimation;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.app.ThreadManager;

public class jme
  implements Runnable
{
  public jme(RedPacketGameView paramRedPacketGameView, AVRedPacketManager paramAVRedPacketManager) {}
  
  public void run()
  {
    Object localObject = (AVActivity)this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.getContext();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.a != null))
    {
      localObject = ((AVActivity)localObject).a;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.a.b(true);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.setDrawingCacheEnabled(true);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.getDrawingCache();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.a.b(false);
      ThreadManager.postImmediately(new jmf(this, (VideoLayerUI)localObject, localBitmap), null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jme
 * JD-Core Version:    0.7.0.1
 */