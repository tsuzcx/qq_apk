import android.widget.PopupWindow.OnDismissListener;

class qqx
  implements PopupWindow.OnDismissListener
{
  qqx(qqt paramqqt, bklp parambklp) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Bklp.a(1.0F);
    if (this.jdField_a_of_type_Qqt.a.b)
    {
      seu localseu = this.jdField_a_of_type_Qqt.a.a();
      if (localseu != null)
      {
        localseu.c();
        this.jdField_a_of_type_Qqt.a.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqx
 * JD-Core Version:    0.7.0.1
 */