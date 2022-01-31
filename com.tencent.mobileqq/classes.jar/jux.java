import com.tencent.av.gameplay.ARNativeBridge;
import com.tencent.av.ui.GamePlayView;

public class jux
  implements Runnable
{
  public jux(GamePlayView paramGamePlayView, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    GamePlayView.a(this.jdField_a_of_type_ComTencentAvUiGamePlayView).native_updateParticleTexture(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jux
 * JD-Core Version:    0.7.0.1
 */