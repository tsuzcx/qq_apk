import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class nkm
  extends Handler
{
  public nkm(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      this.a.P();
      return;
    case 1: 
      if (this.a.c)
      {
        this.a.j();
        this.a.L();
      }
      for (;;)
      {
        this.a.c(this.a.getIntent());
        return;
        this.a.j();
      }
    case 2: 
      paramMessage = new Intent();
      paramMessage.putExtra("isNeedFinish", true);
      this.a.setResult(-1, paramMessage);
      this.a.finish();
      return;
    case 4: 
      paramMessage = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      paramMessage.putExtra("BSafeReportPost", true);
      try
      {
        if (this.a.a != null) {
          paramMessage.putExtra("SafeReportData", this.a.a.toString().getBytes("utf-8"));
        }
        paramMessage.putExtra("hide_more_buttonbutton", true);
        paramMessage.putExtra("ishiderefresh", true);
        paramMessage.putExtra("ishidebackforward", true);
        this.a.startActivity(paramMessage.putExtra("url", "http://jubao.mp.qq.com/mobile/reportAccount"));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    paramMessage = new AlphaAnimation(1.0F, 0.0F);
    paramMessage.setDuration(500L);
    this.a.d.startAnimation(paramMessage);
    this.a.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nkm
 * JD-Core Version:    0.7.0.1
 */