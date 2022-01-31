import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class log
  implements AdapterView.OnItemClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  log(loa paramloa) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = paramView.getTag();
    if (paramView == null) {}
    do
    {
      return;
      paramAdapterView = paramAdapterView.getContext();
      if (this.jdField_a_of_type_Loa.jdField_a_of_type_Bahv != null) {
        this.jdField_a_of_type_Loa.jdField_a_of_type_Bahv.b();
      }
    } while (this.jdField_a_of_type_Loa.jdField_a_of_type_Lof == null);
    int i;
    switch (((baia)paramView).a.c)
    {
    default: 
      this.jdField_a_of_type_Loa.jdField_a_of_type_Int = ((int)paramLong);
      if ((paramLong == 2L) || (paramLong == 3L)) {
        if (!WXShareHelper.a().a()) {
          i = 2131655008;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        bbmy.a(paramAdapterView, paramAdapterView.getString(i), 0).a();
        this.jdField_a_of_type_Loa.a(this.jdField_a_of_type_Loa.jdField_a_of_type_Int, this.jdField_a_of_type_Loa.b, 3);
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
        i = 2131655009;
        continue;
      }
      QLog.w("ShareChat", 1, "onItemClick, mChoosedChannel[" + this.jdField_a_of_type_Loa.jdField_a_of_type_Int + "], position[" + paramInt + "], id[" + paramLong + "], seq[" + this.jdField_a_of_type_Long + "], mChoosedLinkType[" + this.jdField_a_of_type_Loa.b + "]");
      if (this.jdField_a_of_type_Loa.b == -1)
      {
        this.jdField_a_of_type_Loa.c(this.jdField_a_of_type_Long, paramAdapterView);
        return;
      }
      this.jdField_a_of_type_Loa.a(this.jdField_a_of_type_Long, paramAdapterView);
      return;
      label392:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     log
 * JD-Core Version:    0.7.0.1
 */