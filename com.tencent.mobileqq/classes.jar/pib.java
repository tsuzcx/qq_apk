import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class pib
{
  private static volatile pib jdField_a_of_type_Pib;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final pia jdField_a_of_type_Pia = new pia();
  
  private pib()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Pia);
  }
  
  public static pib a()
  {
    if (jdField_a_of_type_Pib != null) {
      return jdField_a_of_type_Pib;
    }
    try
    {
      if (jdField_a_of_type_Pib == null) {
        jdField_a_of_type_Pib = new pib();
      }
      return jdField_a_of_type_Pib;
    }
    finally {}
  }
  
  private void a(pic parampic)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, parampic), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bidn.a().a(paramDownloadInfo);
    a(new pic(paramDownloadInfo, null));
  }
  
  public void a(phz paramphz)
  {
    this.jdField_a_of_type_Pia.a(paramphz);
  }
  
  public void b(phz paramphz)
  {
    this.jdField_a_of_type_Pia.b(paramphz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pib
 * JD-Core Version:    0.7.0.1
 */