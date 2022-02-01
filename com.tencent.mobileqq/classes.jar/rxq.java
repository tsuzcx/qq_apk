import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class rxq
  implements View.OnClickListener
{
  rxq(rxo paramrxo) {}
  
  public void onClick(View paramView)
  {
    rwv.a(rxo.a(this.a), rxo.a(this.a).a);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", rxo.a(this.a).getCurrentAccountUin());
      label45:
      odq.a(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", ofe.a(null, null, rxo.a(this.a).a.a.a, rxo.a(this.a).a.a.g, localJSONObject), false);
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
 * Qualified Name:     rxq
 * JD-Core Version:    0.7.0.1
 */