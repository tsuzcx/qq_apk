import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import java.lang.ref.WeakReference;

public class nsd
  implements Runnable
{
  public nsd(ProgressControler paramProgressControler) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    IVideoView localIVideoView;
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_JavaLangRefWeakReference == null);
      localIVideoView = (IVideoView)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localIVideoView == null);
    if (localIVideoView.b() > 0L)
    {
      this.a.a(this.a.jdField_a_of_type_Int, localIVideoView.a(), localIVideoView.b(), localIVideoView);
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsd
 * JD-Core Version:    0.7.0.1
 */