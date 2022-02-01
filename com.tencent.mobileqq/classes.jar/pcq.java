import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class pcq
{
  private static volatile pcq jdField_a_of_type_Pcq;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final pcp jdField_a_of_type_Pcp = new pcp();
  
  private pcq()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Pcp);
  }
  
  public static pcq a()
  {
    if (jdField_a_of_type_Pcq != null) {
      return jdField_a_of_type_Pcq;
    }
    try
    {
      if (jdField_a_of_type_Pcq == null) {
        jdField_a_of_type_Pcq = new pcq();
      }
      return jdField_a_of_type_Pcq;
    }
    finally {}
  }
  
  private void a(pcr parampcr)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, parampcr), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bjyf.a().a(paramDownloadInfo);
    a(new pcr(paramDownloadInfo, null));
  }
  
  public void a(pco parampco)
  {
    this.jdField_a_of_type_Pcp.a(parampco);
  }
  
  public void b(pco parampco)
  {
    this.jdField_a_of_type_Pcp.b(parampco);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcq
 * JD-Core Version:    0.7.0.1
 */