import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;

class leb
  extends BroadcastReceiver
{
  leb(lea paramlea) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((lea.a(this.a) != null) && (lea.a(this.a).a != null))
    {
      ((lhy)lea.a(this.a).a(4)).a(i);
      lhw.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     leb
 * JD-Core Version:    0.7.0.1
 */