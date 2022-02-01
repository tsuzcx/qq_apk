import android.widget.PopupWindow.OnDismissListener;

class rbv
  implements PopupWindow.OnDismissListener
{
  rbv(rbp paramrbp, blcn paramblcn) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Blcn.a(1.0F);
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
 * Qualified Name:     rbv
 * JD-Core Version:    0.7.0.1
 */