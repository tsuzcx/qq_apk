import com.tencent.av.gameplay.ARNativeBridge;
import com.tencent.av.ui.GamePlayView;

public class jvo
  implements Runnable
{
  public jvo(GamePlayView paramGamePlayView, boolean paramBoolean) {}
  
  public void run()
  {
    GamePlayView.a(this.jdField_a_of_type_ComTencentAvUiGamePlayView).native_stopEmitter(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvo
 * JD-Core Version:    0.7.0.1
 */