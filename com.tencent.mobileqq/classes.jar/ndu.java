import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.DownloadResult;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerAIOShortVideoDownloader;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class ndu
  implements UiCallBack
{
  public ndu(AsyncFileDownloader.InnerAIOShortVideoDownloader paramInnerAIOShortVideoDownloader, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    DownloadTask localDownloadTask;
    if (paramShortVideoResult.jdField_a_of_type_Int == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.jdField_a_of_type_JavaLangObject;
      localDownloadTask = (DownloadTask)this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerAIOShortVideoDownloader.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localDownloadTask != null)
      {
        if (!new File(paramShortVideoResult.b).exists()) {
          break label99;
        }
        localDownloadTask.b = (System.currentTimeMillis() - localDownloadTask.jdField_a_of_type_Long);
        if (localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult != null) {
          localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult.a(localDownloadTask, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        SLog.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        SLog.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(paramShortVideoResult.jdField_a_of_type_Int) });
        localDownloadTask = (DownloadTask)this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerAIOShortVideoDownloader.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localDownloadTask == null);
      localDownloadTask.b = (System.currentTimeMillis() - localDownloadTask.jdField_a_of_type_Long);
    } while (localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult == null);
    localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult.a(localDownloadTask, new ErrorMessage(paramShortVideoResult.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList paramArrayList) {}
  
  public void b(int paramInt, ShortVideoResult paramShortVideoResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndu
 * JD-Core Version:    0.7.0.1
 */