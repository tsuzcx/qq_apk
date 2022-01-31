import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mpi
  implements Runnable
{
  public mpi(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void run()
  {
    Object localObject2 = FastWebVideoFeedsPlayManager.a(this.a);
    Object localObject1 = FastWebVideoFeedsPlayManager.a(this.a);
    if ((localObject2 == null) || (localObject1 == null)) {}
    long l;
    label299:
    label304:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            FastWebVideoFeedsPlayManager.a(this.a, true);
            l = 0L;
            File localFile;
            if (((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_Int == 0)
            {
              if (FastWebVideoFeedsPlayManager.a(this.a) > 0L)
              {
                l = FastWebVideoFeedsPlayManager.a(this.a);
                FastWebVideoFeedsPlayManager.a(this.a, 0L);
              }
            }
            else
            {
              if (((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int != 0) {
                break;
              }
              localObject2 = ((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "Message For Short Video: " + ((MessageForShortVideo)localObject2).toLogString());
              }
              bool = true;
              localObject3 = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
              localFile = new File((String)localObject3);
              if (localFile.exists()) {
                if (localFile.length() >= ((MessageForShortVideo)localObject2).videoFileSize) {
                  break label299;
                }
              }
            }
            for (boolean bool = true;; bool = false)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "ShortVideo file.exists()=" + localFile.exists() + ", msg.videoFileStatus=" + ((MessageForShortVideo)localObject2).videoFileStatus + ", transferredSize=" + localFile.length() + ", msg.videoFileSize=" + ((MessageForShortVideo)localObject2).videoFileSize + ", needDownload=" + bool);
              }
              if (bool) {
                break label304;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "play short video from local");
              }
              ((VideoPlayerWrapper)localObject1).a(null, (String)localObject3, 4, l, 0L, 0);
              return;
              l = 0L;
              break;
            }
          } while (FastWebVideoFeedsPlayManager.a(this.a) == null);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putParcelable("VALUE_SHORTVIDEO_MSG", (Parcelable)localObject2);
          FastWebVideoFeedsPlayManager.a(this.a).a("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD", (Bundle)localObject1);
          return;
          if ((((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int == 1) || (((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int == 3))
          {
            ((VideoPlayerWrapper)localObject1).a(((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString, 2, l);
            return;
          }
          if ((((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int != 2) && ((((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString == null);
        Object localObject3 = ThirdVideoManager.a();
        ((ThirdVideoManager)localObject3).a(((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new mpj(this, (VideoPlayerWrapper)localObject1, l, (ThirdVideoManager)localObject3));
        return;
        if (((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString == null);
      ((VideoPlayerWrapper)localObject1).a("", ((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_JavaLangString, 2, l, 0L, 0);
      return;
    } while ((((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.p)));
    ((VideoPlayerWrapper)localObject1).a("", ((FastWebVideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.p, 2, l, 0L, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpi
 * JD-Core Version:    0.7.0.1
 */