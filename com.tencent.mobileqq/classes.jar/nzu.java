import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import java.util.HashSet;
import java.util.Set;

public class nzu
  extends qyj
{
  private Set<String> a;
  public nzw a;
  private Handler b = new nzv(this, Looper.getMainLooper());
  
  public nzu(nzw paramnzw, qyn paramqyn, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    super(paramqyn, paramVideoFeedsPlayManager, paramBoolean);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Nzw = paramnzw;
  }
  
  public void a(qqo paramqqo)
  {
    super.a(paramqqo);
    Log.d("MultiVideoAd", "onVideoStart");
    this.b.sendEmptyMessageDelayed(101, 3000L);
    if ((this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
    {
      paramqqo = this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.h;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramqqo))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramqqo);
        paramqqo = nmf.a(this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
        if (!this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_Nzw.jdField_a_of_type_AndroidAppActivity)) {
          break label187;
        }
        nmf.a(new nyg().a(this.jdField_a_of_type_Nzw.jdField_a_of_type_AndroidAppActivity).a(nmf.b).b(nmf.P).a(paramqqo).a(this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
      }
    }
    return;
    label187:
    nmf.a(new nyg().a(this.jdField_a_of_type_Nzw.jdField_a_of_type_AndroidAppActivity).a(nmf.b).b(nmf.N).a(paramqqo).a(this.jdField_a_of_type_Nzw.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a());
  }
  
  public void b(qqo paramqqo)
  {
    super.b(paramqqo);
    Log.d("MultiVideoAd", "onVideoRestart");
    this.b.removeMessages(101);
    this.b.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void c(qqo paramqqo)
  {
    super.c(paramqqo);
    Log.d("MultiVideoAd", "onVideoStop");
    this.b.removeMessages(101);
  }
  
  public void d(qqo paramqqo)
  {
    super.d(paramqqo);
    Log.d("MultiVideoAd", "onVideoPause");
    this.b.removeMessages(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzu
 * JD-Core Version:    0.7.0.1
 */