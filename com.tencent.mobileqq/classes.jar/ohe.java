import android.os.SystemClock;
import com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.util.MqqWeakReferenceHandler;

public class ohe
  implements Runnable
{
  public ohe(DanceMachineUploadVideoFragment paramDanceMachineUploadVideoFragment) {}
  
  public void run()
  {
    try
    {
      i = DanceMachineUploadVideoFragment.a(this.a, DanceMachineUploadVideoFragment.a(this.a));
      if (i != 0)
      {
        DanceMachineUploadVideoFragment.a(this.a, -1L);
        this.a.a.setResult(2);
        this.a.a.finish();
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = -1;
        }
        DanceMachineUploadVideoFragment.a(this.a, SystemClock.elapsedRealtime());
      } while (DanceMachineUploadVideoFragment.a() == null);
      DanceMachineUploadVideoFragment.a().sendEmptyMessage(-2);
      DanceMachineUploadVideoFragment.a().sendEmptyMessageDelayed(-1, 120000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohe
 * JD-Core Version:    0.7.0.1
 */