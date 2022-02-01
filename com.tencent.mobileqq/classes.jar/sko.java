import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sko
  implements AdapterView.OnItemClickListener
{
  sko(skn paramskn, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    pqu localpqu = (pqu)this.jdField_a_of_type_Skn.getItem(paramInt);
    Object localObject;
    if ((localpqu != null) && (!TextUtils.isEmpty(localpqu.b)))
    {
      if (!localpqu.b.startsWith("mqq://")) {
        break label178;
      }
      localObject = bhni.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, localpqu.b);
      if (localObject != null) {
        ((bhmr)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new paa().b().a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ocd.a(null, "CliOper", "", "", "0X80092FE", "0X80092FE", 0, 0, "" + localpqu.c, "" + localpqu.a, "", (String)localObject, false);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label178:
      ozs.b(skn.a(this.jdField_a_of_type_Skn), localpqu.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sko
 * JD-Core Version:    0.7.0.1
 */