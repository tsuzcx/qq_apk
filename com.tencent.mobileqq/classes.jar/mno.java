import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import org.json.JSONObject;

public class mno
  implements View.OnClickListener
{
  public mno(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a).b();
    ReadInJoyActivityHelper.a(this.a.a().getApplicationContext(), false);
    if ((ReadinjoyTabFrame.a(this.a) != null) && (ReadinjoyTabFrame.a(this.a).a())) {
      ReadinjoyTabFrame.a(this.a).a(null);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = ReadInJoyUtils.a();
        localJSONObject.put("folder_status", ReadInJoyUtils.d);
        if (!ReadinjoyTabFrame.a(this.a).a()) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        paramView = (ReadInJoySkinManager)this.a.a.getManager(260);
        if ((paramView.a() != 1) || (TextUtils.isEmpty(paramView.a()))) {
          continue;
        }
        paramView = paramView.a();
        localJSONObject.put("skin_id", paramView);
        localJSONObject.put("button_state", 0);
        PublicAccountReportUtils.a(this.a.a, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "4", null, null, localJSONObject.toString(), false);
        PublicAccountReportUtils.a(this.a.a, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
      }
      catch (Exception paramView)
      {
        int i;
        paramView.printStackTrace();
        continue;
      }
      PublicTracker.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      paramView = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mno
 * JD-Core Version:    0.7.0.1
 */