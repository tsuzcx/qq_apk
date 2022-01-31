import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class mdb
  implements Runnable
{
  public mdb(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      try
      {
        boolean bool = VideoFeedsHelper.a(VideoFeedsPlayActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity), Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j).longValue());
        Object localObject = VideoFeedsPlayActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity);
        if (localObject != null)
        {
          i = 0;
          localObject = ((ArrayList)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
            j = i;
            if (localVideoInfo.j == null) {
              break label146;
            }
            j = i;
            if (!localVideoInfo.j.equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j)) {
              break label146;
            }
            if (localVideoInfo.g != bool) {
              i = 1;
            }
            localVideoInfo.g = bool;
            j = i;
            break label146;
          }
          if (i != 0) {
            VideoFeedsPlayActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      label146:
      int i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdb
 * JD-Core Version:    0.7.0.1
 */