import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;

public class jqh
  extends VipFunCallMediaListener
{
  public jqh(AVActivity paramAVActivity) {}
  
  public void a()
  {
    if (this.a.a != null) {
      this.a.a.a().postDelayed(new jqi(this), 0L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      this.a.a.a().post(new jqj(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqh
 * JD-Core Version:    0.7.0.1
 */