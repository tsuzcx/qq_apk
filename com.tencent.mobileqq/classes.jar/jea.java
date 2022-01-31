import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;

public class jea
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  
  public jea(VideoController paramVideoController, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().n < 0)
    {
      VcSystemInfo.a();
      long l = VcSystemInfo.c();
      int i = VcSystemInfo.f();
      int j = Build.VERSION.SDK_INT;
      if ((i < 4) || (l / 1000L < 800L) || (j < 9)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().n = 0;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c == 1L) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().m))) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().m });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.e();
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Jea = null;
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), this.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jea
 * JD-Core Version:    0.7.0.1
 */