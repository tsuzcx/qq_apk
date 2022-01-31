import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import java.util.HashSet;
import java.util.Set;

public class odb
  extends rnr
{
  private Set<String> a;
  public odd a;
  private Handler b = new odc(this, Looper.getMainLooper());
  
  public odb(odd paramodd, rnv paramrnv, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    super(paramrnv, paramVideoFeedsPlayManager, paramBoolean);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Odd = paramodd;
  }
  
  public void a(rfs paramrfs)
  {
    super.a(paramrfs);
    Log.d("MultiVideoAd", "onVideoStart");
    this.b.sendEmptyMessageDelayed(101, 3000L);
    if ((this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
    {
      paramrfs = this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.h;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramrfs))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramrfs);
        paramrfs = noy.a(this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
        if (!this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_Odd.jdField_a_of_type_AndroidAppActivity)) {
          break label187;
        }
        noy.a(new obk().a(this.jdField_a_of_type_Odd.jdField_a_of_type_AndroidAppActivity).a(noy.b).b(noy.P).a(paramrfs).a(this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
      }
    }
    return;
    label187:
    noy.a(new obk().a(this.jdField_a_of_type_Odd.jdField_a_of_type_AndroidAppActivity).a(noy.b).b(noy.N).a(paramrfs).a(this.jdField_a_of_type_Odd.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
  }
  
  public void b(rfs paramrfs)
  {
    super.b(paramrfs);
    Log.d("MultiVideoAd", "onVideoRestart");
    this.b.removeMessages(101);
    this.b.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void c(rfs paramrfs)
  {
    super.c(paramrfs);
    Log.d("MultiVideoAd", "onVideoStop");
    this.b.removeMessages(101);
  }
  
  public void d(rfs paramrfs)
  {
    super.d(paramrfs);
    Log.d("MultiVideoAd", "onVideoPause");
    this.b.removeMessages(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     odb
 * JD-Core Version:    0.7.0.1
 */