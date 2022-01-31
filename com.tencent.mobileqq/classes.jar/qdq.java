import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class qdq
  implements View.OnClickListener
{
  qdq(qdn paramqdn) {}
  
  public void onClick(View paramView)
  {
    if (qdn.a(this.a) != null) {
      qdn.a(this.a).a(qdn.a(this.a));
    }
    qdn.a(this.a).b.setVisibility(8);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", qdn.a(this.a).getCurrentAccountUin());
      label67:
      ndn.a(null, null, "0X8009BF1", "0X8009BF1", 0, 0, "", "", "", new.a(null, null, qdn.a(this.a).a.a.a, qdn.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdq
 * JD-Core Version:    0.7.0.1
 */