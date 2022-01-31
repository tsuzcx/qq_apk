import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher;

public class nze
  extends ContentObserver
{
  public nze(LocalVideoPusher paramLocalVideoPusher, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (!this.a.a)
    {
      this.a.b();
      return;
    }
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nze
 * JD-Core Version:    0.7.0.1
 */