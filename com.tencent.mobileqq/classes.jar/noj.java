import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import java.util.HashSet;
import java.util.Set;

public class noj
  extends qme
{
  private Set<String> a;
  public nol a;
  private Handler b = new nok(this, Looper.getMainLooper());
  
  public noj(nol paramnol, qmi paramqmi, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    super(paramqmi, paramVideoFeedsPlayManager, paramBoolean);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Nol = paramnol;
  }
  
  public void a(qeq paramqeq)
  {
    super.a(paramqeq);
    Log.d("MultiVideoAd", "onVideoStart");
    this.b.sendEmptyMessageDelayed(101, 3000L);
    if ((this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
    {
      paramqeq = this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.h;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramqeq))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramqeq);
        paramqeq = nbe.a(this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
        if (!this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_Nol.jdField_a_of_type_AndroidAppActivity)) {
          break label187;
        }
        nbe.a(new nmv().a(this.jdField_a_of_type_Nol.jdField_a_of_type_AndroidAppActivity).a(nbe.b).b(nbe.P).a(paramqeq).a(this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
      }
    }
    return;
    label187:
    nbe.a(new nmv().a(this.jdField_a_of_type_Nol.jdField_a_of_type_AndroidAppActivity).a(nbe.b).b(nbe.N).a(paramqeq).a(this.jdField_a_of_type_Nol.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
  }
  
  public void b(qeq paramqeq)
  {
    super.b(paramqeq);
    Log.d("MultiVideoAd", "onVideoRestart");
    this.b.removeMessages(101);
    this.b.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void c(qeq paramqeq)
  {
    super.c(paramqeq);
    Log.d("MultiVideoAd", "onVideoStop");
    this.b.removeMessages(101);
  }
  
  public void d(qeq paramqeq)
  {
    super.d(paramqeq);
    Log.d("MultiVideoAd", "onVideoPause");
    this.b.removeMessages(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noj
 * JD-Core Version:    0.7.0.1
 */