package cooperation.qzone.share;

import bdcd;
import bdfq;
import bjnl;
import bjnm;
import com.tencent.mobileqq.widget.QQToast;

public class QZoneShareActivity$4$2
  implements Runnable
{
  public QZoneShareActivity$4$2(bjnl parambjnl, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      this.jdField_a_of_type_Bjnl.a.k();
      bdcd.a(this.jdField_a_of_type_Bjnl.a, 233, this.jdField_a_of_type_Bjnl.a.getString(2131720023), this.jdField_a_of_type_JavaLangString, new bjnm(this), null).show();
      return;
    }
    this.jdField_a_of_type_Bjnl.a.k();
    QZoneShareActivity.e(this.jdField_a_of_type_Bjnl.a);
    QQToast.a(this.jdField_a_of_type_Bjnl.a, 1, 2131694432, 1).a();
    this.jdField_a_of_type_Bjnl.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */