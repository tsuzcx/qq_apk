package cooperation.qzone.share;

import alpo;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;

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
        String str = alpo.a(2131712711) + this.jdField_a_of_type_Int + alpo.a(2131712723);
        int i = this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.getResources().getColor(2131166662);
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setTextColor(i);
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setText(str);
        if (this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.getVisibility() != 0) {
          this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setVisibility(0);
        }
      } while (!this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.b);
      QQToast.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0, 2131718698, 0).a();
      this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.b = false;
      return;
    } while (this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.getVisibility() == 8);
    this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity$14.this$0.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.14.1
 * JD-Core Version:    0.7.0.1
 */