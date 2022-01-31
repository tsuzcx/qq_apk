import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;

public class jez
  implements Runnable
{
  public jez(VideoController paramVideoController, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a.a(3000, this.jdField_a_of_type_JavaLangString, null, true, true);
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a.getDisplayName(1004, this.b, this.jdField_a_of_type_JavaLangString);
    QAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a).a(this.c, str, localBitmap, this.jdField_a_of_type_JavaLangString, 57, 3000, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jez
 * JD-Core Version:    0.7.0.1
 */