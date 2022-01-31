import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import java.util.HashSet;
import java.util.Set;

public class nzr
  extends qyg
{
  private Set<String> a;
  public nzt a;
  private Handler b = new nzs(this, Looper.getMainLooper());
  
  public nzr(nzt paramnzt, qyk paramqyk, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    super(paramqyk, paramVideoFeedsPlayManager, paramBoolean);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Nzt = paramnzt;
  }
  
  public void a(qql paramqql)
  {
    super.a(paramqql);
    Log.d("MultiVideoAd", "onVideoStart");
    this.b.sendEmptyMessageDelayed(101, 3000L);
    if ((this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
    {
      paramqql = this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.h;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramqql))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramqql);
        paramqql = nmc.a(this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
        if (!this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_Nzt.jdField_a_of_type_AndroidAppActivity)) {
          break label187;
        }
        nmc.a(new nyd().a(this.jdField_a_of_type_Nzt.jdField_a_of_type_AndroidAppActivity).a(nmc.b).b(nmc.P).a(paramqql).a(this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
      }
    }
    return;
    label187:
    nmc.a(new nyd().a(this.jdField_a_of_type_Nzt.jdField_a_of_type_AndroidAppActivity).a(nmc.b).b(nmc.N).a(paramqql).a(this.jdField_a_of_type_Nzt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
  }
  
  public void b(qql paramqql)
  {
    super.b(paramqql);
    Log.d("MultiVideoAd", "onVideoRestart");
    this.b.removeMessages(101);
    this.b.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void c(qql paramqql)
  {
    super.c(paramqql);
    Log.d("MultiVideoAd", "onVideoStop");
    this.b.removeMessages(101);
  }
  
  public void d(qql paramqql)
  {
    super.d(paramqql);
    Log.d("MultiVideoAd", "onVideoPause");
    this.b.removeMessages(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzr
 * JD-Core Version:    0.7.0.1
 */