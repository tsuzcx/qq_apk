import android.widget.PopupWindow.OnDismissListener;

class qpo
  implements PopupWindow.OnDismissListener
{
  qpo(qpk paramqpk, bjrh parambjrh) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_Bjrh.a(1.0F);
    if (this.jdField_a_of_type_Qpk.a.c())
    {
      sdc localsdc = this.jdField_a_of_type_Qpk.a.a();
      if (localsdc != null)
      {
        localsdc.c();
        this.jdField_a_of_type_Qpk.a.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpo
 * JD-Core Version:    0.7.0.1
 */