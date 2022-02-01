import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class psy
{
  private static volatile psy jdField_a_of_type_Psy;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final psx jdField_a_of_type_Psx = new psx();
  
  private psy()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Psx);
  }
  
  public static psy a()
  {
    if (jdField_a_of_type_Psy != null) {
      return jdField_a_of_type_Psy;
    }
    try
    {
      if (jdField_a_of_type_Psy == null) {
        jdField_a_of_type_Psy = new psy();
      }
      return jdField_a_of_type_Psy;
    }
    finally {}
  }
  
  private void a(psz parampsz)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, parampsz), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bjop.a().a(paramDownloadInfo);
    a(new psz(paramDownloadInfo, null));
  }
  
  public void a(psw parampsw)
  {
    this.jdField_a_of_type_Psx.a(parampsw);
  }
  
  public void b(psw parampsw)
  {
    this.jdField_a_of_type_Psx.b(parampsw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psy
 * JD-Core Version:    0.7.0.1
 */