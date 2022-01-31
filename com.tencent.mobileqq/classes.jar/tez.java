import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class tez
  implements AdapterView.OnItemClickListener
{
  tez(tey paramtey) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (tey.a(this.a).a().isShowing()) {
      tey.a(this.a).a().dismiss();
    }
    int i = ((baia)paramView.getTag()).a.c;
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131655008;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        vvp.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131655009;
        }
      }
      else
      {
        this.a.a(i);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tez
 * JD-Core Version:    0.7.0.1
 */