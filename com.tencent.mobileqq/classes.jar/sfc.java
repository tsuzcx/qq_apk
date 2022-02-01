import android.widget.PopupWindow.OnDismissListener;

class sfc
  implements PopupWindow.OnDismissListener
{
  sfc(sel paramsel) {}
  
  public void onDismiss()
  {
    sel.a(this.a).a(1.0F);
    if (this.a.b)
    {
      this.a.a.c();
      this.a.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfc
 * JD-Core Version:    0.7.0.1
 */