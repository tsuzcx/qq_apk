import android.widget.PopupWindow.OnDismissListener;

class rbt
  implements PopupWindow.OnDismissListener
{
  rbt(rbp paramrbp, blct paramblct) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Blct.a(1.0F);
    if (this.jdField_a_of_type_Rbp.a.c())
    {
      spg localspg = this.jdField_a_of_type_Rbp.a.a();
      if (localspg != null)
      {
        localspg.c();
        this.jdField_a_of_type_Rbp.a.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbt
 * JD-Core Version:    0.7.0.1
 */