import android.app.Activity;
import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoDataManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class rmv
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private nsz jdField_a_of_type_Nsz;
  private nta jdField_a_of_type_Nta;
  private rmn jdField_a_of_type_Rmn;
  private rng jdField_a_of_type_Rng;
  
  rmv(Activity paramActivity, rmn paramrmn, rng paramrng)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rmn = paramrmn;
    this.jdField_a_of_type_Rng = paramrng;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Nsz = ((nsz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Nta = new rmw(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Nta);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MultiVideoDataManager.1(this, paramInt1, paramInt2), 1, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nta);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt1 + paramInt2) && (i < this.jdField_a_of_type_Rng.a().size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_Rng.a().get(i);
      if (localVideoInfo.p == 0) {
        this.jdField_a_of_type_Nsz.a(localVideoInfo.a, localVideoInfo.g);
      }
      i += 1;
    }
    b(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rmv
 * JD-Core Version:    0.7.0.1
 */