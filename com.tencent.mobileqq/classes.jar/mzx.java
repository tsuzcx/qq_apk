import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class mzx
  extends SimpleJob
{
  public mzx(DownloadUrlManager paramDownloadUrlManager, String paramString, int paramInt) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    try
    {
      DownloadUrlManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager).lock();
      paramJobContext = DownloadingUrlEntry.makeKey(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      DownloadUrlManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager).remove(paramJobContext);
      paramJobContext = QQStoryContext.a().a().createEntityManager();
      paramVarArgs = StoryManager.a(paramJobContext, DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int) });
      if ((paramVarArgs != null) && (paramVarArgs.size() > 0))
      {
        paramVarArgs = (DownloadingUrlEntry)paramVarArgs.get(0);
        paramVarArgs.setStatus(1000);
        paramVarArgs.bIsDownloadCompleted = 1;
        paramJobContext.b(paramVarArgs);
      }
      return null;
    }
    finally
    {
      DownloadUrlManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzx
 * JD-Core Version:    0.7.0.1
 */