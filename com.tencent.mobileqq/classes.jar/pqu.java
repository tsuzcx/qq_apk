import android.widget.PopupWindow.OnDismissListener;

class pqu
  implements PopupWindow.OnDismissListener
{
  pqu(pqq parampqq, bfsz parambfsz) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Bfsz.a(1.0F);
    if (this.jdField_a_of_type_Pqq.a.b)
    {
      qtr localqtr = this.jdField_a_of_type_Pqq.a.a();
      if (localqtr != null)
      {
        localqtr.c();
        this.jdField_a_of_type_Pqq.a.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqu
 * JD-Core Version:    0.7.0.1
 */