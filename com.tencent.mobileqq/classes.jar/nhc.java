import android.os.Handler;
import com.tencent.av.opengl.ui.GLRootView;

class nhc
  implements nea
{
  nhc(nha paramnha) {}
  
  public void a()
  {
    bjcq.c(this.a.a, "notifyCameraNoData ");
  }
  
  public void a(long paramLong)
  {
    bjcq.c(this.a.a, "onBeforeCloseCamera ");
    if (this.a.d()) {
      this.a.a(true);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    bjcq.c(this.a.a, "onBeforeOpenCamera ");
  }
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    bjcq.c(this.a.a, "onAfterOpenCamera ");
    nha.a(this.a, true);
    if (this.a.d()) {
      nha.a(this.a).sendEmptyMessageDelayed(6, 200L);
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    bjcq.c(this.a.a, "onAfterCloseCamera ");
    nha.a(this.a, false);
    if ((this.a.d()) && (nha.a(this.a) != null) && (nha.a(this.a).a() != null))
    {
      nha.a(this.a).a().requestRender();
      nha.a(this.a).sendEmptyMessageDelayed(3, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhc
 * JD-Core Version:    0.7.0.1
 */