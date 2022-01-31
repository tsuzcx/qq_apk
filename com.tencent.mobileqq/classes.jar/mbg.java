import android.view.View;
import com.tencent.qphone.base.util.QLog;

class mbg
  implements bhqd
{
  mbg(mbc parammbc, long paramLong, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "showChooseTypeActionSheet, which[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "], mIHandle[" + this.jdField_a_of_type_Mbc.a + "]");
    }
    if (this.jdField_a_of_type_Mbc.a == null) {
      return;
    }
    paramView = paramView.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      this.jdField_a_of_type_Mbc.b(this.jdField_a_of_type_Long, paramView);
      continue;
      this.jdField_a_of_type_Mbc.a(this.jdField_a_of_type_Long, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mbg
 * JD-Core Version:    0.7.0.1
 */