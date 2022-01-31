import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;

public class jrv
  extends VipFunCallMediaListener
{
  public jrv(AVActivity paramAVActivity) {}
  
  public void a()
  {
    if (this.a.a != null) {
      this.a.a.a().postDelayed(new jrw(this), 0L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      this.a.a.a().post(new jrx(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jrv
 * JD-Core Version:    0.7.0.1
 */