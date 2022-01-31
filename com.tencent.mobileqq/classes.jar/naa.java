import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.DownloadResult;
import com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.InnerBaseDownloader;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader.OnPreloadListener;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class naa
  implements INetEngine.INetEngineListener
{
  public naa(AsyncFileDownloader.InnerBaseDownloader paramInnerBaseDownloader) {}
  
  public void a(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof DownloadTask)))
    {
      DownloadTask localDownloadTask = (DownloadTask)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
          if (localOnPreloadListener != null) {
            localOnPreloadListener.a(localDownloadTask.jdField_b_of_type_JavaLangString, localDownloadTask.jdField_a_of_type_Int, i, localDownloadTask);
          }
        }
      }
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 3) {}
    DownloadTask localDownloadTask;
    do
    {
      do
      {
        return;
        localObject = ((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).a();
      } while ((localObject == null) || (!(localObject instanceof DownloadTask)));
      localDownloadTask = (DownloadTask)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((DownloadTask)localObject).jdField_a_of_type_JavaLangString);
      localDownloadTask.jdField_b_of_type_Long = (System.currentTimeMillis() - localDownloadTask.jdField_a_of_type_Long);
    } while (localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult == null);
    Object localObject = localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult;
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    for (paramNetResp = new ErrorMessage(0, "");; paramNetResp = new ErrorMessage(paramNetResp.b, paramNetResp.jdField_a_of_type_JavaLangString))
    {
      ((AsyncFileDownloader.DownloadResult)localObject).a(localDownloadTask, paramNetResp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     naa
 * JD-Core Version:    0.7.0.1
 */