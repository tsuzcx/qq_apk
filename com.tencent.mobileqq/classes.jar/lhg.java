import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;

class lhg
  extends BroadcastReceiver
{
  lhg(lhf paramlhf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((lhf.a(this.a) != null) && (lhf.a(this.a).a != null))
    {
      ((lkz)lhf.a(this.a).a(4)).a(i);
      lkx.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lhg
 * JD-Core Version:    0.7.0.1
 */