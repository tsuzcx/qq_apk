import android.widget.PopupWindow.OnDismissListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onDismiss"}, k=3, mv={1, 1, 16})
final class rkn
  implements PopupWindow.OnDismissListener
{
  rkn(rkk paramrkk) {}
  
  public final void onDismiss()
  {
    rkl localrkl = rkk.a(this.a);
    if (localrkl != null) {
      localrkl.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkn
 * JD-Core Version:    0.7.0.1
 */