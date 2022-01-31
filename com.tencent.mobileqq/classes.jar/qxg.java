import android.app.Activity;
import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoDataManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class qxg
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private npq jdField_a_of_type_Npq;
  private npr jdField_a_of_type_Npr;
  private qwy jdField_a_of_type_Qwy;
  private qxr jdField_a_of_type_Qxr;
  
  qxg(Activity paramActivity, qwy paramqwy, qxr paramqxr)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qwy = paramqwy;
    this.jdField_a_of_type_Qxr = paramqxr;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onh.a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Npq = ((npq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Npr = new qxh(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Npr);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MultiVideoDataManager.1(this, paramInt1, paramInt2), 1, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Npr);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt1 + paramInt2) && (i < this.jdField_a_of_type_Qxr.a().size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_Qxr.a().get(i);
      if (localVideoInfo.s == 0) {
        this.jdField_a_of_type_Npq.a(localVideoInfo.a, localVideoInfo.g);
      }
      i += 1;
    }
    b(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxg
 * JD-Core Version:    0.7.0.1
 */