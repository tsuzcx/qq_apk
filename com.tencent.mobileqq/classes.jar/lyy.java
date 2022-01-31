import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class lyy
  implements AdapterView.OnItemClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  lyy(lys paramlys) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = paramView.getTag();
    if (paramView == null) {}
    do
    {
      return;
      paramAdapterView = paramAdapterView.getContext();
      if (this.jdField_a_of_type_Lys.jdField_a_of_type_Bbjc != null) {
        this.jdField_a_of_type_Lys.jdField_a_of_type_Bbjc.b();
      }
    } while (this.jdField_a_of_type_Lys.jdField_a_of_type_Lyx == null);
    int i;
    switch (((bbjh)paramView).a.c)
    {
    default: 
      this.jdField_a_of_type_Lys.jdField_a_of_type_Int = ((int)paramLong);
      if ((paramLong == 2L) || (paramLong == 3L)) {
        if (!WXShareHelper.a().a()) {
          i = 2131720906;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        bcpw.a(paramAdapterView, paramAdapterView.getString(i), 0).a();
        this.jdField_a_of_type_Lys.a(this.jdField_a_of_type_Lys.jdField_a_of_type_Int, this.jdField_a_of_type_Lys.b, 3);
        return;
        paramLong = 0L;
        break;
        paramLong = 1L;
        break;
        paramLong = 3L;
        break;
        paramLong = 2L;
        break;
        paramLong = 4L;
        break;
        paramLong = 5L;
        break;
        paramLong = 7L;
        break;
        if (WXShareHelper.a().b()) {
          break label392;
        }
        i = 2131720907;
        continue;
      }
      QLog.w("ShareChat", 1, "onItemClick, mChoosedChannel[" + this.jdField_a_of_type_Lys.jdField_a_of_type_Int + "], position[" + paramInt + "], id[" + paramLong + "], seq[" + this.jdField_a_of_type_Long + "], mChoosedLinkType[" + this.jdField_a_of_type_Lys.b + "]");
      if (this.jdField_a_of_type_Lys.b == -1)
      {
        this.jdField_a_of_type_Lys.c(this.jdField_a_of_type_Long, paramAdapterView);
        return;
      }
      this.jdField_a_of_type_Lys.a(this.jdField_a_of_type_Long, paramAdapterView);
      return;
      label392:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyy
 * JD-Core Version:    0.7.0.1
 */