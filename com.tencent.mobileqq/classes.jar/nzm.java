import android.widget.PopupWindow.OnDismissListener;

class nzm
  implements PopupWindow.OnDismissListener
{
  nzm(nzl paramnzl) {}
  
  public void onDismiss()
  {
    nzl.a(this.a);
    if (nzl.a(this.a) != null) {
      nzl.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nzm
 * JD-Core Version:    0.7.0.1
 */