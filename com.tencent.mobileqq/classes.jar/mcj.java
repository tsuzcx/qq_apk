import android.content.IntentFilter;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mcj
{
  int jdField_a_of_type_Int = 0;
  DownloadInfo jdField_a_of_type_ComTencentAvSoDownloadInfo = null;
  ArrayList<mcf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  mcj()
  {
    a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    this.jdField_a_of_type_Int = mcl.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo);
    QLog.d("QavSo", 1, String.format("SoMgr, mStatusSo[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  DownloadInfo a()
  {
    if (this.jdField_a_of_type_ComTencentAvSoDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    }
    return this.jdField_a_of_type_ComTencentAvSoDownloadInfo;
  }
  
  boolean a()
  {
    this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    this.jdField_a_of_type_Int = mcl.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo);
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("checkResReady, mStatusSo[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    return 11 != this.jdField_a_of_type_Int;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.somgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new mck(this), localIntentFilter) != null;
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  boolean c()
  {
    this.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = mcl.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo);
    if (this.jdField_a_of_type_Int == 11)
    {
      this.jdField_a_of_type_Int = 12;
      BusinessCommonConfig.notifyQQDownload(3, null, 0);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSo", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusSo[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mcj
 * JD-Core Version:    0.7.0.1
 */