import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class rfu
  implements AdapterView.OnItemClickListener
{
  rfu(rft paramrft, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (pbo)this.jdField_a_of_type_Rft.getItem(paramInt);
    if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.b)))
    {
      if (!paramAdapterView.b.startsWith("mqq://")) {
        break label154;
      }
      paramView = bbex.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, paramAdapterView.b);
      if (paramView != null) {
        paramView.c();
      }
    }
    for (;;)
    {
      paramView = new ono().b().a();
      if (!TextUtils.isEmpty(paramView)) {
        nol.a(null, "CliOper", "", "", "0X80092FE", "0X80092FE", 0, 0, "" + paramAdapterView.c, "" + paramAdapterView.a, "", paramView, false);
      }
      return;
      label154:
      onh.b(rft.a(this.jdField_a_of_type_Rft), paramAdapterView.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfu
 * JD-Core Version:    0.7.0.1
 */