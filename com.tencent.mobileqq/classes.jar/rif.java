import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class rif
  extends ClickableSpan
{
  public rif(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void onClick(View paramView)
  {
    pqx.a(this.a.getContext(), this.a.a.a.a(), 1, false, 8, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(AIOUtils.sp2TextSize(2, 14, this.a.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rif
 * JD-Core Version:    0.7.0.1
 */