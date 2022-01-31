package cooperation.qzone.share;

import ajyc;
import android.content.res.Resources;
import android.widget.TextView;
import bcpw;

class QZoneShareActivity$14$1
  implements Runnable
{
  QZoneShareActivity$14$1(QZoneShareActivity.14 param14, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int <= 0) {
          break;
        }
        String str = ajyc.a(2131712328) + this.jdField_a_of_type_Int + ajyc.a(2131712340);
        int i = this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.getResources().getColor(2131166615);
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setTextColor(i);
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setText(str);
        if (this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.getVisibility() != 0) {
          this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setVisibility(0);
        }
      } while (!this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.b);
      bcpw.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0, 2131718309, 0).a();
      this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.b = false;
      return;
    } while (this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.getVisibility() == 8);
    this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.14.1
 * JD-Core Version:    0.7.0.1
 */