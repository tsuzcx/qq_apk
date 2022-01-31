import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;

public class pms
  extends ClickableSpan
{
  public pms(NativeAwesomeCommentView paramNativeAwesomeCommentView) {}
  
  public void onClick(View paramView)
  {
    if (NativeAwesomeCommentView.a(this.a) != null)
    {
      long l = NativeAwesomeCommentView.a(this.a).a;
      NativeAwesomeCommentView.a(this.a, true);
      ohf.a(l + "", this.a.getContext());
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pms
 * JD-Core Version:    0.7.0.1
 */