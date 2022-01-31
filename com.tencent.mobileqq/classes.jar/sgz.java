import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class sgz
  implements slx<tan, tby>
{
  sgz(sgs paramsgs, String paramString, Object paramObject, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2) {}
  
  public void a(@NonNull tan arg1, @Nullable tby paramtby, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramtby != null))
    {
      urk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url success , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
      ??? = (sqd)sqg.a(5);
      if (paramtby.a != null)
      {
        paramErrorMessage = paramtby.a.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramtby.a = ???.a(paramtby.a);
      ((sgs)sqg.a(28)).a(paramtby.b);
      this.jdField_a_of_type_Sgs.c(this.jdField_a_of_type_JavaLangString, 0);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        try
        {
          if (this.b.get()) {
            this.jdField_a_of_type_JavaLangObject.notifyAll();
          }
          return;
          urk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url fail , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        }
        catch (Exception paramtby)
        {
          for (;;)
          {
            urk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary lock error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgz
 * JD-Core Version:    0.7.0.1
 */