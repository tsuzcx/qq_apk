import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.seat.PkMemberItemView;
import com.tencent.avgame.gameroom.seat.PkSeatView;
import com.tencent.mobileqq.utils.ViewUtils;

public class nka
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nka(PkSeatView paramPkSeatView) {}
  
  public void onGlobalLayout()
  {
    if ((PkSeatView.a(this.a) != null) && (PkSeatView.a(this.a).b != null))
    {
      int[] arrayOfInt1 = new int[2];
      this.a.getLocationInWindow(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      PkSeatView.a(this.a).b.getLocationInWindow(arrayOfInt2);
      PkSeatView.a(this.a, new nqa(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1], PkSeatView.a(this.a).b.getWidth(), PkSeatView.a(this.a).b.getHeight(), ViewUtils.dip2px(12.0F)));
      this.a.a(PkSeatView.a(this.a));
      if (Build.VERSION.SDK_INT >= 16) {
        PkSeatView.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nka
 * JD-Core Version:    0.7.0.1
 */