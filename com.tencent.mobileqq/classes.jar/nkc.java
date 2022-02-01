import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.seat.PkMemberItemView;
import com.tencent.avgame.gameroom.seat.PkSeatView;
import com.tencent.image.ApngImage;

public class nkc
  implements Handler.Callback
{
  public nkc(PkSeatView paramPkSeatView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ApngImage.pauseAll();
      PkSeatView.a(this.a).setImageBitmap(nqf.a("avgame_pk_logo_static@2x.png"));
      continue;
      PkSeatView.b(this.a).c();
      PkSeatView.a(this.a).c();
      PkSeatView.b(this.a).setVisibility(8);
      PkSeatView.c(this.a).setVisibility(8);
      PkSeatView.b(this.a).a(this.a.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkc
 * JD-Core Version:    0.7.0.1
 */