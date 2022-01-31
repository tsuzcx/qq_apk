import android.os.Handler;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;

public class jpy
  implements Runnable
{
  public jpy(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void run()
  {
    if (!this.a.d)
    {
      boolean bool = SmallScreenUtils.c(((AppInterface)BaseSmallScreenService.a(this.a)).getApp());
      if (bool != this.a.e)
      {
        this.a.e = bool;
        this.a.e();
      }
      bool = SmallScreenUtils.e();
      if (bool != this.a.b)
      {
        this.a.b = bool;
        this.a.d();
      }
      bool = SmallScreenUtils.b(((AppInterface)BaseSmallScreenService.b(this.a)).getApp());
      if (bool != this.a.c)
      {
        this.a.c = bool;
        this.a.c();
      }
      bool = this.a.a();
      if (bool != this.a.f)
      {
        this.a.f = bool;
        this.a.f();
        if (!bool) {
          break label188;
        }
      }
    }
    label188:
    for (long l = 1L;; l = 2L)
    {
      VideoNodeManager.a(20, l);
      this.a.a().postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jpy
 * JD-Core Version:    0.7.0.1
 */