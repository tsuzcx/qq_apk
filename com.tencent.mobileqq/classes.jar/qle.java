import android.app.Activity;
import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoDataManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class qle
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private nes jdField_a_of_type_Nes;
  private net jdField_a_of_type_Net;
  private qkw jdField_a_of_type_Qkw;
  private qlp jdField_a_of_type_Qlp;
  
  qle(Activity paramActivity, qkw paramqkw, qlp paramqlp)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qkw = paramqkw;
    this.jdField_a_of_type_Qlp = paramqlp;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)obz.a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Nes = ((nes)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Net = new qlf(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Net);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MultiVideoDataManager.1(this, paramInt1, paramInt2), 1, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Net);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt1 + paramInt2) && (i < this.jdField_a_of_type_Qlp.a().size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_Qlp.a().get(i);
      if (localVideoInfo.s == 0) {
        this.jdField_a_of_type_Nes.a(localVideoInfo.a, localVideoInfo.g);
      }
      i += 1;
    }
    b(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qle
 * JD-Core Version:    0.7.0.1
 */