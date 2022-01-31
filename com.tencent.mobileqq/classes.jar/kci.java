import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUIBase;

public class kci
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private final int c = 9;
  
  private kci(VideoLayerUIBase paramVideoLayerUIBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Float = ((paramInt4 - paramInt2) / 10.0F);
    this.jdField_b_of_type_Float = ((paramInt5 - paramInt3) / 10.0F);
    this.jdField_b_of_type_Int = paramInt1;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 9) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase.c(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase.a != null)
      {
        if (this.jdField_a_of_type_Int > 9) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase.a.a().postDelayed(this, 10L);
      }
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase.b((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase.i();
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase.a.a(new Object[] { Integer.valueOf(121) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kci
 * JD-Core Version:    0.7.0.1
 */