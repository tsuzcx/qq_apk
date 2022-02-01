import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class pjy
{
  private static volatile pjy jdField_a_of_type_Pjy;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final pjx jdField_a_of_type_Pjx = new pjx();
  
  private pjy()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Pjx);
  }
  
  public static pjy a()
  {
    if (jdField_a_of_type_Pjy != null) {
      return jdField_a_of_type_Pjy;
    }
    try
    {
      if (jdField_a_of_type_Pjy == null) {
        jdField_a_of_type_Pjy = new pjy();
      }
      return jdField_a_of_type_Pjy;
    }
    finally {}
  }
  
  private void a(pjz parampjz)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, parampjz), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bixg.a().a(paramDownloadInfo);
    a(new pjz(paramDownloadInfo, null));
  }
  
  public void a(pjw parampjw)
  {
    this.jdField_a_of_type_Pjx.a(parampjw);
  }
  
  public void b(pjw parampjw)
  {
    this.jdField_a_of_type_Pjx.b(parampjw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjy
 * JD-Core Version:    0.7.0.1
 */