import android.widget.PopupWindow.OnDismissListener;

class raz
  implements PopupWindow.OnDismissListener
{
  raz(rap paramrap) {}
  
  public void onDismiss()
  {
    rap.a(this.a).a(1.0F);
    if (this.a.b)
    {
      this.a.a.c();
      this.a.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     raz
 * JD-Core Version:    0.7.0.1
 */