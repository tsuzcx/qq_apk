import android.widget.PopupWindow.OnDismissListener;

class qjn
  implements PopupWindow.OnDismissListener
{
  qjn(qjh paramqjh, blmm paramblmm) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Blmm.a(1.0F);
    if (this.jdField_a_of_type_Qjh.a.b)
    {
      rvy localrvy = this.jdField_a_of_type_Qjh.a.a();
      if (localrvy != null)
      {
        localrvy.c();
        this.jdField_a_of_type_Qjh.a.b = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjn
 * JD-Core Version:    0.7.0.1
 */