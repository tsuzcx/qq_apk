import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class rhq
  extends CharacterStyle
{
  public rhq(ComponentContentUgcOriginalHeader paramComponentContentUgcOriginalHeader) {}
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(AIOUtils.sp2TextSize(2, 14, this.a.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhq
 * JD-Core Version:    0.7.0.1
 */