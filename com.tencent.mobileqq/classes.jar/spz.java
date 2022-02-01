import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class spz
  implements View.OnClickListener
{
  public spz(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("selectedGrade", pay.a());
      localBundle.putString("param", localJSONObject.toString());
      pay.a(this.a.a(), "https://viola.qq.com/js/grade.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bid=3740&v_bundleName=grade", localBundle);
      pay.d("0X800AF06");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyTabFrame", 1, "clickGradeListener error! e= " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spz
 * JD-Core Version:    0.7.0.1
 */