import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;

public class qpx
  extends ClickableSpan
{
  public qpx(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void onClick(View paramView)
  {
    ozs.a(this.a.getContext(), this.a.a.a.a(), 1, false, 8, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(agej.a(2, 14, this.a.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpx
 * JD-Core Version:    0.7.0.1
 */