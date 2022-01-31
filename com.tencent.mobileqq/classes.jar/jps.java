import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;

public class jps
  extends VipFunCallMediaListener
{
  public jps(AVActivity paramAVActivity) {}
  
  public void a()
  {
    if (this.a.a != null) {
      this.a.a.a().postDelayed(new jpt(this), 0L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      this.a.a.a().post(new jpu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jps
 * JD-Core Version:    0.7.0.1
 */