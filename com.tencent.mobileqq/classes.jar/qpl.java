import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class qpl
  implements View.OnClickListener
{
  qpl(qpi paramqpi) {}
  
  public void onClick(View paramView)
  {
    if (qpi.a(this.a) != null) {
      qpi.a(this.a).a(qpi.a(this.a));
    }
    qpi.a(this.a).c.setVisibility(8);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", qpi.a(this.a).getCurrentAccountUin());
      label67:
      nol.a(null, null, "0X8009BF1", "0X8009BF1", 0, 0, "", "", "", npu.a(null, null, qpi.a(this.a).a.a.a, qpi.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpl
 * JD-Core Version:    0.7.0.1
 */