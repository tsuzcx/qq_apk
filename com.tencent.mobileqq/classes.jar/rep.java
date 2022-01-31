import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class rep
  implements View.OnClickListener
{
  rep(rem paramrem) {}
  
  public void onClick(View paramView)
  {
    if (rem.a(this.a) != null) {
      rem.a(this.a).a(rem.a(this.a));
    }
    rem.a(this.a).c.setVisibility(8);
    paramView = new JSONObject();
    try
    {
      paramView.put("uin", rem.a(this.a).getCurrentAccountUin());
      label67:
      nrt.a(null, null, "0X8009BF1", "0X8009BF1", 0, 0, "", "", "", ntd.a(null, null, rem.a(this.a).a.a.a, rem.a(this.a).a.a.g, paramView), false);
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rep
 * JD-Core Version:    0.7.0.1
 */