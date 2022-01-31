import android.widget.PopupWindow.OnDismissListener;

class pqz
  implements PopupWindow.OnDismissListener
{
  pqz(pqt parampqt, bfsc parambfsc) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Bfsc.a(1.0F);
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
 * Qualified Name:     pqz
 * JD-Core Version:    0.7.0.1
 */