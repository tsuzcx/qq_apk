import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class oqc
{
  private static volatile oqc jdField_a_of_type_Oqc;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final oqb jdField_a_of_type_Oqb = new oqb();
  
  private oqc()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Oqb);
  }
  
  public static oqc a()
  {
    if (jdField_a_of_type_Oqc != null) {
      return jdField_a_of_type_Oqc;
    }
    try
    {
      if (jdField_a_of_type_Oqc == null) {
        jdField_a_of_type_Oqc = new oqc();
      }
      return jdField_a_of_type_Oqc;
    }
    finally {}
  }
  
  private void a(oqd paramoqd)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, paramoqd), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bdme.a().a(paramDownloadInfo);
    a(new oqd(paramDownloadInfo, null));
  }
  
  public void a(oqa paramoqa)
  {
    this.jdField_a_of_type_Oqb.a(paramoqa);
  }
  
  public void b(oqa paramoqa)
  {
    this.jdField_a_of_type_Oqb.b(paramoqa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqc
 * JD-Core Version:    0.7.0.1
 */