import com.tencent.biz.pubaccount.readinjoy.download.ReadInJoyDownloader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import mqq.os.MqqHandler;

public class opz
{
  private static volatile opz jdField_a_of_type_Opz;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("ReadInJoyDownloader");
  private final opy jdField_a_of_type_Opy = new opy();
  
  private opz()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_Opy);
  }
  
  public static opz a()
  {
    if (jdField_a_of_type_Opz != null) {
      return jdField_a_of_type_Opz;
    }
    try
    {
      if (jdField_a_of_type_Opz == null) {
        jdField_a_of_type_Opz = new opz();
      }
      return jdField_a_of_type_Opz;
    }
    finally {}
  }
  
  private void a(oqa paramoqa)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyDownloader.1(this, paramoqa), 15000L);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    QLog.d("ReadInJoyDownloader", 2, "[startDownload] ");
    bdmt.a().a(paramDownloadInfo);
    a(new oqa(paramDownloadInfo, null));
  }
  
  public void a(opx paramopx)
  {
    this.jdField_a_of_type_Opy.a(paramopx);
  }
  
  public void b(opx paramopx)
  {
    this.jdField_a_of_type_Opy.b(paramopx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opz
 * JD-Core Version:    0.7.0.1
 */