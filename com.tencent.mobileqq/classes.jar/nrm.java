import android.os.Handler;
import com.tencent.av.opengl.ui.GLRootView;

class nrm
  implements nnt
{
  nrm(nrk paramnrk) {}
  
  public void a()
  {
    bjuc.c(this.a.a, "notifyCameraNoData ");
  }
  
  public void a(long paramLong)
  {
    bjuc.c(this.a.a, "onBeforeCloseCamera ");
    if (this.a.d()) {
      this.a.a(true);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    bjuc.c(this.a.a, "onBeforeOpenCamera ");
  }
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    bjuc.c(this.a.a, "onAfterOpenCamera ");
    nrk.a(this.a, true);
    if (this.a.d()) {
      nrk.a(this.a).sendEmptyMessageDelayed(6, 200L);
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    bjuc.c(this.a.a, "onAfterCloseCamera ");
    nrk.a(this.a, false);
    if ((this.a.d()) && (nrk.a(this.a) != null) && (nrk.a(this.a).a() != null))
    {
      nrk.a(this.a).a().requestRender();
      nrk.a(this.a).sendEmptyMessageDelayed(3, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrm
 * JD-Core Version:    0.7.0.1
 */