import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;

class jlq
  implements Runnable
{
  jlq(jlp paramjlp, VideoLayerUI paramVideoLayerUI, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a[0].a();
      int i = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a[0].a().j();
      localBitmap1 = RedPacketGameView.a(this.jdField_a_of_type_Jlp.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView, localBitmap1, i * 90);
      i = localBitmap1.getHeight();
      int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * i / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      Bitmap localBitmap2 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      Rect localRect1 = new Rect(0, 0, localBitmap1.getWidth(), localBitmap1.getHeight());
      int k = localBitmap1.getWidth() * i / localBitmap1.getHeight();
      int m = i * -200 / 1334;
      Rect localRect2 = new Rect((j - k) / 2, m, (k + j) / 2, i + m);
      localCanvas.save();
      localCanvas.scale(-1.0F, 1.0F, j / 2, 0.0F);
      localCanvas.drawBitmap(localBitmap1, localRect1, localRect2, null);
      localCanvas.restore();
      localRect1.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      localRect2.set(0, 0, j, i);
      localCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, localRect2, null);
      this.jdField_a_of_type_Jlp.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.setDrawingCacheEnabled(false);
      localBitmap1.recycle();
      this.jdField_a_of_type_Jlp.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localBitmap2);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlq
 * JD-Core Version:    0.7.0.1
 */