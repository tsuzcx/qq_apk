import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class qpk
  implements View.OnClickListener
{
  qpk(qpi paramqpi) {}
  
  public void onClick(View paramView)
  {
    qoi.a(qpi.a(this.a), qpi.a(this.a).a);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", qpi.a(this.a).getCurrentAccountUin());
      label45:
      nol.a(null, null, "0X8009BF2", "0X8009BF2", 0, 0, "", "", "", npu.a(null, null, qpi.a(this.a).a.a.a, qpi.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpk
 * JD-Core Version:    0.7.0.1
 */