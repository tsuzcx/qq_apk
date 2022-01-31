import android.widget.PopupWindow.OnDismissListener;

class okx
  implements PopupWindow.OnDismissListener
{
  okx(okw paramokw) {}
  
  public void onDismiss()
  {
    okw.a(this.a);
    if (okw.a(this.a) != null) {
      okw.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     okx
 * JD-Core Version:    0.7.0.1
 */