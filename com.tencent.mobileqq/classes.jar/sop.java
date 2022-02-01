import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sop
  implements AdapterView.OnItemClickListener
{
  sop(soo paramsoo, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    pwo localpwo = (pwo)this.jdField_a_of_type_Soo.getItem(paramInt);
    Object localObject;
    if ((localpwo != null) && (!TextUtils.isEmpty(localpwo.b)))
    {
      if (!localpwo.b.startsWith("mqq://")) {
        break label178;
      }
      localObject = bfwg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, localpwo.b);
      if (localObject != null) {
        ((bfvp)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new pbg().b().a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        odq.a(null, "CliOper", "", "", "0X80092FE", "0X80092FE", 0, 0, "" + localpwo.c, "" + localpwo.a, "", (String)localObject, false);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label178:
      pay.b(soo.a(this.jdField_a_of_type_Soo), localpwo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sop
 * JD-Core Version:    0.7.0.1
 */