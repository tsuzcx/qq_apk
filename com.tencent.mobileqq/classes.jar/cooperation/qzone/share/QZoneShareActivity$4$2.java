package cooperation.qzone.share;

import bhlq;
import bhpc;
import bnhe;
import bnhf;
import com.tencent.mobileqq.widget.QQToast;

public class QZoneShareActivity$4$2
  implements Runnable
{
  public QZoneShareActivity$4$2(bnhe parambnhe, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      this.jdField_a_of_type_Bnhe.a.k();
      bhlq.a(this.jdField_a_of_type_Bnhe.a, 233, this.jdField_a_of_type_Bnhe.a.getString(2131718142), this.jdField_a_of_type_JavaLangString, new bnhf(this), null).show();
      return;
    }
    this.jdField_a_of_type_Bnhe.a.k();
    QZoneShareActivity.e(this.jdField_a_of_type_Bnhe.a);
    QQToast.a(this.jdField_a_of_type_Bnhe.a, 1, 2131693721, 1).a();
    this.jdField_a_of_type_Bnhe.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */