import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

public class qkp
  extends ContentObserver
{
  public qkp(GdtVideoCommonView paramGdtVideoCommonView, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public boolean deliverSelfNotifications()
  {
    return super.deliverSelfNotifications();
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (GdtVideoCommonView.a(this.a) != null) {
      GdtVideoCommonView.a(this.a).post(new qkq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qkp
 * JD-Core Version:    0.7.0.1
 */