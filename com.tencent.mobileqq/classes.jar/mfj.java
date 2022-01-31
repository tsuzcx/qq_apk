import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class mfj
  implements Runnable
{
  private List jdField_a_of_type_JavaUtilList;
  
  public mfj(VideoPreDownloadMgr paramVideoPreDownloadMgr, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void run()
  {
    if ((VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr) == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr) == null)) {}
    do
    {
      return;
      int j;
      for (int i = 0; i < this.jdField_a_of_type_JavaUtilList.size(); i = j + 1)
      {
        localObject1 = (VideoPreDownloadMgr.VideoPreDownloadParam)this.jdField_a_of_type_JavaUtilList.get(i);
        j = i;
        if (VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr).contains(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject1).a))
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          j = i - 1;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        VideoPreDownloadMgr.VideoPreDownloadParam localVideoPreDownloadParam;
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + localVideoPreDownloadParam.a + " | ") {
          localVideoPreDownloadParam = (VideoPreDownloadMgr.VideoPreDownloadParam)((Iterator)localObject2).next();
        }
        QLog.i(VideoPreDownloadMgr.a(), 2, "当前预下载列表: " + (String)localObject1);
      }
    } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
    Object localObject1 = (VideoPreDownloadMgr.VideoPreDownloadParam)this.jdField_a_of_type_JavaUtilList.get(0);
    Object localObject2 = VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(VideoPreDownloadMgr.a(), 2, "当前没有做预下载，启动预下载");
      }
      VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, this.jdField_a_of_type_JavaUtilList);
      VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
      return;
    }
    if (((String)localObject2).equals(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject1).a))
    {
      if (QLog.isColorLevel()) {
        QLog.i(VideoPreDownloadMgr.a(), 2, "当前预下载与list第一项一致");
      }
      this.jdField_a_of_type_JavaUtilList.remove(0);
      VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "当前预下载与list第一项不一致，暂停预下载任务，重新启动预下载");
    }
    VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.e();
    VideoPreDownloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfj
 * JD-Core Version:    0.7.0.1
 */