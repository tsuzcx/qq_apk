import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class our
{
  private static volatile our jdField_a_of_type_Our;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final ouq jdField_a_of_type_Ouq = new ouq();
  
  private our()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Ouq);
  }
  
  public static our a()
  {
    if (jdField_a_of_type_Our != null) {
      return jdField_a_of_type_Our;
    }
    try
    {
      if (jdField_a_of_type_Our == null) {
        jdField_a_of_type_Our = new our();
      }
      return jdField_a_of_type_Our;
    }
    finally {}
  }
  
  private void a(ous paramous)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, paramous), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bflq.a().a(paramDownloadInfo);
    a(new ous(paramDownloadInfo, null));
  }
  
  public void a(oup paramoup)
  {
    this.jdField_a_of_type_Ouq.a(paramoup);
  }
  
  public void b(oup paramoup)
  {
    this.jdField_a_of_type_Ouq.b(paramoup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     our
 * JD-Core Version:    0.7.0.1
 */