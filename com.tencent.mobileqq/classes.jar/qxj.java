import android.app.Activity;
import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoDataManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class qxj
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private npt jdField_a_of_type_Npt;
  private npu jdField_a_of_type_Npu;
  private qxb jdField_a_of_type_Qxb;
  private qxu jdField_a_of_type_Qxu;
  
  qxj(Activity paramActivity, qxb paramqxb, qxu paramqxu)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qxb = paramqxb;
    this.jdField_a_of_type_Qxu = paramqxu;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onk.a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Npt = ((npt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Npu = new qxk(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Npu);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MultiVideoDataManager.1(this, paramInt1, paramInt2), 1, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Npu);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt1 + paramInt2) && (i < this.jdField_a_of_type_Qxu.a().size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_Qxu.a().get(i);
      if (localVideoInfo.s == 0) {
        this.jdField_a_of_type_Npt.a(localVideoInfo.a, localVideoInfo.g);
      }
      i += 1;
    }
    b(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxj
 * JD-Core Version:    0.7.0.1
 */