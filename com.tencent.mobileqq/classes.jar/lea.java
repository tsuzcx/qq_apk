import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;

class lea
  extends BroadcastReceiver
{
  lea(ldz paramldz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((ldz.a(this.a) != null) && (ldz.a(this.a).a != null))
    {
      ((lhw)ldz.a(this.a).a(4)).a(i);
      lhu.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lea
 * JD-Core Version:    0.7.0.1
 */