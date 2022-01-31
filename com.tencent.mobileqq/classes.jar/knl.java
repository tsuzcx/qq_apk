import android.os.Handler;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.qphone.base.util.QLog;

public class knl
  implements Runnable
{
  public knl(BidDownloader paramBidDownloader) {}
  
  public void run()
  {
    int i = BidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader.a(BidDownloader.jdField_a_of_type_AndroidContentContext, this.a.c);
    if (QLog.isColorLevel()) {
      QLog.i(BidDownloader.d, 2, "state = " + i);
    }
    if (i != 2) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knl
 * JD-Core Version:    0.7.0.1
 */