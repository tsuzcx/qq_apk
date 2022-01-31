import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class oer
{
  private static volatile oer jdField_a_of_type_Oer;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final oeq jdField_a_of_type_Oeq = new oeq();
  
  private oer()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Oeq);
  }
  
  public static oer a()
  {
    if (jdField_a_of_type_Oer != null) {
      return jdField_a_of_type_Oer;
    }
    try
    {
      if (jdField_a_of_type_Oer == null) {
        jdField_a_of_type_Oer = new oer();
      }
      return jdField_a_of_type_Oer;
    }
    finally {}
  }
  
  private void a(oes paramoes)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, paramoes), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bcid.a().a(paramDownloadInfo);
    a(new oes(paramDownloadInfo, null));
  }
  
  public void a(oep paramoep)
  {
    this.jdField_a_of_type_Oeq.a(paramoep);
  }
  
  public void b(oep paramoep)
  {
    this.jdField_a_of_type_Oeq.b(paramoep);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oer
 * JD-Core Version:    0.7.0.1
 */