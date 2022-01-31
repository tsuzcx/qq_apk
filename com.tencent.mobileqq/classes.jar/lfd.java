import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;

class lfd
  extends BroadcastReceiver
{
  lfd(lfc paramlfc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((lfc.a(this.a) != null) && (lfc.a(this.a).a != null))
    {
      ((liw)lfc.a(this.a).a(4)).a(i);
      liu.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */