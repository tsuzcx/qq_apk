import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mhq
  implements Runnable
{
  public mhq(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    Object localObject2 = VideoFeedsPlayManager.a(this.a);
    Object localObject1 = VideoFeedsPlayManager.a(this.a);
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
          Object localObject4;
          do
          {
            return;
            VideoFeedsPlayManager.a(this.a, true);
            l = 0L;
            if (((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_Int == 0)
            {
              if (VideoFeedsPlayManager.a(this.a) > 0L)
              {
                l = VideoFeedsPlayManager.a(this.a);
                VideoFeedsPlayManager.a(this.a, 0L);
              }
            }
            else
            {
              if (((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) {
                break;
              }
              localObject2 = ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "Message For Short Video: " + ((MessageForShortVideo)localObject2).toLogString());
              }
              bool = true;
              localObject3 = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
              localObject4 = new File((String)localObject3);
              if (((File)localObject4).exists()) {
                if (((File)localObject4).length() >= ((MessageForShortVideo)localObject2).videoFileSize) {
                  break label299;
                }
              }
            }
            for (boolean bool = true;; bool = false)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "ShortVideo file.exists()=" + ((File)localObject4).exists() + ", msg.videoFileStatus=" + ((MessageForShortVideo)localObject2).videoFileStatus + ", transferredSize=" + ((File)localObject4).length() + ", msg.videoFileSize=" + ((MessageForShortVideo)localObject2).videoFileSize + ", needDownload=" + bool);
              }
              if (bool) {
                break label304;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "play short video from local");
              }
              ((VideoPlayerWrapper)localObject1).a(null, (String)localObject3, 4, l, 0L, 0);
              return;
              l = 0L;
              break;
            }
            localObject1 = FileTransferManager.a(VideoFeedsPlayManager.a(this.a));
            if (localObject1 != null)
            {
              if (VideoFeedsPlayManager.a(this.a) == null) {
                VideoFeedsPlayManager.a(this.a, new View(BaseApplicationImpl.getContext()));
              }
              VideoFeedsPlayManager.a(this.a, new mhr(this, (MessageForShortVideo)localObject2));
              ((FileTransferManager)localObject1).a(VideoFeedsPlayManager.a(this.a), VideoFeedsPlayManager.a(this.a));
            }
            ((MessageForShortVideo)localObject2).busiType = 0;
            localObject1 = ShortVideoBusiManager.a(VideoFeedsPlayManager.a(this.a), (MessageForShortVideo)localObject2, 1);
          } while (localObject1 == null);
          ShortVideoBusiManager.a((ShortVideoReq)localObject1, VideoFeedsPlayManager.a(this.a));
          return;
          if ((((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 1) || (((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 3) || (((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 7))
          {
            if (VideoFeedsPlayManager.a(this.a) != null)
            {
              localObject3 = VideoFeedsPlayManager.a(this.a);
              localObject4 = ((VideoPreDownloadMgr)localObject3).a;
              ((VideoPlayerWrapper)localObject1).b = ((VideoPreDownloadMgr)localObject3).a(null, ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
              ((VideoPreDownloadMgr)localObject3).a(((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, ((VideoPlayerWrapper)localObject1).b);
            }
            ((VideoPlayerWrapper)localObject1).a(((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 2, l);
            return;
          }
          if ((((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 2) && ((((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null);
        localObject3 = ThirdVideoManager.a();
        ((ThirdVideoManager)localObject3).a(((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new mhs(this, (VideoPlayerWrapper)localObject1, l, (ThirdVideoManager)localObject3));
        return;
        if (((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null);
      Object localObject3 = VideoFeedsPlayManager.a(this.a);
      if (localObject3 != null)
      {
        ((VideoPlayerWrapper)localObject1).b = ((VideoPreDownloadMgr)localObject3).a(((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + " ;isPreDownloadHit: " + ((VideoPlayerWrapper)localObject1).b);
        }
        ((VideoPreDownloadMgr)localObject3).a(((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, ((VideoPlayerWrapper)localObject1).b);
      }
      ((VideoPlayerWrapper)localObject1).a("", ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 2, l, 0L, ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, false, false);
      return;
    } while ((((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.n)));
    ((VideoPlayerWrapper)localObject1).a("", ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.n, 2, l, 0L, ((VideoFeedsPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhq
 * JD-Core Version:    0.7.0.1
 */