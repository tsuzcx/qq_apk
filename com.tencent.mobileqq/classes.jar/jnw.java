import android.os.Bundle;
import android.os.Message;
import com.tencent.av.redpacket.ui.RedPacketRollTextView;

public class jnw
  implements Runnable
{
  public jnw(RedPacketRollTextView paramRedPacketRollTextView) {}
  
  public void run()
  {
    while ((RedPacketRollTextView.b(this.a) != RedPacketRollTextView.c(this.a)) && (this.a.a)) {
      try
      {
        if (RedPacketRollTextView.b(this.a) != RedPacketRollTextView.c(this.a)) {
          RedPacketRollTextView.a(this.a, (RedPacketRollTextView.b(this.a) + 1) % 10);
        }
        int i = RedPacketRollTextView.b(this.a);
        Message localMessage = RedPacketRollTextView.a(this.a).obtainMessage();
        localMessage.what = 1;
        Bundle localBundle = new Bundle();
        localBundle.putString("content", Integer.toString(i % 10));
        localMessage.setData(localBundle);
        RedPacketRollTextView.a(this.a).sendMessage(localMessage);
        Thread.sleep(RedPacketRollTextView.d(this.a));
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (RedPacketRollTextView.a(this.a) != null) {
      RedPacketRollTextView.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jnw
 * JD-Core Version:    0.7.0.1
 */