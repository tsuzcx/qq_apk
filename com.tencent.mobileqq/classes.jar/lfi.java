import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;

class lfi
  extends BroadcastReceiver
{
  lfi(lfh paramlfh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((lfh.a(this.a) != null) && (lfh.a(this.a).a != null))
    {
      ((ljb)lfh.a(this.a).a(4)).a(i);
      liz.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfi
 * JD-Core Version:    0.7.0.1
 */