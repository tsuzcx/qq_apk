import android.graphics.Bitmap;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketGameEmojiAnimation;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.app.ThreadManager;

public class jlp
  implements Runnable
{
  public jlp(RedPacketGameView paramRedPacketGameView, AVRedPacketManager paramAVRedPacketManager) {}
  
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
      ThreadManager.postImmediately(new jlq(this, (VideoLayerUI)localObject, localBitmap), null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlp
 * JD-Core Version:    0.7.0.1
 */