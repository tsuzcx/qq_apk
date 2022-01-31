import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qrcode.ipc.VoiceScan;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class ote
  implements ClickableColorSpanTextView.SpanClickListener
{
  ote(otd paramotd) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(VoiceScan.a(this.a.a), QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    VoiceScan.a(this.a.a).startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ote
 * JD-Core Version:    0.7.0.1
 */