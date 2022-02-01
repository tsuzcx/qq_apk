import android.widget.PopupWindow.OnDismissListener;

class pgs
  implements PopupWindow.OnDismissListener
{
  pgs(pgn parampgn, ped paramped) {}
  
  public void onDismiss()
  {
    pgn.a(this.jdField_a_of_type_Pgn).a(1.0F);
    if (this.jdField_a_of_type_Ped.a().b())
    {
      this.jdField_a_of_type_Ped.a().a().c();
      this.jdField_a_of_type_Ped.a().f(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgs
 * JD-Core Version:    0.7.0.1
 */