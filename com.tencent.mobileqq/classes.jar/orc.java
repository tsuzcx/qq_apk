import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class orc
  implements old
{
  public orc(ADVideoAppDownloadManager paramADVideoAppDownloadManager, orb paramorb) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.d("ADVideoAppDownloadManager", 1, "already finishDownload." + this.jdField_a_of_type_Orb.d);
      ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a = true;
      ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a();
      ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).c(this.jdField_a_of_type_Orb);
    }
    label70:
    do
    {
      do
      {
        do
        {
          do
          {
            break label70;
            break label70;
            do
            {
              return;
            } while ((ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager) == null) || (ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a == null) || (ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a.a == null) || (!oqi.d(ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a.a.a)));
            int j = ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager, ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager), this.jdField_a_of_type_Orb);
            int i = j;
            if (j == -1)
            {
              i = j;
              if (this.jdField_a_of_type_Orb.b > 0) {
                i = this.jdField_a_of_type_Orb.b;
              }
            }
            if ((i < 0) || ((this.jdField_a_of_type_Orb.a != 3) && (this.jdField_a_of_type_Orb.a != 4))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading.isPkgDownloading." + this.jdField_a_of_type_Orb.d + " " + i);
            }
            if (this.jdField_a_of_type_Orb.a == 3)
            {
              ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).b(this.jdField_a_of_type_Orb, i);
              return;
            }
          } while (this.jdField_a_of_type_Orb.a != 4);
          ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a(this.jdField_a_of_type_Orb);
          return;
          if ((!ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a) && ((!ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager)) || (!acrw.a()))) {
            break;
          }
          if (ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager).a)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "autodownload not by userClick");
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a(this.jdField_a_of_type_Orb, 0);
            return;
          }
        } while ((!ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager)) || (!acrw.a()));
        if (!ADVideoAppDownloadManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ADVideoAppDownloadManager", 2, "autodownload for getAppData <1s");
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a(this.jdField_a_of_type_Orb, 0);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "dont autodownload for getAppData >1s");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orc
 * JD-Core Version:    0.7.0.1
 */