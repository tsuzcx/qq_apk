import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.qphone.base.util.QLog;

public class kda
  implements Runnable
{
  public kda(VideoNetStateBar paramVideoNetStateBar) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoNetStateBar", 2, "mVideoController == null");
      }
      return;
    }
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.f();
    this.a.e = true;
    switch (i)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = 1;
      if (QLog.isColorLevel()) {
        QLog.d("VideoNetStateBar", 2, String.format("getGAudioNetLevel[%s], mCurNetLevel[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.a.b) }));
      }
      if ((this.a.jdField_a_of_type_JavaLangRunnable == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
      return;
      this.a.b = 3;
      continue;
      this.a.b = 2;
      continue;
      this.a.b = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kda
 * JD-Core Version:    0.7.0.1
 */