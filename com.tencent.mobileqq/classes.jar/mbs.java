import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;

public class mbs
  extends Handler
{
  public mbs(AVActivity paramAVActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    long l = mur.a(paramMessage.obj);
    this.a.a(l, "handleMessage", true);
    if (this.a.jdField_a_of_type_Mji != null) {
      this.a.jdField_a_of_type_Mji.n();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l(this.a.jdField_a_of_type_Mji.a);
    }
    this.a.g(-1031L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mbs
 * JD-Core Version:    0.7.0.1
 */