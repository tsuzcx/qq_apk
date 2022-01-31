import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.av.redpacket.ui.RedPacketGameView;

public class jmh
  implements Runnable
{
  public jmh(RedPacketGameView paramRedPacketGameView, ViewGroup paramViewGroup) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.c != null)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.c.recycle();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.c = null;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.b != null)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.b.recycle();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.b = null;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmh
 * JD-Core Version:    0.7.0.1
 */