import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class stk
  implements AdapterView.OnItemClickListener
{
  stk(stj paramstj, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    pyk localpyk = (pyk)this.jdField_a_of_type_Stj.getItem(paramInt);
    Object localObject;
    if ((localpyk != null) && (!TextUtils.isEmpty(localpyk.b)))
    {
      if (!localpyk.b.startsWith("mqq://")) {
        break label178;
      }
      localObject = bgng.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, localpyk.b);
      if (localObject != null) {
        ((bgmp)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new phi().b().a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        oat.a(null, "CliOper", "", "", "0X80092FE", "0X80092FE", 0, 0, "" + localpyk.c, "" + localpyk.a, "", (String)localObject, false);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label178:
      pha.b(stj.a(this.jdField_a_of_type_Stj), localpyk.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stk
 * JD-Core Version:    0.7.0.1
 */