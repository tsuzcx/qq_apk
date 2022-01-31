import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

public class qrw
  extends ContentObserver
{
  public qrw(GdtVideoCommonView paramGdtVideoCommonView, Handler paramHandler)
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
      GdtVideoCommonView.a(this.a).post(new qrx(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qrw
 * JD-Core Version:    0.7.0.1
 */