import com.tencent.av.gameplay.ARNativeBridge;
import com.tencent.av.ui.GamePlayView;

public class jxa
  implements Runnable
{
  public jxa(GamePlayView paramGamePlayView, float paramFloat1, float paramFloat2, boolean paramBoolean) {}
  
  public void run()
  {
    GamePlayView.a(this.jdField_a_of_type_ComTencentAvUiGamePlayView).native_updateEmitterLocation(this.jdField_a_of_type_Float, this.b, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jxa
 * JD-Core Version:    0.7.0.1
 */