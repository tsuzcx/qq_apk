import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import mqq.app.AppRuntime;

class qtr
  extends ClickableSpan
{
  qtr(qtq paramqtq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Qtq.getContext(), QQBrowserActivity.class);
    String str = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Qtq.getContext()).getString("qq_readinjoy_user_protocol_92_jump_url_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "https://kandian.qq.com/mqq/watchspot/extrapage.html ");
    if (!TextUtils.isEmpty(str))
    {
      paramView.putExtra("url", URLUtil.guessUrl(str));
      this.jdField_a_of_type_Qtq.getContext().startActivity(paramView);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qtr
 * JD-Core Version:    0.7.0.1
 */