import android.os.Handler;
import com.tencent.av.opengl.ui.GLRootView;

class nix
  implements nft
{
  nix(niv paramniv) {}
  
  public void a()
  {
    bkdp.c(this.a.a, "notifyCameraNoData ");
  }
  
  public void a(long paramLong)
  {
    bkdp.c(this.a.a, "onBeforeCloseCamera ");
    if (this.a.d()) {
      this.a.a(true);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    bkdp.c(this.a.a, "onBeforeOpenCamera ");
  }
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    bkdp.c(this.a.a, "onAfterOpenCamera ");
    niv.a(this.a, true);
    if (this.a.d()) {
      niv.a(this.a).sendEmptyMessageDelayed(6, 200L);
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    bkdp.c(this.a.a, "onAfterCloseCamera ");
    niv.a(this.a, false);
    if ((this.a.d()) && (niv.a(this.a) != null) && (niv.a(this.a).a() != null))
    {
      niv.a(this.a).a().requestRender();
      niv.a(this.a).sendEmptyMessageDelayed(3, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nix
 * JD-Core Version:    0.7.0.1
 */