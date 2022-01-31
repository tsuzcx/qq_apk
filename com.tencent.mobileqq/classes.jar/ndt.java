import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerDownloader;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import java.util.Map;

public class ndt
  extends Job
{
  public ndt(AsyncFileDownloader paramAsyncFileDownloader, DownloadTask paramDownloadTask) {}
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask);
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndt
 * JD-Core Version:    0.7.0.1
 */