import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;

public class mbb
  extends Handler
{
  public mbb(AVActivity paramAVActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    long l = mtj.a(paramMessage.obj);
    this.a.a(l, "handleMessage", true);
    if (this.a.jdField_a_of_type_Min != null) {
      this.a.jdField_a_of_type_Min.n();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(this.a.jdField_a_of_type_Min.a);
    }
    this.a.g(-1031L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbb
 * JD-Core Version:    0.7.0.1
 */