import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.biz.qqstory.base.preload.PreloadQueue;
import java.util.List;

@TargetApi(14)
public class suv
  implements suu
{
  public suv(sut paramsut) {}
  
  public void a(int paramInt)
  {
    int i = paramInt + 1;
    if (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      PreloadQueue localPreloadQueue = (PreloadQueue)this.a.jdField_a_of_type_JavaUtilList.get(i);
      ved.b("Q.qqstory.download.preload.PreloadDownloaderManager", "queue " + paramInt + " download completed , turn to " + localPreloadQueue.getId());
      this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localPreloadQueue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suv
 * JD-Core Version:    0.7.0.1
 */