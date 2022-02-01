import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.avgame.gameresult.GameResultFragment;

public class nao
  extends ClickableSpan
{
  public nao(GameResultFragment paramGameResultFragment) {}
  
  public void onClick(View paramView)
  {
    GameResultFragment.a(this.a);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nao
 * JD-Core Version:    0.7.0.1
 */