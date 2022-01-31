import android.widget.PopupWindow.OnDismissListener;

class pff
  implements PopupWindow.OnDismissListener
{
  pff(pez parampez, beki parambeki) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Beki.a(1.0F);
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
 * Qualified Name:     pff
 * JD-Core Version:    0.7.0.1
 */