import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.view.View;
import com.tencent.av.widget.stageview.StageMemberView;

public class myk
  extends View
{
  public myk(StageMemberView paramStageMemberView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f;
    if (StageMemberView.a(this.a) != null)
    {
      f = -StageMemberView.a(this.a).getFontMetrics().ascent;
      if (this.a.a == null) {
        break label76;
      }
      StageMemberView.a(this.a).setColor(this.a.a.a);
    }
    for (;;)
    {
      paramCanvas.drawText(StageMemberView.a(this.a), 0.0F, f, StageMemberView.a(this.a));
      return;
      label76:
      StageMemberView.a(this.a).setColor(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     myk
 * JD-Core Version:    0.7.0.1
 */