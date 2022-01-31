import android.widget.PopupWindow.OnDismissListener;

class pqx
  implements PopupWindow.OnDismissListener
{
  pqx(pqt parampqt, bfsi parambfsi) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Bfsi.a(1.0F);
    if (this.jdField_a_of_type_Pqt.a.b)
    {
      qtu localqtu = this.jdField_a_of_type_Pqt.a.a();
      if (localqtu != null)
      {
        localqtu.c();
        this.jdField_a_of_type_Pqt.a.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqx
 * JD-Core Version:    0.7.0.1
 */