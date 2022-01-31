import android.widget.PopupWindow.OnDismissListener;

class pfd
  implements PopupWindow.OnDismissListener
{
  pfd(pez parampez, beko parambeko) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Beko.a(1.0F);
    if (this.jdField_a_of_type_Pez.a.b)
    {
      qhp localqhp = this.jdField_a_of_type_Pez.a.a();
      if (localqhp != null)
      {
        localqhp.c();
        this.jdField_a_of_type_Pez.a.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfd
 * JD-Core Version:    0.7.0.1
 */