package cooperation.qzone.share;

import bdgm;
import bdjz;
import bjrs;
import bjrt;
import com.tencent.mobileqq.widget.QQToast;

public class QZoneShareActivity$4$2
  implements Runnable
{
  public QZoneShareActivity$4$2(bjrs parambjrs, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      this.jdField_a_of_type_Bjrs.a.k();
      bdgm.a(this.jdField_a_of_type_Bjrs.a, 233, this.jdField_a_of_type_Bjrs.a.getString(2131720035), this.jdField_a_of_type_JavaLangString, new bjrt(this), null).show();
      return;
    }
    this.jdField_a_of_type_Bjrs.a.k();
    QZoneShareActivity.e(this.jdField_a_of_type_Bjrs.a);
    QQToast.a(this.jdField_a_of_type_Bjrs.a, 1, 2131694434, 1).a();
    this.jdField_a_of_type_Bjrs.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */