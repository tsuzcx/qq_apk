import android.widget.PopupWindow.OnDismissListener;

class qjl
  implements PopupWindow.OnDismissListener
{
  qjl(qjh paramqjh, blms paramblms) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Blms.a(1.0F);
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
 * Qualified Name:     qjl
 * JD-Core Version:    0.7.0.1
 */