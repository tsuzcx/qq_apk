import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;
import java.util.Set;

public class mtc
  implements Runnable
{
  public mtc(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((FastWebVideoFeedsPlayManager.a(this.a) != null) && (FastWebVideoFeedsPlayManager.a(this.a).c() == 2))
    {
      this.a.a(4);
      FastWebVideoFeedsPlayManager.a(this.a, 8);
      FastWebVideoFeedsPlayManager.a(this.a).d();
      if (FastWebVideoFeedsPlayManager.c(this.a))
      {
        String str = FastWebVideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.a.h;
        if (FastWebVideoFeedsPlayManager.a(this.a).contains(str)) {
          break label125;
        }
        FastWebVideoFeedsPlayManager.a(this.a).add(str);
        FastWebVideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.a;
      }
    }
    return;
    label125:
    FastWebVideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtc
 * JD-Core Version:    0.7.0.1
 */