package cooperation.qzone.share;

import bglp;
import bgpa;
import bmgc;
import bmgd;
import com.tencent.mobileqq.widget.QQToast;

public class QZoneShareActivity$4$2
  implements Runnable
{
  public QZoneShareActivity$4$2(bmgc parambmgc, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      this.jdField_a_of_type_Bmgc.a.k();
      bglp.a(this.jdField_a_of_type_Bmgc.a, 233, this.jdField_a_of_type_Bmgc.a.getString(2131718010), this.jdField_a_of_type_JavaLangString, new bmgd(this), null).show();
      return;
    }
    this.jdField_a_of_type_Bmgc.a.k();
    QZoneShareActivity.e(this.jdField_a_of_type_Bmgc.a);
    QQToast.a(this.jdField_a_of_type_Bmgc.a, 1, 2131693704, 1).a();
    this.jdField_a_of_type_Bmgc.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */