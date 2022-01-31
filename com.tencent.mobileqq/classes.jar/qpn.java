import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class qpn
  implements View.OnClickListener
{
  qpn(qpl paramqpl) {}
  
  public void onClick(View paramView)
  {
    qol.a(qpl.a(this.a), qpl.a(this.a).a);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", qpl.a(this.a).getCurrentAccountUin());
      label45:
      noo.a(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", npx.a(null, null, qpl.a(this.a).a.a.a, qpl.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpn
 * JD-Core Version:    0.7.0.1
 */