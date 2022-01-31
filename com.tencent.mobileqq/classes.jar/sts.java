import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class sts
  implements syq<tng, tor>
{
  sts(stl paramstl, String paramString, Object paramObject, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2) {}
  
  public void a(@NonNull tng arg1, @Nullable tor paramtor, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramtor != null))
    {
      ved.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url success , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
      ??? = (tcw)tcz.a(5);
      if (paramtor.a != null)
      {
        paramErrorMessage = paramtor.a.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramtor.a = ???.a(paramtor.a);
      ((stl)tcz.a(28)).a(paramtor.b);
      this.jdField_a_of_type_Stl.c(this.jdField_a_of_type_JavaLangString, 0);
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
          ved.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url fail , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        }
        catch (Exception paramtor)
        {
          for (;;)
          {
            ved.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary lock error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sts
 * JD-Core Version:    0.7.0.1
 */