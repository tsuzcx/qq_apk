import android.widget.PopupWindow.OnDismissListener;

class pxr
  implements PopupWindow.OnDismissListener
{
  pxr(pxl parampxl, bhtq parambhtq) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Bhtq.a(1.0F);
    if (this.jdField_a_of_type_Pxl.a.b)
    {
      rjg localrjg = this.jdField_a_of_type_Pxl.a.a();
      if (localrjg != null)
      {
        localrjg.c();
        this.jdField_a_of_type_Pxl.a.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pxr
 * JD-Core Version:    0.7.0.1
 */