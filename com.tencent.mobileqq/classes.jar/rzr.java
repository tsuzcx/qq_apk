import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class rzr
  implements View.OnClickListener
{
  rzr(rzp paramrzp) {}
  
  public void onClick(View paramView)
  {
    ryx.a(rzp.a(this.a), rzp.a(this.a).a);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", rzp.a(this.a).getCurrentAccountUin());
      label45:
      oat.a(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", och.a(null, null, rzp.a(this.a).a.a.a, rzp.a(this.a).a.a.g, localJSONObject), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzr
 * JD-Core Version:    0.7.0.1
 */