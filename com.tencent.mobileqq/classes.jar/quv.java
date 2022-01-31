import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import org.json.JSONObject;

public class quv
  implements View.OnClickListener
{
  public quv(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    boolean bool = ReadinjoyTabFrame.a(this.a).a();
    ReadinjoyTabFrame.a(this.a).b();
    nji.b(this.a.a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = obz.a();
        localJSONObject.put("folder_status", obz.d);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", obz.e());
        localJSONObject.put("kandian_mode_new", new.a());
        paramView = (pnn)this.a.a.getManager(261);
        if ((paramView.a() != 1) || (TextUtils.isEmpty(paramView.a()))) {
          continue;
        }
        paramView = paramView.a();
        localJSONObject.put("skin_id", paramView);
        localJSONObject.put("button_state", 0);
        ndn.a(this.a.a, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
      }
      catch (Exception paramView)
      {
        int i;
        paramView.printStackTrace();
        continue;
      }
      ruf.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      paramView = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     quv
 * JD-Core Version:    0.7.0.1
 */