import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;

public class mbg
  extends Handler
{
  public mbg(AVActivity paramAVActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    long l = mtm.a(paramMessage.obj);
    this.a.a(l, "handleMessage", true);
    if (this.a.jdField_a_of_type_Miq != null) {
      this.a.jdField_a_of_type_Miq.n();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(this.a.jdField_a_of_type_Miq.a);
    }
    this.a.g(-1031L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbg
 * JD-Core Version:    0.7.0.1
 */