import android.os.Handler;
import com.tencent.av.opengl.ui.GLRootView;

class nkm
  implements nhb
{
  nkm(nkk paramnkk) {}
  
  public void a()
  {
    bija.c(this.a.a, "notifyCameraNoData ");
  }
  
  public void a(long paramLong)
  {
    bija.c(this.a.a, "onBeforeCloseCamera ");
    if (this.a.d()) {
      this.a.a(true);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    bija.c(this.a.a, "onBeforeOpenCamera ");
  }
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    bija.c(this.a.a, "onAfterOpenCamera ");
    nkk.a(this.a, true);
    if (this.a.d()) {
      nkk.a(this.a).sendEmptyMessageDelayed(6, 200L);
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    bija.c(this.a.a, "onAfterCloseCamera ");
    nkk.a(this.a, false);
    if ((this.a.d()) && (nkk.a(this.a) != null) && (nkk.a(this.a).a() != null))
    {
      nkk.a(this.a).a().requestRender();
      nkk.a(this.a).sendEmptyMessageDelayed(3, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkm
 * JD-Core Version:    0.7.0.1
 */