import android.widget.PopupWindow.OnDismissListener;

class pxp
  implements PopupWindow.OnDismissListener
{
  pxp(pxl parampxl, bhtw parambhtw) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Bhtw.a(1.0F);
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
 * Qualified Name:     pxp
 * JD-Core Version:    0.7.0.1
 */