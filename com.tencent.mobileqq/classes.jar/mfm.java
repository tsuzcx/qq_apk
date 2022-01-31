import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;

public final class mfm
  extends ClickableSpan
{
  public mfm(Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = CUKingCardHelper.a("kandian");
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "handleKingCardHintTextView span is clicked, guideUrl=" + paramView);
    }
    if (!TextUtils.isEmpty(paramView))
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(7, 208, 176));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfm
 * JD-Core Version:    0.7.0.1
 */