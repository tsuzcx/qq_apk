import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import org.json.JSONObject;

public class rhg
  implements View.OnClickListener
{
  public rhg(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    boolean bool = ReadinjoyTabFrame.a(this.a).a();
    ReadinjoyTabFrame.a(this.a).b();
    nut.b(this.a.a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = onk.a();
        localJSONObject.put("folder_status", onk.d);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", onk.e());
        localJSONObject.put("kandian_mode_new", npx.a());
        paramView = (pzi)this.a.a.getManager(261);
        if ((paramView.a() != 1) || (TextUtils.isEmpty(paramView.a()))) {
          continue;
        }
        paramView = paramView.a();
        localJSONObject.put("skin_id", paramView);
        localJSONObject.put("button_state", 0);
        noo.a(this.a.a, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
      }
      catch (Exception paramView)
      {
        int i;
        paramView.printStackTrace();
        continue;
      }
      sgx.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      paramView = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rhg
 * JD-Core Version:    0.7.0.1
 */