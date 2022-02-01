import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class rzs
  implements View.OnClickListener
{
  rzs(rzp paramrzp) {}
  
  public void onClick(View paramView)
  {
    if (rzp.a(this.a) != null) {
      rzp.a(this.a).a(rzp.a(this.a));
    }
    rzp.a(this.a).c.setVisibility(8);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", rzp.a(this.a).getCurrentAccountUin());
      label67:
      oat.a(null, null, "0X8009BF1", "0X8009BF1", 0, 0, "", "", "", och.a(null, null, rzp.a(this.a).a.a.a, rzp.a(this.a).a.a.g, localJSONObject), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzs
 * JD-Core Version:    0.7.0.1
 */