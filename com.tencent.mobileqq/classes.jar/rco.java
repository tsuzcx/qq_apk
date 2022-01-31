import android.os.Handler;
import android.os.Message;
import android.view.View;

class rco
  extends Handler
{
  rco(rcn paramrcn) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = 1;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      int i;
      if ((rcn.a(this.a) != null) && (rcn.a(this.a) != null))
      {
        i = 1;
        label51:
        if ((rcn.a(this.a) == null) || (!rcn.a(this.a).a())) {
          break label130;
        }
      }
      while ((i != 0) && (rcn.a(this.a).getVisibility() == 0) && (j == 0) && (bkbq.f()))
      {
        rcn.a(this.a, rcn.a(this.a));
        sendEmptyMessageDelayed(2, 3000L);
        return;
        i = 0;
        break label51;
        label130:
        j = 0;
      }
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rco
 * JD-Core Version:    0.7.0.1
 */