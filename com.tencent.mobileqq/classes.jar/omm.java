import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class omm
  extends AbsPreDownloadTask
{
  public omm(ArtFilterManager paramArtFilterManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, File paramFile, String paramString4)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "realStart download url:" + this.jdField_a_of_type_JavaLangString + " path:" + this.b);
    }
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager).getManager(46)).a(1);
    DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    localDownloadTask.l = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("md5", this.c);
    localBundle.putString("path", this.b);
    localDownloaderInterface.a(localDownloadTask, ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omm
 * JD-Core Version:    0.7.0.1
 */