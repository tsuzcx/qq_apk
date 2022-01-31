import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.utils.UITools;

public class kbh
  implements Runnable
{
  public kbh(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.h))
    {
      this.a.d = UITools.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
      Object localObject = this.a;
      ((VideoControlUI)localObject).jdField_k_of_type_Int += 1;
      if ((this.a.g != null) && (!this.a.j))
      {
        localObject = UITools.a(this.a.d);
        this.a.g.setContentDescription((CharSequence)localObject);
        this.a.f((String)localObject);
        this.a.d = this.a.a(this.a.d);
        if (!this.a.jdField_k_of_type_Boolean)
        {
          this.a.g.setText(this.a.d);
          this.a.e(this.a.d);
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.a.d);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbh
 * JD-Core Version:    0.7.0.1
 */