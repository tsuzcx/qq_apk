import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tca
  implements AdapterView.OnItemClickListener
{
  tca(tbz paramtbz, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    qhu localqhu = (qhu)this.jdField_a_of_type_Tbz.getItem(paramInt);
    Object localObject;
    if ((localqhu != null) && (!TextUtils.isEmpty(localqhu.b)))
    {
      if (!localqhu.b.startsWith("mqq://")) {
        break label178;
      }
      localObject = bhey.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, localqhu.b);
      if (localObject != null) {
        ((bheh)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new pqg().b().a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        olh.a(null, "CliOper", "", "", "0X80092FE", "0X80092FE", 0, 0, "" + localqhu.c, "" + localqhu.a, "", (String)localObject, false);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label178:
      pqx.a(tbz.a(this.jdField_a_of_type_Tbz), localqhu.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tca
 * JD-Core Version:    0.7.0.1
 */