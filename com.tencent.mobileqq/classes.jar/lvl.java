import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class lvl
  extends CharacterStyle
{
  public lvl(ComponentContentUgcOriginalHeader paramComponentContentUgcOriginalHeader) {}
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(AIOUtils.a(2, 14, this.a.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvl
 * JD-Core Version:    0.7.0.1
 */