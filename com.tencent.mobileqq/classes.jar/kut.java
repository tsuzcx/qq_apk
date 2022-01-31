import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;

class kut
  extends BroadcastReceiver
{
  kut(kus paramkus) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((kus.a(this.a) != null) && (kus.a(this.a).a != null))
    {
      ((kyl)kus.a(this.a).a(4)).a(i);
      kyj.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kut
 * JD-Core Version:    0.7.0.1
 */