import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import com.tencent.av.ui.QavPanel;

public class miz
  extends Handler
{
  public miz(QavPanel paramQavPanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QavPanel.a(this.a);
          return;
          QavPanel.b(this.a);
          return;
        } while ((mvk.a(false)) || (this.a.h == null) || (!this.a.h.isShown()));
        this.a.a(this.a.getResources().getString(2131692735));
        mvk.a(false);
        QavPanel.a(this.a).a();
        QavPanel.a(this.a).sendEmptyMessageDelayed(260, 5000L);
        return;
      } while ((mvk.a(true)) || (this.a.h == null) || (!this.a.h.isShown()) || (!QavPanel.a(this.a).a()));
      this.a.a(this.a.getResources().getString(2131692736));
      QavPanel.a(this.a).a();
      QavPanel.a(this.a).sendEmptyMessageDelayed(260, 5000L);
      mvk.a(true);
      return;
      this.a.a("MSG_TRY_CLEAN_TIPS", 1);
      return;
    } while (QavPanel.a(this.a) == null);
    QavPanel.a(this.a).a();
    QavPanel.a(this.a).sendEmptyMessageDelayed(261, 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     miz
 * JD-Core Version:    0.7.0.1
 */