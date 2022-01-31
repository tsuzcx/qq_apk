import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class qdp
  implements View.OnClickListener
{
  qdp(qdn paramqdn) {}
  
  public void onClick(View paramView)
  {
    qcn.a(qdn.a(this.a), qdn.a(this.a).a);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", qdn.a(this.a).getCurrentAccountUin());
      label45:
      ndn.a(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", new.a(null, null, qdn.a(this.a).a.a.a, qdn.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdp
 * JD-Core Version:    0.7.0.1
 */