import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class ops
  extends BroadcastReceiver
{
  public ops(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!"com.tencent.biz.pubaccount.ecshop.tabpage.finish".equals(paramContext)) {
        break label41;
      }
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
    label41:
    int j;
    int k;
    do
    {
      do
      {
        return;
      } while (!"action_notify_view_update".equals(paramContext));
      j = paramIntent.getIntExtra("businessId", 0);
      k = paramIntent.getIntExtra("viewId", 0);
    } while ((25 != j) || (k != 1));
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramIntent.getStringExtra("extstr"));
        if (EcshopNewPageFragment.a(this.a) == null) {
          break;
        }
        paramIntent = EcshopNewPageFragment.a(this.a);
        if (paramContext.optInt("isShow") == 1)
        {
          paramIntent.setVisibility(i);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ops
 * JD-Core Version:    0.7.0.1
 */