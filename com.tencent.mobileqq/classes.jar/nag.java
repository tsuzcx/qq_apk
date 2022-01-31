import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader.OnPreloadListener;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.IOnQueueStateChangeListener;
import com.tencent.biz.qqstory.base.preload.PreloadQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class nag
  implements Runnable
{
  public volatile boolean a;
  
  private nag(PreloadDownloader paramPreloadDownloader)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue == null)
      {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloaderManager$IOnQueueStateChangeListener.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a());
        }
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        DownloadTask localDownloadTask1 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_ComTencentBizQqstoryBasePreloadDownloadTask;
        if (localDownloadTask1 != null)
        {
          localDownloadTask1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
              if (localOnPreloadListener != null) {
                localOnPreloadListener.a(localDownloadTask1.jdField_b_of_type_JavaLangString, localDownloadTask1.a, localDownloadTask1);
              }
            }
            localIterator.remove();
          }
          localDownloadTask2.jdField_b_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.b(localDownloadTask2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nag
 * JD-Core Version:    0.7.0.1
 */