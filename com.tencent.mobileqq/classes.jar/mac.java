import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class mac
  implements VideoPreDownloadMgr.PreDownloadController
{
  public mac(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public List a(int paramInt, boolean paramBoolean)
  {
    int m = 0;
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    List localList;
    int j;
    int i;
    VideoInfo localVideoInfo;
    if (paramInt >= 0)
    {
      localList = VideoFeedsAdapter.a(this.a);
      j = paramInt + 1;
      if (j >= localList.size()) {
        break label324;
      }
      if (paramBoolean) {}
      for (i = 4;; i = 3)
      {
        int n = Math.min(i + paramInt, localList.size() - 1);
        i = 0;
        while (j <= n)
        {
          localVideoInfo = (VideoInfo)localList.get(j);
          localArrayList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, localVideoInfo.jdField_a_of_type_Int));
          i += 1;
          j += 1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + i);
      }
      j = paramInt - 1;
      i = m;
      if (j >= 0)
      {
        if (paramBoolean) {}
        for (i = 1;; i = 2)
        {
          m = Math.max(paramInt - i, 0);
          paramInt = k;
          for (;;)
          {
            i = paramInt;
            if (j < m) {
              break;
            }
            localVideoInfo = (VideoInfo)localList.get(j);
            localArrayList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, localVideoInfo.jdField_a_of_type_Int));
            paramInt += 1;
            j -= 1;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + i);
      }
      return localArrayList;
      label324:
      i = 0;
    }
  }
  
  public boolean a()
  {
    return NetworkUtil.h(VideoFeedsAdapter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */