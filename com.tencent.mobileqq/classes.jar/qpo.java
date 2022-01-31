import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class qpo
  implements View.OnClickListener
{
  qpo(qpl paramqpl) {}
  
  public void onClick(View paramView)
  {
    if (qpl.a(this.a) != null) {
      qpl.a(this.a).a(qpl.a(this.a));
    }
    qpl.a(this.a).c.setVisibility(8);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", qpl.a(this.a).getCurrentAccountUin());
      label67:
      noo.a(null, null, "0X8009BF1", "0X8009BF1", 0, 0, "", "", "", npx.a(null, null, qpl.a(this.a).a.a.a, qpl.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpo
 * JD-Core Version:    0.7.0.1
 */