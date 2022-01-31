import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class mld
  implements VideoPreDownloadMgr.PreDownloadController
{
  private int jdField_a_of_type_Int = 10;
  
  public mld(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public List a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int k;
    label43:
    int m;
    BaseArticleInfo localBaseArticleInfo;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c == 0)
      {
        i = 0;
        k = i + paramInt;
        i = 0;
        j = i;
        if (k >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount()) {
          break label200;
        }
        j = i;
        if (k >= this.jdField_a_of_type_Int + paramInt) {
          break label200;
        }
        m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(k);
        if ((m != 4) && (m != 6))
        {
          j = i;
          if (m != 66) {}
        }
        else
        {
          localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(k);
          if (localBaseArticleInfo != null) {
            break label142;
          }
          j = i;
        }
      }
      label142:
      do
      {
        k += 1;
        i = j;
        break label43;
        i = 1;
        break;
        localArrayList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID, localBaseArticleInfo.busiType, localBaseArticleInfo.getVideoDuration()));
        i += 1;
        if (!paramBoolean) {
          break label336;
        }
        m = 4;
        j = i;
      } while (i < m);
    }
    for (int j = i;; j = 0)
    {
      label200:
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + j);
      }
      if (paramInt >= 0)
      {
        k = paramInt - 1;
        i = 0;
        label252:
        j = i;
        if (k > 0)
        {
          j = i;
          if (k > paramInt - this.jdField_a_of_type_Int)
          {
            j = i;
            if (k < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount())
            {
              j = i;
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(k) == 4)
              {
                localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(k);
                if (localBaseArticleInfo != null) {
                  break label342;
                }
                j = i;
              }
              label336:
              label342:
              do
              {
                k -= 1;
                i = j;
                break label252;
                m = 3;
                break;
                localArrayList.add(new VideoPreDownloadMgr.VideoPreDownloadParam(localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID, localBaseArticleInfo.busiType, localBaseArticleInfo.getVideoDuration()));
                i += 1;
                if (!paramBoolean) {
                  break label444;
                }
                m = 1;
                j = i;
              } while (i < m);
            }
          }
        }
      }
      for (j = i;; j = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + j);
        }
        return localArrayList;
        label444:
        m = 2;
        break;
      }
    }
  }
  
  public boolean a()
  {
    return NetworkUtil.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mld
 * JD-Core Version:    0.7.0.1
 */