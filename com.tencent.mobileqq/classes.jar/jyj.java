import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoEnterPageActivity;

public class jyj
  implements Runnable
{
  public jyj(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    Object localObject = "QQ电话";
    if (this.a.jdField_c_of_type_Int == 2) {
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(3000, String.valueOf(this.a.jdField_a_of_type_Long), null);
    }
    for (;;)
    {
      this.a.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.a;
      ((MultiVideoEnterPageActivity)localObject).g += 1;
      if (this.a.jdField_c_of_type_JavaLangRunnable != null)
      {
        if (this.a.g >= 3) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 1000L);
      }
      return;
      if (this.a.jdField_c_of_type_Int == 1) {
        localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1, String.valueOf(this.a.jdField_a_of_type_Long), null);
      }
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_c_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyj
 * JD-Core Version:    0.7.0.1
 */