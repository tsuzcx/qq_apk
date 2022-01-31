package cooperation.qzone.share;

import bbdj;
import bbgu;
import bcql;
import bhma;
import bhmb;

public class QZoneShareActivity$4$2
  implements Runnable
{
  public QZoneShareActivity$4$2(bhma parambhma, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      this.jdField_a_of_type_Bhma.a.k();
      bbdj.a(this.jdField_a_of_type_Bhma.a, 233, this.jdField_a_of_type_Bhma.a.getString(2131719491), this.jdField_a_of_type_JavaLangString, new bhmb(this), null).show();
      return;
    }
    this.jdField_a_of_type_Bhma.a.k();
    QZoneShareActivity.e(this.jdField_a_of_type_Bhma.a);
    bcql.a(this.jdField_a_of_type_Bhma.a, 1, 2131694283, 1).a();
    this.jdField_a_of_type_Bhma.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.4.2
 * JD-Core Version:    0.7.0.1
 */